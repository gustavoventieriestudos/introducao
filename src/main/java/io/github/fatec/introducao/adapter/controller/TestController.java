package io.github.fatec.introducao.adapter.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "teste")
    public String teste() {
        String id = UUID.randomUUID().toString();
        return id;
    }
    
}
