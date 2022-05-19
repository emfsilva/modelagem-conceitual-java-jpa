package io.github.emfsilva.curso.modelagem.conceitual.model.pagamento;

import io.github.emfsilva.curso.modelagem.conceitual.model.enums.EstadoPagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.produto.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
