package br.com.clrf.domain.rules;

public class SemEspacamento implements RegraSenha {

    @Override
    public boolean validaSenha(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (Character.isWhitespace(caractere)) {
                return false;
            } indice++;
        } return true;
    }
}
