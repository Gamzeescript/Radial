package DAO;

import Conexion.Conexion;
import Modelo.CargoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CargoDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;

    public CargoDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CargoBean carb) {

        String sql = "insert into cargo values(?,?,?)";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, carb.getIdcargo());
            ps.setString(2, carb.getNombrecargo());
            ps.setString(3, carb.getDescripcion());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<CargoBean> mostrar() throws SQLException {
        List<CargoBean>lista = new LinkedList<>();
        
        String sql = "select * from cargo";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                CargoBean carb = new CargoBean();
                carb.setIdcargo(rs.getInt(1));
                carb.setNombrecargo(rs.getString(2));
                carb.setDescripcion(rs.getString(3));
                lista.add(carb);
            }            
            return lista;
        } catch (Exception e) {
            return null;
        }

        
    }

    public boolean Actualizar(CargoBean carb) {

        String sql = "update cargo set nombrecargo=?, descripcion=? where idcargo=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, carb.getNombrecargo());
            ps.setString(2, carb.getDescripcion());
            ps.setInt(3, carb.getIdcargo());
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
