package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.dto.ValidacaoResultado;
import br.com.clrf.adapter.response.MensagemSenha;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/senhas")
@RequiredArgsConstructor
public class ValidacaoController {

    private final ValidadorCredenciaisService validadorCredenciaisService;

    @PostMapping("/validacoes")
    public ResponseEntity<ValidacaoResultado> validarSenha (
            @Valid @RequestBody CredenciaisEntrada credenciaisEntrada) {

        Optional<String> regraNaoSatisfeita = validadorCredenciaisService.executaRegras(credenciaisEntrada.senha());

        boolean senhaValida = regraNaoSatisfeita.isEmpty();

        String mensagem;
        if (senhaValida) {
            mensagem = "Senha validada com sucesso";
        } else {
            mensagem = MensagemSenha.extraiRegra(regraNaoSatisfeita.get());
        }
        return ResponseEntity.ok(new ValidacaoResultado(senhaValida, mensagem));
    }
}
