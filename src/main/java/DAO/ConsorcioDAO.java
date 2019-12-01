/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.ConsorcioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class ConsorcioDAO {
    
    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public ConsorcioDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ConsorcioBean conb) {

        String sql = "insert into consorcio values(?,?,?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, conb.getIdconsorcio());
            ps.setString(2, conb.getNombreconsorcio());
            ps.setString(3, conb.getRfc());
            ps.setString(4, conb.getTelefono());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ConsorcioBean> mostrar() throws SQLException {
        List<ConsorcioBean>lista = new LinkedList<>();
        
        String sql = "select * from consorcio";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ConsorcioBean conb = new ConsorcioBean();
                conb.setIdconsorcio(rs.getInt(1));
                conb.setNombreconsorcio(rs.getString(2));
                conb.setRfc(rs.getString(3));
                conb.setTelefono(rs.getString(4));
                lista.add(conb);
            }            
            return lista;
        } catch (Exception e) {
            return null;
        }

        
    }

    public boolean Actualizar(ConsorcioBean conb) {

        String sql = "update cargo set nombreconsorcio=?, rfc=?, telefono=? where idconsorcio=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, conb.getNombreconsorcio());
            ps.setString(2, conb.getRfc());
            ps.setString(3, conb.getTelefono());
             ps.setInt(4, conb.getIdconsorcio());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idconsorcio) {

        String sql = "delete from consorcio where idconsorcio=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idconsorcio);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}

