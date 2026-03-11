package io.github.fatec.controller;

import io.github.fatec.controller.dto.request.SomaRequest;
import io.github.fatec.service.CalcularService;
import io.github.fatec.service.CalculoSpringService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularController {
    public final CalcularService calcularService;
    public final CalculoSpringService calculoSpringService;

    public CalcularController(
            CalcularService calcularService,
            CalculoSpringService calculoSpringService) {
        this.calcularService = calcularService;
        this.calculoSpringService = calculoSpringService;
    }

    @PostMapping("/calcular")
    public Integer calcular(@RequestBody SomaRequest somaRequest) {
        return calculoSpringService.calcular(somaRequest.valor1(),
                somaRequest.valor2());
    }

}
