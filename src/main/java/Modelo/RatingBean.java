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
public class RatingBean {
    
    private int idrating;
    private String nombrerating;
    private String descripcion;

    public RatingBean() {
    }

    public RatingBean(int idrating) {
        this.idrating = idrating;
    }

    public int getIdrating() {
        return idrating;
    }

    public void setIdrating(int idrating) {
        this.idrating = idrating;
    }

    public String getNombrerating() {
        return nombrerating;
    }

    public void setNombrerating(String nombrerating) {
        this.nombrerating = nombrerating;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
