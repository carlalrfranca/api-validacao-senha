package br.com.clrf.domain.comuns.rules;

public class SemEspacamento implements RegraValidacao {

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
