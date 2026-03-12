package br.com.clrf.domain.policy;

import java.util.Optional;

public interface PoliticaRegra {
    Optional<String> satifazRegra(String senha);
}
