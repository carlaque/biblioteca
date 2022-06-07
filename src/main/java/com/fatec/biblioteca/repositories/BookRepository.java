package com.fatec.biblioteca.repositories;

import java.util.Optional;

import com.fatec.biblioteca.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    Optional<Book> findByIsbn(String isbn);

    @Modifying
    @Query(nativeQuery = true,value = "call insert_livros(:isbn, :titulo, :autor, :genero)")
    void salvar(String isbn, String titulo, String autor, String genero);
}
