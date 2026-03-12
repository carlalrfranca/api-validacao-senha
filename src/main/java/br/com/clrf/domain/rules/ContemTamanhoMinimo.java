package br.com.clrf.domain.rules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContemTamanhoMinimo implements RegraSenha {

    @Override
    public boolean validar(String senha) {
        int indice = 0;
        while (indice < senha.length()) {
            if (indice >= 9) {
                return true;
            } indice++;
        } return false;
    }
}

