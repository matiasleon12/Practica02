package gestionDeCompras;

public class DatosEntrada {
    private String nombreProducto;
    private double precioUnitario;
    private String descripcion;
    private boolean iva;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "DatosEntrada{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", descripcion='" + descripcion + '\'' +
                ", iva=" + iva +
                '}';
    }
}
