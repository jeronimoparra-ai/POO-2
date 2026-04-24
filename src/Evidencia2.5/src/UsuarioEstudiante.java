public class UsuarioEstudiante extends Usuario {
    private String institucion;

    public UsuarioEstudiante(int idUsuario, String nombre, String apellido, int numeroIdentificacion,
                             String institucion) {
        super(idUsuario, nombre, apellido, numeroIdentificacion);
        this.institucion = institucion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "UsuarioEstudiante{" +
                "base=" + super.toString() +
                ", institucion='" + institucion + '\'' +
                '}';
    }
}

