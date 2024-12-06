package com.aluracurso.biblioteca.repository;

import com.aluracurso.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String titulo);

    @Query("SELECT l.titulo FROM Libro l WHERE l.idioma = :idioma")
    List<String> listarLibrosPorIdioma(@Param("idioma") String idioma);

    @Query("SELECT l.titulo FROM Libro l WHERE l.idioma != :idioma")
    List<String> listarLibrosPorOtrosIdiomas(@Param("idioma") String idioma);




}