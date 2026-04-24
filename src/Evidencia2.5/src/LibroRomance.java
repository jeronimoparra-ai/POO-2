public class LibroRomance extends Libro {
    private String tipoRomance;

    public LibroRomance(String titulo, String autor, String genero, boolean disponibilidad, int unidades,
                        String tipoRomance) {
        super(titulo, autor, genero, disponibilidad, unidades);
        this.tipoRomance = tipoRomance;
    }

    public String getTipoRomance() {
        return tipoRomance;
    }

    public void setTipoRomance(String tipoRomance) {
        this.tipoRomance = tipoRomance;
    }

    @Override
    public String toString() {
        return "LibroRomance{" +
                "base=" + super.toString() +
                ", tipoRomance='" + tipoRomance + '\'' +
                '}';
    }
}

