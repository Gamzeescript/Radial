package DAO;

import Conexion.Conexion;
import Modelo.ConsorcioBean;
import Modelo.ProductoraBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductoraDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    ConsorcioBean conb;

    public ProductoraDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ProductoraBean prodb) {

        String sql = "insert into productora values(?,?,?,?,?)";

        conb = new ConsorcioBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, prodb.getIdproductora());
            ps.setString(2, prodb.getNombreproductora());
            ps.setString(3, prodb.getRfc());
            ps.setString(4, prodb.getTelefono());
            conb = prodb.getIdconsorcio();
            ps.setInt(5, conb.getIdconsorcio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ProductoraBean> mostrar() throws SQLException {
        List<ProductoraBean> lista = new LinkedList<>();

        String sql = "select prod.idproductora, prod.nombreproductora, prod.rfc, prod.telefono, c.nombreconsorcio from productora prod\n"
                + "inner join consorcio c on prod.idconsorcio = c.idconsorcio;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                ConsorcioBean conb = new ConsorcioBean();

                ProductoraBean prodb = new ProductoraBean();
                prodb.setIdproductora(rs.getInt(1));
                prodb.setNombreproductora(rs.getString(2));
                prodb.setRfc(rs.getString(3));
                prodb.setTelefono(rs.getString(4));
                conb.setNombreconsorcio(rs.getString(5));
                prodb.setIdconsorcio(conb);
                lista.add(prodb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(ProductoraBean prodb) {

        String sql = "update cargo set nombreproductora=?, rfc=?, nombreproductora=?, rfc=?, idconsorcio=? where idcargo=?";

        conb = new ConsorcioBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, prodb.getIdproductora());
            ps.setString(2, prodb.getNombreproductora());
            ps.setString(3, prodb.getRfc());
            ps.setString(4, prodb.getTelefono());
            conb = prodb.getIdconsorcio();
            ps.setInt(5, conb.getIdconsorcio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int idproductora) {

        String sql = "delete from productora where idproductora=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idproductora);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
