package DAO;

import Conexion.Conexion;
import Modelo.CargoBean;
import Modelo.CargoxEmpleadoBean;
import Modelo.EmpleadoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CargoxEmpleadoDAO {

    Conexion conn;
    ResultSet rs;

    PreparedStatement ps;

    public CargoxEmpleadoDAO(Conexion conn) {
        this.conn = conn;
    }

    public List<CargoxEmpleadoBean> mostrar() throws SQLException {
        List<CargoxEmpleadoBean> lista = new LinkedList<>();

        String sql = "select c.nombrecargo, e.nombre from cargoxempleado ce\n"
                + "left join cargo c on ce.idcargo = c.idcargo \n"
                + "left join empleado e on ce.idempleado = e.idempleado;";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CargoBean carb = new CargoBean();
                EmpleadoBean empb = new EmpleadoBean();

                CargoxEmpleadoBean cxeb = new CargoxEmpleadoBean();
                carb.setNombrecargo(rs.getString(1));
                cxeb.setIdcargo(carb);
                empb.setNombre(rs.getString(2));
                cxeb.setIdempleado(empb);

            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

}
