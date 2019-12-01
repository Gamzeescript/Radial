
package Modelo;


public class ProduccionBean {
    
    private int idproduccion;
    private String nombreproduccion;
    private ProductoraBean idproductora;

    public ProduccionBean() {
    }

    public ProduccionBean(int idproduccion) {
        this.idproduccion = idproduccion;
    }

    public int getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(int idproduccion) {
        this.idproduccion = idproduccion;
    }

    public String getNombreproduccion() {
        return nombreproduccion;
    }

    public void setNombreproduccion(String nombreproduccion) {
        this.nombreproduccion = nombreproduccion;
    }

    public ProductoraBean getIdproductora() {
        return idproductora;
    }

    public void setIdproductora(ProductoraBean idproductora) {
        this.idproductora = idproductora;
    }
    
    
}
