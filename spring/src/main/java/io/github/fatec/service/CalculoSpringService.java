package io.github.fatec.service;

import org.springframework.stereotype.Service;

@Service
public class CalculoSpringService {

    public Integer calcular(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }

}
