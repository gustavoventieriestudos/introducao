package io.github.fatec.introducao.adapter.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.fatec.introducao.dto.request.PessoaPostRequest;
import io.github.fatec.introducao.dto.request.PessoaUpdateRequest;
import io.github.fatec.introducao.dto.response.PessoaResponse;

@RestController
@RequestMapping(value = "pessoa")
public class PessoaController {

    @GetMapping("/{id}")
    public String getPessoa(@PathVariable String id) {
        return "Pessoa: " + id;
    }

    @PostMapping
    public PessoaResponse save(@RequestBody PessoaPostRequest request) {
        String id = UUID.randomUUID().toString();
        return new PessoaResponse(id, request.nome());
    }

    @PutMapping("/{id}")
    public PessoaResponse update(@PathVariable String id, @RequestBody PessoaUpdateRequest request) {
        return new PessoaResponse(id, request.nome());
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return "Usuario: " + id + " deletado.";
    }
}