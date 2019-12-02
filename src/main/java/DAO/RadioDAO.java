
package DAO;

import Conexion.Conexion;
import Modelo.ConsorcioBean;
import Modelo.FrecuenciaBean;
import Modelo.RadioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class RadioDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    ConsorcioBean conb;
    FrecuenciaBean frecb;

    public RadioDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(RadioBean radb) {

        String sql = "insert into radio values(?,?,?,?,?)";

        conb = new ConsorcioBean();
        frecb = new FrecuenciaBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, radb.getIdradio());
            ps.setString(2, radb.getNombreradio());
            ps.setString(3, radb.getDescripcion());
            frecb = radb.getIdfrecuencia();
            ps.setInt(4, frecb.getIdfrecuencia());
            conb = radb.getIdconsorcio();
            ps.setInt(5, conb.getIdconsorcio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<RadioBean> mostrar() throws SQLException {
        List<RadioBean> lista = new LinkedList<>();

        String sql = "select r.idradio, r.nombreradio, r.descripcion, f.nombrefrecuencia, t.nombretransmision, c.nombreconsorcio from radio r\n"
                + "inner join frecuencia f on r.idfrecuencia = f.idfrecuencia\n"
                + "inner join consorcio c on r.idconsorcio = c.idconsorcio\n"
                + "inner join transmision t on f.idtransmision = t.idtransmision";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                ConsorcioBean conb = new ConsorcioBean();
                FrecuenciaBean frecb = new FrecuenciaBean();

                RadioBean radb = new RadioBean();
                radb.setIdradio(rs.getInt(1));
                radb.setNombreradio(rs.getString(2));
                radb.setDescripcion(rs.getString(3));
                frecb.setNombrefrecuencia(rs.getString(4));
                radb.setIdfrecuencia(frecb);
                conb.setNombreconsorcio(rs.getString(5));
                radb.setIdconsorcio(conb);
                lista.add(radb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(RadioBean radb) {

        String sql = "update radio set nombreradio=?, descripcion=?, idfrecuencia=?, idconsorcio=? where idradio=?";

        conb = new ConsorcioBean();
        frecb = new FrecuenciaBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, radb.getNombreradio());
            ps.setString(2, radb.getDescripcion());
            frecb = radb.getIdfrecuencia();
            ps.setInt(3, frecb.getIdfrecuencia());
            conb = radb.getIdconsorcio();
            ps.setInt(4, conb.getIdconsorcio());
            ps.setInt(5, radb.getIdradio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idradio) {

        String sql = "delete from radio where idradio=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idradio);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
