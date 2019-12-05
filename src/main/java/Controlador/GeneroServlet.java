package Controlador;

import Conexion.Conexion;
import DAO.GeneroDAO;
import Modelo.GeneroBean;
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

public class GeneroServlet extends HttpServlet {

    boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    GeneroDAO gend = new GeneroDAO(conn);
    List<GeneroBean> lista = new LinkedList<>();

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

        String nombregenero = request.getParameter("nombregenero");

        GeneroBean genb = new GeneroBean(0);
        genb.setNombregenero(nombregenero);

        res = gend.insertar(genb);
        lista = gend.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallegenero.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = gend.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallegenero.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idgenero = Integer.parseInt(request.getParameter("idgenero"));
        String nombregenero = request.getParameter("nombregenero");

        GeneroBean genb = new GeneroBean(idgenero);
        genb.setNombregenero(nombregenero);

        res = gend.Actualizar(genb);
        lista = gend.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallegenero.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idgenero = Integer.parseInt(request.getParameter("idgenero"));

        res = gend.eliminar(idgenero);
        lista = gend.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallegenero.jsp");
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
