/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.EmisionBean;
import Modelo.ProgramaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class EmisionDAO {

    Conexion conn;
    ResultSet rs;
    ProgramaBean prob;
    PreparedStatement ps;
    SimpleDateFormat ffechai;
    SimpleDateFormat fhorai;
    SimpleDateFormat ffechaf;
    SimpleDateFormat fhoraf;

    public EmisionDAO(Conexion conn) {
        this.conn = conn;
    }


    public boolean insertar(EmisionBean emb) {

        String sql = "insert into emision values(?,?,?,?,?,?,?,?)";

        prob = new ProgramaBean();

        ffechai = new SimpleDateFormat("yyyy-MM-dd");
        fhorai = new SimpleDateFormat("HH:mm");
        ffechaf = new SimpleDateFormat("yyyy-MM-dd");
        fhoraf = new SimpleDateFormat("HH:mm");

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, emb.getIdemision());
            prob = emb.getIdprograma();
            ps.setInt(2, prob.getIdprograma());
            ps.setString(3, ffechai.format(emb.getFechainicio()));
            ps.setString(4, fhorai.format(emb.getHorainicio()));
            ps.setString(5, ffechaf.format(emb.getFechafin()));
            ps.setString(6, fhoraf.format(emb.getHorafin()));
            ps.setString(7, emb.getDuracion());
            ps.setBoolean(8, emb.isRepeticion());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<EmisionBean> mostrar() throws SQLException {
        List<EmisionBean> lista = new LinkedList<>();

        String sql = "select em.idemision, pro.nombreprograma, em.fechainicio, em.horainicio, em.fechafin, em.horafin, em.duracion, em.repeticion from emision em\n"
                + "inner join programa pro on em.idprograma = pro.idprograma;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                ProgramaBean prob = new ProgramaBean();

                EmisionBean emb = new EmisionBean();
                emb.setIdemision(rs.getInt(1));
                prob.setNombreprograma(rs.getString(2));
                emb.setIdprograma(prob);
                emb.setFechainicio(rs.getDate(3));
                emb.setHorainicio(rs.getTime(4));
                emb.setFechainicio(rs.getDate(5));
                emb.setHorainicio(rs.getTime(6));
                emb.setDuracion(rs.getString(7));
                emb.setRepeticion(rs.getBoolean(8));
                lista.add(emb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean Actualizar(EmisionBean emb) {

        String sql = "update cargo set idprograma=?, fechainicio=?, horainicio=?, fechafin=?, horafin=?, duracion=?, repeticion=?  where idemision=?";

        prob = new ProgramaBean();

        ffechai = new SimpleDateFormat("yyyy-MM-dd");
        fhorai = new SimpleDateFormat("HH:mm");
        ffechaf = new SimpleDateFormat("yyyy-MM-dd");
        fhoraf = new SimpleDateFormat("HH:mm");

        try {
            ps = conn.conectar().prepareStatement(sql);
            prob = emb.getIdprograma();
            ps.setInt(1, prob.getIdprograma());
            ps.setString(2, ffechai.format(emb.getFechainicio()));
            ps.setString(3, fhorai.format(emb.getHorainicio()));
            ps.setString(4, ffechaf.format(emb.getFechafin()));
            ps.setString(5, fhoraf.format(emb.getHorafin()));
            ps.setString(6, emb.getDuracion());
            ps.setBoolean(7, emb.isRepeticion());
            ps.setInt(8, emb.getIdemision());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminar(int idemision) {

        String sql = "delete from cargo where idemision=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idemision);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
