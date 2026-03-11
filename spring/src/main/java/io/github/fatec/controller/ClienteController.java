package io.github.fatec.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.fatec.controller.adapter.ClienteControllerAdapter;
import io.github.fatec.controller.dto.request.ClientRequest;
import io.github.fatec.controller.dto.response.ClienteResponse;
import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.ClienteRepository;

@RestController
public class ClienteController {

    public final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/cliente")
    public ClienteResponse salvar(@RequestBody ClientRequest request) {
        Cliente cliente = ClienteControllerAdapter.castRequest(request);
        Cliente clienteSalvo = clienteRepository.salve(cliente);
        return ClienteControllerAdapter.castResponse(clienteSalvo);
    }

    @GetMapping("/cliente")
    public List<ClienteResponse> listar() {
        return clienteRepository.busqueTodos()
                .stream()
                .map(ClienteControllerAdapter::castResponse)
                .toList();
    }

    @GetMapping("/cliente/{id}")
    public ClienteResponse buscarPorId(@PathVariable String id) {
        return clienteRepository.busquePorId(id)
                .map(ClienteControllerAdapter::castResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }

    @PutMapping("/cliente/{id}")
    public ClienteResponse atualizar(@PathVariable String id, @RequestBody ClientRequest request) {
        clienteRepository.busquePorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

        Cliente cliente = ClienteControllerAdapter.castRequest(id, request);
        Cliente clienteAtualizado = clienteRepository.salve(cliente);
        return ClienteControllerAdapter.castResponse(clienteAtualizado);
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String id) {
        clienteRepository.busquePorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

        clienteRepository.deletePorId(id);
    }

}
