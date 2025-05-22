package interfaz;

import gestionDeCompras.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private List<Proveedor> listaProveedores;
    private List<Producto> listaProductos;
    private List<SolicitudCompra> listaSolicitudes;

    public VentanaPrincipal(List<Proveedor> proveedores, List<Producto> productos,
                            List<SolicitudCompra> solicitudes) {
        this.listaProveedores = proveedores;
        this.listaProductos = productos;
        this.listaSolicitudes = solicitudes;

        setTitle("Sistema de Compras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel titulo = new JLabel("MENÚ PRINCIPAL", JLabel.CENTER);
        JButton btnProductos = new JButton("1. Productos");
        JButton btnSolicitudes = new JButton("2. Solicitudes");
        JButton btnProveedores = new JButton("3. Proveedores");

        btnProductos.addActionListener(e -> mostrarMenuProductos());
        btnSolicitudes.addActionListener(e -> mostrarMenuSolicitudes());
        btnProveedores.addActionListener(e -> mostrarMenuProveedores());

        panel.add(titulo);
        panel.add(btnProductos);
        panel.add(btnSolicitudes);
        panel.add(btnProveedores);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
    }

    private void mostrarMenuProductos() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel titulo = new JLabel("MENÚ PRODUCTOS", JLabel.CENTER);
        JButton btnCrear = new JButton("1. Crear Producto");
        JButton btnListar = new JButton("2. Listar Productos");
        JButton btnVolver = new JButton("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearProducto());
        btnListar.addActionListener(e -> listarProductos());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        panel.add(titulo);
        panel.add(btnCrear);
        panel.add(btnListar);
        panel.add(btnVolver);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
    }

    private void mostrarMenuSolicitudes() {
        JPanel panel = new JPanel(new GridLayout(6, 1));

        JLabel titulo = new JLabel("MENÚ SOLICITUDES", JLabel.CENTER);
        JButton btnCrear = new JButton("1. Crear Solicitud");
        JButton btnListar = new JButton("2. Listar Solicitudes");
        JButton btnBuscar = new JButton("3. Buscar Solicitud");
        JButton btnDetalle = new JButton("4. Ver Detalle");
        JButton btnVolver = new JButton("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearSolicitud());
        btnListar.addActionListener(e -> listarSolicitudes());
        btnBuscar.addActionListener(e -> buscarSolicitud());
        btnDetalle.addActionListener(e -> verDetalleSolicitud());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        panel.add(titulo);
        panel.add(btnCrear);
        panel.add(btnListar);
        panel.add(btnBuscar);
        panel.add(btnDetalle);
        panel.add(btnVolver);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
    }

    private void mostrarMenuProveedores() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel titulo = new JLabel("MENÚ PROVEEDORES", JLabel.CENTER);
        JButton btnCrear = new JButton("1. Crear Proveedor");
        JButton btnListar = new JButton("2. Listar Proveedores");
        JButton btnVolver = new JButton("Volver al Menú Principal");

        btnCrear.addActionListener(e -> crearProveedor());
        btnListar.addActionListener(e -> listarProveedores());
        btnVolver.addActionListener(e -> mostrarMenuPrincipal());

        panel.add(titulo);
        panel.add(btnCrear);
        panel.add(btnListar);
        panel.add(btnVolver);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
    }

    // Métodos básicos para las operaciones
    private void crearProducto() {
        JOptionPane.showMessageDialog(this, "Aquí se crearía un nuevo producto");
    }

    private void listarProductos() {
        StringBuilder sb = new StringBuilder("PRODUCTOS:\n\n");
        for (Producto p : listaProductos) {
            sb.append("- ").append(p.getNombreProducto())
                    .append(" ($").append(p.getPrecioUnitario()).append(")\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void crearSolicitud() {
        JOptionPane.showMessageDialog(this, "Aquí se crearía una nueva solicitud");
    }

    private void listarSolicitudes() {
        StringBuilder sb = new StringBuilder("SOLICITUDES:\n\n");
        for (SolicitudCompra s : listaSolicitudes) {
            sb.append("#").append(s.getNumSolicitud())
                    .append(" - ").append(s.getSolicitante().getNombre())
                    .append(" (").append(s.getEstadoSolicitud()).append(")\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void buscarSolicitud() {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese ID de solicitud:");
        try {
            int id = Integer.parseInt(idStr);
            for (SolicitudCompra s : listaSolicitudes) {
                if (s.getNumSolicitud() == id) {
                    JOptionPane.showMessageDialog(this,
                            "Solicitud #" + id + "\n" +
                                    "Solicitante: " + s.getSolicitante().getNombre() + "\n" +
                                    "Estado: " + s.getEstadoSolicitud());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No se encontró la solicitud");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido");
        }
    }

    private void verDetalleSolicitud() {
        JOptionPane.showMessageDialog(this, "Aquí se mostrarían los detalles de una solicitud");
    }

    private void crearProveedor() {
        JOptionPane.showMessageDialog(this, "Aquí se crearía un nuevo proveedor");
    }

    private void listarProveedores() {
        StringBuilder sb = new StringBuilder("PROVEEDORES:\n\n");
        for (Proveedor p : listaProveedores) {
            sb.append("- ").append(p.getNombre())
                    .append(" (ID: ").append(p.getId()).append(")\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}