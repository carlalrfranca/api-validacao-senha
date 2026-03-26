package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class FormatoBasico implements RegraValidacao {
    @Override
    public boolean valida(String valor) {
        if (valor == null || valor.isBlank()) return false;

        int arroba = valor.indexOf('@');
        if (arroba <= 0 || arroba == valor.length() - 1) return false;

        String dominio = valor.substring(arroba + 1);
        int ponto = dominio.lastIndexOf('.');
        if (ponto <= 0 || ponto == dominio.length() - 1) return false;

        String local = valor.substring(0, arroba);
        String tld = dominio.substring(ponto + 1);

        return !local.isBlank() && !tld.isBlank() && tld.length() >= 2;
    }
}
