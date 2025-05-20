package gestionDeCompras;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudCompra {
    private int numSolicitud;
    private Solicitante solicitante;
    private EstadoSolicitud estadoSolicitud;
    private List<DetalleSolicitud> detallesSolicitud;
    private GregorianCalendar fechaSolicitud;

    public SolicitudCompra(int numSolicitud, Solicitante solicitante, GregorianCalendar fechaSolicitud) {
        this.numSolicitud = numSolicitud;
        this.solicitante = solicitante;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.detallesSolicitud = new ArrayList<>();
    }

    public int getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(int numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public GregorianCalendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(GregorianCalendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public List<DetalleSolicitud> getDetallesSolicitud() {
        return detallesSolicitud;
    }

    public void addDetallesSolicitud(DetalleSolicitud detallesSolicitud) {
        this.detallesSolicitud.add(detallesSolicitud);
    }

    @Override
    public String toString() {
        return "SolicitudCompra{" +
                "numSolicitud=" + numSolicitud +
                ", solicitante=" + solicitante +
                ", estadoSolicitud=" + estadoSolicitud +
                ", detallesSolicitud=" + detallesSolicitud +
                ", fechaSolicitud=" + fechaSolicitud +
                '}';
    }
}
