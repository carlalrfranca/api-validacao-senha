package br.com.clrf.config.config;

import br.com.clrf.config.ComposicaoRegrasSenha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ComposicaoRegrasSenhaTest {

    private ComposicaoRegrasSenha composicaoRegrasSenha;

    @BeforeEach
     void setUp() {
        composicaoRegrasSenha = new ComposicaoRegrasSenha();
    }

    @Test
    void criaComposicaoRegras() {
        var politica = composicaoRegrasSenha.politicaSenha();
        assertNotNull(politica);
    }
}