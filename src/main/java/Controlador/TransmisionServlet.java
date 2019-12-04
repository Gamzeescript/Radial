
package Controlador;

import Conexion.Conexion;
import DAO.TransmisionDAO;
import Modelo.TransmisionBean;
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

public class TransmisionServlet extends HttpServlet {

    boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    TransmisionDAO transd = new TransmisionDAO(conn);
    List<TransmisionBean> lista = new LinkedList<>();

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

        String nombretransmision = request.getParameter("nombretransmision");
        String descripcion = request.getParameter("descripcion");

        TransmisionBean transb = new TransmisionBean(0);
        transb.setNombretransmision(nombretransmision);
        transb.setDescripcion(descripcion);

        res = transd.insertar(transb);
        lista = transd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalletransmision.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = transd.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalletransmision.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idtransmision = Integer.parseInt(request.getParameter("idtransmision"));
        String nombretransmision = request.getParameter("nombretransmision");
        String descripcion = request.getParameter("descripcion");
        
        System.out.println(idtransmision);
        System.out.println(nombretransmision);
        System.out.println(descripcion);

        TransmisionBean transb = new TransmisionBean(idtransmision);
        transb.setNombretransmision(nombretransmision);
        transb.setDescripcion(descripcion);

        res = transd.Actualizar(transb);
        lista = transd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalletransmision.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idtransmision = Integer.parseInt(request.getParameter("idtransmision"));

        res = transd.eliminar(idtransmision);
        lista = transd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalletransmision.jsp");
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
