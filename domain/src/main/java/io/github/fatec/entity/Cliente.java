package io.github.fatec.entity;

public record Cliente(
        String id,
        String nome,
        String endereco,
        String telefone
) {
}