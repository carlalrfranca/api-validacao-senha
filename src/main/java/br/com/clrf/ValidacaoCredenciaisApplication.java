package br.com.clrf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidacaoCredenciaisApplication {
    public static void main(String[] args) {

        SpringApplication.run(ValidacaoCredenciaisApplication.class, args);
    }
}


/*
Uma regex eficiente e comum para validar a maioria dos formatos de e-mail é ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$. Ela garante caracteres alfanuméricos, símbolos comuns (ponto, sublinhado, hífen, mais) antes do @, seguidos por domínio e extensão de pelo menos 2 letras. Importante: e-mails reais são complexos; regex não garante que o e-mail existe.
 */