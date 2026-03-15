import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {

    // Atributos
    private List<Libro> catalogo;
    private List<Usuario> usuariosRegistrados;
    private List<Recibo> registroDePrestamos;

    // Constructor
    public SistemaBiblioteca() {
        this.catalogo = new ArrayList<>();
        this.usuariosRegistrados = new ArrayList<>();
        this.registroDePrestamos = new ArrayList<>();
    }

    // Agregar libro al catálogo
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    // Registrar usuario
    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    // Realizar préstamo
    public void realizarPrestamo(Usuario usuario, Libro libro) {
        if (usuario.prestarLibro(libro)) {
            Recibo recibo = new Recibo(libro, usuario);
            registroDePrestamos.add(recibo);
            recibo.generarRecibo();
        } else {
            System.out.println("No se pudo realizar el prestamo.");
        }
    }

    // Realizar devolución
    public void realizarDevolucion(Usuario usuario, Libro libro) {
        usuario.devolverLibro(libro);
        System.out.println("Devolucion exitosa: " + libro.getTitulo());
    }

    // Buscar por título
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Buscar por autor
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Consultar registro global
    public void consultarRegistroGlobal() {
        System.out.println("\n=== REGISTRO GLOBAL DE PRESTAMOS ===");
        if (registroDePrestamos.isEmpty()) {
            System.out.println("No hay prestamos registrados.");
        } else {
            for (Recibo recibo : registroDePrestamos) {
                System.out.println("Libro: " + recibo.getLibro().getTitulo() +
                        " | Usuario: " + recibo.getUsuario().getNombre() +
                        " | Fecha: " + recibo.getFechaDePrestamo());
            }
        }
        System.out.println("====================================\n");
    }
}
