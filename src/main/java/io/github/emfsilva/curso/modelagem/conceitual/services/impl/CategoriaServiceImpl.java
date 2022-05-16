package io.github.emfsilva.curso.modelagem.conceitual.services.impl;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CategoriaRepository;
import io.github.emfsilva.curso.modelagem.conceitual.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria buscar(Integer id) {
        Optional<Categoria> idOptional = repository.findById(id);
        return idOptional.orElse(null);
    }
}
