// Libro.java
public class Libro extends RecursoBibliografico {
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false; // Al crear un libro, está disponible por defecto
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public boolean estaDisponible() {
        return !prestado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("=== LIBRO ===");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));
        System.out.println("============");
    }
}