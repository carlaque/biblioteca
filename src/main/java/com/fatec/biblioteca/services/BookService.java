package com.fatec.biblioteca.services;

import com.fatec.biblioteca.controllers.dtos.BookDto;
import com.fatec.biblioteca.controllers.forms.BookForm;
import com.fatec.biblioteca.models.Book;
import com.fatec.biblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<Page<BookDto>> list(Pageable pagination) {
        Page<Book> books = bookRepository.findAll(pagination);
        return ResponseEntity.ok().body(BookDto.converter(books));
    }

    public ResponseEntity<BookDto> post( BookForm form, UriComponentsBuilder uriBuilder) {
        Book book = form.converter();
//        bookRepository.save(book);
        bookRepository.salvar(book.getIsbn(),book.getTitulo(), book.getAutor(), book.getGenero());

        URI uri = uriBuilder.path("/books/{isbn}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookDto(book));
    }

    public ResponseEntity<BookDto> detalhar( String isbn) {
        Optional<Book> livro = bookRepository.findByIsbn(isbn);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new BookDto(livro.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BookDto> update( String isbn,  BookForm form) {
        Optional<Book> optional = bookRepository.findByIsbn(isbn);
        if (optional.isPresent()) {
            Book book = form.atualizar(isbn, bookRepository);
            return ResponseEntity.ok(new BookDto(book));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> remover( String isbn) {
        Optional<Book> optional = bookRepository.findByIsbn(isbn);
        if (optional.isPresent()) {
            bookRepository.deleteById(optional.get().getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
