package io.github.emfsilva.curso.modelagem.conceitual.config;

import io.github.emfsilva.curso.modelagem.conceitual.model.*;
import io.github.emfsilva.curso.modelagem.conceitual.model.enums.EstadoPagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.enums.TipoCliente;
import io.github.emfsilva.curso.modelagem.conceitual.model.endereco.Cidade;
import io.github.emfsilva.curso.modelagem.conceitual.model.endereco.Endereco;
import io.github.emfsilva.curso.modelagem.conceitual.model.endereco.Estado;
import io.github.emfsilva.curso.modelagem.conceitual.model.pagamento.Pagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.pagamento.PagamentoComBoleto;
import io.github.emfsilva.curso.modelagem.conceitual.model.pagamento.PagamentoComCartao;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.ItemPedido;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Produto;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {
    private  final CategoriaRepository categoriaRepository;
    private  final ProdutoRepository produtoRepository;
    private  final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public LocalConfig(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
                       CidadeRepository cidadeRepository, EstadoRepository estadoRepository,
                       ClienteRepository clienteRepository, EnderecoRepository enderecoRepository,
                       PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository,
                       ItemPedidoRepository itemPedidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Bean
    public void startDB() throws ParseException {

        //CATEGORIA - PRODUTO
        Categoria cat1 = new Categoria(null, "Informarica");
        Categoria cat2 = new Categoria(null, "Escritorio");

        Produto p1 = new Produto(null, "Computador", new BigDecimal(2000.00));
        Produto p2 = new Produto(null, "Impressora", new BigDecimal(800.00));
        Produto p3 = new Produto(null, "Mouse", new BigDecimal(80.00));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(List.of(cat1,cat2));
        produtoRepository.saveAll(List.of(p1, p2, p3));

        // ESTADO - CIDADE

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(List.of(est1, est2));
        cidadeRepository.saveAll(List.of(c1, c2, c3));

        // CLIENTE - TELEFONE - ENDEREÇO

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838383"));
        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303","Jardim", "38220834",cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800","Centro", "38777012",cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(List.of(cli1));
        enderecoRepository.saveAll(List.of(e1, e2));

        // PEDIDO - PAGAMENTO

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pgto1);
        Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pgto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(List.of(ped1, ped2));
        pagamentoRepository.saveAll(List.of(pgto1, pgto2));

        // ITEM_PEDIDO

        ItemPedido ip1 = new ItemPedido(ped1, p1, new BigDecimal(0.0), 1, new BigDecimal(2000.00));
        ItemPedido ip2 = new ItemPedido(ped1, p3, new BigDecimal(0.0), 2, new BigDecimal(80.00));
        ItemPedido ip3 = new ItemPedido(ped2, p2, new BigDecimal(100.00), 1, new BigDecimal(800.00));

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(List.of(ip1, ip2, ip3));
    }
}
