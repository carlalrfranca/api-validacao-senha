package br.com.clrf.domain.email.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormatoBasicoTest {

    private FormatoBasico regra;

    @BeforeEach
    void setUp() {
        regra = new FormatoBasico();
    }

    @Test
    void devePassarQuandoFormatoValido() {
        assertTrue(regra.valida("teste@email.com"));
    }

    @Test
    void deveFalharSemArroba() {
        assertFalse(regra.valida("testeemail.com"));
    }

    @Test
    void deveFalharArrobaNoInicio() {
        assertFalse(regra.valida("@email.com"));
    }

    @Test
    void deveFalharArrobaNoFinal() {
        assertFalse(regra.valida("teste@"));
    }
}
