/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author liliana.gironusam
 */
public class FrecuenciaBean {
    
    private int idfrecuencia;
    private String nombrefrecuencia;
    private String descripcion;
    private String frecuencia;
    private TransmisionBean idtransmision;

    public FrecuenciaBean() {
    }

    public FrecuenciaBean(int idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public int getIdfrecuencia() {
        return idfrecuencia;
    }

    public void setIdfrecuencia(int idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public String getNombrefrecuencia() {
        return nombrefrecuencia;
    }

    public void setNombrefrecuencia(String nombrefrecuencia) {
        this.nombrefrecuencia = nombrefrecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public TransmisionBean getIdtransmision() {
        return idtransmision;
    }

    public void setIdtransmision(TransmisionBean idtransmision) {
        this.idtransmision = idtransmision;
    }
    
    
    
}
