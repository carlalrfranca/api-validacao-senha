package br.com.clrf.adapter.dto;

import jakarta.validation.constraints.NotNull;

public record CredenciaisEntrada(
        @NotNull(message = "Senha não pode ser nula")String senha) {}
