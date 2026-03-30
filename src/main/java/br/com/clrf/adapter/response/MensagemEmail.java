package br.com.clrf.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MensagemEmail {
    CONTEM_TAMANHO_MINIMO("TamanhoMinimo","O email deve conter no mínimo 8 caracteres."),
    CONTEM_FORMATO_BASICO("FormatoBasico","O email deve conter um formato básico válido"),
    APENAS_UM_ARROBA("ApenasUmArroba","O email deve conter exatamente um caractere '@'."),
    DOMINIO_VALIDO("DominioValido","O email deve conter um domínio válido após o '@'."),
    SEM_DUPLICIDADE_PONTOS("SemDuplicidadePontos","O email não deve conter pontos consecutivos."),
    TLD_VALIDO("TldValido","O email deve conter um TLD válido (por exemplo: '.com', '.net', '.org')."),
    SEM_ESPACAMENTO("SemEspacamento","O email não deve conter espaços em branco.");

    private final String nomeRegra;
    private final String mensagem;

    public static String extraiRegra(String nomeRegra) {
        MensagemEmail[] regras = values();
        int indice = 0;

        while (indice < regras.length) {
            MensagemEmail regra = regras[indice];
            if (regra.getNomeRegra().equals(nomeRegra)) {
                return regra.getMensagem();
            } indice++;
        } return "Regra de validação desconhecida.";
    }
}
