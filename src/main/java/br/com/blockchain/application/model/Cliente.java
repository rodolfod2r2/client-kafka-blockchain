package br.com.blockchain.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    private String texto;

    @Override
    public String toString() {
        return this.texto;
    }
}
