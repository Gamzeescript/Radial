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
public class CargoxEmpleadoBean {
    private EmpleadoBean idempleado;
    private CargoBean idcargo;

    public CargoxEmpleadoBean() {
    }

    public EmpleadoBean getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(EmpleadoBean idempleado) {
        this.idempleado = idempleado;
    }

    public CargoBean getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(CargoBean idcargo) {
        this.idcargo = idcargo;
    }
    
    
}
