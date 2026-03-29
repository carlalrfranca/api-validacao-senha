package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;
import java.util.Set;

public class TldValido implements RegraValidacao {

    private static final Set<String> TLDS_VALIDOS =
            Set.of("com", "org", "net", "br", "io", "gov", "edu", "co", "us", "uk", "ca", "de", "jp", "fr", "au");

    @Override
    public boolean valida(String valor) {

        int arroba = valor.lastIndexOf('@');
        if (arroba < 0 || arroba == valor.length() - 1) return false;

        String dominio = valor.substring(arroba + 1);
        int ultimoPonto = dominio.lastIndexOf('.');
        if (ultimoPonto <= 0 || ultimoPonto == dominio.length() - 1) return false;

        String tld = dominio.substring(ultimoPonto + 1).toLowerCase();
        return TLDS_VALIDOS.contains(tld);
    }
}
