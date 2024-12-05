package com.aluracurso.biblioteca.service;

import com.aluracurso.biblioteca.entity.Autor;
import com.aluracurso.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void listarAutores(){
        List<Autor> listaAutores = autorRepository.findAll();
        listaAutores.forEach(System.out::println);
    }

    public void listarAutoresPorFecha(int fecha){
        List<Autor> listaAutores = autorRepository.listarAutoresMuertosAntesDeEstaFecha(fecha);
        if (listaAutores.isEmpty()){
            System.out.println("No hay autores en esa fecha");
        }else {
            listaAutores.forEach(System.out::println);
        }
    }
}