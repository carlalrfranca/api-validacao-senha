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
    void passaQuandoFormatoValido() {
        assertTrue(regra.valida("teste@email.com"));
    }

    @Test
    void falhaSemArroba() {
        assertFalse(regra.valida("testeemail.com"));
    }

    @Test
    void falhaArrobaNoInicio() {
        assertFalse(regra.valida("@email.com"));
    }

    @Test
    void falhaArrobaNoFinal() {
        assertFalse(regra.valida("teste@"));
    }

    @Test
    void falhaSemDominio() {
        assertFalse(regra.valida("teste@email"));
    }

    @Test
    void falhaDominioInvalido() {
        assertFalse(regra.valida("teste@email."));
    }

    @Test
    void falhaMultiplosArrobas() {
        assertFalse(regra.valida("teste@@email.com"));
    }

    @Test
    void falhaStringVazia() {
        assertFalse(regra.valida(""));
    }
}