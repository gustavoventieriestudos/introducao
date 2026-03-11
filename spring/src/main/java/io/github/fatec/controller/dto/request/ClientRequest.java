package io.github.fatec.controller.dto.request;

public record ClientRequest(
        String nome,
        String endereco,
        String telefone
) {
}
