package br.com.clrf.domain.email.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApenasUmArrobaTest {

    private ApenasUmArroba regra;

    @BeforeEach
    void setUp() {
       regra = new ApenasUmArroba();
    }

    @Test
    void validaTrueParaEmailComApenasUmArroba() {
        boolean valido = regra.valida("teste@teste.com");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaEmailComMaisDeUmArroba() {
        boolean invalido = regra.valida("teste@@teste.com");
        assertFalse(invalido);
    }
}
