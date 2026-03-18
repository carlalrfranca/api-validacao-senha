package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.usecase.ValidadorCredenciaisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidacaoControllerTest {

    private ValidadorCredenciaisService validadorCredenciaisService;
    private ValidacaoController controller;

    @BeforeEach
    void setUp() {

        validadorCredenciaisService = Mockito.mock(ValidadorCredenciaisService.class);
        controller = new ValidacaoController(validadorCredenciaisService);
    }

    @Test
    void retornaSenhaValida() {
        Mockito.when(validadorCredenciaisService.executaRegras("AbTp9!fok"))
                .thenReturn(Optional.empty());
        var requisicao = new CredenciaisEntrada("AbTp9!fok");
        var resposta = controller.validarSenha(requisicao);
        assertTrue(resposta.getBody().valido());
    }

    @Test
    void retornaSenhaInvalida() {
        Mockito.when(validadorCredenciaisService.executaRegras("AbTp9 fok"))
                .thenReturn(Optional.of("SemEspacamento"));
        var requisicao = new CredenciaisEntrada("AbTp9 fok");
        var resposta = controller.validarSenha(requisicao);
        assertFalse(resposta.getBody().valido());
    }

}
