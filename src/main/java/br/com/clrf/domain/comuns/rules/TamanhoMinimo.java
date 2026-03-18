package br.com.clrf.domain.comuns.rules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamanhoMinimo implements RegraValidacao {

    private final int tamanhoMinimoPermitido;

    @Override
    public boolean validaSenha(String senha) {
        return senha.length() >= tamanhoMinimoPermitido;
    }
}
