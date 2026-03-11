package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ClienteControllerAdapter;
import io.github.fatec.controller.dto.request.ClientRequest;
import io.github.fatec.controller.dto.response.ClienteResponse;
import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.ClienteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    public final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/cliente/cadastrar")
    public ClienteResponse salvar(@RequestBody ClientRequest request) {
        Cliente cliente = ClienteControllerAdapter.castRequest(request);
        Cliente clienteSalvo = clienteRepository.salve(cliente);
        return ClienteControllerAdapter.castResponse(clienteSalvo);
    }

}
