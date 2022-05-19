package io.github.emfsilva.curso.modelagem.conceitual.repositories;

import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
