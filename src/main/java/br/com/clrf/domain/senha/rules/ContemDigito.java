package br.com.clrf.domain.senha.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class ContemDigito implements RegraValidacao {

    @Override
    public boolean validaSenha(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (Character.isDigit(caractere)) {
                return true;
            } indice++;
        } return false;
    }
}