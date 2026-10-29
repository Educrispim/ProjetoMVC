package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    @GetMapping("/livros")
    public String exibirLivro(Model model) {

        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);

        return "livros/livros";

    }

    @PostMapping("/livros")
    public String cadastrarLivro(
            @ModelAttribute Livro livro, Model model)
    {
        model.addAttribute("livro", livro);
        return "livros/confirmacao";
    }

    @GetMapping("/livros/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }
}