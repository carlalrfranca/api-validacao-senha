package br.com.clrf.domain.policy;

import br.com.clrf.domain.rules.RegraSenha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AplicaPoliticaRegrasTeste {

    private AplicaPoliticaRegras politicaRegras;

    @BeforeEach
    void setUp() {
        RegraSenha regraValida = senha -> true;
        RegraSenha regraInvalida = senha -> false;
        politicaRegras = new AplicaPoliticaRegras(List.of(regraValida, regraInvalida));
    }

    @Test
    void retornaNomeDaRegraQuandoSenhaInvalida() {
        Optional<String> invalida = politicaRegras.satisfazRegra("abc");
        assertFalse(invalida.isEmpty());
    }

    @Test
    void retornaVazioQuandoSenhaValidas() {

        RegraSenha regra1 = senha -> true;
        RegraSenha regra2 = senha -> true;
        politicaRegras = new AplicaPoliticaRegras(List.of(regra1, regra2));
        Optional<String> resultado = politicaRegras.satisfazRegra("abc");
        assertTrue(resultado.isEmpty());
    }
}
