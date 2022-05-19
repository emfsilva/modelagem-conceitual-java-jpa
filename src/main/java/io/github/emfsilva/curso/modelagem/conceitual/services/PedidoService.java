package io.github.emfsilva.curso.modelagem.conceitual.services;

import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Produto;

public interface PedidoService {

    Pedido buscar(Integer id);

}
