package DAO;

import Conexion.Conexion;
import Modelo.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UsuarioDAO {
     Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public UsuarioDAO(Conexion conn) {
        this.conn = conn;
    }
       
    public boolean insertar(UsuarioBean userb) {

        String sql = "insert into usuario values(?,?,?,?,?,?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, userb.getIdusuario());
            ps.setString(2, userb.getNombre());
            ps.setString(3, userb.getApellido());
            ps.setString(4, userb.getUsuario());
            ps.setString(5, userb.getPass());
            ps.setString(6, userb.getEmail());
            ps.setString(7, userb.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<UsuarioBean> mostrar() throws SQLException {
        List<UsuarioBean>lista = new LinkedList<>();
        
        String sql = "select * from usuario";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                UsuarioBean userb = new UsuarioBean();
                userb.setIdusuario(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                userb.setApellido(rs.getString(3));
                userb.setUsuario(rs.getString(4));
                userb.setPass(rs.getString(5));
                userb.setEmail(rs.getString(6));
                userb.setTelefono(rs.getString(7));
                lista.add(userb);
            }            
            return lista;
        } catch (Exception e) {
            return null;
        }

        
    }

    public boolean Actualizar(UsuarioBean userb) {

        String sql = "update usuario set nombre=?, apellido=?, usuario=?, pass=?, email=?, telefono=? where idusuario=?";

         try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, userb.getNombre());
            ps.setString(2, userb.getApellido());
            ps.setString(3, userb.getUsuario());
            ps.setString(4, userb.getPass());
            ps.setString(5, userb.getEmail());
            ps.setString(6, userb.getTelefono());
            ps.setInt(7, userb.getIdusuario());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idusuario) {

        String sql = "delete from usuario where idusuario=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idusuario);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}