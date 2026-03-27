package br.com.clrf.usecase;

import br.com.clrf.domain.comuns.policy.PoliticaRegra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidadorCredenciaisService {

    private final PoliticaRegra politicaSenha;
    private final PoliticaRegra politicaEmail;

    public Optional<String> executaRegrasSenha(String senha) {
        Optional<String> regraNaoSatisfeita = politicaSenha.satisfazRegra(senha);

        if (regraNaoSatisfeita.isPresent())
                log.warn("Senha inválida: regra = {}", regraNaoSatisfeita.get());
        return regraNaoSatisfeita;
    }

    public Optional<String> executaRegrasEmail(String email) {
        Optional<String> regraNaoSatisfeita = politicaEmail.satisfazRegra(email);

        if (regraNaoSatisfeita.isPresent()) {
            log.warn("Email inválido: regra = {}", regraNaoSatisfeita.get());
        }
        return regraNaoSatisfeita;
    }
}