// Usuario.java
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<RecursoBibliografico> recursosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.recursosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<RecursoBibliografico> getRecursosPrestados() {
        return recursosPrestados;
    }

    public boolean prestarRecurso(RecursoBibliografico recurso) {
        if (recurso.estaDisponible()) {
            if (recurso instanceof Libro) {
                ((Libro) recurso).setPrestado(true);
                recursosPrestados.add(recurso);
                return true;
            } else if (recurso instanceof Revista) {
                ((Revista) recurso).prestarEjemplar();
                recursosPrestados.add(recurso);
                return true;
            }
        }
        return false;
    }

    public boolean devolverRecurso(RecursoBibliografico recurso) {
        if (recursosPrestados.contains(recurso)) {
            if (recurso instanceof Libro) {
                ((Libro) recurso).setPrestado(false);
                recursosPrestados.remove(recurso);
                return true;
            } else if (recurso instanceof Revista) {
                ((Revista) recurso).devolverEjemplar();
                recursosPrestados.remove(recurso);
                return true;
            }
        }
        return false;
    }

    public void mostrarRecursosPrestados() {
        if (recursosPrestados.isEmpty()) {
            System.out.println("El usuario " + nombre + " no tiene recursos prestados.");
            return;
        }

        System.out.println("Recursos prestados a " + nombre + ":");
        for (RecursoBibliografico recurso : recursosPrestados) {
            recurso.mostrarDetalle();
        }
    }
}