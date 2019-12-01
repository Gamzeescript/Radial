
package Modelo;


public class RadioBean {
    
  private int idradio;
  private String nombreradio;
  private String descripcion;
  private FrecuenciaBean idfrecuencia;
  private ConsorcioBean idconsorcio;

    public RadioBean() {
    }

    public RadioBean(int idradio) {
        this.idradio = idradio;
    }

    public int getIdradio() {
        return idradio;
    }

    public void setIdradio(int idradio) {
        this.idradio = idradio;
    }

    public String getNombreradio() {
        return nombreradio;
    }

    public void setNombreradio(String nombreradio) {
        this.nombreradio = nombreradio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FrecuenciaBean getIdfrecuencia() {
        return idfrecuencia;
    }

    public void setIdfrecuencia(FrecuenciaBean idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public ConsorcioBean getIdconsorcio() {
        return idconsorcio;
    }

    public void setIdconsorcio(ConsorcioBean idconsorcio) {
        this.idconsorcio = idconsorcio;
    }

  
    
}
