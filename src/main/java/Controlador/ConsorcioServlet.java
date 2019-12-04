package Controlador;

import Conexion.Conexion;
import DAO.ConsorcioDAO;
import Modelo.ConsorcioBean;
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

public class ConsorcioServlet extends HttpServlet {

   boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    ConsorcioDAO cond = new ConsorcioDAO(conn);
    List<ConsorcioBean> lista = new LinkedList<>();

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

        String nombreconsorcio = request.getParameter("nombreconsorcio");
        String rfc = request.getParameter("rfc");
        String telefono = request.getParameter("telefono");

        ConsorcioBean conb = new ConsorcioBean(0);
        conb.setNombreconsorcio(nombreconsorcio);
        conb.setRfc(rfc);
        conb.setTelefono(telefono);

        res = cond.insertar(conb);
        lista = cond.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleconsorcio.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = cond.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleconsorcio.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idconsorcio = Integer.parseInt(request.getParameter("idconsorcio"));
        String nombreconsorcio = request.getParameter("nombreconsorcio");
        String rfc = request.getParameter("rfc");
        String telefono = request.getParameter("telefono");
        
        ConsorcioBean conb = new ConsorcioBean(idconsorcio);
        conb.setNombreconsorcio(nombreconsorcio);
        conb.setRfc(rfc);
        conb.setTelefono(telefono);

        res = cond.Actualizar(conb);
        lista = cond.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleconsorcio.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idconsorcio = Integer.parseInt(request.getParameter("idconsorcio"));

        res = cond.eliminar(idconsorcio);
        lista = cond.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleconsorcio.jsp");
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
