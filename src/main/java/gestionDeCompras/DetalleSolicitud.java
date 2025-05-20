package gestionDeCompras;

public class DetalleSolicitud {
    private Producto producto;
    private int cantidad;
    private String justificacion;

    public DetalleSolicitud(int cantidad, String justificacion, Producto producto) {
        this.cantidad = cantidad;
        this.justificacion = justificacion;
        this.producto = producto;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String descripcion) {
        this.justificacion = descripcion;
    }

    @Override
    public String toString() {
        return "DetalleSolicitud{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", justificacion='" + justificacion + '\'' +
                '}';
    }
}
