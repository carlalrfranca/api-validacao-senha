package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.dto.ValidacaoResultado;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/credenciais")
@RequiredArgsConstructor
public class ValidacaoController {

    private final ValidadorCredenciaisService validadorCredenciaisService;

    @PostMapping("/validacoes")
    public ResponseEntity<ValidacaoResultado> validar(@Valid @RequestBody CredenciaisEntrada credenciais) {
        validadorCredenciaisService.validarCredenciais(credenciais);
        return ResponseEntity.ok(new ValidacaoResultado(true, "Credenciais validadas com sucesso"));
    }
}

/*
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
import java.util.Optional;

@SuppressWarnings("checkstyle:Indentation")
@RestController
@RequestMapping("/credenciais")
@RequiredArgsConstructor
public class ValidacaoController {

    private final ValidadorCredenciaisService validadorCredenciaisService;

    @PostMapping("/validacoes")
    public ResponseEntity<ValidacaoResultado> validar(
            @Valid @RequestBody CredenciaisEntrada credenciais) {

        Optional<String> erroSenha =
                validadorCredenciaisService.executaRegrasSenha(credenciais.senha());
        Optional<String> erroEmail =
                validadorCredenciaisService.executaRegrasEmail(credenciais.email());
        boolean valido = erroSenha.isEmpty() && erroEmail.isEmpty();
        if (valido) {
            return ResponseEntity.ok(
                    new ValidacaoResultado(true, "Credenciais validadas com sucesso")
            );
        }
        String mensagem;

        if (erroSenha.isPresent())
            mensagem = MensagemSenha.extraiRegra(erroSenha.get());
        else
            mensagem = MensagemEmail.extraiRegra(erroEmail.get());
        return ResponseEntity.unprocessableEntity()
                .body(new ValidacaoResultado(false, mensagem));
    }
}
*/
