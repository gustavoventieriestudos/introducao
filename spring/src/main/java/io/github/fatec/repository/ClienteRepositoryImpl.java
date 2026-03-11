package io.github.fatec.repository;

import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.adapter.ClienteRepositoryAdapter;
import io.github.fatec.repository.mongo.ClienteRepositoryWithMongoDB;
import io.github.fatec.repository.orm.ClienteOrmMongo;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryWithMongoDB repository;

    public ClienteRepositoryImpl(ClienteRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salve(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo ormSave = repository.save(orm);
        return ClienteRepositoryAdapter.castOrm(ormSave);
    }
}
