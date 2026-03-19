package br.com.clrf.adapter.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MensagemEmailTest {

    @Test
    void retornaMensagemQuandoTemRegra() {
        String mensagem = MensagemEmail.extraiRegra("FormatoBasico");
        assertEquals("O email deve conter um formato básico válido", mensagem);
    }

    @Test
    void retornaMensagemQuandoNaoTemRegra() {
        String mensagem = MensagemEmail.extraiRegra("INVALIDA");
        assertEquals("Regra de validação desconhecida.", mensagem);
    }
}
