
package Modelo;


public class EmpleadoBean {
    
    private int idempleado;
    private String nombre;
    private String cedula;
    private ProductoraBean idproductora;

    public EmpleadoBean() {
    }

    public EmpleadoBean(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ProductoraBean getIdproductora() {
        return idproductora;
    }

    public void setIdproductora(ProductoraBean idproductora) {
        this.idproductora = idproductora;
    }
    
    
}
