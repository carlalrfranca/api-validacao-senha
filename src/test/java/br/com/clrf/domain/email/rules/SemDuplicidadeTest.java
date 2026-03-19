package br.com.clrf.domain.email.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SemDuplicidadeTest {

    private SemDuplicidadePontos regra;

    @BeforeEach
    void setUp() {
        regra = new SemDuplicidadePontos();
    }

    @Test
    void validaTrueParaEmailSemDuplicidade() {
        boolean valido = regra.valida("teste@teste.com.br");
        assertTrue(valido);
    }

    @Test
    void validaFalseParaEmailSemDuplicidade() {
        boolean invalido = regra.valida("teste@teste.com..br");
        assertFalse(invalido);
    }
}
