package com.fatec.biblioteca.controllers.forms;

import java.util.Optional;

import com.fatec.biblioteca.models.Livro;
import com.fatec.biblioteca.repositories.LivroRepository;

public class LivroForm {

    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Livro converter() {
        return new Livro(this.isbn,this.titulo,this.autor,this.genero);
    }

    public Livro atualizar(String isbn, LivroRepository livroRepository) {
		Optional<Livro> livro = livroRepository.findByIsbn(isbn);
        if(livro.isPresent()){
            livro.get().setIsbn(this.isbn);
            livro.get().setTitulo(this.titulo);
            livro.get().setAutor(this.autor);
            livro.get().setGenero(this.genero);
            return livro.get();
        }
        return null;
		
	}
    
}
