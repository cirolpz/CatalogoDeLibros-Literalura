package com.aluracurso.biblioteca.view;

import com.aluracurso.biblioteca.repository.AutorRepository;
import com.aluracurso.biblioteca.repository.LibroRepository;
import com.aluracurso.biblioteca.service.AutorService;
import com.aluracurso.biblioteca.service.LibroService;
import java.util.InputMismatchException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Vista {
    public int menuPrincipal(LibroRepository libroRepository, AutorRepository autorRepository) {
        Scanner scanner = new Scanner(System.in);
        LibroService libroService = new LibroService(libroRepository);
        AutorService autorService = new AutorService(autorRepository);
        int seleccion = 0;
        do {
            System.out.println("Menu");
            System.out.println("1 - Buscar Libro.");
            System.out.println("2 - Listar Libros registrados.");
            System.out.println("3 - Listar Autores registrados.");
            System.out.println("4 - Buscar autores vivos hasta la una fecha determinada.");
            System.out.println("5 - Listar Libros por Idioma.");
            System.out.println("6 - Salir.");
            try {
                seleccion = scanner.nextInt();
                menuSwitch(seleccion, libroService, autorService);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        } while (seleccion != 6);
        return seleccion;
    }

    public void menuIdiomas() {
        System.out.println("Menu de Idiomas");
        System.out.println("1 - Ingles");
        System.out.println("2 - Espaniol");
        System.out.println("3 - Otros idiomas");
    }

    public String seleccionDeIdiomas(int seleccion) {
        final String INGLES = "en";
        final String ESPANIOL = "es";
        final String OTRO = "otro";
        String idioma = "";
        String idiomaSeleccionado = "";
        switch (seleccion) {
            case 1:
                idiomaSeleccionado = INGLES;
                idioma = "Ingles";
                break;
            case 2:
                idiomaSeleccionado = ESPANIOL;
                idioma = "Espaniol";
                break;
            case 3:
                idiomaSeleccionado = OTRO;
                idioma = "Otros Idiomas";
                break;
        }
        System.out.println("Libros registrados en " + idioma);
        return idiomaSeleccionado;
    }

    public void menuSwitch(int seleccion, LibroService libroService, AutorService autorService) {
        Scanner scanner = new Scanner(System.in);
        switch (seleccion) {
            // 1 - Buscar Libro.
            case 1:
                System.out.println("Ingrese el nombre del Libro");
                String libroBuscado = scanner.next();
                try {
                    libroService.buscarLibro(libroBuscado);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                break;
            // 2 - Listar Libros registrados.
            case 2:
                libroService.listarLibros();
                break;
            // 3 - Listar Autores registrados.
            case 3:
                autorService.listarAutores();
                break;
            // 4 - Buscar autores vivos hasta la una fecha determinada.
            case 4:
                System.out.println("Ingrese una fecha");
                try {
                    autorService.listarAutoresPorFecha(scanner.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
                break;
            // 5 - Listar Libros por Idioma
            case 5:
                menuIdiomas();
                try {
                    libroService.listarLibrosIdioma(seleccionDeIdiomas(scanner.nextInt()));
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
                break;
            // 6 - Salir.
            case 6:
                System.out.println("Cerrando Biblioteca...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}