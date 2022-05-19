package io.github.emfsilva.curso.modelagem.conceitual.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.emfsilva.curso.modelagem.conceitual.model.enums.TipoCliente;
import io.github.emfsilva.curso.modelagem.conceitual.model.endereco.Endereco;
import io.github.emfsilva.curso.modelagem.conceitual.model.pedido.Pedido;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    @Column(name = "cpf_cnpj")
    private String cpfCpnj;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String cpfCpnj, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfCpnj = cpfCpnj;
        this.tipo = tipoCliente.getCod();
    }

    public TipoCliente getTipo() throws IllegalAccessException {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

}
