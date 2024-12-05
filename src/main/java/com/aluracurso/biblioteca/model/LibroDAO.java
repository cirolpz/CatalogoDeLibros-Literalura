package com.aluracurso.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDAO(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors")List<AutorDAO> autores,
        @JsonAlias("languages")List<String> idioma,
        @JsonAlias("download_count") Integer cantidadDeDescargas
        ) {
}
