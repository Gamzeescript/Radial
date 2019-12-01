/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.EmpleadoBean;
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
public class EmpleadoDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    ProductoraBean prodb;

    public EmpleadoDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(EmpleadoBean empb) {

        String sql = "insert into empleado values(?,?,?,?)";

        prodb = new ProductoraBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, empb.getIdempleado());
            ps.setString(2, empb.getNombre());
            ps.setString(3, empb.getCedula());
            prodb = empb.getIdproductora();
            ps.setInt(4, prodb.getIdproductora());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<EmpleadoBean> mostrar() throws SQLException {
        List<EmpleadoBean> lista = new LinkedList<>();

        String sql = "select e.idempleado, e.nombre, e.cedula, prod.nombreproductora from empleado e \n"
                + "inner join productora prod on e.idproductora = prod.idproductora; ";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductoraBean prod = new ProductoraBean();

                EmpleadoBean empb = new EmpleadoBean();
                empb.setIdempleado(rs.getInt(1));
                empb.setNombre(rs.getString(2));
                empb.setCedula(rs.getString(3));
                prod.setNombreproductora(rs.getString(4));
                empb.setIdproductora(prod);
                lista.add(empb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(EmpleadoBean empb) {

        String sql = "update cargo set nombre=?, cedula=?, idproductora where idempleado=?";

        prodb = new ProductoraBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, empb.getNombre());
            ps.setString(2, empb.getCedula());
            prodb = empb.getIdproductora();
            ps.setInt(3, prodb.getIdproductora());
            ps.setInt(4, empb.getIdempleado());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idcargo) {

        String sql = "delete from cargo where idcargo=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idcargo);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
