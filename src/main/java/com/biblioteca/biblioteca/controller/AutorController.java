package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.repository.AutorRepository;
import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        model.addAttribute("autores", repository.findAll());
        model.addAttribute("autor", new Autor());

        return "autores/autores";
    }

    @PostMapping("/autores")
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {
        repository.save(autor);
        model.addAttribute("autor", autor);

        return "redirect:/autores";
    }

    @GetMapping("/autores/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "redirect:/autores";
    }

    @GetMapping("/autores/excluir/{id}")
    public String excluir(@PathVariable long id) {
        repository.deleteById(id);

        return "redirect:/autores";
    }
}
