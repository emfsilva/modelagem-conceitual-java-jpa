package io.github.emfsilva.curso.modelagem.conceitual.model.enums;

import io.github.emfsilva.curso.modelagem.conceitual.config.Mensagem;
import lombok.Getter;

@Getter
public enum     TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(1, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer cod) throws IllegalAccessException {
        if( cod == null) {
            return null;
        }

        for(TipoCliente x : TipoCliente.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException(Mensagem.INVALID_ID + cod);
    }
}
