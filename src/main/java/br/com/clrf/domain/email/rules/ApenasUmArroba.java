package br.com.clrf.domain.email.rules;

import br.com.clrf.domain.comuns.rules.RegraValidacao;

public class ApenasUmArroba implements RegraValidacao {

    @Override
    public boolean valida(String valor) {

        int cont = 0;
        int arrobaCont = 0;

        while (cont < valor.length()) {
            if (valor.charAt(cont) == '@') {
                arrobaCont++;
            }
            cont++;
        }
        return arrobaCont == 1;
    }
}
