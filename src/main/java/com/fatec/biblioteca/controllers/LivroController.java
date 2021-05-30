package com.fatec.biblioteca.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fatec.biblioteca.controllers.dtos.LivroDto;
import com.fatec.biblioteca.controllers.forms.LivroForm;
import com.fatec.biblioteca.models.Livro;
import com.fatec.biblioteca.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<LivroDto> list() {
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.converter(livros);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> post(@RequestBody LivroForm form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.converter();
        livroRepository.save(livro);

        URI uri = uriBuilder.path("/livros/{isbn}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<LivroDto> detalhar(@PathVariable String isbn) {
        Optional<Livro> livro = livroRepository.findByIsbn(isbn);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroDto(livro.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{isbn}")
    @Transactional
    public ResponseEntity<LivroDto> atualizar(@PathVariable String isbn, @RequestBody LivroForm form) {
        Optional<Livro> optional = livroRepository.findByIsbn(isbn);
        if (optional.isPresent()) {
            Livro livro = form.atualizar(isbn, livroRepository);
            return ResponseEntity.ok(new LivroDto(livro));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{isbn}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String isbn) {
        Optional<Livro> optional = livroRepository.findByIsbn(isbn);
        if (optional.isPresent()) {
            livroRepository.deleteById(optional.get().getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
