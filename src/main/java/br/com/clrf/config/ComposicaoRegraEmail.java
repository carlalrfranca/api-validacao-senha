package br.com.clrf.config;

import br.com.clrf.domain.comuns.policy.AplicaPoliticaRegras;
import br.com.clrf.domain.comuns.policy.PoliticaRegra;
import br.com.clrf.domain.comuns.rules.RegraValidacao;
import br.com.clrf.domain.comuns.rules.SemEspacamento;
import br.com.clrf.domain.comuns.rules.TamanhoMinimo;
import br.com.clrf.domain.email.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ComposicaoRegraEmail {

    private static final int TAMANHO_MINIMO = 4;

    @Bean(name = "politicaEmail")
    public PoliticaRegra politicaEmail() {

        List<RegraValidacao> regrasEmail = List.of(
                new SemEspacamento(),
                new FormatoBasico(),
                new ApenasUmArroba(),
                new TamanhoMinimo(TAMANHO_MINIMO),
                new DominioValido(),
                new SemDuplicidadePontos(),
                new TldValido()
        );
        return new AplicaPoliticaRegras(regrasEmail);
    }
}
