public class LibroHistorico extends Libro {
    private String periodoHistorico;

    public LibroHistorico(String titulo, String autor, String genero, boolean disponibilidad, int unidades,
                          String periodoHistorico) {
        super(titulo, autor, genero, disponibilidad, unidades);
        this.periodoHistorico = periodoHistorico;
    }

    public String getPeriodoHistorico() {
        return periodoHistorico;
    }

    public void setPeriodoHistorico(String periodoHistorico) {
        this.periodoHistorico = periodoHistorico;
    }

    @Override
    public String toString() {
        return "LibroHistorico{" +
                "base=" + super.toString() +
                ", periodoHistorico='" + periodoHistorico + '\'' +
                '}';
    }
}

