package br.com.clrf.domain.comuns.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TamanhoMinimoTest {

    private TamanhoMinimo regra;

    @BeforeEach
    void setUp() {
        regra = new TamanhoMinimo(9);
    }

    @Test
    void validaTrueParaSenhaComTamanhoMinimo() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaSemTamanhoMinimo() {
        boolean invalido = regra.valida("AbTp9!f");
        assertFalse(invalido);
    }
}
