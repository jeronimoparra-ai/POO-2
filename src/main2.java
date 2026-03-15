public class Main1 {
    public static void main(String[] args) {

        // 1. Crear libros
        Libro libro1 = new Libro("Cien Años de Soledad", "Garcia Marquez", 3);
        Libro libro2 = new Libro("1984", "George Orwell", 1);
        Libro libro3 = new Libro("El Quijote", "Cervantes", 2);

        // 2. Crear usuarios
        Usuario usuario1 = new Usuario("Andres", "Parra", 1001);
        Usuario usuario2 = new Usuario("Juan", "Rueda", 1002);

        // 3. Prestar libros
        usuario1.prestarLibro(libro1);
        usuario1.prestarLibro(libro2);

        // 4. Generar recibo
        Recibo recibo1 = new Recibo(libro1, usuario1);
        recibo1.generarRecibo();

        // 5. Devolver un libro
        usuario1.devolverLibro(libro1);

        // 6. Verificar límite
        System.out.println("¿Puede pedir mas libros? " + usuario1.verificarLimite());
    }
}