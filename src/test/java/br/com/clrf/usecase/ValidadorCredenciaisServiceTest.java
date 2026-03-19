package br.com.clrf.usecase;

import br.com.clrf.domain.comuns.policy.PoliticaRegra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidadorCredenciaisServiceTest {


    private ValidadorCredenciaisService orquestrador;

    @Mock
    private PoliticaRegra politicaSenha;

    @Mock
    private PoliticaRegra politicaEmail;

    @BeforeEach
    void setUp() {
        orquestrador = new ValidadorCredenciaisService(politicaSenha, politicaEmail);
    }

    @Test
    void validaCredenciaisComEmailESenhaValidos() {
        String email = "teste@teste.com";
        String senha = "AbTp9!fok";

        when(politicaSenha.satisfazRegra(senha)).thenReturn(Optional.empty());
        when(politicaEmail.satisfazRegra(email)).thenReturn(Optional.empty());

        Optional<String> resultadoSenha = orquestrador.executaRegrasSenha(senha);
        Optional<String> resultadoEmail = orquestrador.executaRegrasEmail(email);

        assertTrue(resultadoSenha.isEmpty());
        assertTrue(resultadoEmail.isEmpty());
    }

    @Test
    void deveRetornarErroQuandoSenhaInvalida() {

        String senha = "123";

        when(politicaSenha.satisfazRegra(senha))
                .thenReturn(Optional.of("TamanhoMinimo"));
        Optional<String> resultado = orquestrador.executaRegrasSenha(senha);
        assertTrue(resultado.isPresent());
        assertEquals("TamanhoMinimo", resultado.get());
    }

    @Test
    void deveRetornarErroQuandoEmailInvalido() {

        String email = "teste.com";

        when(politicaEmail.satisfazRegra(email))
                .thenReturn(Optional.of("FormatoBasico"));
        Optional<String> resultado = orquestrador.executaRegrasEmail(email);
        assertTrue(resultado.isPresent());
        assertEquals("FormatoBasico", resultado.get());
    }



}
