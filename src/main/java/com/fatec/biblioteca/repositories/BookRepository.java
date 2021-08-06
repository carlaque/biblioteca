package com.fatec.biblioteca.repositories;

import java.util.Optional;

import com.fatec.biblioteca.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
    
}
