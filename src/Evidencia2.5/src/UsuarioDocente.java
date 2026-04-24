public class UsuarioDocente extends Usuario {
    private String departamento;

    public UsuarioDocente(int idUsuario, String nombre, String apellido, int numeroIdentificacion,
                          String departamento) {
        super(idUsuario, nombre, apellido, numeroIdentificacion);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "UsuarioDocente{" +
                "base=" + super.toString() +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}

