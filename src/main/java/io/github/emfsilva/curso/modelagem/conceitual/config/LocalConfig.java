package io.github.emfsilva.curso.modelagem.conceitual.config;

import io.github.emfsilva.curso.modelagem.conceitual.model.*;
import io.github.emfsilva.curso.modelagem.conceitual.model.enums.TipoCliente;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
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

    @Autowired
    public LocalConfig(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
                       CidadeRepository cidadeRepository, EstadoRepository estadoRepository,
                       ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Bean
    public void startDB() {

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

    }
}
