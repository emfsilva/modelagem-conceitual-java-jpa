package io.github.emfsilva.curso.modelagem.conceitual.model.dtos;

import io.github.emfsilva.curso.modelagem.conceitual.model.Endereco;
import io.github.emfsilva.curso.modelagem.conceitual.model.enums.TipoCliente;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String email;
    private String cpfCpnj;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer tipo;
    private List<Endereco> enderecos = new ArrayList<>();
    private Set<String> telefones = new HashSet<>();

    public TipoCliente getTipo() throws IllegalAccessException {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
