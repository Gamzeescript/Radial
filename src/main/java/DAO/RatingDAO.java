/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.GeneroBean;
import Modelo.RatingBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class RatingDAO {
    
    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public RatingDAO(Conexion conn) {
        this.conn = conn;
    }
    
    
    public boolean insertar(RatingBean ratb) {

        String sql = "insert into rating values(?,?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ratb.getIdrating());
            ps.setString(2, ratb.getNombrerating());
            ps.setString(3, ratb.getDescripcion());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<RatingBean> mostrar() throws SQLException {
        List<RatingBean>lista = new LinkedList<>();
        
        String sql = "select * from rating";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                RatingBean ratb = new RatingBean();
                ratb.setIdrating(rs.getInt(1));
                ratb.setNombrerating(rs.getString(2));
                ratb.setDescripcion(rs.getString(3));
                lista.add(ratb);
            }            
            return lista;
        } catch (Exception e) {
            return null;
        }

        
    }

    public boolean Actualizar(RatingBean ratb) {

        String sql = "update cargo set nombrerating=?, descripcion=? where idrating=?";

         try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, ratb.getNombrerating());
            ps.setString(2, ratb.getDescripcion());
            ps.setInt(3, ratb.getIdrating());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idrating) {

        String sql = "delete from rating where idrating=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idrating);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}