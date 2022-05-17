package io.github.emfsilva.curso.modelagem.conceitual.config;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.model.Produto;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CategoriaRepository;
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

    @Autowired
    public LocalConfig(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    @Bean
    public void startDB() {
        Categoria c1 = new Categoria(null, "Informarica");
        Categoria c2 = new Categoria(null, "Escritorio");

        Produto p1 = new Produto(null, "Computador", new BigDecimal(2000.00));
        Produto p2 = new Produto(null, "Impressora", new BigDecimal(800.00));
        Produto p3 = new Produto(null, "Mouse", new BigDecimal(80.00));

        c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        c2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(c1));
        p2.getCategorias().addAll(Arrays.asList(c1, c2));
        p3.getCategorias().addAll(Arrays.asList(c1));

        categoriaRepository.saveAll(List.of(c1,c2));
        produtoRepository.saveAll(List.of(p1, p2, p3));
    }
}
