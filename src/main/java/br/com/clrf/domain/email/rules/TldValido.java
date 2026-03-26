package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class TldValido implements RegraValidacao {

    @Override
    public boolean valida(String valor) {

        int arroba = valor.lastIndexOf('@');
        if (arroba < 0 || arroba == valor.length() - 1) return false;

        String dominio = valor.substring(arroba + 1);
        int ultimoPonto = dominio.lastIndexOf('.');

        if (ultimoPonto <= 0 || ultimoPonto == dominio.length() - 1) return false;

        String tld = dominio.substring(ultimoPonto + 1);

        return tld.length() >= 2 && tld.chars().allMatch(Character::isLetter);
    }
}
