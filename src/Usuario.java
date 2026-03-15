import java.util.List;
import java.util.ArrayList;

public class Usuario {

    // Atributos
    private String nombre;
    private String apellido;
    private int id;
    private List<Libro> librosPrestados;

    // Constructor
    public Usuario(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getId() { return id; }
    public List<Libro> getLibrosPrestados() { return librosPrestados; }

    // Métodos
    public boolean verificarLimite() {
        if (librosPrestados.size() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean prestarLibro(Libro libro) {
        if (verificarLimite() && libro.getDisponibilidad()) {
            librosPrestados.add(libro);
            return true;
        } else {
            return false;
        }
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
        libro.devolverLibro();
    }
}
