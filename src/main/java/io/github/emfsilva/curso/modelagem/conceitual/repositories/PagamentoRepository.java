package io.github.emfsilva.curso.modelagem.conceitual.repositories;

import io.github.emfsilva.curso.modelagem.conceitual.model.pagamento.Pagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
