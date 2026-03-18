package br.com.clrf.domain.senha.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContemCaractereEspecialTest {

    private static final String ESPECIAL = "!@#$%^&*()-+";
    private ContemCaractereEspecial regra;

    @BeforeEach
    void setUp() {
        regra = new ContemCaractereEspecial(ESPECIAL);
    }

    @Test
    void validaTrueParaSenhaComCaracteresEspecial() {
        boolean valido = regra.validaSenha("AbTp9!fok");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaSenhaComCaracteresEspecial() {
        boolean invalido = regra.validaSenha("abc\tdef");
        assertFalse(invalido);
    }
}
