package br.com.clrf.domain.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContemLetraMinusculaTeste {

    private ContemLetraMaiuscula regra;

    @BeforeEach
    void setUp() {
        regra = new ContemLetraMaiuscula();
    }

    @Test
    void validaTrueParaSenhaComLetraMinuscula() {
        boolean valido = regra.validaSenha("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaSemLetraMinuscula() {
        boolean invalido = regra.validaSenha("ABC123HUH!");
        assertTrue(invalido);
    }
}
