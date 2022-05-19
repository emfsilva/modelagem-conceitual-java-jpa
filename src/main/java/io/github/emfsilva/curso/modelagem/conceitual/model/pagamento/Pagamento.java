package io.github.emfsilva.curso.modelagem.conceitual.model.pagamento;

import io.github.emfsilva.curso.modelagem.conceitual.model.enums.EstadoPagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PAGAMENTO")
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "ESTADO_PAGAMENTO")
    private Integer estadoPagamento;

    @OneToOne
    @JoinColumn(name = "PEDIDO_ID")
    @MapsId
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }
}
