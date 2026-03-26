package br.com.clrf.usecase;

import br.com.clrf.adapter.dto.CredenciaisEntrada;
import br.com.clrf.adapter.exception.ExcecoesGlobais;
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
        CredenciaisEntrada entrada = new CredenciaisEntrada(senha, email);

        when(politicaSenha.satisfazRegra(senha)).thenReturn(Optional.empty());
        when(politicaEmail.satisfazRegra(email)).thenReturn(Optional.empty());

        assertDoesNotThrow(() -> orquestrador.validarCredenciais(entrada));
    }

    @Test
    void retornaErroQuandoSenhaInvalida() {
        CredenciaisEntrada entrada = new CredenciaisEntrada(senhaInvalida, email);

        when(politicaSenha.satisfazRegra(senhaInvalida)).thenReturn(Optional.of("TamanhoMinimo"));
        when(politicaEmail.satisfazRegra(email)).thenReturn(Optional.empty());

        ExcecoesGlobais.RegraNegocioException ex = assertThrows(
                ExcecoesGlobais.RegraNegocioException.class,
                () -> orquestrador.validarCredenciais(entrada)
        );

        assertTrue(ex.getMessage().contains("mínimo 9 caracteres"));
    }

    @Test
    void retornaErroQuandoEmailInvalido() {
        CredenciaisEntrada entrada = new CredenciaisEntrada(senha, emailInvalido);

        when(politicaSenha.satisfazRegra(senha)).thenReturn(Optional.empty());
        when(politicaEmail.satisfazRegra(emailInvalido)).thenReturn(Optional.of("FormatoBasico"));

        ExcecoesGlobais.RegraNegocioException ex = assertThrows(
                ExcecoesGlobais.RegraNegocioException.class,
                () -> orquestrador.validarCredenciais(entrada)
        );
        assertTrue(ex.getMessage().toLowerCase().contains("formato"));
    }
}

