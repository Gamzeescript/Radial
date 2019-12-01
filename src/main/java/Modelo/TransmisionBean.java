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
public class TransmisionBean {
   
    private int idtransmision; 
    private String nombretransmision;
    private String descripcion; 

    public TransmisionBean() {
    }

    public TransmisionBean(int idtransmision) {
        this.idtransmision = idtransmision;
    }

    public int getIdtransmision() {
        return idtransmision;
    }

    public void setIdtransmision(int idtransmision) {
        this.idtransmision = idtransmision;
    }

    public String getNombretransmision() {
        return nombretransmision;
    }

    public void setNombretransmision(String nombretransmision) {
        this.nombretransmision = nombretransmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
