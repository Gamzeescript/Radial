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
public class ConsorcioBean {

   private int idconsorcio;
   private String nombreconsorcio;
   private String rfc; 
   private String telefono;

    public ConsorcioBean() {
    }

    public ConsorcioBean(int idconsorcio) {
        this.idconsorcio = idconsorcio;
    }

    public int getIdconsorcio() {
        return idconsorcio;
    }

    public void setIdconsorcio(int idconsorcio) {
        this.idconsorcio = idconsorcio;
    }

    public String getNombreconsorcio() {
        return nombreconsorcio;
    }

    public void setNombreconsorcio(String nombreconsorcio) {
        this.nombreconsorcio = nombreconsorcio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
   
    
    
}
