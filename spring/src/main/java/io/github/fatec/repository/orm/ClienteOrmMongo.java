package io.github.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "cliente")
public record ClienteOrmMongo(
        @Id
        String id,
        String nome,
        String endereco,
        String telefone
) {
}