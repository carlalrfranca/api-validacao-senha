package br.com.clrf.domain.email.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TldValidoTest {

    private final TldValido regra = new TldValido();

    @ParameterizedTest
    @CsvSource({
            "testeemail.com, false",
            "teste@, false",
            "teste@email, false",
            "teste@email., false",
            "teste@email.c, false",
            "teste@email.com, true"
    })
    void deveValidarEmails(String email, boolean esperado) {
        assertEquals(esperado, regra.valida(email));
    }
}