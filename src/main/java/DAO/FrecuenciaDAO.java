package DAO;

import Conexion.Conexion;
import Modelo.FrecuenciaBean;
import Modelo.TransmisionBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FrecuenciaDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    TransmisionBean transb;

    public FrecuenciaDAO(Conexion conn) {
        this.conn = conn;
    }
       

    public boolean insertar(FrecuenciaBean frecb) {

        String sql = "insert into frecuencia values(?,?,?,?,?)";

        transb = new TransmisionBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, frecb.getIdfrecuencia());
            ps.setString(2, frecb.getNombrefrecuencia());
            ps.setString(3, frecb.getDescripcion());
            ps.setString(4, frecb.getFrecuencia());
            transb = frecb.getIdtransmision();
            ps.setInt(5, transb.getIdtransmision());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<FrecuenciaBean> mostrar() throws SQLException {
        List<FrecuenciaBean> lista = new LinkedList<>();

        String sql = "select f.idfrecuencia, f.nombrefrecuencia, f.descripcion, f.frecuencia, t.nombretransmision from frecuencia f\n"
                + "inner join transmision t on f.idtransmision = t.idtransmision;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                TransmisionBean transb = new TransmisionBean();
                
                FrecuenciaBean frecb = new FrecuenciaBean();
                frecb.setIdfrecuencia(rs.getInt(1));
                frecb.setNombrefrecuencia(rs.getString(2));
                frecb.setDescripcion(rs.getString(3));
                frecb.setFrecuencia(rs.getString(4));
                transb.setNombretransmision(rs.getString(5));
                frecb.setIdtransmision(transb);
                lista.add(frecb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(FrecuenciaBean frecb) {

        String sql = "update frecuencia set nombrefrecuencia=?, descripcion=?, frecuencia=?, idtransmision=? where idfrecuencia=?";

        transb = new TransmisionBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, frecb.getNombrefrecuencia());
            ps.setString(2, frecb.getDescripcion());
            ps.setString(3, frecb.getFrecuencia());
            transb = frecb.getIdtransmision();
            ps.setInt(4, transb.getIdtransmision());
            ps.setInt(5, frecb.getIdfrecuencia());

            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idfrecuencia) {

        String sql = "delete from frecuencia where idfrecuencia=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idfrecuencia);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
