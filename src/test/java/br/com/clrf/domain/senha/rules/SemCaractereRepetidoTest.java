package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SemCaractereRepetidoTest {

    private SemCaractereRepetido regra;

    @BeforeEach
    void setUp() {
        regra = new SemCaractereRepetido();
    }

    @Test
    void validaTrueParaSenhaSemCaractereRepetido() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComCaractereRepetido() {
        boolean invalido = regra.valida("AbTp9!foA");
        assertFalse(invalido);
    }
}
