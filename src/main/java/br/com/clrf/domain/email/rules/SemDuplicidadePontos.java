package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class SemDuplicidadePontos implements RegraValidacao {

    @Override
    public boolean valida(String valor){
        int indice = 0;

        while (indice < valor.length() - 1) {
            if (valor.charAt(indice) == '.' && valor.charAt(indice + 1) == '.') {
                return false;
            } indice++;
        } return true;
    }
}

