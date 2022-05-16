package io.github.emfsilva.curso.modelagem.conceitual.config;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {
    private  final CategoriaRepository repository;

    @Autowired
    public LocalConfig(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Bean
    public void startDB() {
        Categoria c1 = new Categoria(null, "Informarica");
        Categoria c2 = new Categoria(null, "Escritorio");
        repository.saveAll(List.of(c1,c2));
    }
}
