package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.dto.ValidacaoResultado;
import br.com.clrf.adapter.response.MensagemEmail;
import br.com.clrf.adapter.response.MensagemSenha;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credenciais")
@RequiredArgsConstructor
public class ValidacaoController {

    private final ValidadorCredenciaisService validadorCredenciaisService;

    @PostMapping("/validacoes")
    public ResponseEntity<ValidacaoResultado> validar(
            @RequestBody @Valid CredenciaisEntrada credenciais) {

        Optional<String> erroSenha =
                validadorCredenciaisService.executaRegrasSenha(credenciais.senha());

        Optional<String> erroEmail =
                validadorCredenciaisService.executaRegrasEmail(credenciais.email());

        List<String> erros = new ArrayList<>();

        erroSenha.ifPresent(e ->
                erros.add(MensagemSenha.extraiRegra(e))
        );

        erroEmail.ifPresent(e ->
                erros.add(MensagemEmail.extraiRegra(e))
        );

        if (!erros.isEmpty()) {
            return ResponseEntity.unprocessableEntity()
                    .body(new ValidacaoResultado(false, erros));
        }

        return ResponseEntity.ok(
                new ValidacaoResultado(true, List.of("Credenciais validadas com sucesso"))
        );
    }
}