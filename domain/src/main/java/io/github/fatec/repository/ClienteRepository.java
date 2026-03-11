package io.github.fatec.repository;

import java.util.List;
import java.util.Optional;

import io.github.fatec.entity.Cliente;

public interface ClienteRepository {
    Cliente salve(Cliente cliente);

    List<Cliente> busqueTodos();

    Optional<Cliente> busquePorId(String id);

    void deletePorId(String id);
}