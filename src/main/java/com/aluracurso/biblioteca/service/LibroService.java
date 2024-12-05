package com.aluracurso.biblioteca.service;

import com.aluracurso.biblioteca.entity.Libro;
import com.aluracurso.biblioteca.model.DatosAPI;
import com.aluracurso.biblioteca.model.LibroDAO;
import com.aluracurso.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    String BASE_URL = "https://gutendex.com/books/";
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void buscarLibro(String libro) throws UnsupportedEncodingException {
        String libroBuscado = encodeLibro(libro);
        String searchURL = buildSearchURL(libroBuscado);
        String json = obtenerJson(searchURL);
        DatosAPI datos = convertirDatos(json);
        Optional<LibroDAO> resultadoBusqueda = buscarPrimerResultado(datos);
        Libro libroEncontrado = convertirLibro(resultadoBusqueda);
        imprimirLibro(libroEncontrado);
        guardarLibro(libroEncontrado);
    }

    private String encodeLibro(String libro) throws UnsupportedEncodingException {
        return URLEncoder.encode(libro, "UTF-8");
    }

    private String buildSearchURL(String libroBuscado) {
        return BASE_URL + "?search=" + libroBuscado;
    }

    private String obtenerJson(String searchURL) {
        return consumirAPI.obtenerJson(searchURL);
    }

    private DatosAPI convertirDatos(String json) {
        return convertirDatos.obtenerDatos(json, DatosAPI.class);
    }

    private Optional<LibroDAO> buscarPrimerResultado(DatosAPI datos) {
        return datos.resultados().stream().findFirst();
    }

    private Libro convertirLibro(Optional<LibroDAO> resultadoBusqueda) {
        return resultadoBusqueda.map(this::libroDAOALibro).orElse(null);
    }

    private void imprimirLibro(Libro libro) {
        System.out.println(libro);
    }

    public Libro libroDAOALibro(LibroDAO libroRecord){
        Libro libro = new Libro(libroRecord);
        return libro;
    }

    public void guardarLibro(Libro libro){
        try{
            libroRepository.save(libro);
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
    }

    public void listarLibros(){
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    public void listarLibrosIdioma(String idioma){
        if (idioma.equalsIgnoreCase("otro")){
            List<String> titulos = libroRepository.listarLibrosPorIdioma(idioma);
            if (titulos.isEmpty()){
                System.out.println("No hay libros regitrados con ese idioma");
            }else{
                titulos.forEach(System.out::println);
            }
        }
        List<String> titulos = libroRepository.listarLibrosPorIdioma(idioma);
        if (titulos.isEmpty()){
            System.out.println("No hay libros regitrados con ese idioma");
        }else{
            titulos.forEach(System.out::println);
        }
    }
}