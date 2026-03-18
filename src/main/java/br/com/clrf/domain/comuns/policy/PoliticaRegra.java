package br.com.clrf.domain.comuns.policy;

import java.util.Optional;

public interface PoliticaRegra {
    Optional<String> satisfazRegra(String senha);
}
