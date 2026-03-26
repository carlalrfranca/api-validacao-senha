package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContemDigitoTest {

    private ContemDigito regra;

    @BeforeEach
    void setUp() {
        regra = new ContemDigito();
    }

    @Test
    void validaTrueParaSenhaComDigito() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaSemDigito() {
        boolean invalido = regra.valida("AbTp!fok");
        assertFalse(invalido);
    }
}
