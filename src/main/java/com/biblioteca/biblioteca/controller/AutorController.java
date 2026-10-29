package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {
    
    @GetMapping("/autores")
    public String exibirAutores(Model model) {
        
        Autor autor = new Autor();
        autor.setNome("George Orwell");
        autor.setNacionalidade("Reino Unido");


        model.addAttribute("autor", autor);

        return "/autores/autores/autores";
    }

    @PostMapping("/autores")
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {

        model.addAttribute("autor", autor);
        return "/autores/autores/confirmacao";
    }

    @GetMapping("/autores/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("autor", new Autor());
        return "/autores/autores/form";
    }

}
