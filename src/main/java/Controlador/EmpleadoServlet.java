package Controlador;

import Conexion.Conexion;
import DAO.EmpleadoDAO;
import DAO.ProductoraDAO;
import Modelo.EmpleadoBean;
import Modelo.ProductoraBean;
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

public class EmpleadoServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    EmpleadoDAO empd = new EmpleadoDAO(conn);
    ProductoraDAO prodd = new ProductoraDAO(conn);
    List<EmpleadoBean> lista = new LinkedList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
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
            throws ServletException, IOException, ParseException, SQLException {

        ProductoraBean prodb = new ProductoraBean();

        String nombre = request.getParameter("nombre");
        String cedula = request.getParameter("cedula");
        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        EmpleadoBean empb = new EmpleadoBean(0);
        empb.setNombre(nombre);
        empb.setCedula(cedula);
        prodb.setIdproductora(idproductora);
        empb.setIdproductora(prodb);

        res = empd.insertar(empb);
        lista = empd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleempleado.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = empd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleempleado.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

         ProductoraBean prodb = new ProductoraBean();

        int idempleado = Integer.parseInt(request.getParameter("idempleado"));

        String nombre = request.getParameter("nombre");
        String cedula = request.getParameter("cedula");
        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        EmpleadoBean empb = new EmpleadoBean(idempleado);
        empb.setNombre(nombre);
        empb.setCedula(cedula);
        prodb.setIdproductora(idproductora);
        empb.setIdproductora(prodb);

        res = empd.insertar(empb);
        lista = empd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleempleado.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idempleado = Integer.parseInt(request.getParameter("idempleado"));

        res = empd.eliminar(idempleado);
        lista = empd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleempleado.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
