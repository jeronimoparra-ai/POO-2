public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private int numeroIdentificacion;
    private Libro libroPrestado;
    private Recibo ultimoRecibo;

    public Usuario(int idUsuario, String nombre, String apellido, int numeroIdentificacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public Recibo getUltimoRecibo() {
        return ultimoRecibo;
    }

    public Recibo prestarLibro(Libro libro) {
        if (libroPrestado != null) {
            System.out.println("  ⚠️  " + nombre + " ya tiene un libro prestado: " + libroPrestado.getTitulo());
            return null;
        }

        if (libro.prestarUnidad()) {
            libroPrestado = libro;
            ultimoRecibo = new Recibo("PRESTAMO", this, libro);
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.print(FormatoConsola.formatoPrestamo(nombre + " " + apellido, libro.getTitulo(), ultimoRecibo.getFecha().format(formatter)));
            return ultimoRecibo;
        }

        System.out.println("  ❌ No hay unidades disponibles de: " + libro.getTitulo());
        return null;
    }

    public Recibo devolverLibro() {
        if (libroPrestado == null) {
            System.out.println("  ⚠️  " + nombre + " no tiene libros para devolver.");
            return null;
        }

        ultimoRecibo = new Recibo("DEVOLUCION", this, libroPrestado);
        System.out.print(FormatoConsola.formatoDevolucion(nombre + " " + apellido, libroPrestado.getTitulo()));
        libroPrestado.devolverUnidad();
        libroPrestado = null;
        return ultimoRecibo;
    }

    @Override
    public String toString() {
        String tituloLibro = (libroPrestado == null) ? "Ninguno" : libroPrestado.getTitulo();
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroIdentificacion=" + numeroIdentificacion +
                ", libroPrestado='" + tituloLibro + '\'' +
                '}';
    }
}
