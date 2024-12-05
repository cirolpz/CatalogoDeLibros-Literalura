# LiterAlura - Catálogo de Libros

## Descripción

En este desafío de programación, te invitamos a construir tu propio catálogo de libros: LiterAlura. Aprenderás a realizar solicitudes a una API de libros, a manipular datos JSON, guardarlos en una base de datos y, finalmente, a filtrar y mostrar los libros y autores de interés.

## Objetivos

- Desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios, proporcionando al menos 5 opciones de interacción.
- Los libros se buscarán a través de una API específica.
- La información sobre la API y las opciones de interacción con el usuario se detallan en la columna "Backlog"/"Listo para iniciar".

## Funcionalidades

- **Buscar Libros**: Buscar libros por nombre utilizando la API.
- **Listar Libros Registrados**: Mostrar una lista de todos los libros almacenados en la base de datos.
- **Listar Autores Registrados**: Mostrar una lista de todos los autores almacenados en la base de datos.
- **Buscar Autores por Fecha de Defunción**: Encontrar autores que estaban vivos hasta una fecha específica.
- **Listar Libros por Idioma**: Mostrar libros filtrados por idioma.

## Configuración

### Prerrequisitos

- Java 17 o superior
- Maven
- IntelliJ IDEA u otro IDE

### Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/cirolpz/literalura.git
    cd literalura
    ```

2. Construye el proyecto usando Maven:
    ```sh
    mvn clean install
    ```

3. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```

## Uso

1. Ejecuta la aplicación.
2. Sigue las opciones del menú en la consola para interactuar con el catálogo de libros.

## Estructura del Proyecto

- `src/main/java/com/aluracurso/biblioteca/entity`: Contiene las clases de entidad.
- `src/main/java/com/aluracurso/biblioteca/model`: Contiene las clases de modelo.
- `src/main/java/com/aluracurso/biblioteca/repository`: Contiene las interfaces de repositorio.
- `src/main/java/com/aluracurso/biblioteca/service`: Contiene las clases de servicio.
- `src/main/java/com/aluracurso/biblioteca/view`: Contiene las clases de vista.

## API

El proyecto utiliza la [API de Gutenberg](https://gutendex.com/books/) para buscar libros.

## Contribuciones

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature-branch`).
3. Realiza tus cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4. Sube los cambios a la rama (`git push origin feature-branch`).
5. Abre un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.