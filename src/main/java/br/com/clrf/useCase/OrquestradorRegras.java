package br.com.clrf.useCase;

import br.com.clrf.domain.policy.PoliticaRegra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrquestradorRegras {

    private final PoliticaRegra politicaRegra;

    public Optional<String> executaRegras(String senha) {
        Optional<String> regraNaoSatisfeita = politicaRegra.satisfazRegra(senha);

        if(regraNaoSatisfeita.isPresent()) {
            log.warn("A senha não atende aos requisitos : regra = {}", regraNaoSatisfeita.get());
        }
        return regraNaoSatisfeita;
    }
}
