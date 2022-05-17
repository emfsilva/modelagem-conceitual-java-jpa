package io.github.emfsilva.curso.modelagem.conceitual.config;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.model.Cidade;
import io.github.emfsilva.curso.modelagem.conceitual.model.Estado;
import io.github.emfsilva.curso.modelagem.conceitual.model.Produto;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CategoriaRepository;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CidadeRepository;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.EstadoRepository;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.ProdutoRepository;
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

    @Autowired
    public LocalConfig(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
                       CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    @Bean
    public void startDB() {
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

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(List.of(est1, est2));
        cidadeRepository.saveAll(List.of(c1, c2, c3));

    }
}
