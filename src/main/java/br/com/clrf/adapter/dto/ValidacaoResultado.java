package br.com.clrf.adapter.dto;

import java.util.List;

public record ValidacaoResultado(
        boolean valido,
        List<String> mensagens
) {}

