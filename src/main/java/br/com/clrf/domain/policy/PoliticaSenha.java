package br.com.clrf.domain.policy;

import java.util.Optional;

public interface PoliticaSenha {

    Optional<String> validaSenha(String senha);
}
