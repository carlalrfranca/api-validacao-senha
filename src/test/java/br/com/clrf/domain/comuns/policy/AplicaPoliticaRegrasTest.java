package br.com.clrf.domain.comuns.policy;

import br.com.clrf.domain.comuns.rules.RegraValidacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AplicaPoliticaRegrasTest {

    private AplicaPoliticaRegras politicaRegras;

    @BeforeEach
    void setUp() {
        RegraValidacao regraValida = senha -> true;
        RegraValidacao regraInvalida = senha -> false;
        politicaRegras = new AplicaPoliticaRegras(List.of(regraValida, regraInvalida));
    }

    @Test
    void retornaNomeDaRegraQuandoSenhaInvalida() {
        Optional<String> invalida = politicaRegras.satisfazRegra("abc");
        assertFalse(invalida.isEmpty());
    }

    @Test
    void retornaVazioQuandoSenhaValidas() {

        RegraValidacao regra1 = senha -> true;
        RegraValidacao regra2 = senha -> true;
        politicaRegras = new AplicaPoliticaRegras(List.of(regra1, regra2));
        Optional<String> resultado = politicaRegras.satisfazRegra("abc");
        assertTrue(resultado.isEmpty());
    }
}
