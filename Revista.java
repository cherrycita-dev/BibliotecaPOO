// Revista.java
public class Revista extends RecursoBibliografico {
    private String issn;
    private int anioPublicacion;
    private int ejemplares;

    public Revista(String id, String titulo, String issn, int anioPublicacion, int ejemplares) {
        super(id, titulo);
        this.issn = issn;
        this.anioPublicacion = anioPublicacion;
        this.ejemplares = ejemplares;
    }

    public String getIssn() {
        return issn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void prestarEjemplar() {
        if (ejemplares > 0) {
            ejemplares--;
        }
    }

    public void devolverEjemplar() {
        ejemplares++;
    }

    @Override
    public boolean estaDisponible() {
        return ejemplares > 0;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("=== REVISTA ===");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("ISSN: " + issn);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("Ejemplares disponibles: " + ejemplares);
        System.out.println("===============");
    }
}