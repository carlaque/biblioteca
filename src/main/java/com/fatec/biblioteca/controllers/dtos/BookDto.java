package com.fatec.biblioteca.controllers.dtos;

import com.fatec.biblioteca.models.Book;
import org.springframework.data.domain.Page;

public class BookDto {

    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;

    public BookDto(Book book){
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.titulo = book.getTitulo();
        this.autor = book.getAutor();
        this.genero = book.getGenero();
    }

    public static Page<BookDto> converter(Page<Book> livros) {
		return livros.map(BookDto::new);
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
