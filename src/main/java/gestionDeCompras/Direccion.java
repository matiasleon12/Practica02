package gestionDeCompras;

public class Direccion {
    private String callePrincipal;
    private String calleSecundaria;
    private String numeroPropiedad;
    private String ciudad;
    private String provincia;
    private String pais;

    public Direccion(String callePrincipal, String calleSecundaria,String numeroPropiedad, String ciudad, String pais, String provincia) {
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.ciudad = ciudad;
        this.numeroPropiedad = numeroPropiedad;
        this.pais = pais;
        this.provincia = provincia;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumeroPropiedad() {
        return numeroPropiedad;
    }

    public void setNumeroPropiedad(String numeroPropiedad) {
        this.numeroPropiedad = numeroPropiedad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "callePrincipal='" + callePrincipal + '\'' +
                ", calleSecundaria='" + calleSecundaria + '\'' +
                ", numeroPropiedad='" + numeroPropiedad + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
