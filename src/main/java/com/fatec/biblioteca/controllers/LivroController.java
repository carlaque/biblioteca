package com.fatec.biblioteca.controllers;

import java.util.List;

import com.fatec.biblioteca.controllers.dtos.LivroDto;
import com.fatec.biblioteca.models.Livro;
import com.fatec.biblioteca.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<LivroDto> list(){
        
        List<Livro> livros = livroRepository.findAll();

        return LivroDto.converter(livros);
    }

    
}
