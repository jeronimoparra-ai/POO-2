import java.util.List;

public class main2 {
    public static void main(String[] args) {

        // 1. Crear el sistema
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // 2. Agregar libros
        Libro libro1 = new Libro("Cien Años de Soledad", "Garcia Marquez", 3);
        Libro libro2 = new Libro("1984", "George Orwell", 1);
        Libro libro3 = new Libro("El Quijote", "Cervantes", 2);

        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);
        sistema.agregarLibro(libro3);

        // 3. Registrar usuarios
        Usuario usuario1 = new Usuario("Andres", "Parra", 1001);
        Usuario usuario2 = new Usuario("Juan", "Rueda", 1002);

        sistema.registrarUsuario(usuario1);
        sistema.registrarUsuario(usuario2);

        // 4. Realizar préstamos
        sistema.realizarPrestamo(usuario1, libro1);
        sistema.realizarPrestamo(usuario1, libro2);

        // 5. Buscar libro
        System.out.println("\n=== BUSQUEDA POR AUTOR: Garcia ===");
        List<Libro> resultados = sistema.buscarPorAutor("Garcia");
        for (Libro l : resultados) {
            System.out.println("Encontrado: " + l.getTitulo());
        }

        // 6. Consultar registro global
        sistema.consultarRegistroGlobal();

        // 7. Devolver un libro
        sistema.realizarDevolucion(usuario1, libro1);

        // 8. Verificar límite
        System.out.println("¿Puede pedir mas libros? " + usuario1.verificarLimite());
    }
}
