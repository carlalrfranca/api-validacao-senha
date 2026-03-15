package br.com.clrf.domain.rules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContemTamanhoMinimo implements RegraSenha {

    private final int tamanhoMinimo;

    @Override
    public boolean validaSenha(String senha) {

        int tamanho = senha.length();

        if (tamanho >= tamanhoMinimo) {
            return true;
        } return false;
    }
}
