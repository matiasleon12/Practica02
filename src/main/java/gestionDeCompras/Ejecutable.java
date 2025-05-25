package gestionDeCompras;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Ejecutable {
    private List<DetalleSolicitud> detallesSolicitud;
    private List<SolicitudCompra> solicitudesCompra;
    private List<Proveedor> proveedores;
    private int idProveedores = 103;
    private int idSolicitudes = 203;
    private int idproductos = 103;
    private List<Producto> productos;

    Scanner scanner = new Scanner(System.in);


    public Ejecutable(List<Proveedor> proveedores, List<Producto> listadoProductos, List<DetalleSolicitud> detallesSolicitud, List<SolicitudCompra> solicitudesCompra) {
        this.detallesSolicitud = detallesSolicitud;
        this.solicitudesCompra = solicitudesCompra;
        this.productos = listadoProductos;
        this.proveedores = proveedores;
    }
    //------------------------------------------------------------MENU----------------------------------------------------------------------------------------------------------------

    public void menuPrincipal() {
        System.out.println("---------MENU DE PRINCIPAL---------");
        System.out.println("1. Productos");
        System.out.println("2. Solicitudes");
        System.out.println("3. Proveedores");
        System.out.println("4. Salir");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                menuProducto();
                break;
            case 2:
                menuSolicitud();
                break;
            case 3:
                menuProveedor();
                break;
            case 4:
                System.out.println("Finalizando Ejecucion...");
            default:
                System.out.println("Opcion no valida");
                break;

        }
        while (opcion!= 4){
            System.out.println("---------MENU DE PRINCIPAL---------");
            System.out.println("1. Productos");
            System.out.println("2. Solicitudes");
            System.out.println("3. Proveedores");
            System.out.println("4. Salir");
             opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    menuProducto();
                    break;
                case 2:
                    menuSolicitud();
                    break;
                case 3:
                    menuProveedor();
                    break;
                case 4:
                    System.out.println("Finalizando Ejecucion...");
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }

    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void menuProducto() {

        System.out.println("---------MENU DE PRODUCTO---------");
        System.out.println("1. Crear Producto");
        System.out.println("2. Listar Productos");
        System.out.println("3. Buscar Producto");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                crearProducto();
                break;
            case 2:
                listarProductos();
                break;
            case 3:
                buscarProductoPorNombre();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public void menuProveedor() {
        System.out.println("---------MENU DE PROVEEDOR---------");
        System.out.println("1. Crear Proveedor");
        System.out.println("2. Listar Proveedor");
        System.out.println("3. Buscar Proveedor");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                crearProveedor();
                break;
            case 2:
                listarProveedores();
                break;
            case 3:
                System.out.println("Ingrese el id del proveedor a buscar: ");
                int id = scanner.nextInt();
                buscarProveedorPorId(id);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

    }

    public void menuSolicitud() {
        System.out.println("---------MENU DE SOLICITUDES---------");
        System.out.println("1. Crear Solicitud");
        System.out.println("2. Listar Solicitudes");
        System.out.println("3. Buscar Solicitud");
        System.out.println("4. Ver Detalle Solicitud");
        System.out.println("5. Cambiar Estado Solicitud");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                crearSolicitud();
                break;
            case 2:
                listarSolicitudes();
                break;
            case 3:
                SolicitudCompra sc = buscarSolicitudPorId();
                if (sc != null) {
                    System.out.println("Solicitud encontrada: "+sc);
                }
                break;
            case 4:
                verDetalleSolicitud();
                break;
            case 5:
                cambiarEstadoSolicitud();
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    //---------------------------------------------------------------------------PROVEEDOR---------------------------------------------------------------------------------------------------------

    public void crearProveedor() {
        System.out.println("---Creando proveedor---");
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = scanner.next();
        System.out.println("Ingrese el nombre del departamento: ");
        String departamento = scanner.next();
        System.out.println("Ingrese el telefono del proveedor: ");
        String telefono = scanner.next();
        System.out.println("Ingrese el correo del proveedor: ");
        String correo = scanner.next();
        System.out.println("Ingresando Direccion del proveedor: ");
        System.out.println("Calle principal: ");
        String principal = scanner.next();
        System.out.println("Calle secundaria: ");
        String secundaria = scanner.next();
        System.out.println("Numero de propiedad: ");
        String numCalle = scanner.next();
        System.out.println("Nombre de pais: ");
        String pais = scanner.next();
        System.out.println("Nombre de provincia: ");
        String provincia = scanner.next();
        System.out.println("Nombre de ciudad: ");
        String ciudad = scanner.next();

        // Crear la dirección
        Direccion direccion = new Direccion(principal, secundaria, numCalle, ciudad, pais, provincia);

        // Crear el proveedor
        Proveedor proveedor = new Proveedor(idProveedores++, nombre, telefono, correo, direccion);
        proveedor.setId(idProveedores++);

        // Agregar el proveedor a la lista general
        proveedores.add(proveedor);

        System.out.println("Proveedor registrado exitosamente.");
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void listarProveedores() {
        System.out.println("Proveedores disponibles:");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores.");
        } else {
            for (Proveedor p : proveedores) {
                System.out.println(p.getId() + " - " + p.getNombre());
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Proveedor buscarProveedorPorId(int idBuscado) {
        int izquierda = 0;
        int derecha = proveedores.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            Proveedor proveedorMedio = proveedores.get(medio);

            if (proveedorMedio.getId() == idBuscado) {
                return proveedorMedio;
            } else if (proveedorMedio.getId() < idBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }

    //------------------------------PRODUCTO------------------------------

    public void crearProducto() {

        System.out.println("Ingrese nombre del producto:");
        String nombreProducto = scanner.nextLine();
        scanner.next();
        System.out.println("Ingrese precio unitario:");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese descripción del producto:");
        String descripcion = scanner.nextLine();
        System.out.println("Seleccione una categoria de Producto:");
        CategoriaProducto[] categorias = CategoriaProducto.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();

        CategoriaProducto categoriaSeleccionada = null;
        if (opcion >= 1 && opcion <= categorias.length) {
            categoriaSeleccionada = categorias[opcion - 1];
            System.out.println("Categoría seleccionada: " + categoriaSeleccionada);
        } else {
            System.out.println("Opción no válida.");
            while (opcion < 1 || opcion > categorias.length) {
                System.out.println("Seleccione una categoría:");
                opcion = scanner.nextInt();
                scanner.nextLine();
            }
        }
        // Mostrar proveedores disponibles
        System.out.println("Proveedores disponibles:");
        listarProveedores();
        System.out.println("Ingrese el ID del proveedor al que pertenece el producto:");
        int idProveedor = scanner.nextInt();
        scanner.nextLine();
        Proveedor proveedorSeleccionado = buscarProveedorPorId(idProveedor);
        while (proveedorSeleccionado == null) {
            System.out.println("Proveedor no encontrado.");
            System.out.println("Ingrese el ID del proveedor al que pertenece el producto:");
            idProveedor = scanner.nextInt();
            scanner.nextLine();
            proveedorSeleccionado = buscarProveedorPorId(idProveedor);
        }



            Producto nuevoProducto = new Producto(idproductos++, nombreProducto, precioUnitario, proveedorSeleccionado, categoriaSeleccionada, descripcion);
            System.out.println(nuevoProducto.calcularCosto());
            productos.add(nuevoProducto);
            proveedorSeleccionado.getProductos().add(nuevoProducto);

            System.out.println(" Producto registrado exitosamente.");

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void listarProductosConProveedor() {
        int contador = 1;
        System.out.println("Lista de Proveedores: ");
        for (Proveedor p : proveedores) {
            System.out.println(contador + " - " + p.getNombre());
            contador++;
        }
        System.out.println("¿De que proveedor desea listar productos?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion >= 1 && opcion <= contador) {
            for (int i = 0; i < proveedores.size(); i++) {
                for (int j = 0; j < proveedores.get(i).getProductos().size(); j++) {
                    System.out.println(proveedores.get(i).getProductos().get(j).getNombreProducto());
                }
            }
        } else {
            System.out.println("Opcion no valida");
        }
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay lista de productos.");
        }

        System.out.println("Lista de Productos:");
        for (Producto p : productos) {
            System.out.println("- " + p.getId() + ": " + p.getNombreProducto() + "/ Precio: " + p.getPrecioUnitario() + "$");
        }
    }

    public Producto buscarProductoPorNombre() {

            System.out.println("Ingrese el nombre del producto:");
            String nombreBuscado = scanner.next().toLowerCase();
            for (Producto p : productos) {
                if (p.getNombreProducto().equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("Encontrado: "+ p);
                    return p;
                }

        }
        System.out.println("No se encontro el producto a buscar.");
        return null;


    }

    //------------------------------SOLICITUD------------------------------
    public void crearSolicitud() {

        System.out.println("Ingrese nombre del solicitante:");
        String nombreSolicitante = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese departamento del solicitante:");
        String departamento = scanner.nextLine();

        System.out.println("Ingrese teléfono del solicitante:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese correo del solicitante:");
        String correo = scanner.nextLine();

        Solicitante solicitante = new Solicitante(nombreSolicitante, departamento, telefono, correo);
        GregorianCalendar fechaActual = new GregorianCalendar();
        SolicitudCompra nuevaSolicitud = new SolicitudCompra(idSolicitudes++, solicitante, fechaActual);

        boolean condicion = true;
        while (condicion) {
            DetalleSolicitud adicionalSolicitud = detallesSolicitud();
            nuevaSolicitud.addDetallesSolicitud(adicionalSolicitud);
            System.out.println("¿Desea seguir ingresando detalles?(true/false)");
            condicion = scanner.nextBoolean();
            scanner.nextLine();
        }
        nuevaSolicitud.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);

        solicitudesCompra.add(nuevaSolicitud);

        System.out.println("Solicitud numero " + nuevaSolicitud.getNumSolicitud() + " creada exitosamente");
    }

    public DetalleSolicitud detallesSolicitud() {
        System.out.println("INGRESANDO DETALLE DE SOLICITUD:");
        listarProductos();
        System.out.println("Seleccione el producto por nombre a agregar: ");
        Producto producto = buscarProductoPorNombre();
        while (producto == null) {
            System.out.println("No se encontro el producto a agregar.");
            System.out.println("Seleccione el producto a agregar: ");
            listarProductos();
            producto = buscarProductoPorNombre();
        }

        System.out.println("Ingrese la cantidad de producto: ");
        int cantidadProducto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la justificacion: ");
        String justificacion = scanner.nextLine();

        return new DetalleSolicitud(cantidadProducto, justificacion, producto);


    }

    public void listarSolicitudes() {
        if (solicitudesCompra.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
            return;
        }

        System.out.println("Lista de Solicitudes:");
        for (SolicitudCompra solicitud : solicitudesCompra) {
            System.out.println("- Número: " + solicitud.getNumSolicitud() + " | Solicitante: " + solicitud.getSolicitante().getNombre() + " | Estado: " + solicitud.getEstadoSolicitud());
        }
    }

    public SolicitudCompra buscarSolicitudPorId() {
        listarSolicitudes();
        System.out.println("Ingrese el id de la solicitud:");
        int id = scanner.nextInt();
            for (SolicitudCompra solicitudCompra : solicitudesCompra) {
                if (solicitudCompra.getNumSolicitud() == id) {
                    return solicitudCompra;
                }
            }

        System.out.println("No se encontro la solicitud a buscar.");
        return null;

    }
    public void verDetalleSolicitud() {
        SolicitudCompra solicitudCompraEncontrada = buscarSolicitudPorId();
        if (solicitudCompraEncontrada == null) {
            System.out.println("Solicitud no encontrada.");
        } else {
            List<DetalleSolicitud> detalles = solicitudCompraEncontrada.getDetallesSolicitud();
            if (detalles.isEmpty()) {
                System.out.println("La solicitud no tiene detalles.");
            } else {
                System.out.println("Detalles de la solicitud:");
                for (DetalleSolicitud detalle : detalles) {
                    Producto producto = detalle.getProducto();
                    System.out.println("- Producto: " + producto.getNombreProducto());
                    System.out.println("  ID Producto: " + producto.getId());
                    System.out.println("  Precio Unitario: $" + producto.getPrecioUnitario());
                    System.out.println("  Categoría: " + producto.getCategoriaProducto());
                    System.out.println("  Cantidad Solicitada: " + detalle.getCantidad());
                    System.out.println("  Justificación: " + detalle.getJustificacion());

                }
            }
        }
    }

    public void cambiarEstadoSolicitud() {

        System.out.println("Ingrese el número de la solicitud que desea modificar:");
        int numeroSolicitud = scanner.nextInt();
        scanner.nextLine();

        SolicitudCompra solicitudEncontrada = null;

        for (SolicitudCompra solicitud : solicitudesCompra) {
            if (solicitud.getNumSolicitud() == numeroSolicitud) {
                solicitudEncontrada = solicitud;
                break;
            }
        }

        if (solicitudEncontrada == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        System.out.println("Estado actual de la solicitud: " + solicitudEncontrada.getEstadoSolicitud());
        System.out.println("Seleccione el nuevo estado:");

        EstadoSolicitud[] estados = EstadoSolicitud.values();
        for (int i = 0; i < estados.length; i++) {
            System.out.println((i + 1) + ". " + estados[i]);
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion >= 1 && opcion <= estados.length) {
            EstadoSolicitud nuevoEstado = estados[opcion - 1];
            solicitudEncontrada.setEstadoSolicitud(nuevoEstado);
            System.out.println("Estado actualizado a: " + nuevoEstado);
        } else {
            System.out.println("Opción inválida. Estado no actualizado.");
        }
    }



}