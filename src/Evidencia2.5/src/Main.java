import java.util.List;

/**
 * Clase Main - Punto de entrada del Sistema de Gestión de Biblioteca
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(FormatoConsola.encabezadoPrincipal());

        // Crear instancia del sistema
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Crear libros de ficción
        LibroFiccion libroFiccion1 = new LibroFiccion("Harry Potter y la Piedra Filosofal", "J.K. Rowling", "Ficción Mágica", true, 3, "Universo de Hogwarts");
        LibroFiccion libroFiccion2 = new LibroFiccion("El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía Épica", true, 2, "Tierra Media");

        // Crear libros de romance
        LibroRomance libroRomance1 = new LibroRomance("Orgullo y Prejuicio", "Jane Austen", "Romance Clásico", true, 2, "Romance Histórico");
        LibroRomance libroRomance2 = new LibroRomance("Cumbres Borrascosas", "Emily Brontë", "Romance Gótico", true, 1, "Romance Pasional");

        // Crear libros históricos
        LibroHistorico libroHistorico1 = new LibroHistorico("1984", "George Orwell", "Distopía Histórica", true, 2, "Siglo XX - Totalitarismo");
        LibroHistorico libroHistorico2 = new LibroHistorico("Cien Años de Soledad", "Gabriel García Márquez", "Realismo Mágico", true, 3, "Colombia - Siglos XIX-XX");

        // Crear usuarios
        UsuarioEstudiante usuarioEstudiante = new UsuarioEstudiante(1001, "Juan Angel", "Rueda Correa", 1001, "IU Digital de Antioquia");
        UsuarioDocente usuarioDocente = new UsuarioDocente(2001, "Luis Fernando", "Castano Rua", 2001, "Departamento de Programación");

        System.out.println("\n✅ Objetos creados exitosamente\n");

        // Agregar libros al catálogo
        System.out.println("Agregando libros al catálogo...");
        sistema.agregarLibro(libroFiccion1);
        sistema.agregarLibro(libroFiccion2);
        sistema.agregarLibro(libroRomance1);
        sistema.agregarLibro(libroRomance2);
        sistema.agregarLibro(libroHistorico1);
        sistema.agregarLibro(libroHistorico2);

        // Registrar usuarios
        System.out.println("\nRegistrando usuarios...");
        sistema.registrarUsuario(usuarioEstudiante);
        sistema.registrarUsuario(usuarioDocente);

        // Realizar préstamos
        System.out.println(FormatoConsola.seccion("REALIZANDO PRÉSTAMOS", "📚"));
        sistema.realizarPrestamo(usuarioEstudiante, libroFiccion1);
        sistema.realizarPrestamo(usuarioEstudiante, libroRomance1);
        sistema.realizarPrestamo(usuarioDocente, libroHistorico1);
        sistema.realizarPrestamo(usuarioDocente, libroFiccion2);

        // Demostrar polimorfismo en libros
        System.out.println("\n" + FormatoConsola.seccion("DEMOSTRANDO POLIMORFISMO", "📖"));
        System.out.println("El método mostrarInfoLibro() se adapta al tipo real del objeto:\n");
        sistema.mostrarInfoLibro(libroFiccion1);
        sistema.mostrarInfoLibro(libroRomance1);
        sistema.mostrarInfoLibro(libroHistorico1);

        // Demostrar polimorfismo en usuarios
        System.out.println(FormatoConsola.seccion("POLIMORFISMO EN USUARIOS", "👤"));
        sistema.mostrarInfoUsuario(usuarioEstudiante);
        sistema.mostrarInfoUsuario(usuarioDocente);

        // Demostrar sobrecarga de métodos
        System.out.println(FormatoConsola.seccion("DEMOSTRANDO SOBRECARGA DE MÉTODOS", "🔍"));
        
        System.out.println(FormatoConsola.formatoBusqueda("Harry Potter"));
        List<Libro> resultados1 = sistema.buscarLibro("Harry Potter y la Piedra Filosofal");
        if (resultados1.isEmpty()) {
            System.out.println("  └─ Sin resultados\n");
        } else {
            for (int i = 0; i < resultados1.size(); i++) {
                if (i == resultados1.size() - 1) {
                    System.out.println("  └─ Resultado " + (i+1) + ": " + resultados1.get(i).getTitulo());
                } else {
                    System.out.println("  ├─ Resultado " + (i+1) + ": " + resultados1.get(i).getTitulo());
                }
            }
            System.out.println("  └─ Total encontrados: " + resultados1.size() + "\n");
        }

        System.out.println(FormatoConsola.formatoBusqueda("Orgullo"));
        List<Libro> resultados2 = sistema.buscarLibro("Orgullo y Prejuicio", "Jane Austen");
        if (resultados2.isEmpty()) {
            System.out.println("  └─ Sin resultados\n");
        } else {
            for (int i = 0; i < resultados2.size(); i++) {
                if (i == resultados2.size() - 1) {
                    System.out.println("  └─ Resultado " + (i+1) + ": " + resultados2.get(i).getTitulo() + " por " + resultados2.get(i).getAutor());
                } else {
                    System.out.println("  ├─ Resultado " + (i+1) + ": " + resultados2.get(i).getTitulo() + " por " + resultados2.get(i).getAutor());
                }
            }
            System.out.println("  └─ Total encontrados: " + resultados2.size() + "\n");
        }

        // Mostrar catálogo
        sistema.mostrarCatalogo();

        // Realizar devoluciones
        System.out.println("\n" + FormatoConsola.seccion("REALIZANDO DEVOLUCIONES", "🔄"));
        sistema.realizarDevolucion(usuarioEstudiante, libroFiccion1);
        System.out.println("Libros que quedan prestados al estudiante: " + (usuarioEstudiante.getLibroPrestado() != null ? 1 : 0) + "/3");

        // Consultar registro global
        sistema.consultarRegistroGlobal();

        // Contar préstamos y devoluciones
        int totalPrestamos = 0;
        int totalDevoluciones = 0;
        for (Recibo recibo : sistema.getRegistroDePrestamos()) {
            if (recibo.getTipo().equals("PRESTAMO")) totalPrestamos++;
            else if (recibo.getTipo().equals("DEVOLUCION")) totalDevoluciones++;
        }

        System.out.print(FormatoConsola.cierrePrincipal(totalPrestamos, totalDevoluciones));
    }
}
