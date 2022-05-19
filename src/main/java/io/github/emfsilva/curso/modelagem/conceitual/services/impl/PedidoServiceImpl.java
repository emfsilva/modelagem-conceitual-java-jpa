package io.github.emfsilva.curso.modelagem.conceitual.services.impl;

import io.github.emfsilva.curso.modelagem.conceitual.config.Mensagem;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Produto;
import io.github.emfsilva.curso.modelagem.conceitual.repositories.PedidoRepository;
import io.github.emfsilva.curso.modelagem.conceitual.services.PedidoService;
import io.github.emfsilva.curso.modelagem.conceitual.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido buscar(Integer id) {
        Optional<Pedido> idOptional = pedidoRepository.findById(id);
        return idOptional.orElseThrow(() -> new ObjectNotFountException(Mensagem.OBJECT_NOT_FOUND + id + " "
        + Pedido.class.getName()));
    }
}
