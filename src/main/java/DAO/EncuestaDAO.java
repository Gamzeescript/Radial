package DAO;

import Conexion.Conexion;
import Modelo.EncuestaBean;
import Modelo.ProgramaBean;
import Modelo.RatingBean;
import Modelo.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EncuestaDAO {

    Conexion conn;
    ResultSet rs;
    UsuarioBean userb;
    ProgramaBean prob;
    RatingBean rtb;
    PreparedStatement ps;

    public EncuestaDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(EncuestaBean encb) {

        String sql = "insert into encuesta values(?,?,?,?)";

        userb = new UsuarioBean();
        prob = new ProgramaBean();
        rtb = new RatingBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, encb.getIdencuesta());
            userb = encb.getIdusuario();
            ps.setInt(2, userb.getIdusuario());
            prob = encb.getIdprograma();
            ps.setInt(3, prob.getIdprograma());
            rtb = encb.getIdrating();
            ps.setInt(4, rtb.getIdrating());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<EncuestaBean> mostrar() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select e.idencuesta, u.nombre, pro.nombreprograma, r.nombrerating from encuesta e\n"
                + "inner join usuario u on e.idusuario = u.idusuario\n"
                + "inner join programa pro on e.idprograma = pro.idprograma\n"
                + "inner join rating r on  e.idrating = r.idrating";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    
    public List<EncuestaBean> mostrarcincoestrellas() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e \n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 1";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<EncuestaBean> mostrarcuatroestrellas() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e\n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 2";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<EncuestaBean> mostrartresestrellas() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e\n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 3";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<EncuestaBean> mostrardosestrellas() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e\n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 4";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<EncuestaBean> mostrarunaestrella() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e\n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 5;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<EncuestaBean> mostrarceroestrellas() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "select p.nombreprograma,\n"
                + "count(*) from encuesta e\n"
                + "inner join programa p on e.idprograma = p.idprograma\n"
                + "where e.idrating = 6";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }
    
    public List<EncuestaBean> conteo() throws SQLException {
        List<EncuestaBean> lista = new LinkedList<>();

        String sql = "count(*) from encuesta e\n"
                + "inner join usuario u on e.idusuario = u.idusuario";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                userb = new UsuarioBean();
                prob = new ProgramaBean();
                rtb = new RatingBean();

                EncuestaBean encb = new EncuestaBean();
                encb.setIdencuesta(rs.getInt(1));
                userb.setNombre(rs.getString(2));
                encb.setIdusuario(userb);
                prob.setNombreprograma(rs.getString(3));
                encb.setIdprograma(prob);
                rtb.setNombrerating(rs.getString(4));
                encb.setIdrating(rtb);
                lista.add(encb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(EncuestaBean encb) {

        String sql = "update encuesta set idusuario=?, idprograma=?, idrating=? where idencuesta=?";

        userb = new UsuarioBean();
        prob = new ProgramaBean();
        rtb = new RatingBean();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, encb.getIdencuesta());
            userb = encb.getIdusuario();
            ps.setInt(2, userb.getIdusuario());
            prob = encb.getIdprograma();
            ps.setInt(3, prob.getIdprograma());
            rtb = encb.getIdrating();
            ps.setInt(4, rtb.getIdrating());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idencuesta) {

        String sql = "delete from idencuesta where idencuesta=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idencuesta);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
