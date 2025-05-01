# Sistema de Gestión de Biblioteca

Este es un sistema simple de gestión de biblioteca desarrollado en Java. Permite gestionar libros y revistas, registrar préstamos y devoluciones, y llevar un control de los recursos prestados por usuario.

## Características

- Listado de todos los recursos bibliográficos (libros y revistas).
- Filtro para ver solo libros o solo revistas disponibles.
- Registro de usuarios de forma dinámica al momento del préstamo.
- Préstamo y devolución de recursos.
- Visualización de los recursos prestados por usuario.

## Estructura

El archivo `Main.java` contiene la lógica principal del sistema, incluyendo:

- Un menú interactivo para el usuario.
- Funciones para prestar y devolver recursos.
- Funcionalidades para gestionar usuarios y recursos desde consola.

Este sistema utiliza clases como `Biblioteca`, `Usuario` y `RecursoBibliografico`, que deben estar definidas en archivos separados dentro del mismo proyecto.

## Cómo usar

1. Clona o descarga este repositorio.
2. Asegúrate de tener Java instalado (Java 8 o superior).
3. Compila el proyecto desde tu IDE o usando terminal:
   ```bash
   javac Main.java
