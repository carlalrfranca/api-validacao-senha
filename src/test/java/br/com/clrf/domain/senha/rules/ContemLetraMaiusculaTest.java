package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContemLetraMaiusculaTest {

    private ContemLetraMaiuscula regra;

    @BeforeEach
    void setUp() {
        regra = new ContemLetraMaiuscula();
    }

    @Test
    void validaTrueParaSenhaComLetraMaiuscula() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComLetraMaiuscula() {
        boolean invalido = regra.valida("atpfok76@f");
        assertFalse(invalido);
    }
}
