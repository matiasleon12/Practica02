package gestionDeCompras;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private int id;
    private String nombre;
    private List<Producto> productos;
    private String telefono;
    private String correo;
    private Direccion direccion;

    public Proveedor(int id, String nombre, String telefono, String correo, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Direccion getDireccion() {
        return direccion;
    }

    //METODOS

    public List<Producto> getProductos() {
        return productos;
    }
    public void addProductos(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", productos=" + productos +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
