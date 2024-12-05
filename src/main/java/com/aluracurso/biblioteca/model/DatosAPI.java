package com.aluracurso.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
//mapear datos JSON a objetos Java
@JsonIgnoreProperties(ignoreUnknown = true)//ignora las propiedades desconocidas del JSON
public record DatosAPI(
        @JsonAlias("results") List<LibroDAO> resultados
    ){
}
