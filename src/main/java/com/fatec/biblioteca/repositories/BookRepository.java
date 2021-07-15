package com.fatec.biblioteca.repositories;

import java.util.Optional;

import com.fatec.biblioteca.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
    
}
