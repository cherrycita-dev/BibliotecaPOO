// Biblioteca.java
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<RecursoBibliografico> recursos;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.recursos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarRecurso(RecursoBibliografico recurso) {
        recursos.add(recurso);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public RecursoBibliografico buscarRecursoPorId(String id) {
        for (RecursoBibliografico recurso : recursos) {
            if (recurso.getId().equals(id)) {
                return recurso;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public void listarTodosLosRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos en la biblioteca.");
            return;
        }

        System.out.println("Lista de todos los recursos:");
        for (RecursoBibliografico recurso : recursos) {
            recurso.mostrarDetalle();
        }
    }

    public void listarLibrosDisponibles() {
        boolean hayLibros = false;

        System.out.println("Libros disponibles:");
        for (RecursoBibliografico recurso : recursos) {
            if (recurso instanceof Libro && recurso.estaDisponible()) {
                recurso.mostrarDetalle();
                hayLibros = true;
            }
        }

        if (!hayLibros) {
            System.out.println("No hay libros disponibles.");
        }
    }

    public void listarRevistasDisponibles() {
        boolean hayRevistas = false;

        System.out.println("Revistas disponibles:");
        for (RecursoBibliografico recurso : recursos) {
            if (recurso instanceof Revista && recurso.estaDisponible()) {
                recurso.mostrarDetalle();
                hayRevistas = true;
            }
        }

        if (!hayRevistas) {
            System.out.println("No hay revistas disponibles.");
        }
    }

    public void inicializarDatosDePrueba() {
        // Crear 5 libros de ejemplo
        agregarRecurso(new Libro("L001", "Cien años de soledad", "Gabriel García Márquez", "9780307474728"));
        agregarRecurso(new Libro("L002", "El código Da Vinci", "Dan Brown", "9780307474529"));
        agregarRecurso(new Libro("L003", "Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884459"));
        agregarRecurso(new Libro("L004", "El principito", "Antoine de Saint-Exupéry", "9788478887194"));
        agregarRecurso(new Libro("L005", "Don Quijote de la Mancha", "Miguel de Cervantes", "9788420412146"));

        // Crear 3 revistas de ejemplo
        agregarRecurso(new Revista("R001", "National Geographic", "0027-9358", 2023, 5));
        agregarRecurso(new Revista("R002", "Scientific American", "0036-8733", 2023, 3));
        agregarRecurso(new Revista("R003", "Time", "0040-781X", 2023, 8));

        // Crear usuarios de ejemplo
        agregarUsuario(new Usuario("Juan Pérez"));
        agregarUsuario(new Usuario("María López"));
    }
}