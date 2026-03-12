package br.com.clrf.domain.rules;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContemCaractereEspecial implements RegraSenha {
    private final String caracteresEspeciais;

    @Override
    public boolean validaSenha(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (caracteresEspeciais.indexOf(caractere) >= 0) {
                return true;
            } indice++;
        } return false;
    }
}
