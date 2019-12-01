/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.TransmisionBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class TransmisionDAO {
    
     Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public TransmisionDAO(Conexion conn) {
        this.conn = conn;
    }
    
    
     public boolean insertar(TransmisionBean transb) {

        String sql = "insert into transmision values(?,?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, transb.getIdtransmision());
            ps.setString(2, transb.getNombretransmision());
            ps.setString(3, transb.getDescripcion());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<TransmisionBean> mostrar() throws SQLException {
        List<TransmisionBean>lista = new LinkedList<>();
        
        String sql = "select * from transmision";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TransmisionBean transb = new TransmisionBean();
                transb.setIdtransmision(rs.getInt(1));
                transb.setNombretransmision(rs.getString(2));
                transb.setDescripcion(rs.getString(3));
                lista.add(transb);
            }            
            return lista;
        } catch (Exception e) {
            return null;
        }

        
    }

    public boolean Actualizar(TransmisionBean transb) {

        String sql = "update transmision set nombretransmision=?, descripcion=? where idtransmision=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, transb.getIdtransmision());
            ps.setString(2, transb.getNombretransmision());
            ps.setString(3, transb.getDescripcion());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idtransmision) {

        String sql = "delete from transmision where idtransmision=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idtransmision);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}