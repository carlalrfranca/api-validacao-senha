package br.com.clrf.adapter.dto;

import jakarta.validation.constraints.NotBlank;

public record CredenciaisEntrada(
        @NotBlank(message = "Senha não pode ser vazia ou nula") String senha,
        @NotBlank(message = "Email não pode ser vazio ou nulo") String email) {}
