package br.com.clrf.domain.rules;

public class ContemLetraMaiuscula implements RegraSenha {

    @Override
    public boolean validaSenha(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (Character.isUpperCase(caractere)) {
                return true;
            } indice++;
        } return false;
    }
}
