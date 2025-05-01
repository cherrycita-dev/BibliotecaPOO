// RecursoBibliografico.java
public abstract class RecursoBibliografico {
    protected String id;
    protected String titulo;

    public RecursoBibliografico(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    // Método abstracto que deberán implementar las clases hijas
    public abstract void mostrarDetalle();

    // Método abstracto para verificar disponibilidad
    public abstract boolean estaDisponible();
}