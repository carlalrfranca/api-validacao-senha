package br.com.clrf.domain.comuns.rules;

public class SemEspacamento implements RegraValidacao {

    @Override
    public boolean valida(String valor) {
        int indice = 0;

        while (indice < valor.length()) {
            char caractere = valor.charAt(indice);
            if (Character.isWhitespace(caractere)) {
                return false;
            } indice++;
        } return true;
    }
}
