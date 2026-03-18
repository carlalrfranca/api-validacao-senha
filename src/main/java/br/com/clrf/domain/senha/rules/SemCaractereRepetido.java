package br.com.clrf.domain.senha.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class SemCaractereRepetido implements RegraValidacao {

    @Override
    public boolean validaSenha(String senha) {
        int indice = 0;

        while(indice < senha.length()) {
            char caractere = senha.charAt(indice);

            int indiceComparacao = indice + 1;

            while (indiceComparacao < senha.length()) {
                if (caractere == senha.charAt(indiceComparacao)) {
                    return false;
                } indiceComparacao++;
            } indice++;
        } return true;
    }
}
