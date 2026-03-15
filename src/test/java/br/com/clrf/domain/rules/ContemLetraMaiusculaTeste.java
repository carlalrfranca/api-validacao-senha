package br.com.clrf.domain.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContemLetraMaiusculaTeste {

    private ContemLetraMaiuscula regra;

    @BeforeEach
    void setUp() {
        regra = new ContemLetraMaiuscula();
    }

    @Test
    void validaTrueParaSenhaComLetraMaiuscula() {
        boolean valido = regra.validaSenha("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComLetraMaiuscula() {
        boolean invalido = regra.validaSenha("atpfok76@f");
        assertFalse(invalido);
    }
}
