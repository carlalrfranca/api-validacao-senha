package br.com.clrf.config;

import br.com.clrf.domain.comuns.rules.TamanhoMinimo;
import br.com.clrf.domain.comuns.rules.RegraValidacao;
import br.com.clrf.domain.comuns.rules.SemEspacamento;
import br.com.clrf.domain.comuns.policy.AplicaPoliticaRegras;
import br.com.clrf.domain.comuns.policy.PoliticaRegra;
import br.com.clrf.domain.senha.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ComposicaoRegrasSenha {

    private static final int TAMANHO_MINIMO = 9;
    private static final String ESPECIAL = "!@#$%^&*()-+";

    @Bean
    public PoliticaRegra politicaSenha() {

        List<RegraValidacao> regras = List.of(
                new SemEspacamento(),
                new ApenasCaracteresPermitidos(ESPECIAL),
                new TamanhoMinimo(TAMANHO_MINIMO),
                new ContemDigito(),
                new ContemLetraMinuscula(),
                new ContemLetraMaiuscula(),
                new ContemCaractereEspecial(ESPECIAL),
                new SemCaractereRepetido()
        );
        return new AplicaPoliticaRegras(regras);
    }
}
