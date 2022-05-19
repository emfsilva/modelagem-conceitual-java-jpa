package io.github.emfsilva.curso.modelagem.conceitual.model.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.emfsilva.curso.modelagem.conceitual.model.Cliente;
import io.github.emfsilva.curso.modelagem.conceitual.model.endereco.Endereco;
import io.github.emfsilva.curso.modelagem.conceitual.model.pagamento.Pagamento;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;
    private Date instante;
    private Pagamento pagamento;
    private Cliente cliente;
    private Endereco enderecoDeEntrega;
    private Set<ItemPedido> itens = new HashSet<>();

    public PedidoDTO(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDTO pedidoDTO = (PedidoDTO) o;
        return Objects.equals(id, pedidoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
