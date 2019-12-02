package Controlador;

import Conexion.Conexion;
import DAO.RatingDAO;
import Modelo.RatingBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RatingServlet extends HttpServlet {

    boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    RatingDAO ratd = new RatingDAO(conn);
    List<RatingBean> lista = new LinkedList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insertar(request, response);
                break;
            case "mostrar":
                mostrar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String nombrerating = request.getParameter("nombrerating");
        String descripcion = request.getParameter("descripcion");

        RatingBean ratb = new RatingBean(0);
        ratb.setNombrerating(nombrerating);
        ratb.setDescripcion(descripcion);

        res = ratd.insertar(ratb);
        lista = ratd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallerating.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = ratd.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallerating.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idrating = Integer.parseInt(request.getParameter("idrating"));
        String nombrerating = request.getParameter("nombrerating");
        String descripcion = request.getParameter("descripcion");

        RatingBean ratb = new RatingBean(idrating);
        ratb.setNombrerating(nombrerating);
        ratb.setDescripcion(descripcion);

        res = ratd.Actualizar(ratb);
        lista = ratd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallerating.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idrating = Integer.parseInt(request.getParameter("idrating"));

        res = ratd.eliminar(idrating);
        lista = ratd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallerating.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RatingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RatingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
