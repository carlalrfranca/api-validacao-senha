package br.com.clrf.useCase;

import br.com.clrf.domain.policy.PoliticaRegra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrquestradorDeRegrasTeste {

    @Mock
    private OrquestradorRegras orquestrador;

    @Mock
    private PoliticaRegra politicaRegra;

    @BeforeEach
    void setUp() {
        orquestrador = new OrquestradorRegras(politicaRegra);
    }

    @Test
    void retornaTrueQuandoRegrasSatisfeitas() {

        when(politicaRegra.satisfazRegra("valid"))
                .thenReturn(Optional.empty());
        Optional<String> result = orquestrador.executaRegras("valid");
        assertTrue(result.isEmpty());
        verify(politicaRegra).satisfazRegra("valid");
    }

    @Test
    void retornaFalseQuandoAlgumaRegraFalha() {

        when(politicaRegra.satisfazRegra("invalid"))
                .thenReturn(Optional.of("HasDigitRule"));
        Optional<String> result = orquestrador.executaRegras("invalid");
        assertTrue(result.isPresent());
        assertEquals("HasDigitRule", result.get());
        verify(politicaRegra).satisfazRegra("invalid");
    }
}
