public class LibroFiccion extends Libro {
    private String universoFicticio;

    public LibroFiccion(String titulo, String autor, String genero, boolean disponibilidad, int unidades,
                        String universoFicticio) {
        super(titulo, autor, genero, disponibilidad, unidades);
        this.universoFicticio = universoFicticio;
    }

    public String getUniversoFicticio() {
        return universoFicticio;
    }

    public void setUniversoFicticio(String universoFicticio) {
        this.universoFicticio = universoFicticio;
    }

    @Override
    public String toString() {
        return "Libro Ficcion{" +
                "base=" + super.toString() +
                ", universoFicticio='" + universoFicticio + '\'' +
                '}';
    }
}

