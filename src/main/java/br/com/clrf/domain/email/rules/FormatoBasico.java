package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class FormatoBasico implements RegraValidacao {

    @Override
    public boolean valida(String valor) {

        int arroba = valor.indexOf('@');
        if (arroba <= 0 || arroba == valor.length() - 1) return false;
        if (valor.indexOf('@', arroba + 1) != -1) return false;

        String local = valor.substring(0, arroba);
        String dominio = valor.substring(arroba + 1);

        if (!dominio.contains(".")) return false;
        if (dominio.startsWith(".") || dominio.endsWith(".")) return false;
        if (dominio.contains("..")) return false;

        return !local.isBlank();
    }
}
