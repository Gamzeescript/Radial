package Modelo;


public class ProgramaBean {
    
    private int idprograma;
    private String nombreprograma;
    private String descripcion;
    private GeneroBean idgenero;
    private RadioBean idradio;    

    public ProgramaBean() {
    }

    public ProgramaBean(int idprograma) {
        this.idprograma = idprograma;
    }

    public int getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(int idprograma) {
        this.idprograma = idprograma;
    }

    public String getNombreprograma() {
        return nombreprograma;
    }

    public void setNombreprograma(String nombreprograma) {
        this.nombreprograma = nombreprograma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GeneroBean getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(GeneroBean idgenero) {
        this.idgenero = idgenero;
    }

    public RadioBean getIdradio() {
        return idradio;
    }

    public void setIdradio(RadioBean idradio) {
        this.idradio = idradio;
    }
    
    
}
