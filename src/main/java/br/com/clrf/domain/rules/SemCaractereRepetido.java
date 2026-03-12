package br.com.clrf.domain.rules;

public class SemCaractereRepetido implements  RegraSenha {

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
