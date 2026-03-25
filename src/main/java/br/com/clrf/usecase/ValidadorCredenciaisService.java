package br.com.clrf.usecase;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.exception.ExcecoesGlobais.RegraNegocioException;
import br.com.clrf.adapter.response.MensagemEmail;
import br.com.clrf.adapter.response.MensagemSenha;
import br.com.clrf.domain.comuns.policy.PoliticaRegra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidadorCredenciaisService {

    private final PoliticaRegra politicaSenha;
    private final PoliticaRegra politicaEmail;

    public void validarCredenciais(CredenciaisEntrada credenciais) {
        List<String> erros = new ArrayList<>();

        if (credenciais.senha() == null) {
            erros.add("Senha não pode ser nula");
        } else {
            politicaSenha.satisfazRegra(credenciais.senha())
                    .ifPresent(e -> erros.add(MensagemSenha.extraiRegra(e)));
        }

        if (credenciais.email() == null) {
            erros.add("Email não pode ser nulo");
        } else {
            politicaEmail.satisfazRegra(credenciais.email())
                    .ifPresent(e -> erros.add(MensagemEmail.extraiRegra(e)));
        }

        if (!erros.isEmpty()) {
            log.warn("Erros de validação: {}", erros);
            throw new RegraNegocioException(String.join("; ", erros));
        }

        log.info("Credenciais atendem todas as regras de negócio");
    }
}


/*
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

        if(regraNaoSatisfeita.isPresent()) {
            log.warn("Senha inválida : regra = {}", regraNaoSatisfeita.get());
        }
        return regraNaoSatisfeita;
    }

    public Optional<String> executaRegrasEmail(String email) {
        Optional<String> regraNaoSatisfeita = politicaEmail.satisfazRegra(email);

        if(regraNaoSatisfeita.isPresent()) {
            log.warn("Email inválido : regra = {}", regraNaoSatisfeita.get());
        }
        return regraNaoSatisfeita;
    }
}
*/
