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
    void passaComEmailValido() {
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
    void falhaComPontosDuplicados() {
        assertFalse(regra.valida("teste@email..com"));
    }
}

