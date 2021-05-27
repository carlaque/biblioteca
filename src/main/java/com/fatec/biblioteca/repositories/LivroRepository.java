package com.fatec.biblioteca.repositories;

import com.fatec.biblioteca.models.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
