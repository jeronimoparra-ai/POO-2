# 📚 Sistema de Gestión Bibliotecaria — Java POO

Sistema de gestión de biblioteca implementado en Java aplicando los principios de
Programación Orientada a Objetos (POO). Desarrollado como proyecto universitario
para la asignatura Programación Orientada A Objetos en la IU Digital de Antioquia.

---

## 👥 Integrantes

| Nombre | 
|--------|
| Andres Jeronimo Parra Bastidas |
| Juan Angel Rueda Correa |
| Luis Fernando Castaño Rua |

**Docente:** Julian Andres Loaiza  
**Institución:** IU Digital de Antioquia  
**Año:** 2026

---

## 📋 Descripción

El sistema permite gestionar los préstamos y devoluciones de una biblioteca,
controlando el inventario de libros y los usuarios registrados. Se aplicaron
los conceptos de encapsulamiento, modificadores de acceso (private/public),
métodos con parámetros y diferenciación entre variables locales y globales.

---

## 🏗️ Clases del Sistema

| Clase | Descripción |
|-------|-------------|
| `Libro` | Guarda los datos del ejemplar y controla su disponibilidad |
| `Usuario` | Gestiona la lista de libros prestados y verifica el límite de 3 |
| `Recibo` | Registra qué libro se prestó, a quién y en qué fecha |
| `SistemaBiblioteca` | Coordina todas las operaciones del sistema |

---

## ⚙️ Funcionalidades

- ✅ Registrar libros y usuarios en el sistema
- ✅ Prestar libros verificando disponibilidad y límite de 3 por usuario
- ✅ Devolver libros y actualizar el inventario automáticamente
- ✅ Buscar libros por título o por autor
- ✅ Generar recibo de cada préstamo realizado
- ✅ Consultar el registro global de todos los préstamos

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/jeronimoparra-ai/POO-2.git
```

2. Abre el proyecto en **IntelliJ IDEA**

3. Ejecuta la clase `Main.java` con clic derecho → **Run 'Main.main()'**

---

## 📁 Estructura del proyecto

```
src/
├── Libro.java
├── Usuario.java
├── Recibo.java
├── SistemaBiblioteca.java
└── Main.java
```

https://github.com/jeronimoparra-ai/POO-2/tree/master/src

---

## 💻 Código Fuente

### 📖 Libro.java

```java
public class Libro {

    // Atributos privados — encapsulamiento
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponibilidad;
    private int unidades;

    // Constructor
    public Libro(String titulo, String autor, String genero, int unidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.unidades = unidades;
        this.disponibilidad = unidades > 0;
    }

    // Getters
    public String getTitulo()        { return titulo; }
    public String getAutor()         { return autor; }
    public String getGenero()        { return genero; }
    public boolean isDisponibilidad(){ return disponibilidad; }
    public int getUnidades()         { return unidades; }

    // Setters
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor)   { this.autor = autor; }

    // Actualiza disponibilidad segun unidades
    public void actualizarEstado() {
        this.disponibilidad = this.unidades > 0;
    }

    // Resta una unidad al prestar
    public boolean prestar() {
        if (this.unidades > 0) {
            this.unidades--;
            actualizarEstado();
            return true;
        }
        return false;
    }

    // Suma una unidad al devolver
    public void devolver() {
        this.unidades++;
        actualizarEstado();
    }

    @Override
    public String toString() {
        return String.format("Libro{titulo='%s', autor='%s', disponible=%b, unidades=%d}",
                titulo, autor, disponibilidad, unidades);
    }
}
```

---

### 👤 Usuario.java

```java
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    // Constante global: limite maximo de prestamos simultaneos
    private static final int LIMITE_PRESTAMOS = 3;

    // Atributos privados
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
    public String getNombre()              { return nombre; }
    public String getApellido()            { return apellido; }
    public int getId()                     { return id; }
    public List<Libro> getLibrosPrestados(){ return librosPrestados; }

    // Setters
    public void setNombre(String nombre)     { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Verifica si puede pedir mas libros
    public boolean verificarLimite() {
        return librosPrestados.size() < LIMITE_PRESTAMOS;
    }

    // Presta un libro si hay disponibilidad y no supero el limite
    public boolean prestarLibro(Libro libro) {
        if (verificarLimite() && libro.isDisponibilidad()) {
            librosPrestados.add(libro);
            libro.prestar();
            return true;
        }
        return false;
    }

    // Devuelve un libro
    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
        libro.devolver();
    }

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, nombre='%s %s', librosPrestados=%d/%d}",
                id, nombre, apellido, librosPrestados.size(), LIMITE_PRESTAMOS);
    }
}
```

---

### 🧾 Recibo.java

```java
import java.util.Date;
import java.text.SimpleDateFormat;

public class Recibo {

    // Atributos privados
    private Libro libro;
    private Usuario usuario;
    private Date fechaDePrestamo;

