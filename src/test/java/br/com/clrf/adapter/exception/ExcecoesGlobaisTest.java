package br.com.clrf.adapter.exception;

import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import br.com.clrf.adapter.dto.ValidacaoResultado;

class ExcecoesGlobaisTest {

    private final ExcecoesGlobais handler = new ExcecoesGlobais();

    @Test
    void retornaErroValidacaoCampos() {
        var handler = new ExcecoesGlobais();
        var ex = Mockito.mock(MethodArgumentNotValidException.class);
        var bindingResult = Mockito.mock(org.springframework.validation.BindingResult.class);
        var fieldError = Mockito.mock(org.springframework.validation.FieldError.class);
        Mockito.when(fieldError.getDefaultMessage()).thenReturn("Email inválido");
        Mockito.when(bindingResult.getFieldErrors()).thenReturn(java.util.List.of(fieldError));
        Mockito.when(ex.getBindingResult()).thenReturn(bindingResult);
        var response = handler.validarCampos(ex);
        assertEquals(400, response.getStatusCode().value());
        assertFalse(response.getBody().valido());
        assertEquals("Email inválido", response.getBody().mensagens().get(0));
    }

    @Test
    void retornaErroRegraNegocio() {
        var ex = new ExcecoesGlobais.RegraNegocioException("erro regra");
        ResponseEntity<ValidacaoResultado> response = handler.regraNegocio(ex);
        assertEquals(422, response.getStatusCode().value());
        assertFalse(response.getBody().valido());
        assertEquals("erro regra", response.getBody().mensagens().get(0));
    }

    @Test
    void retornaErroJsonInvalido() {
        var ex = new HttpMessageNotReadableException("erro");
        ResponseEntity<ValidacaoResultado> response = handler.validarCampos(ex);
        assertEquals(400, response.getStatusCode().value());
        assertFalse(response.getBody().valido());
        assertEquals("JSON inválido ou payload vazio", response.getBody().mensagens().get(0));
    }

    @Test
    void retornaErroTimeout() {
        var ex = new TimeoutException("timeout");
        ResponseEntity<ValidacaoResultado> response = handler.timeout(ex);
        assertEquals(503, response.getStatusCode().value());
        assertFalse(response.getBody().valido());
        assertEquals("Serviço indisponível no momento", response.getBody().mensagens().get(0));
    }

    @Test
    void retornaErroGenerico() {
        var ex = new RuntimeException("erro");
        ResponseEntity<ValidacaoResultado> response = handler.erroGenerico(ex);
        assertEquals(500, response.getStatusCode().value());
        assertFalse(response.getBody().valido());
        assertEquals("Erro interno no servidor", response.getBody().mensagens().get(0));
    }
}