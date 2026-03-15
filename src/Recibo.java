import java.util.Date;
import java.text.SimpleDateFormat;

public class Recibo {

    // Atributos
    private Libro libro;
    private Usuario usuario;
    private Date fechaDePrestamo;

    // Constructor
    public Recibo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaDePrestamo = new Date(); // guarda la fecha actual automáticamente
    }

    // Getters
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public Date getFechaDePrestamo() { return fechaDePrestamo; }

    // Método principal
    public void generarRecibo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fechaDePrestamo);

        System.out.println("=== RECIBO DE PRÉSTAMO ===");
        System.out.println("Libro  : " + libro.getTitulo());
        System.out.println("Autor  : " + libro.getAutor());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Fecha  : " + fecha);
        System.out.println("=========================");
    }
}
