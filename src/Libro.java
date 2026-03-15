public class Libro {
    private String titulo;
    private String autor;
    private int unidades;
    private boolean disponibilidad;

    public Libro(String titulo, String autor, int unidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.unidades = unidades;
        this.disponibilidad = unidades > 0;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getUnidades() { return unidades; }
    public boolean getDisponibilidad() { return disponibilidad; }

    public boolean prestarLibro() {
        if (unidades > 0) {
            unidades--;
            return true;
        } else {
            return false;
        }
    }

    public void devolverLibro() {
        unidades++;
    }
}
