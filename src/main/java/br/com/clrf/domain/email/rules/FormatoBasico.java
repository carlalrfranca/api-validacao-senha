package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class FormatoBasico implements RegraValidacao {

    @Override
    public boolean valida(String valor) {
        int indiceArroba = valor.indexOf('@');

        return indiceArroba > 0 &&
                indiceArroba < valor.length() - 1;
    }
}