    // Constructor — la fecha se asigna automaticamente
    public Recibo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaDePrestamo = new Date();
    }

    // Getters
    public Libro   getLibro()           { return libro; }
    public Usuario getUsuario()         { return usuario; }
    public Date    getFechaDePrestamo() { return fechaDePrestamo; }

    // Genera e imprime el recibo en consola
    public void generarRecibo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = sdf.format(fechaDePrestamo);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         RECIBO DE PRÉSTAMO               ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ Libro   : " + libro.getTitulo());
        System.out.println("║ Autor   : " + libro.getAutor());
        System.out.println("║ Usuario : " + usuario.getNombre() + " " + usuario.getApellido());
        System.out.println("║ ID      : " + usuario.getId());
        System.out.println("║ Fecha   : " + fecha);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    @Override
    public String toString() {
        return String.format("Recibo{libro='%s', usuario='%s %s', fecha=%s}",
                libro.getTitulo(), usuario.getNombre(), usuario.getApellido(),
                new SimpleDateFormat("dd/MM/yyyy").format(fechaDePrestamo));
    }
}
```

---

### 🏛️ SistemaBiblioteca.java

```java
import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {

    // Atributos privados (variables globales del sistema)
    private List<Libro>   catalogo;
    private List<Usuario> usuariosRegistrados;
    private List<Recibo>  registroDePrestamos;

    // Constructor
    public SistemaBiblioteca() {
        this.catalogo            = new ArrayList<>();
        this.usuariosRegistrados = new ArrayList<>();
        this.registroDePrestamos = new ArrayList<>();
    }

    // Agrega un libro al catalogo
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    // Registra un usuario en el sistema
    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    // Realiza el prestamo y genera el recibo
    public void realizarPrestamo(Usuario usuario, Libro libro) {
        if (usuario.prestarLibro(libro)) {
            Recibo recibo = new Recibo(libro, usuario);
            registroDePrestamos.add(recibo);
            recibo.generarRecibo();
        } else {
            System.out.println("No se pudo realizar el prestamo.");
        }
    }

    // Realiza la devolucion del libro
    public void realizarDevolucion(Usuario usuario, Libro libro) {
        usuario.devolverLibro(libro);
        System.out.println("Devolucion exitosa: " + libro.getTitulo());
    }

    // Busca libros por titulo — variable local: resultados
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                resultados.add(libro);
        }
        return resultados;
    }

    // Busca libros por autor — variable local: resultados
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                resultados.add(libro);
        }
        return resultados;
    }

    // Consulta el registro global de todos los prestamos
    public void consultarRegistroGlobal() {
        System.out.println("\n=== REGISTRO GLOBAL DE PRESTAMOS ===");
        if (registroDePrestamos.isEmpty()) {
            System.out.println("No hay prestamos registrados.");
        } else {
            int contador = 1;
            for (Recibo recibo : registroDePrestamos) {
                System.out.println(contador + ". " + recibo);
                contador++;
            }
        }
        System.out.println("=====================================\n");
    }
}
```

---

### ▶️ Main.java

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Crear el sistema
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // 2. Agregar libros al catalogo
        Libro libro1 = new Libro("Cien Anos de Soledad", "Garcia Marquez", "Novela", 3);
        Libro libro2 = new Libro("1984", "George Orwell", "Distopia", 1);
        Libro libro3 = new Libro("El Quijote", "Cervantes", "Clasico", 2);

        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);
        sistema.agregarLibro(libro3);

        // 3. Registrar usuarios
        Usuario usuario1 = new Usuario("Andres", "Parra", 1001);
        Usuario usuario2 = new Usuario("Juan", "Rueda", 1002);

        sistema.registrarUsuario(usuario1);
        sistema.registrarUsuario(usuario2);

        // 4. Realizar prestamos
        sistema.realizarPrestamo(usuario1, libro1);
        sistema.realizarPrestamo(usuario1, libro2);

        // 5. Intentar superar el limite de 3 prestamos
        sistema.realizarPrestamo(usuario1, libro3);

        // 6. Buscar libro por autor
        System.out.println("\n=== BUSQUEDA POR AUTOR: Garcia ===");
        List<Libro> resultados = sistema.buscarPorAutor("Garcia");
        for (Libro l : resultados) {
            System.out.println("Encontrado: " + l.getTitulo());
        }

        // 7. Consultar registro global
        sistema.consultarRegistroGlobal();

        // 8. Devolver un libro
        sistema.realizarDevolucion(usuario1, libro1);

        // 9. Verificar limite despues de devolucion
        System.out.println("Puede pedir mas libros: " + usuario1.verificarLimite());
    }
}
```

---

## 🔒 Encapsulamiento aplicado

Todos los atributos de las clases son **private** para proteger
los datos internos del sistema. Solo se accede a ellos a través
de métodos públicos (getters y setters).

```java
// Ejemplo en la clase Libro
private String titulo;           // nadie puede modificarlo directamente
private boolean disponibilidad;

public String getTitulo() {      // solo así se puede leer
    return titulo;
}
```

---

## 📊 Diagrama UML

El diagrama de clases fue elaborado en LucidChart:  
https://lucid.app/lucidchart/0ba6e8fa-479b-4fa1-b0bb-f947cf16d115/edit

---

## 📄 Licencia

Proyecto académico — IU Digital de Antioquia 2026
