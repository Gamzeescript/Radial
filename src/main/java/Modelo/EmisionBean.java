
package Modelo;

import java.util.Date;


public class EmisionBean {
    
    private int idemision;
    private ProgramaBean idprograma;
    private Date fechainicio;
    private Date horainicio;
    private Date fechafin;
    private Date horafin;
    private String duracion;
    private boolean repeticion;

    public EmisionBean() {
    }

    public EmisionBean(int idemision) {
        this.idemision = idemision;
    }

    public int getIdemision() {
        return idemision;
    }

    public void setIdemision(int idemision) {
        this.idemision = idemision;
    }

    public ProgramaBean getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(ProgramaBean idprograma) {
        this.idprograma = idprograma;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public boolean isRepeticion() {
        return repeticion;
    }

    public void setRepeticion(boolean repeticion) {
        this.repeticion = repeticion;
    }
    
    
}
