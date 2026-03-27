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
    private String senha;
    private String senhaInvalida;
    private String email;
    String emailInvalido;

    @BeforeEach
    void setUp() {
        orquestrador = new ValidadorCredenciaisService(politicaSenha, politicaEmail);
        senha = "AbTp9!fok";
        senhaInvalida = "123";
        email = "teste@teste.com";
        emailInvalido = "teste.com";
    }

    @Test
    void validaCredenciaisComEmailESenhaValidos() {
        when(politicaSenha.satisfazRegra(senha)).thenReturn(Optional.empty());
        when(politicaEmail.satisfazRegra(email)).thenReturn(Optional.empty());

        Optional<String> erroSenha = orquestrador.executaRegrasSenha(senha);
        Optional<String> erroEmail = orquestrador.executaRegrasEmail(email);

        assertTrue(erroSenha.isEmpty());
        assertTrue(erroEmail.isEmpty());
    }

    @Test
    void retornaErroQuandoSenhaInvalida() {
        when(politicaSenha.satisfazRegra(senhaInvalida)).thenReturn(Optional.of("TamanhoMinimo"));
        Optional<String> erroSenha = orquestrador.executaRegrasSenha(senhaInvalida);
        assertTrue(erroSenha.isPresent());
        assertEquals("TamanhoMinimo", erroSenha.get());
    }

    @Test
    void retornaErroQuandoEmailInvalido() {
        when(politicaEmail.satisfazRegra(emailInvalido)).thenReturn(Optional.of("FormatoBasico"));
        Optional<String> erroEmail = orquestrador.executaRegrasEmail(emailInvalido);
        assertTrue(erroEmail.isPresent());
        assertEquals("FormatoBasico", erroEmail.get());
    }
}

