package com.fatec.biblioteca.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.biblioteca.models.Livro;
import org.springframework.data.domain.Page;

public class LivroDto {

    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;

    public LivroDto(Livro livro){
        this.id = livro.getId();
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.genero = livro.getGenero();
    }

    public static Page<LivroDto> converter(Page<Livro> livros) {
		return livros.map(LivroDto::new);
	}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    

}
