package com.aluracurso.biblioteca.repository;

import com.aluracurso.biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.fechaDeDefuncion < :fechaDeDefuncion")
    List<Autor> listarAutoresMuertosAntesDeEstaFecha(@Param("fechaDeDefuncion") int fechaDeDefuncion);
}