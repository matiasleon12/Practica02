package interfaz;

import gestionDeCompras.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class VentanaPrincipal extends Frame {
    int idProductos = 103;
    int idProveedores = 103;
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private List<SolicitudCompra> solicitudes;

    public VentanaPrincipal(List<Proveedor> proveedores, List<Producto> productos,
                            List<SolicitudCompra> solicitudes) {
        super("Menú principal SISTEMA ERP");
        this.proveedores = proveedores;
        this.productos = productos;
        this.solicitudes = solicitudes;

        setSize(400, 300);
        setLayout(new GridLayout(4, 1));


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        crearMenuPrincipal();
    }

    private void crearMenuPrincipal() {
        removeAll();

        Label titulo = new Label("MENU PRINCIPAL", Label.CENTER);
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

        setVisible(true);
    }

    private void mostrarMenuProductos() {
        removeAll();

        Label titulo = new Label("MENU PRODUCTOS", Label.CENTER);
        Button btnCrear = new Button("1. Crear Producto");
        Button btnListar = new Button("2. Listar Productos");
        Button btnVolver = new Button("Volver");

        btnCrear.addActionListener(e -> crearProducto());
        btnListar.addActionListener(e -> listarProductos());
        btnVolver.addActionListener(e -> crearMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnVolver);

        setVisible(true);
    }

    private void mostrarMenuSolicitudes() {
        removeAll();

        setLayout(new GridLayout(6, 1));

        Label titulo = new Label("MENU SOLICITUDES", Label.CENTER);
        Button btnCrear = new Button("1. Crear Solicitud");
        Button btnListar = new Button("2. Listar Solicitudes");
        Button btnCambiar = new Button("3. Cambiar Estado Solicitud");
        Button btnVolver = new Button("Volver");

        btnCrear.addActionListener(e -> crearSolicitud());
        btnListar.addActionListener(e -> listarSolicitudes());
        btnCambiar.addActionListener(e -> cambiarEstadoSolicitud());
        btnVolver.addActionListener(e -> crearMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnCambiar);
        add(btnVolver);

        setVisible(true);
    }

    private void mostrarMenuProveedores() {
        removeAll();

        Label titulo = new Label("MENU PROVEEDORES", Label.CENTER);
        Button btnCrear = new Button("1. Crear Proveedor");
        Button btnListar = new Button("2. Listar Proveedores");
        Button btnVolver = new Button("Volver");

        btnCrear.addActionListener(e -> crearProveedor());
        btnListar.addActionListener(e -> listarProveedores());
        btnVolver.addActionListener(e -> crearMenuPrincipal());

        add(titulo);
        add(btnCrear);
        add(btnListar);
        add(btnVolver);

        setVisible(true);
    }

    private void crearProducto() {

            Frame productoFrame = new Frame("Crear Producto");
            productoFrame.setSize(1000, 500);
            productoFrame.setLayout(new GridLayout(12, 2));

            productoFrame.add(new Label("Nombre del producto:"));
            TextField campoNombre = new TextField();
            productoFrame.add(campoNombre);

            productoFrame.add(new Label("Precio unitario:"));
            TextField campoPrecio = new TextField();
            productoFrame.add(campoPrecio);

            productoFrame.add(new Label("Descripción del producto:"));
            TextField campoDescripcion = new TextField();
            productoFrame.add(campoDescripcion);

            productoFrame.add(new Label("Categoría del producto:"));
            TextField campoCategoria = new TextField();
            productoFrame.add(campoCategoria);

            productoFrame.add(new Label("Categorías válidas:"));
            String listaCategorias = "";
            for (CategoriaProducto c : CategoriaProducto.values()) {
                listaCategorias += c.name() + "  ";
            }
            productoFrame.add(new Label(listaCategorias));

            productoFrame.add(new Label("ID del proveedor:"));
            TextField campoIdProveedor = new TextField();
            productoFrame.add(campoIdProveedor);

            productoFrame.add(new Label("Proveedores disponibles:"));
            String listaProveedores = "";
            for (Proveedor p : proveedores) {
                listaProveedores += "ID: " + p.getId() + " - " + p.getNombre() + "   ";
            }
            productoFrame.add(new Label(listaProveedores));

            Button btnCrear = new Button("Crear Producto");
            productoFrame.add(btnCrear);
            Label resultado = new Label("");
            productoFrame.add(resultado);

            btnCrear.addActionListener(e -> {
                String nombre = campoNombre.getText();
                String precioTexto = campoPrecio.getText();
                String descripcion = campoDescripcion.getText();
                String categoriaTexto = campoCategoria.getText();
                String idProveedorTexto = campoIdProveedor.getText();

                // Buscar categoría
                CategoriaProducto categoriaSeleccionada = null;
                for (CategoriaProducto c : CategoriaProducto.values()) {
                    if (c.name().equals(categoriaTexto)) {
                        categoriaSeleccionada = c;
                    }
                }

                // Buscar proveedor
                Proveedor proveedorSeleccionado = null;
                for (Proveedor p : proveedores) {
                    if (String.valueOf(p.getId()).equals(idProveedorTexto)) {
                        proveedorSeleccionado = p;
                    }
                }

                // Convertir precio a double sin usar parse
                double precioUnitario = 0;
                boolean esPrecioValido = true;
                int puntoIndex = precioTexto.indexOf(".");
                if (puntoIndex != -1) {
                    String parteEntera = precioTexto.substring(0, puntoIndex);
                    String parteDecimal = precioTexto.substring(puntoIndex + 1);
                    for (int i = 0; i < parteEntera.length(); i++) {
                        char c = parteEntera.charAt(i);
                        if (c < '0' || c > '9') {
                            esPrecioValido = false;
                        }
                    }
                    for (int i = 0; i < parteDecimal.length(); i++) {
                        char c = parteDecimal.charAt(i);
                        if (c < '0' || c > '9') {
                            esPrecioValido = false;
                        }
                    }
                    if (esPrecioValido) {
                        double parte1 = 0;
                        for (int i = 0; i < parteEntera.length(); i++) {
                            parte1 = parte1 * 10 + (parteEntera.charAt(i) - '0');
                        }
                        double parte2 = 0;
                        for (int i = parteDecimal.length() - 1; i >= 0; i--) {
                            parte2 = (parte2 + (parteDecimal.charAt(i) - '0')) / 10;
                        }
                        precioUnitario = parte1 + parte2;
                    }
                }

                if (nombre.length() > 0 && descripcion.length() > 0 && categoriaSeleccionada != null && proveedorSeleccionado != null && esPrecioValido) {
                    Producto nuevoProducto = new Producto(idProductos++, nombre, precioUnitario, proveedorSeleccionado, categoriaSeleccionada, descripcion);
                    productos.add(nuevoProducto);
                    proveedorSeleccionado.getProductos().add(nuevoProducto);
                    resultado.setText("Producto registrado exitosamente. ");
                } else {
                    resultado.setText("Datos inválidos.");
                }
            });

        productoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                productoFrame.dispose();
            }
        });
            productoFrame.setVisible(true);


    }
     private void listarProductos() {
        Frame listapro = new Frame("Lista de Productos");
        listapro.setSize(400, 300);
        TextArea area = new TextArea();
        area.setEditable(false);

        String texto = "ID\tNombre\tPrecio\n";
        for (Producto p : productos) {
            texto += p.getId() + "\t" + p.getNombreProducto() + "\t" + p.getPrecioUnitario() + "\n";
        }

        area.setText(texto);
        listapro.add(area);

        listapro.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                listapro.dispose();
            }
        });

        listapro.setVisible(true);
    }

    private void crearSolicitud() {


        Frame solicitud = new Frame("Crear Solicitud");
        solicitud.setSize(1000, 500);
        solicitud.setLayout(new GridLayout(7, 2));

        solicitud.add(new Label("Nombre del solicitante:"));
        TextField nombre = new TextField();
        solicitud.add(nombre);

        solicitud.add(new Label("Departamento:"));
        TextField departamento = new TextField();
        solicitud.add(departamento);

        solicitud.add(new Label("Telefono:"));
        TextField telefono = new TextField();
        solicitud.add(telefono);

        solicitud.add(new Label("""
                Ingrese el nombre del producto:
                -100: Grapadora/ 7.5$\s
                -101: Impresora/ 170.5$\s
                -102: Escoba/ 4.0$\s"""
               ));
        TextField nomproduc = new TextField();
        solicitud.add(nomproduc);

        solicitud.add(new Label("Ingrese la cantidad del producto:"));
        TextField cantidadPro = new TextField();
        solicitud.add(cantidadPro);

        solicitud.add(new Label("Ingrese la justificación:"));
        TextField justificacion = new TextField();
        solicitud.add(justificacion);

        Button guardar = new Button("Guardar");
        guardar.addActionListener(e -> {
            //
            solicitud.dispose();
        });

        Button cancelar = new Button("Cancelar");
        cancelar.addActionListener(e -> solicitud.dispose());

        solicitud.add(guardar);
        solicitud.add(cancelar);

        solicitud.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                solicitud.dispose();
            }
        });

        solicitud.setVisible(true);

    }

    private void listarSolicitudes() {

        Frame listasoli = new Frame("Lista de Solicitudes");
        listasoli.setSize(700, 300);
        TextArea area = new TextArea();
        area.setEditable(false);

        String texto = "Numero\tSolicitante\tEstado\n";
        for (SolicitudCompra solicitudCompra : solicitudes) {
            texto += solicitudCompra.getNumSolicitud() + "\t" + solicitudCompra.getSolicitante() + "\t" + solicitudCompra.getEstadoSolicitud() + "\n";
        }

        area.setText(texto);
        listasoli.add(area);

        listasoli.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                listasoli.dispose();
            }
        });

        listasoli.setVisible(true);

    }

    private void cambiarEstadoSolicitud(){

            Frame solicitud = new Frame("Cambiar Estado de Solicitud");
            solicitud.setSize(1000, 500);
            solicitud.setLayout(new GridLayout(10, 2));

            solicitud.add(new Label("Número de la Solicitud:"));
            TextField campoNumero = new TextField();
            solicitud.add(campoNumero);

            Button btnBuscar = new Button("Buscar Solicitud");
            solicitud.add(btnBuscar);
            Label resultadoBusqueda = new Label("");
            solicitud.add(resultadoBusqueda);

            solicitud.add(new Label("Estado actual:"));
            Label lblEstadoActual = new Label("-");
            solicitud.add(lblEstadoActual);

            solicitud.add(new Label("Nuevo estado :"));
            TextField campoNuevoEstado = new TextField();
            solicitud.add(campoNuevoEstado);

            solicitud.add(new Label("Estados válidos:"));
            solicitud.add(new Label("SOLICITADA, EN_REVISION, APROBADO, RECHAZADO"));

            Button btnCambiar = new Button("Cambiar Estado");
            solicitud.add(btnCambiar);
            Label resultadoCambio = new Label("");
            solicitud.add(resultadoCambio);

            final SolicitudCompra[] solicitudEncontrada = new SolicitudCompra[1];

            // Botón para buscar
            btnBuscar.addActionListener(e -> {
                String inputNumero = campoNumero.getText();
                solicitudEncontrada[0] = null;

                for (SolicitudCompra s : solicitudes) {
                    if (String.valueOf(s.getNumSolicitud()).equals(inputNumero)) {
                        solicitudEncontrada[0] = s;

                    }
                }

                if (solicitudEncontrada[0] != null) {
                    lblEstadoActual.setText(solicitudEncontrada[0].getEstadoSolicitud().toString());
                    resultadoBusqueda.setText("Solicitud encontrada.");
                } else {
                    lblEstadoActual.setText("-");
                    resultadoBusqueda.setText("Solicitud no encontrada.");
                }
            });

            // Botón para cambiar estado
            btnCambiar.addActionListener(e -> {
                if (solicitudEncontrada[0] != null) {
                    String nuevoTexto = campoNuevoEstado.getText();
                    EstadoSolicitud nuevoEstado = null;

                    for (EstadoSolicitud estado : EstadoSolicitud.values()) {
                        if (estado.name().equals(nuevoTexto)) {
                            nuevoEstado = estado;
                        }
                    }

                    if (nuevoEstado != null) {
                        solicitudEncontrada[0].setEstadoSolicitud(nuevoEstado);
                        lblEstadoActual.setText(nuevoEstado.toString());
                        resultadoCambio.setText("Estado actualizado.");
                    } else {
                        resultadoCambio.setText("Estado inválido.");
                    }
                } else {
                    resultadoCambio.setText("Primero busca una solicitud.");
                }
            });

        solicitud.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                solicitud.dispose();
            }
        });

            solicitud.setVisible(true);



    }

    private void crearProveedor() {

            Frame proveedorFrame = new Frame("Crear Proveedor");
            proveedorFrame.setSize(1000, 600);
            proveedorFrame.setLayout(new GridLayout(14, 2));

            proveedorFrame.add(new Label("Nombre del proveedor:"));
            TextField campoNombre = new TextField();
            proveedorFrame.add(campoNombre);

            proveedorFrame.add(new Label("Departamento:"));
            TextField campoDepartamento = new TextField();
            proveedorFrame.add(campoDepartamento);

            proveedorFrame.add(new Label("Teléfono:"));
            TextField campoTelefono = new TextField();
            proveedorFrame.add(campoTelefono);

            proveedorFrame.add(new Label("Correo:"));
            TextField campoCorreo = new TextField();
            proveedorFrame.add(campoCorreo);

            proveedorFrame.add(new Label("Calle principal:"));
            TextField campoPrincipal = new TextField();
            proveedorFrame.add(campoPrincipal);

            proveedorFrame.add(new Label("Calle secundaria:"));
            TextField campoSecundaria = new TextField();
            proveedorFrame.add(campoSecundaria);

            proveedorFrame.add(new Label("Número de casa:"));
            TextField campoNumCalle = new TextField();
            proveedorFrame.add(campoNumCalle);

            proveedorFrame.add(new Label("Ciudad:"));
            TextField campoCiudad = new TextField();
            proveedorFrame.add(campoCiudad);

            proveedorFrame.add(new Label("País:"));
            TextField campoPais = new TextField();
            proveedorFrame.add(campoPais);

            proveedorFrame.add(new Label("Provincia:"));
            TextField campoProvincia = new TextField();
            proveedorFrame.add(campoProvincia);

            Button btnCrear = new Button("Registrar Proveedor");
            proveedorFrame.add(btnCrear);

            Label resultado = new Label("");
            proveedorFrame.add(resultado);

            btnCrear.addActionListener(e -> {
                String nombre = campoNombre.getText();
                String departamento = campoDepartamento.getText();
                String telefono = campoTelefono.getText();
                String correo = campoCorreo.getText();
                String principal = campoPrincipal.getText();
                String secundaria = campoSecundaria.getText();
                String numCalle = campoNumCalle.getText();
                String ciudad = campoCiudad.getText();
                String pais = campoPais.getText();
                String provincia = campoProvincia.getText();

                if (nombre.length() > 0 && telefono.length() > 0 && correo.length() > 0
                        && principal.length() > 0 && secundaria.length() > 0 && numCalle.length() > 0
                        && ciudad.length() > 0 && pais.length() > 0 && provincia.length() > 0) {

                    Direccion direccion = new Direccion(principal, secundaria, numCalle, ciudad, pais, provincia);
                    Proveedor proveedor = new Proveedor(idProveedores, nombre, telefono, correo, direccion);
                    proveedor.setId(idProveedores);
                    idProveedores++;

                    proveedores.add(proveedor);
                    resultado.setText("Proveedor registrado exitosamente.");
                } else {
                    resultado.setText("Faltan datos.");
                }
            });

        proveedorFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                proveedorFrame.dispose();
            }
        });

            proveedorFrame.setVisible(true);




    }

    private void listarProveedores() {


            Frame listarFrame = new Frame("Lista de Proveedores");
            listarFrame.setSize(400, 400);
            listarFrame.setLayout(new BorderLayout());

            TextArea areaTexto = new TextArea();
            listarFrame.add(areaTexto, BorderLayout.CENTER);

            // Comprobar si proveedores está vacío sin usar isEmpty()
            if (proveedores.size() == 0) {
                areaTexto.setText("No hay proveedores.");
            } else {
                String textoProveedores = "";
                for (int i = 0; i < proveedores.size(); i++) {
                    Proveedor p = proveedores.get(i);
                    textoProveedores = textoProveedores + p.getId() + " - " + p.getNombre() + "\n";
                }
                areaTexto.setText(textoProveedores);
            }
        listarFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                listarFrame.dispose();
            }
        });
            listarFrame.setVisible(true);




    }

    public static void main(String[] args) {

        // Datos de prueba básicos
        List<Proveedor> listaProveedores = new ArrayList();
        List<DetalleSolicitud> listaDetalleSolicitud = new ArrayList();
        List<SolicitudCompra> listaSolicitudesCompra = new ArrayList();
        List<Producto> listaProductos = new ArrayList();


        Direccion direccion1 = new Direccion("Principal1","Secundaria1","17-80","Cuenca","Ecuador","Azuay");
        Direccion direccion2 = new Direccion("Principal2","Secundaria2","17-90","Cuenca","Ecuador","Azuay");
        Direccion direccion3 = new Direccion("Principal3","Secundaria1","17-70","Cuenca","Ecuador","Azuay");

        Proveedor proveedor1 = new Proveedor(100,"LNS","0982717217","lns@gmail.com",direccion1);
        Proveedor proveedor2 = new Proveedor(101,"ImpreShop","0981231231","impre@gmail.com",direccion2);
        Proveedor proveedor3 = new Proveedor(102,"OfiShop","0931231127","oficinaShop@gmail.com",direccion3);

        listaProveedores.add(proveedor1);
        listaProveedores.add(proveedor2);
        listaProveedores.add(proveedor3);

        Producto producto1 = new Producto(100,"Grapadora",7.50,proveedor1,CategoriaProducto.OFICINA,"Producto de oficina");
        Producto producto2 = new Producto(101,"Impresora",170.50,proveedor2,CategoriaProducto.HARDWARE,"Producto de impresion");
        Producto producto3 = new Producto(102,"Escoba",4,proveedor3,CategoriaProducto.LIMPIEZA,"Producto de limpieza");

        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);

        DetalleSolicitud detalleSolicitud1 = new DetalleSolicitud(3,"Necesario",producto1);
        DetalleSolicitud detalleSolicitud2 = new DetalleSolicitud(1,"Necesario",producto2);
        DetalleSolicitud detalleSolicitud3 = new DetalleSolicitud(2,"Necesario",producto3);

        listaDetalleSolicitud.add(detalleSolicitud1);
        listaDetalleSolicitud.add(detalleSolicitud2);
        listaDetalleSolicitud.add(detalleSolicitud3);

        GregorianCalendar fechaActual = new GregorianCalendar();

        Solicitante solicitante1 = new Solicitante("Juan","0982717217","Sistemas","juan@mail.com");
        Solicitante solicitante2 = new Solicitante("Paul","0982717217","Administrativo","paul@mail.com");
        Solicitante solicitante3 = new Solicitante("Diego","0982790380","Medico","diego@mail.com");


        SolicitudCompra solicitudCompra1 = new SolicitudCompra(200,solicitante1,fechaActual);
        SolicitudCompra solicitudCompra2 = new SolicitudCompra(201,solicitante2,fechaActual);
        SolicitudCompra solicitudCompra3 = new SolicitudCompra(202,solicitante3,fechaActual);

        solicitudCompra1.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);
        solicitudCompra2.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);
        solicitudCompra3.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);

        solicitudCompra1.addDetallesSolicitud(detalleSolicitud1);
        solicitudCompra2.addDetallesSolicitud(detalleSolicitud2);
        solicitudCompra3.addDetallesSolicitud(detalleSolicitud3);

        listaSolicitudesCompra.add(solicitudCompra1);
        listaSolicitudesCompra.add(solicitudCompra2);
        listaSolicitudesCompra.add(solicitudCompra3);


        new VentanaPrincipal(listaProveedores, listaProductos, listaSolicitudesCompra);
    }
}
