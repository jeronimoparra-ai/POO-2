public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponibilidad;
    private int unidades;

    public Libro(String titulo, String autor, String genero, boolean disponibilidad, int unidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
        this.unidades = Math.max(unidades, 0);
        if (this.unidades == 0) {
            this.disponibilidad = false;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = Math.max(unidades, 0);
        this.disponibilidad = this.unidades > 0;
    }

    public boolean prestarUnidad() {
        if (unidades <= 0) {
            disponibilidad = false;
            return false;
        }

        unidades--;
        disponibilidad = unidades > 0;
        return true;
    }

    public void devolverUnidad() {
        unidades++;
        disponibilidad = true;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", unidades=" + unidades +
                '}';
    }
}
