package br.com.clrf.adapter.controller;

import br.com.clrf.adapter.dto.RequisicaoSenha;
import br.com.clrf.useCase.OrquestradorRegras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacaoSenhaControllerTeste {

    private OrquestradorRegras orquestradorRegras;
    private ValidacaoSenhaController controller;

    @BeforeEach
    void setUp() {

        orquestradorRegras = Mockito.mock(OrquestradorRegras.class);
        controller = new ValidacaoSenhaController(orquestradorRegras);
    }

    @Test
    void retornaSenhaValida() {
        Mockito.when(orquestradorRegras.executaRegras("AbTp9!fok"))
                .thenReturn(Optional.empty());
        var requisicao = new RequisicaoSenha("AbTp9!fok");
        var resposta = controller.validarSenha(requisicao);
        assertTrue(resposta.getBody().valido());
    }

    @Test
    void retornaSenhaInvalida() {
        Mockito.when(orquestradorRegras.executaRegras("AbTp9 fok"))
                .thenReturn(Optional.of("SemEspacamento"));
        var requisicao = new RequisicaoSenha("AbTp9 fok");
        var resposta = controller.validarSenha(requisicao);
        assertFalse(resposta.getBody().valido());
    }

}
