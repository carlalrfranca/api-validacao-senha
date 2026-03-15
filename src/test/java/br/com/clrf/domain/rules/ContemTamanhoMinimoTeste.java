package br.com.clrf.domain.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContemTamanhoMinimoTeste {

    private ContemTamanhoMinimo regra;

    @BeforeEach
    void setUp() {
        regra = new ContemTamanhoMinimo(9);
    }

    @Test
    void validaTrueParaSenhaComTamanhoMinimo() {
        boolean valido = regra.validaSenha("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaSemTamanhoMinimo() {
        boolean invalido = regra.validaSenha("AbTp9!f");
        assertFalse(invalido);
    }
}
