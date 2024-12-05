package com.aluracurso.biblioteca;

import com.aluracurso.biblioteca.repository.AutorRepository;
import com.aluracurso.biblioteca.repository.LibroRepository;
import com.aluracurso.biblioteca.view.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Vista vista = new Vista();
		vista.menuPrincipal(libroRepository, autorRepository);
	}
}
