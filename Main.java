// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Inicializar datos de prueba
        biblioteca.inicializarDatosDePrueba();

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    biblioteca.listarTodosLosRecursos();
                    break;
                case 2:
                    biblioteca.listarLibrosDisponibles();
                    break;
                case 3:
                    biblioteca.listarRevistasDisponibles();
                    break;
                case 4:
                    prestarRecurso(scanner, biblioteca);
                    break;
                case 5:
                    devolverRecurso(scanner, biblioteca);
                    break;
                case 6:
                    verRecursosPrestados(scanner, biblioteca);
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el Sistema de Gestión de Biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println(); // Línea en blanco para mejor visualización
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("1. Listar todos los recursos");
        System.out.println("2. Listar libros disponibles");
        System.out.println("3. Listar revistas disponibles");
        System.out.println("4. Prestar recurso");
        System.out.println("5. Devolver recurso");
        System.out.println("6. Ver recursos prestados por usuario");
        System.out.println("0. Salir");
        System.out.println("=======================================");
    }

    private static void prestarRecurso(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = biblioteca.buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado. ¿Desea crear un nuevo usuario? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                usuario = new Usuario(nombreUsuario);
                biblioteca.agregarUsuario(usuario);
                System.out.println("Usuario creado exitosamente.");
            } else {
                return;
            }
        }

        System.out.print("Ingrese el ID del recurso a prestar: ");
        String idRecurso = scanner.nextLine();

        RecursoBibliografico recurso = biblioteca.buscarRecursoPorId(idRecurso);
        if (recurso == null) {
            System.out.println("Recurso no encontrado.");
            return;
        }

        if (usuario.prestarRecurso(recurso)) {
            System.out.println("Recurso prestado exitosamente.");
        } else {
            System.out.println("No se pudo prestar el recurso. Verifique si está disponible.");
        }
    }

    private static void devolverRecurso(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = biblioteca.buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        if (usuario.getRecursosPrestados().isEmpty()) {
            System.out.println("El usuario no tiene recursos prestados.");
            return;
        }

        usuario.mostrarRecursosPrestados();

        System.out.print("Ingrese el ID del recurso a devolver: ");
        String idRecurso = scanner.nextLine();

        RecursoBibliografico recurso = biblioteca.buscarRecursoPorId(idRecurso);
        if (recurso == null) {
            System.out.println("Recurso no encontrado.");
            return;
        }

        if (usuario.devolverRecurso(recurso)) {
            System.out.println("Recurso devuelto exitosamente.");
        } else {
            System.out.println("No se pudo devolver el recurso. Verifique que el usuario tenga este recurso prestado.");
        }
    }

    private static void verRecursosPrestados(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = biblioteca.buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        usuario.mostrarRecursosPrestados();
    }
}