package io.github.emfsilva.curso.modelagem.conceitual.model.dtos;

import com.sun.source.doctree.SerialDataTree;
import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private BigDecimal preço;

    private List<Categoria> categorias = new ArrayList<>();

    public ProdutoDTO(Integer id, String nome, BigDecimal preço) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
