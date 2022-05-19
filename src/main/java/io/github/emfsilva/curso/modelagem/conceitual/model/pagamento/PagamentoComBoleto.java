package io.github.emfsilva.curso.modelagem.conceitual.model.pagamento;

import io.github.emfsilva.curso.modelagem.conceitual.model.enums.EstadoPagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
