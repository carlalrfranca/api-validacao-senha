package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class DominioValido implements RegraValidacao {

    @Override
    public boolean valida(String valor) {
        int indiceArroba = valor.indexOf('@');
        if (indiceArroba < 0) return false;
        if (indiceArroba == 0) return false;
        if (indiceArroba == valor.length() - 1) return false;

        String dominio = valor.substring(indiceArroba + 1);

        if (dominio.contains("..")) return false;
        return true;

    }
}



