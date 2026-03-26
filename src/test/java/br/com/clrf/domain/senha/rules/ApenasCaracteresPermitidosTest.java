package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApenasCaracteresPermitidosTest {

    private static final String ESPECIAL = "!@#$%^&*()-+";
    private ApenasCaracteresPermitidos regra;

    @BeforeEach
    void setUp() {
        regra = new ApenasCaracteresPermitidos(ESPECIAL);
    }

    @Test
    void validaTrueParaSenhaComCaracteresPermitidos() {
        boolean valido = regra.valida("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComCaracteresPermitidos() {
        boolean invalido = regra.valida("abc\\tdef");
        assertFalse(invalido);
    }
}
