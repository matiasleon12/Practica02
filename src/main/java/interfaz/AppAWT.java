package interfaz;

import gestionDeCompras.SolicitudCompra;
import gestionDeCompras.Solicitante;
import gestionDeCompras.EstadoSolicitud;


import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.List;

public class AppAWT {
    private Frame frame;
    private TextField txtCedula, txtSubtotal, txtDescuento;
    private TextArea taResumen;
    private Button btnAgregar, btnCambiarEstado, btnLimpiar, btnSalir;

    private List<SolicitudCompra> solicitudes;
    private List<Solicitante> solicitantes;

    public AppAWT() {
        this.solicitudes = solicitudes;
        this.solicitantes = solicitantes;
        construirInterfaz();
    }

    private void construirInterfaz() {
        frame = new Frame("Gestión de Solicitudes de Compra");
        frame.setLayout(new FlowLayout());

        // Entrada de datos
        frame.add(new Label("Cédula Solicitante:"));
        txtCedula = new TextField(20);
        frame.add(txtCedula);

        frame.add(new Label("Subtotal:"));
        txtSubtotal = new TextField(10);
        frame.add(txtSubtotal);

        frame.add(new Label("Descuento:"));
        txtDescuento = new TextField(10);
        frame.add(txtDescuento);

        // Botones
        btnAgregar = new Button("Agregar Solicitud");
        btnCambiarEstado = new Button("Cambiar Estado");
        btnLimpiar = new Button("Limpiar");
        btnSalir = new Button("Salir");

        frame.add(btnAgregar);
        frame.add(btnCambiarEstado);
        frame.add(btnLimpiar);
        frame.add(btnSalir);

        // Área de resumen
        taResumen = new TextArea(10, 60);
        taResumen.setEditable(false);
        frame.add(taResumen);

        // Eventos
        btnAgregar.addActionListener(e -> {
            String cedula = txtCedula.getText().trim();
            Solicitante solicitante = buscarSolicitante(cedula);

            if (solicitante != null) {
                int numero = 1; // o puedes generarlo automáticamente
                GregorianCalendar fecha = new GregorianCalendar(); // fecha actual
                SolicitudCompra solicitud = new SolicitudCompra(numero, solicitante, fecha);
                solicitudes.add(solicitud);
                taResumen.append("Solicitud agregada para: " + solicitante.getNombre() + "\n");
            } else {
                taResumen.append("Solicitante no encontrado.\n");
            }
        });

        btnCambiarEstado.addActionListener(e -> {
            if (!solicitudes.isEmpty()) {
                SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
                ultima.setEstadoSolicitud(EstadoSolicitud.APROBADO); // Simulación
                taResumen.append("Estado cambiado a APROBADA.\n");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtCedula.setText("");
            txtSubtotal.setText("");
            txtDescuento.setText("");
        });

        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private Solicitante buscarSolicitante(String cedula) {
        for (Solicitante s : solicitantes) {
            if (s.getNombre().equals(cedula)) {
                return s;
            }
        }
        return null;
    }
}

