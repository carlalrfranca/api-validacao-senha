package br.com.clrf.service;

import br.com.clrf.domain.policy.PoliticaRegra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrquestraRegras {

    private final PoliticaRegra regras;

    public Optional<String> executaRegras(String senha) {
        Optional<String> regraNaoSatisfeita = regras.satifazRegra(senha);

        if(regraNaoSatisfeita.isPresent()) {
            log.warn("A senha não atende aos requisitos : regra = {}", regraNaoSatisfeita.get());
        }
        return regraNaoSatisfeita;
    }
}
