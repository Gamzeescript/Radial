package Controlador;

import Conexion.Conexion;
import DAO.CargoDAO;
import Modelo.CargoBean;
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

public class CargoServlet extends HttpServlet {

    boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    CargoDAO card = new CargoDAO(conn);
    List<CargoBean> lista = new LinkedList<>();

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

        String nombrecargo = request.getParameter("nombrecargo");
        String descripcion = request.getParameter("descripcion");

        CargoBean carb = new CargoBean(0);
        carb.setNombrecargo(nombrecargo);
        carb.setDescripcion(descripcion);

        res = card.insertar(carb);
        lista = card.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallecargo.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = card.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallecargo.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idcargo = Integer.parseInt(request.getParameter("idcargo"));
        String nombrecargo = request.getParameter("nombrecargo");
        String descripcion = request.getParameter("descripcion");

        CargoBean carb = new CargoBean(idcargo);
        carb.setNombrecargo(nombrecargo);
        carb.setDescripcion(descripcion);

        res = card.Actualizar(carb);
        lista = card.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallecargo.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idcargo = Integer.parseInt(request.getParameter("idcargo"));

        res = card.eliminar(idcargo);
        lista = card.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detallecargo.jsp");
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
