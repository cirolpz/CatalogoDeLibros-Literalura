package com.aluracurso.biblioteca.entity;

import com.aluracurso.biblioteca.model.LibroDAO;
import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Autores")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;
    @Column
    private String titulo;
    @Column
    private String idioma;
    @Column
    private Integer cantidadDeDescargas;

    public Libro() {
    }

    public Libro(String titulo, List<Autor> autor, String idioma, Integer cantidadDeDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    public Libro(LibroDAO libroDAO){
        this.titulo = libroDAO.titulo();
        this.autor = libroDAO.autores().stream().map(autores -> new Autor(autores.nombre(), autores.fechaNacimientpo(), autores.fechaDefuncion()))
                .collect(Collectors.toList());
        this.idioma = libroDAO.idioma().get(0);
        this.cantidadDeDescargas = libroDAO.cantidadDeDescargas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(Integer cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma='" + idioma + '\'' +
                ", cantidadDeDescargas=" + cantidadDeDescargas +
                '}';
    }
}