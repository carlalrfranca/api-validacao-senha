package br.com.clrf.domain.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SemEspacamentoTeste {

    private SemEspacamento regra;

    @BeforeEach
    void setUp() {
        regra = new SemEspacamento();
    }

    @Test
    void validaTrueParaSenhaSemEspacamento() {
        boolean valido = regra.validaSenha("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComEspacamento() {
        boolean invalido = regra.validaSenha("AbTp9! fok");
        assertFalse(invalido);
    }
}
