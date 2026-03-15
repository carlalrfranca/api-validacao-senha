package br.com.clrf.adapter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MensagemDeRegraInvalida {
    CONTEM_TAMANHO_MINIMO("ContemTamanhoMinimo","A senha deve conter no mínimo 9 caracteres."),
    CONTEM_LETRA_MINUSCULA("ContemLetraMinuscula","A senha deve conter pelo menos uma letra minúscula."),
    CONTEM_LETRA_MAIUSCULA("ContemLetraMaiuscula","A senha deve conter pelo menos uma letra maiúscula."),
    CONTEM_DIGITO("ContemDigito","A senha deve conter pelo menos um número."),
    CONTEM_CARACTER_ESPECIAL("ContemCaractereEspecial","A senha deve conter pelo menos um caractere especial (!@#$%^&*()-+)."),
    SEM_ESPACAMENTO("SemEspacamento","A senha não deve conter espaços em branco."),
    APENAS_CARACTERES_PERMITIDOS("ApenasCaracteresPermitidos","A senha deve conter apenas caracteres alfanuméricos e os caracteres especiais permitidos !@#$%^&*()-+"),
    SEM_CARACTERE_REPETIDO("SemCaractereRepetido","A senha não deve conter caracteres repetidos.");

    private final String nomeRegra;
    private final String mensagem;

    public static String extraiRegra(String nomeRegra) {
        MensagemDeRegraInvalida[] regras = values();
        int indice = 0;

        while (indice < regras.length) {
            MensagemDeRegraInvalida regra = regras[indice];
            if (regra.getNomeRegra().equals(nomeRegra)) {
                return regra.getMensagem();
            } indice++;
        } return "Regra de validação desconhecida.";
    }
}
