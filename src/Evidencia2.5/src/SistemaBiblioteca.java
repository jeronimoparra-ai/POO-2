import java.util.ArrayList;
import java.util.List;

/**
 * Clase SistemaBiblioteca: Gestiona el catálogo de libros, usuarios registrados
 * y el registro de todos los préstamos y devoluciones realizados.
 * Demuestra polimorfismo, encapsulamiento y sobrecarga de métodos.
 */
public class SistemaBiblioteca {
    private List<Libro> catalogo;
    private List<Usuario> usuariosRegistrados;
    private List<Recibo> registroDePrestamos;

    /**
     * Constructor que inicializa todas las listas del sistema.
     */
    public SistemaBiblioteca() {
        this.catalogo = new ArrayList<>();
        this.usuariosRegistrados = new ArrayList<>();
        this.registroDePrestamos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo libro al catálogo del sistema.
     */
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("  ✅ Libro agregado: " + libro.getTitulo());
    }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
        System.out.println("  ✅ Usuario registrado: " + usuario.getNombre() + " " + usuario.getApellido());
    }

    /**
     * Realiza un préstamo de un libro a un usuario y genera un recibo.
     */
    public Recibo realizarPrestamo(Usuario usuario, Libro libro) {
        if (libro.prestarUnidad()) {
            Recibo recibo = new Recibo("PRESTAMO", usuario, libro);
            registroDePrestamos.add(recibo);
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.print(FormatoConsola.formatoPrestamo(
                usuario.getNombre() + " " + usuario.getApellido(),
                libro.getTitulo(),
                recibo.getFecha().format(formatter)
            ));
            return recibo;
        }
        System.out.println("  ❌ No hay unidades disponibles de: " + libro.getTitulo());
        return null;
    }

    /**
     * Realiza la devolución de un libro y genera un recibo.
     */
    public Recibo realizarDevolucion(Usuario usuario, Libro libro) {
        libro.devolverUnidad();
        Recibo recibo = new Recibo("DEVOLUCION", usuario, libro);
        registroDePrestamos.add(recibo);
        System.out.print(FormatoConsola.formatoDevolucion(
            usuario.getNombre() + " " + usuario.getApellido(),
            libro.getTitulo()
        ));
        return recibo;
    }

    /**
     * Busca libros por título exacto.
     * Sobrecarga de método: buscarLibro(String titulo)
     */
    public List<Libro> buscarLibro(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    /**
     * Busca libros por título y autor.
     * Sobrecarga de método: buscarLibro(String titulo, String autor)
     * Esto demuestra sobrecarga de métodos con parámetros diferentes.
     */
    public List<Libro> buscarLibro(String titulo, String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) &&
                libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    /**
     * Busca todos los libros de un autor específico.
     */
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    /**
     * Consulta y muestra el registro global de todos los préstamos y devoluciones.
     */
    public void consultarRegistroGlobal() {
        System.out.println("\n" + FormatoConsola.seccion("REGISTRO GLOBAL DE PRÉSTAMOS Y DEVOLUCIONES", "📋"));
        if (registroDePrestamos.isEmpty()) {
            System.out.println("  No hay registros aún.\n");
            return;
        }
        System.out.println(FormatoConsola.encabezadoTablaPrestamos());
        int contador = 1;
        for (Recibo recibo : registroDePrestamos) {
            System.out.print(FormatoConsola.filaTablaPrestamos(contador++, 
                recibo.getUsuario().getNombre() + " " + recibo.getUsuario().getApellido(),
                recibo.getLibro().getTitulo(),
                recibo.getTipo(),
                recibo.getFecha().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        }
        System.out.println(FormatoConsola.pieTablaPrestamos());
    }

    /**
     * Muestra el catálogo completo de libros disponibles.
     */
    public void mostrarCatalogo() {
        System.out.println("\n" + FormatoConsola.seccion("CATÁLOGO DE LIBROS", "📚"));
        if (catalogo.isEmpty()) {
            System.out.println("  El catálogo está vacío.\n");
            return;
        }
        for (Libro libro : catalogo) {
            System.out.println(FormatoConsola.formatoLibro(
                libro.getTitulo(),
                libro.getAutor(),
                libro.getGenero(),
                libro instanceof LibroFiccion ? ((LibroFiccion)libro).getUniversoFicticio() :
                libro instanceof LibroRomance ? ((LibroRomance)libro).getTipoRomance() :
                libro instanceof LibroHistorico ? ((LibroHistorico)libro).getPeriodoHistorico() : "N/A",
                libro.getUnidades(),
                libro.isDisponibilidad()
            ));
        }
    }

    /**
     * Método polimórfico que muestra información de un libro.
     * Demuestra POLIMORFISMO: llama al toString() del tipo específico del libro
     * (Libro, LibroFiccion, LibroRomance o LibroHistorico).
     */
    public void mostrarInfoLibro(Libro libro) {
        String contexto = "N/A";
        if (libro instanceof LibroFiccion) {
            contexto = ((LibroFiccion)libro).getUniversoFicticio();
        } else if (libro instanceof LibroRomance) {
            contexto = ((LibroRomance)libro).getTipoRomance();
        } else if (libro instanceof LibroHistorico) {
            contexto = ((LibroHistorico)libro).getPeriodoHistorico();
        }
        System.out.println(FormatoConsola.formatoLibro(
            libro.getTitulo(),
            libro.getAutor(),
            libro.getGenero(),
            contexto,
            libro.getUnidades(),
            libro.isDisponibilidad()
        ));
    }

    /**
     * Método polimórfico que muestra información de un usuario.
     * Demuestra POLIMORFISMO: llama al toString() del tipo específico del usuario
     * (Usuario, UsuarioEstudiante o UsuarioDocente).
     */
    public void mostrarInfoUsuario(Usuario usuario) {
        if (usuario instanceof UsuarioEstudiante) {
            UsuarioEstudiante est = (UsuarioEstudiante) usuario;
            System.out.println(FormatoConsola.formatoUsuario(
                est.getNombre(),
                est.getApellido(),
                est.getIdUsuario(),
                "Estudiante",
                "📚 Institución: " + est.getInstitucion()
            ));
        } else if (usuario instanceof UsuarioDocente) {
            UsuarioDocente doc = (UsuarioDocente) usuario;
            System.out.println(FormatoConsola.formatoUsuario(
                doc.getNombre(),
                doc.getApellido(),
                doc.getIdUsuario(),
                "Docente",
                "🏫 Departamento: " + doc.getDepartamento()
            ));
        } else {
            System.out.println(FormatoConsola.formatoUsuario(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getIdUsuario(),
                "Usuario General",
                "ID: " + usuario.getNumeroIdentificacion()
            ));
        }
    }

    // Getters
    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public List<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public List<Recibo> getRegistroDePrestamos() {
        return registroDePrestamos;
    }
}
