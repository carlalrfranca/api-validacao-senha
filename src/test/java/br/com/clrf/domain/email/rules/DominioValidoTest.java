package br.com.clrf.domain.email.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DominioValidoTest {

    private DominioValido regra;

    @BeforeEach
    void setup() {
        regra = new DominioValido();
    }

    @Test
    void devePassarComEmailValido() {
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
    void deveFalharSemPontoNoDominio() {
        assertFalse(regra.valida("teste@email"));
    }

    @Test
    void deveFalharDominioComecandoComPonto() {
        assertFalse(regra.valida("teste@.email.com"));
    }

    @Test
    void deveFalharDominioTerminandoComPonto() {
        assertFalse(regra.valida("teste@email."));
    }

    @Test
    void deveFalharComPontosDuplicados() {
        assertFalse(regra.valida("teste@email..com"));
    }
}

