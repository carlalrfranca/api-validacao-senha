package br.com.clrf.adapter.exception;

import br.com.clrf.adapter.dto.ValidacaoResultado;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@RestControllerAdvice
public class ExcecoesGlobais {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacaoResultado> validarCampos(MethodArgumentNotValidException ex) {

        List<String> mensagens = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .toList();
        log.warn("Erro de validação: {}", mensagens);
        return ResponseEntity.badRequest()
                .body(new ValidacaoResultado(false, mensagens));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidacaoResultado> validarCampos(HttpMessageNotReadableException ex) {
        log.warn("JSON inválido ou payload vazio: {}", ex.getMessage());
        return ResponseEntity.badRequest()
                .body(new ValidacaoResultado(false, List.of("JSON inválido ou payload vazio")));
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ValidacaoResultado> regraNegocio(RegraNegocioException ex) {
        log.warn("Regra de negócio violada: {}", ex.getMensagem());
        return ResponseEntity.unprocessableEntity()
                .body(new ValidacaoResultado(false, List.of(ex.getMensagem())));
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ValidacaoResultado> timeout(TimeoutException ex) {
        log.warn("Serviço indisponível: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ValidacaoResultado(false, List.of("Serviço indisponível no momento")));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidacaoResultado> erroGenerico(Exception ex) {
        log.error("Erro interno", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ValidacaoResultado(false, List.of("Erro interno no servidor")));
    }

    @Getter
    public static class RegraNegocioException extends RuntimeException {
        private final String mensagem;
        public RegraNegocioException(String mensagem) {
            super(mensagem);
            this.mensagem = mensagem;
        }
    }
}
