package br.com.clrf.domain.comuns.rules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamanhoMinimo implements RegraValidacao {

    private final int tamanhoMinimoPermitido;

    @Override
    public boolean valida(String valor) {

        return valor.length() >= tamanhoMinimoPermitido;
    }
}
