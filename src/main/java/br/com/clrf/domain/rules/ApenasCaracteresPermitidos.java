package br.com.clrf.domain.rules;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApenasCaracteresPermitidos implements RegraSenha {
    private final String caracteresEspeciais;

    @Override
    public boolean validar(String senha) {
        int indice = 0;

        while (indice < senha.length()) {
            char caractere = senha.charAt(indice);
            if (caracteresEspeciais.indexOf(caractere) >= 0
                    || Character.isLetterOrDigit(caractere)) {
                indice++;
            } else {
                return false;
            }
        } return true;
    }
}