package br.com.clrf.adapter.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MensagemSenhaTest {

    @Test
    void retornaMensagemQuandoTemRegra() {
        String mensagem = MensagemSenha.extraiRegra("TEM_DIGITO");
        assertNotNull(mensagem);
    }

    @Test
    void retornaMensagemQuandoNaoTemRegra() {
        String mensagem = MensagemSenha.extraiRegra("INVALIDA");
        assertEquals("Regra de validação desconhecida.", mensagem);
    }
}
