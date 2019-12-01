/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.ProduccionBean;
import Modelo.ProductoraBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class ProduccionDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    ProductoraBean prod;

    public ProduccionDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ProduccionBean prb) {

        String sql = "insert into cargo values(?,?,?)";

        prod = new ProductoraBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, prb.getIdproduccion());
            ps.setString(2, prb.getNombreproduccion());
            prod = prb.getIdproductora();
            ps.setInt(3, prod.getIdproductora());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ProduccionBean> mostrar() throws SQLException {
        List<ProduccionBean> lista = new LinkedList<>();

        String sql = "select pr.idproduccion, pr.nombreproduccion, prod.nombreproductora from produccion pr\n"
                + "inner join productora prod on pr.idproductora = prod.idproductora;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                ProductoraBean prod = new ProductoraBean();

                ProduccionBean prb = new ProduccionBean();
                prb.setIdproduccion(rs.getInt(1));
                prb.setNombreproduccion(rs.getString(2));
                prod.setNombreproductora(rs.getString(3));
                prb.setIdproductora(prod);
                lista.add(prb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(ProduccionBean prb) {

        String sql = "update cargo set nombreproduccion=?, idproductora=? where idproduccion=?";

        prod = new ProductoraBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, prb.getNombreproduccion());
            prod = prb.getIdproductora();
            ps.setInt(2, prod.getIdproductora());
            ps.setInt(3, prb.getIdproduccion());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idproduccion) {

        String sql = "delete from cargo where idproduccion=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idproduccion);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
