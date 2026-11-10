package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository){
        this.repository = repository;
    }

    @PostMapping("/categorias")
    public String cadastrarCategorias(@ModelAttribute Categoria categoria){
        repository.save(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/categorias")
    public String listarCategorias( Model model) {
        model.addAttribute("categorias", repository.findAll());
        model.addAttribute("categoria", new Categoria());

        return "categorias/categorias";
    }

    @GetMapping("/categorias/novo")
    public String novoCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return "redirect:/categorias";
    }

}
