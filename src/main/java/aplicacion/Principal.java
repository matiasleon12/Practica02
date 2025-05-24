package aplicacion;

import gestionDeCompras.*;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class  Principal {
    public static void main(String[] args){




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






        Ejecutable ejecutable = new Ejecutable(listaProveedores, listaProductos,listaDetalleSolicitud,listaSolicitudesCompra);

        ejecutable.menuPrincipal();


    }
}
