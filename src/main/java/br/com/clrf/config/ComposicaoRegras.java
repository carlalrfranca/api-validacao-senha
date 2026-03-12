package br.com.clrf.config;

import br.com.clrf.domain.policy.AplicaPoliticaRegras;
import br.com.clrf.domain.policy.PoliticaRegra;
import br.com.clrf.domain.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ComposicaoRegras {

    private static final int TAMANHO_MINIMO = 9;
    private static final String ESPECIAL = "!@#$%^&*()-+";

    @Bean
    public PoliticaRegra politicaSenha() {
        List<RegraSenha> regras = List.of(
                new SemEspacamento(),
                new ApenasCaracteresPermitidos(ESPECIAL),
                new ContemTamanhoMinimo(TAMANHO_MINIMO),
                new ContemDigito(),
                new ContemLetraMinuscula(),
                new ContemLetraMaiuscula(),
                new ContemCaractereEspecial(ESPECIAL),
                new SemCaractereRepetido()
        );
        return new AplicaPoliticaRegras(regras);
    }
}
