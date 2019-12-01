
package Modelo;


public class ProductoraBean {
    
    private int idproductora;
    private String nombreproductora;
    private String rfc;
    private String telefono;
    private ConsorcioBean idconsorcio;

    public ProductoraBean() {
    }

    public ProductoraBean(int idproductora) {
        this.idproductora = idproductora;
    }

    public int getIdproductora() {
        return idproductora;
    }

    public void setIdproductora(int idproductora) {
        this.idproductora = idproductora;
    }

    public String getNombreproductora() {
        return nombreproductora;
    }

    public void setNombreproductora(String nombreproductora) {
        this.nombreproductora = nombreproductora;
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

    public ConsorcioBean getIdconsorcio() {
        return idconsorcio;
    }

    public void setIdconsorcio(ConsorcioBean idconsorcio) {
        this.idconsorcio = idconsorcio;
    }
    
    
    
}
