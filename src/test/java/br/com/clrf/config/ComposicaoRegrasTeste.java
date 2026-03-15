package br.com.clrf.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ComposicaoRegrasTeste {

    private ComposicaoRegras composicaoRegras;

    @BeforeEach
     void setUp() {
        composicaoRegras = new ComposicaoRegras();
    }

    @Test
    void criaComposicaoRegras() {
        var politica = composicaoRegras.politicaSenha();
        assertNotNull(politica);
    }
}