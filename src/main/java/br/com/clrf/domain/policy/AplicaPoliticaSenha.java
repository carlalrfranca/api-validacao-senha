package br.com.clrf.domain.policy;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AplicaPoliticaSenha implements PoliticaSenha {

    private final List<PoliticaSenha> regras;

    @Override
    public Optional<String> validaSenha(String senha) {
        int indice = 0;

        while (indice < regras.size()) {
            PoliticaSenha regra = regras.get(indice);
            Optional<String> erroRegra = regra.validaSenha(senha);
            if (erroRegra.isPresent()) {
                return erroRegra;
            } indice++;
        } return Optional.empty();
    }
}
