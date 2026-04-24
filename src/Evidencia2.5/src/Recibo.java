import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recibo {
    private static int contadorRecibos = 1000;
    private int numeroRecibo;
    private String tipo; // "PRESTAMO" o "DEVOLUCION"
    private Usuario usuario;
    private Libro libro;
    private LocalDateTime fecha;

    public Recibo(String tipo, Usuario usuario, Libro libro) {
        this.numeroRecibo = ++contadorRecibos;
        this.tipo = tipo;
        this.usuario = usuario;
        this.libro = libro;
        this.fecha = LocalDateTime.now();
    }

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public String getTipo() {
        return tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Recibo{" +
                "numeroRecibo=" + numeroRecibo +
                ", tipo='" + tipo + '\'' +
                ", usuario='" + usuario.getNombre() + " " + usuario.getApellido() + '\'' +
                ", libro='" + libro.getTitulo() + '\'' +
                ", fecha=" + fecha.format(formatter) +
                '}';
    }
}

