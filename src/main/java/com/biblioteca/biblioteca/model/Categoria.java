package com.biblioteca.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;

    public Long getId(){ return id;}

    public String getCategoria(){ return categoria;}

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
