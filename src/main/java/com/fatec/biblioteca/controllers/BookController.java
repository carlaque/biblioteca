package com.fatec.biblioteca.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fatec.biblioteca.controllers.dtos.BookDto;
import com.fatec.biblioteca.controllers.forms.BookForm;
import com.fatec.biblioteca.models.Book;
import com.fatec.biblioteca.repositories.BookRepository;

import com.fatec.biblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService service;

    @GetMapping
    public ResponseEntity<Page<BookDto>> list(Pageable pagination) {
       return service.list(pagination);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> post(@RequestBody BookForm form, UriComponentsBuilder uriBuilder) {
        return service.post(form, uriBuilder);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> detalhar(@PathVariable String isbn) {
        return service.detalhar(isbn);
    }

    @PutMapping("/{isbn}")
    @Transactional
    public ResponseEntity<BookDto> update(@PathVariable String isbn, @RequestBody BookForm form) {
        return service.update(isbn, form);
    }

    @DeleteMapping("/{isbn}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String isbn) {
        return service.remover(isbn);
    }

}
