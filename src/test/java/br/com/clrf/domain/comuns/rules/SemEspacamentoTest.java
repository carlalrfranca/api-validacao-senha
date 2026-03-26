package br.com.clrf.domain.comuns.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SemEspacamentoTest {

    private SemEspacamento regra;

    @BeforeEach
    void setUp() {
        regra = new SemEspacamento();
    }

    @Test
    void validaTrueParaSenhaSemEspacamento() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComEspacamento() {
        boolean invalido = regra.valida("AbTp9! fok");
        assertFalse(invalido);
    }
}
