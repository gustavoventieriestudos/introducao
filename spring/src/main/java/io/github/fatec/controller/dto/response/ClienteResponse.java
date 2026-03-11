package io.github.fatec.controller.dto.response;

public record ClienteResponse(
        String id,
        String nome,
        String endereco,
        String telefone
) {
}
