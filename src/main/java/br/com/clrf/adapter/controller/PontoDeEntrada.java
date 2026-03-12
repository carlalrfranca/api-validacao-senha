package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.RequisicaoSenha;
import br.com.clrf.adapter.dto.RespostaValidacao;
import br.com.clrf.adapter.exception.MensagemDeRegraInvalida;
import br.com.clrf.service.OrquestraRegras;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api-senha")
@RequiredArgsConstructor
public class PontoDeEntrada {

    private final OrquestraRegras orquestraRegras;

    @PostMapping("/valida")
    public ResponseEntity<RespostaValidacao> validaSenha (
            @Valid @RequestBody RequisicaoSenha requere) {
        Optional<String> regraNaoSatisfeita = orquestraRegras.executaRegras(requere.password());
        boolean senhaValida = regraNaoSatisfeita.isEmpty();
        String mensagem = senhaValida ? "Senha validada com sucesso" : MensagemDeRegraInvalida.extraiRegra(regraNaoSatisfeita.get()
        );
        return ResponseEntity.ok(new RespostaValidacao(senhaValida, mensagem));
    }
}

