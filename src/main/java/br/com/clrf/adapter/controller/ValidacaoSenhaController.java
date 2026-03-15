package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.RequisicaoSenha;
import br.com.clrf.adapter.dto.RespostaValidacao;
import br.com.clrf.adapter.exception.MensagemDeRegraInvalida;
import br.com.clrf.useCase.OrquestradorRegras;
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
public class ValidacaoSenhaController {

    private final OrquestradorRegras orquestradorRegras;

    @PostMapping("/validacoes")
    public ResponseEntity<RespostaValidacao> validarSenha (
            @Valid @RequestBody RequisicaoSenha requisicaoSenha) {

        Optional<String> regraNaoSatisfeita = orquestradorRegras.executaRegras(requisicaoSenha.senha());

        boolean senhaValida = regraNaoSatisfeita.isEmpty();

        String mensagem;
        if (senhaValida) {
            mensagem = "Senha validada com sucesso";
        } else {
            mensagem = MensagemDeRegraInvalida.extraiRegra(regraNaoSatisfeita.get());
        }
        return ResponseEntity.ok(new RespostaValidacao(senhaValida, mensagem));
    }
}
