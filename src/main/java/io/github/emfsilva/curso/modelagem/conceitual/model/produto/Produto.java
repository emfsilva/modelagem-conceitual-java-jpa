package io.github.emfsilva.curso.modelagem.conceitual.model.produto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.ItemPedido;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "produto")
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private BigDecimal preço;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto(Integer id, String nome, BigDecimal preço) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
    }

    @JsonIgnore
    public List<Pedido> getPedidos() {
       List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x: itens) {
            lista.add(x.getPedido());
        }
        return lista;

     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
