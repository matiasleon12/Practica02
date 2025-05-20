package gestionDeCompras;

public class Solicitante {
    private String nombre;
    private String departamento;
    private String telefono;
    private String correo;

    public Solicitante(String nombre, String telefono, String departamento, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.departamento = departamento;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
