package br.com.clrf.domain.senha.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApenasCaracteresPermitidos implements RegraValidacao {
    private final String caracteresEspeciais;

    @Override
    public boolean validaSenha (String senha) {
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