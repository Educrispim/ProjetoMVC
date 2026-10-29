package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String exibirInicio() {
        return "Inicio/inicio";
    }
}
