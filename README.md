# 📚 Sistema de Gestión Bibliotecaria — Java POO

Sistema de gestión de biblioteca implementado en Java aplicando los principios de
Programación Orientada a Objetos (POO). Desarrollado como proyecto universitario
para la asignatura Fundamentos de la Programación en la IU Digital de Antioquia.

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
