package br.com.clrf.config.config;

import br.com.clrf.config.ComposicaoRegraEmail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ComposicaoRegraEmailTest {

    private ComposicaoRegraEmail composicaoRegraEmail;

    @BeforeEach
     void setUp() {
        composicaoRegraEmail = new ComposicaoRegraEmail();
    }

    @Test
    void criaComposicaoRegras() {
        var politica = composicaoRegraEmail.politicaEmail();
        assertNotNull(politica);
    }
}