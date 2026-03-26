package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.exception.ExcecoesGlobais;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ValidacaoControllerTest {

    private ValidadorCredenciaisService service;
    private ValidacaoController controller;
    private CredenciaisEntrada entradaValida;
    private CredenciaisEntrada entradaSenhaInvalida;
    private CredenciaisEntrada entradaEmailInvalido;

    @BeforeEach
    void setUp() {
        service = Mockito.mock(ValidadorCredenciaisService.class);
        controller = new ValidacaoController(service);
        entradaValida = new CredenciaisEntrada("AbTp9!fok", "teste@email.com");
        entradaSenhaInvalida = new CredenciaisEntrada("123", "teste@email.com");
        entradaEmailInvalido = new CredenciaisEntrada("AbTp9!fok", "teste.com");
    }

    @Test
    void retornaSucesso() {
        Mockito.doNothing().when(service).validarCredenciais(entradaValida);
        var resposta = controller.validar(entradaValida);
        assertTrue(resposta.getBody().valido());
    }

    @Test
    void retornaErroSenha() {
        Mockito.doThrow(new ExcecoesGlobais.RegraNegocioException("erro senha"))
                .when(service).validarCredenciais(entradaSenhaInvalida);
        assertThrows(ExcecoesGlobais.RegraNegocioException.class, () -> controller.validar(entradaSenhaInvalida)
        );
    }

    @Test
    void retornaErroEmail() {
        Mockito.doThrow(new ExcecoesGlobais.RegraNegocioException("erro email"))
                .when(service).validarCredenciais(entradaEmailInvalido);
        assertThrows(ExcecoesGlobais.RegraNegocioException.class, () -> controller.validar(entradaEmailInvalido)
        );
    }
}