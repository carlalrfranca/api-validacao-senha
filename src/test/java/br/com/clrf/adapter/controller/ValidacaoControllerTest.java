package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
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
        Mockito.when(service.executaRegrasSenha("AbTp9!fok")).thenReturn(Optional.empty());
        Mockito.when(service.executaRegrasEmail("teste@email.com")).thenReturn(Optional.empty());
        var resposta = controller.validar(entradaValida);
        assertTrue(resposta.getBody().valido());
    }

    @Test
    void retornaErroSenha() {
        Mockito.when(service.executaRegrasSenha("123")).thenReturn(Optional.of("TamanhoMinimo"));
        Mockito.when(service.executaRegrasEmail("teste@email.com")).thenReturn(Optional.empty());
        var resposta = controller.validar(entradaSenhaInvalida);
        assertFalse(resposta.getBody().valido());
    }

    @Test
    void retornaErroEmail() {
        Mockito.when(service.executaRegrasSenha("AbTp9!fok")).thenReturn(Optional.empty());
        Mockito.when(service.executaRegrasEmail("teste.com")).thenReturn(Optional.of("FormatoBasico"));
        var resposta = controller.validar(entradaEmailInvalido);
        assertFalse(resposta.getBody().valido());
    }
}