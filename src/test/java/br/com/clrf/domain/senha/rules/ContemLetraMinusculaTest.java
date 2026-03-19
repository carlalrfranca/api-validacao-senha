package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContemLetraMinusculaTest {

    private ContemLetraMinuscula regra;

    @BeforeEach
    void setUp() {
        regra = new ContemLetraMinuscula();
    }

    @Test
    void validaTrueParaSenhaComLetraMinuscula() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaSemLetraMinuscula() {
        boolean invalido = regra.valida("ABC123HUH!");
        assertFalse(invalido);
    }
}
