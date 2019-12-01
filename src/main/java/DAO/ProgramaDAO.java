package DAO;

import Conexion.Conexion;
import Modelo.GeneroBean;
import Modelo.ProgramaBean;
import Modelo.RadioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProgramaDAO {

    Conexion conn;
    ResultSet rs;
    PreparedStatement ps;
    GeneroBean genb;
    RadioBean radb;

    public ProgramaDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ProgramaBean Prob) {

        String sql = "insert into radio values(?,?,?,?,?)";

        genb = new GeneroBean();
        radb = new RadioBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, Prob.getIdprograma());
            ps.setString(2, Prob.getNombreprograma());
            ps.setString(3, Prob.getDescripcion());
            genb = Prob.getIdgenero();
            ps.setInt(4, genb.getIdgenero());
            radb = Prob.getIdradio();
            ps.setInt(5, radb.getIdradio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ProgramaBean> mostrar() throws SQLException {
        List<ProgramaBean> lista = new LinkedList<>();

        String sql = "select pro.idprograma, pro.nombreprograma, pro.descripcion, g.nombregenero, c.nombreconsorcio from programa pro\n"
                + "inner join genero g on pro.idgenero = g.idgenero\n"
                + "inner join radio r on pro.idradio = r.idradio\n"
                + "inner join consorcio c on r.idradio = c.idconsorcio";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                GeneroBean genb = new GeneroBean();
                RadioBean radb = new RadioBean();

                ProgramaBean prob = new ProgramaBean();
                prob.setIdprograma(rs.getInt(1));
                prob.setNombreprograma(rs.getString(2));
                prob.setDescripcion(rs.getString(3));
                genb.setNombregenero(rs.getString(4));
                prob.setIdgenero(genb);
                radb.setIdradio(rs.getInt(5));
                prob.setIdradio(radb);
                lista.add(prob);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(ProgramaBean Prob) {

        String sql = "update programa set nombreprograma=?, descripcion=?, idgenero=?, idradio=? where idprograma=?";

        genb = new GeneroBean();
        radb = new RadioBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, Prob.getNombreprograma());
            ps.setString(2, Prob.getDescripcion());
            genb = Prob.getIdgenero();
            ps.setInt(3, genb.getIdgenero());
            radb = Prob.getIdradio();
            ps.setInt(4, radb.getIdradio());
            ps.setInt(5, Prob.getIdprograma());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idprograma) {

        String sql = "delete from programa where idprograma=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idprograma);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
