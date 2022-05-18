package io.github.emfsilva.curso.modelagem.conceitual.services.impl;

import io.github.emfsilva.curso.modelagem.conceitual.config.Mensagem;
import io.github.emfsilva.curso.modelagem.conceitual.model.Cliente;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.ClienteRepository;
import io.github.emfsilva.curso.modelagem.conceitual.services.ClienteService;
import io.github.emfsilva.curso.modelagem.conceitual.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscar(Integer id) {
        Optional<Cliente> idOptional = clienteRepository.findById(id);
        return idOptional.orElseThrow(() -> new ObjectNotFountException(Mensagem.OBJECT_NOT_FOUND + id + " "
        + Cliente.class.getName()));
    }
}
