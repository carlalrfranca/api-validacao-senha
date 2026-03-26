package br.com.clrf.domain.email.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void deveFalharSemDominio() {
        assertFalse(regra.valida("teste@email"));
    }

    @Test
    void deveFalharDominioInvalido() {
        assertFalse(regra.valida("teste@email."));
    }

    @Test
    void deveFalharMultiplosArrobas() {
        assertFalse(regra.valida("teste@@email.com"));
    }

    @Test
    void deveFalharStringVazia() {
        assertFalse(regra.valida(""));
    }
}