package io.github.emfsilva.curso.modelagem.conceitual.services.impl;

import io.github.emfsilva.curso.modelagem.conceitual.config.Mensagem;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Categoria;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.CategoriaRepository;
import io.github.emfsilva.curso.modelagem.conceitual.services.CategoriaService;
import io.github.emfsilva.curso.modelagem.conceitual.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return idOptional.orElseThrow(() -> new ObjectNotFountException(Mensagem.OBJECT_NOT_FOUND + id +" "+
                Categoria.class.getName()));
    }
}
