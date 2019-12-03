package Controlador;

import Conexion.Conexion;
import DAO.CargoDAO;
import DAO.CargoxEmpleadoDAO;
import DAO.EmpleadoDAO;
import Modelo.CargoxEmpleadoBean;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CargoxempleadoServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    EmpleadoDAO empd = new EmpleadoDAO(conn);
    CargoDAO card = new CargoDAO(conn);
    CargoxEmpleadoDAO cxed = new CargoxEmpleadoDAO(conn);
    List<CargoxEmpleadoBean> lista = new LinkedList<>();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        String action = request.getParameter("action");
        switch (action) {
            case "mostrar":
                mostrar(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }


    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = cxed.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaempleado", empd.mostrar());
        request.setAttribute("listacargo", card.mostrar());
        rd = request.getRequestDispatcher("/detallecxed.jsp");
        rd.forward(request, response);

    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CargoxempleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CargoxempleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CargoxempleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
