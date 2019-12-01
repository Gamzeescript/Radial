/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.GeneroBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class GeneroDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public GeneroDAO(Conexion conn) {
        this.conn = conn;
    }    
    

    public boolean insertar(GeneroBean genb) {

        String sql = "insert into genero values(?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, genb.getIdgenero());
            ps.setString(2, genb.getNombregenero());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<GeneroBean> mostrar() throws SQLException {
        List<GeneroBean> lista = new LinkedList<>();

        String sql = "select * from genero";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                GeneroBean genb = new GeneroBean();
                genb.setIdgenero(rs.getInt(1));
                genb.setNombregenero(rs.getString(2));
                lista.add(genb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(GeneroBean genb) {

        String sql = "update cargo set nombregenero=? where idgenero=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, genb.getNombregenero());
            ps.setInt(2, genb.getIdgenero());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    public boolean eliminar(int idgenero) {

        String sql = "delete from genero where idgenero=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idgenero);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
