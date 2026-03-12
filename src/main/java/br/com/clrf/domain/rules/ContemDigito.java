package br.com.clrf.domain.rules;

public class ContemDigito implements RegraSenha {

    @Override
    public boolean validar(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (Character.isDigit(caractere)) {
                return true;
            } indice++;
        } return false;
    }
}