package br.com.clrf.domain.comuns.policy;

import br.com.clrf.domain.comuns.rules.RegraValidacao;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AplicaPoliticaRegras implements PoliticaRegra {

    private final List<RegraValidacao> regras;

    @Override
    public Optional<String> satisfazRegra(String senha) {
        int indice = 0;

        while (indice < regras.size()) {
            RegraValidacao regra = regras.get(indice);

            if (!regra.validaSenha(senha)) {
                return Optional.of(regra.getClass().getSimpleName());
            } indice++;
        } return Optional.empty();
    }
}
