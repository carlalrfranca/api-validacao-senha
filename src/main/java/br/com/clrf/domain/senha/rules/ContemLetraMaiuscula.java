package br.com.clrf.domain.senha.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class ContemLetraMaiuscula implements RegraValidacao {

    @Override
    public boolean valida(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (Character.isUpperCase(caractere)) {
                return true;
            } indice++;
        } return false;
    }
}
