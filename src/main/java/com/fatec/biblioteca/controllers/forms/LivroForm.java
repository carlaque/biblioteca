package com.fatec.biblioteca.controllers.forms;

import com.fatec.biblioteca.models.Livro;

public class LivroForm {

    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    
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

    public Livro converter() {
        return new Livro(this.isbn,this.titulo,this.autor,this.genero);
    }
    
}
