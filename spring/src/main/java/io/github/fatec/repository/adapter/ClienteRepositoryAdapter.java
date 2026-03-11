package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.orm.ClienteOrmMongo;

public class ClienteRepositoryAdapter {
    private ClienteRepositoryAdapter() {
    }

    public static Cliente castOrm(ClienteOrmMongo orm) {
        return new Cliente(
                orm.id(),
                orm.nome(),
                orm.endereco(),
                orm.telefone());
    }

    public static ClienteOrmMongo castEntity(Cliente entity) {
        return new ClienteOrmMongo(
                entity.id(),
                entity.nome(),
                entity.endereco(),
                entity.telefone());
    }
}
