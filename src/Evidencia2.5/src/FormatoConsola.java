/**
 * Clase utilitaria para mantener un formato visual consistente en la consola.
 * Proporciona métodos estáticos para crear separadores, encabezados y formatos.
 */
public class FormatoConsola {
    // Ancho estándar para los recuadros
    private static final int ANCHO = 52;
    
    // Caracteres para recuadros
    private static final String ESQUINA_SUPERIOR_IZQ = "╔";
    private static final String ESQUINA_SUPERIOR_DER = "╗";
    private static final String ESQUINA_INFERIOR_IZQ = "╚";
    private static final String ESQUINA_INFERIOR_DER = "╝";
    private static final String LINEA_HORIZONTAL = "═";
    private static final String LINEA_VERTICAL = "║";
    
    private static final String ESQUINA_SUP_SECUNDARIA = "┌";
    private static final String ESQUINA_INF_SECUNDARIA = "└";
    private static final String LINEA_SECUNDARIA = "─";
    private static final String ESQUINA_DER_SECUNDARIA = "┐";
    private static final String ESQUINA_INF_DER_SECUNDARIA = "┘";
    
    /**
     * Crea un encabezado principal con diseño de caja
     */
    public static String encabezadoPrincipal() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(ESQUINA_SUPERIOR_IZQ).append(repetir(LINEA_HORIZONTAL, ANCHO)).append(ESQUINA_SUPERIOR_DER).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("🏛️  SISTEMA DE GESTIÓN DE BIBLIOTECA", ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("Institución Universitaria Digital", ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("de Antioquia", ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(ESQUINA_INFERIOR_IZQ).append(repetir(LINEA_HORIZONTAL, ANCHO)).append(ESQUINA_INFERIOR_DER).append("\n");
        return sb.toString();
    }
    
    /**
     * Crea un cierre profesional
     */
    public static String cierrePrincipal(int totalPrestamos, int totalDevoluciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(ESQUINA_SUPERIOR_IZQ).append(repetir(LINEA_HORIZONTAL, ANCHO)).append(ESQUINA_SUPERIOR_DER).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("✅ EJECUCIÓN FINALIZADA EXITOSAMENTE", ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("Total préstamos: " + totalPrestamos, ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("Total devoluciones: " + totalDevoluciones, ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar("Gracias por usar el sistema 🏛️", ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(ESQUINA_INFERIOR_IZQ).append(repetir(LINEA_HORIZONTAL, ANCHO)).append(ESQUINA_INFERIOR_DER).append("\n");
        return sb.toString();
    }
    
    /**
     * Crea un encabezado de sección
     */
    public static String seccion(String titulo, String emoji) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(ESQUINA_SUP_SECUNDARIA);
        sb.append(repetir(LINEA_SECUNDARIA, ANCHO)).append(ESQUINA_DER_SECUNDARIA).append("\n");
        sb.append(LINEA_VERTICAL).append(centrar(emoji + "  " + titulo, ANCHO)).append(LINEA_VERTICAL).append("\n");
        sb.append(ESQUINA_INF_SECUNDARIA);
        sb.append(repetir(LINEA_SECUNDARIA, ANCHO)).append(ESQUINA_INF_DER_SECUNDARIA).append("\n");
        return sb.toString();
    }
    
    /**
     * Formato para mostrar información de un libro
     */
    public static String formatoLibro(String titulo, String autor, String genero, String contexto, int unidades, boolean disponible) {
        StringBuilder sb = new StringBuilder();
        String disponibilidad = disponible ? "✅ Sí" : "❌ No";
        sb.append("  ┌─ 📖 ").append(titulo).append("\n");
        sb.append("  ├─ Autor     : ").append(autor).append("\n");
        sb.append("  ├─ Género    : ").append(genero).append("\n");
        sb.append("  ├─ Contexto  : ").append(contexto).append("\n");
        sb.append("  ├─ Unidades  : ").append(unidades).append("\n");
        sb.append("  └─ Disponible: ").append(disponibilidad).append("\n");
        return sb.toString();
    }
    
    /**
     * Formato para mostrar información de un usuario
     */
    public static String formatoUsuario(String nombre, String apellido, int id, String tipo, String institucionODepartamento) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ┌─ 👤 ").append(nombre).append(" ").append(apellido).append("\n");
        sb.append("  ├─ ID   : ").append(id).append("\n");
        sb.append("  ├─ Tipo : ").append(tipo).append("\n");
        sb.append("  └─ ").append(institucionODepartamento.contains("Instituto") || institucionODepartamento.contains("Departamento") ? institucionODepartamento.substring(0, 1).toUpperCase() + institucionODepartamento.substring(1) : institucionODepartamento).append("\n");
        return sb.toString();
    }
    
    /**
     * Formato para préstamos exitosos
     */
    public static String formatoPrestamo(String nombreUsuario, String nombreLibro, String fecha) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ✅ Préstamo exitoso\n");
        sb.append("  ┌─ Usuario : ").append(nombreUsuario).append("\n");
        sb.append("  ├─ Libro   : ").append(nombreLibro).append("\n");
        sb.append("  └─ Fecha   : ").append(fecha).append("\n");
        return sb.toString();
    }
    
    /**
     * Formato para devoluciones
     */
    public static String formatoDevolucion(String nombreUsuario, String nombreLibro) {
        StringBuilder sb = new StringBuilder();
        sb.append("  🔄 Devolución registrada\n");
        sb.append("  ┌─ Usuario : ").append(nombreUsuario).append("\n");
        sb.append("  └─ Libro   : ").append(nombreLibro).append("\n");
        return sb.toString();
    }
    
    /**
     * Formato para resultados de búsqueda
     */
    public static String formatoBusqueda(String query) {
        StringBuilder sb = new StringBuilder();
        sb.append("  🔍 Búsqueda por: \"").append(query).append("\"\n");
        return sb.toString();
    }
    
    /**
     * Formato para resultado individual en búsqueda
     */
    public static String formatoResultadoBusqueda(int numero, String titulo) {
        if (numero == 1) {
            return "  ┌─ Resultado " + numero + ": " + titulo + "\n";
        }
        return "  ├─ Resultado " + numero + ": " + titulo + "\n";
    }
    
    /**
     * Formato para total de búsqueda
     */
    public static String formatoTotalBusqueda(int total) {
        return "  └─ Total encontrados: " + total + "\n";
    }
    
    /**
     * Formato para fila de tabla
     */
    public static String filaTablaPrestamos(int num, String usuario, String libro, String tipo, String fecha) {
        return String.format("| %-2d | %-25s | %-25s | %-8s | %-19s |\n", num, truncar(usuario, 25), truncar(libro, 25), tipo, fecha);
    }
    
    /**
     * Encabezado de tabla de prestamos
     */
    public static String encabezadoTablaPrestamos() {
        StringBuilder sb = new StringBuilder();
        sb.append("+----+---------------------------+---------------------------+----------+---------------------+\n");
        sb.append("|N°  | Usuario                  | Libro                     | Tipo     | Fecha               |\n");
        sb.append("+----+---------------------------+---------------------------+----------+---------------------+\n");
        return sb.toString();
    }
    
    /**
     * Pie de tabla
     */
    public static String pieTablaPrestamos() {
        return "+----+---------------------------+---------------------------+----------+---------------------+\n";
    }
    
    /**
     * Método auxiliar: centra texto
     */
    private static String centrar(String texto, int ancho) {
        int espacioDisponible = ancho - 2; // Restamos 2 para los bordes
        if (texto.length() >= espacioDisponible) {
            return " " + texto.substring(0, Math.min(texto.length(), espacioDisponible - 1)) + " ";
        }
        int espaciosAnt = (espacioDisponible - texto.length()) / 2;
        int espaciosDes = espacioDisponible - texto.length() - espaciosAnt;
        return " " + repetir(" ", espaciosAnt) + texto + repetir(" ", espaciosDes) + " ";
    }
    
    /**
     * Método auxiliar: repite un string
     */
    private static String repetir(String str, int veces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    /**
     * Método auxiliar: trunca un string
     */
    private static String truncar(String str, int longitud) {
        if (str.length() <= longitud) {
            return str;
        }
        return str.substring(0, longitud - 3) + "...";
    }
}

