package interfaz;

import gestionDeCompras.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaSecundaria extends Frame {
    private List<Proveedor> listaProveedores;
    private List<Producto> listaProductos;
    private List<SolicitudCompra> listaSolicitudes;

    public VentanaSecundaria(List<Proveedor> proveedores, List<Producto> productos,
                      List<SolicitudCompra> solicitudes) {
        this.listaProveedores = proveedores;
        this.listaProductos = productos;
        this.listaSolicitudes = solicitudes;

        setTitle("Sistema de Compras ");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Manejar cierre de ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        removeAll(); // Limpiar componentes anteriores

        setLayout(new GridLayout(4, 1));

        Label titulo = new Label("MENÚ PRINCIPAL", Label.CENTER);
        Button btnProductos = new Button("1. Productos");
        Button btnSolicitudes = new Button("2. Solicitudes");
        Button btnProveedores = new Button("3. Proveedores");

        btnProductos.addActionListener(e -> mostrarMenuProductos());
        btnSolicitudes.addActionListener(e -> mostrarMenuSolicitudes());
        btnProveedores.addActionListener(e -> mostrarMenuProveedores());

        add(titulo);
        add(btnProductos);
        add(btnSolicitudes);
        add(btnProveedores);

        revalidate();
        repaint();
    }

    private void mostrarMenuProductos() {
        removeAll();
        setLayout(new GridLayout(4, 1));

        Label titulo = new Label("MENÚ PRODUCTOS", Label.CENTER);
        Button btnCrear = new Button("1. Crear Producto");
        Button btnListar = new Button("2. Listar Productos");
        Button btnVolver = new Button("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearProducto());
        btnListar.addActionListener(e -> listarProductos());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnVolver);

        revalidate();
        repaint();
    }

    private void mostrarMenuSolicitudes() {
        removeAll();
        setLayout(new GridLayout(6, 1));

        Label titulo = new Label("MENÚ SOLICITUDES", Label.CENTER);
        Button btnCrear = new Button("1. Crear Solicitud");
        Button btnListar = new Button("2. Listar Solicitudes");
        Button btnBuscar = new Button("3. Buscar Solicitud");
        Button btnDetalle = new Button("4. Ver Detalle");
        Button btnVolver = new Button("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearSolicitud());
        btnListar.addActionListener(e -> listarSolicitudes());
        btnBuscar.addActionListener(e -> buscarSolicitud());
        btnDetalle.addActionListener(e -> verDetalleSolicitud());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnBuscar);
        add(btnDetalle);
        add(btnVolver);

        revalidate();
        repaint();
    }

    private void verDetalleSolicitud() {
    }

    private void buscarSolicitud() {
    }

    private void crearSolicitud() {
    }

    private void listarSolicitudes() {
    }


    private void mostrarMenuProveedores() {
        removeAll();
        setLayout(new GridLayout(4, 1));

        Label titulo = new Label("MENÚ PROVEEDORES", Label.CENTER);
        Button btnCrear = new Button("1. Crear Proveedor");
        Button btnListar = new Button("2. Listar Proveedores");
        Button btnVolver = new Button("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearProveedor());
        btnListar.addActionListener(e -> listarProveedores());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnVolver);

        revalidate();
        repaint();
    }

    private void listarProveedores() {
    }

    private void crearProveedor() {
    }

    // Métodos para las operaciones (usando Dialog de AWT)
    private void crearProducto() {
        Dialog dialogo = new Dialog(this, "Crear Producto", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.add(new Label("Funcionalidad de crear producto"));
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> dialogo.dispose());
        dialogo.add(btnCerrar);
        dialogo.setSize(300, 100);
        dialogo.setVisible(true);
    }

    private void listarProductos() {
        Dialog dialogo = new Dialog(this, "Lista de Productos", true);
        dialogo.setLayout(new BorderLayout());

        TextArea areaTexto = new TextArea();
        StringBuilder sb = new StringBuilder("PRODUCTOS:\n\n");
        for (Producto p : listaProductos) {
            sb.append("- ").append(p.getNombreProducto())
                    .append(" ($").append(p.getPrecioUnitario()).append(")\n");
        }
        areaTexto.setText(sb.toString());
        areaTexto.setEditable(false);

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> dialogo.dispose());

        dialogo.add(areaTexto, BorderLayout.CENTER);
        dialogo.add(btnCerrar, BorderLayout.SOUTH);
        dialogo.setSize(400, 300);
        dialogo.setVisible(true);
    }

    // ... (similar para los demás métodos: crearSolicitud, listarSolicitudes, etc.)

    public static void main(String[] args) {
        // Ejemplo de uso:
        List<Proveedor> proveedores = List.of(
                new Proveedor(1, "Proveedor 1", "123", "proveedor1@test.com", null)
        );
        List<Producto> productos = List.of(
                new Producto(1, "Producto 1", 10.0, null, null, "Descripción")
        );
        List<SolicitudCompra> solicitudes = List.of(
                new SolicitudCompra(1, null, null)
        );

        VentanaSecundaria ventana = new VentanaSecundaria(proveedores, productos, solicitudes);
        ventana.setVisible(true);
    }
}