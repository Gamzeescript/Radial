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
public class EncuestaBean {
    
    private int idencuesta;
    private UsuarioBean idusuario;
    private ProgramaBean idprograma;
    private RatingBean idrating;

    public EncuestaBean() {
    }

    public EncuestaBean(int idencuesta) {
        this.idencuesta = idencuesta;
    }

    public int getIdencuesta() {
        return idencuesta;
    }

    public void setIdencuesta(int idencuesta) {
        this.idencuesta = idencuesta;
    }

    public UsuarioBean getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioBean idusuario) {
        this.idusuario = idusuario;
    }

    public ProgramaBean getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(ProgramaBean idprograma) {
        this.idprograma = idprograma;
    }

    public RatingBean getIdrating() {
        return idrating;
    }

    public void setIdrating(RatingBean idrating) {
        this.idrating = idrating;
    }
    
    
    
}
