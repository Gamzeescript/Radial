package Controlador;

import Conexion.Conexion;
import DAO.ProduccionDAO;
import DAO.ProductoraDAO;
import Modelo.ProduccionBean;
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

public class ProduccionServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    ProductoraDAO prodd = new ProductoraDAO(conn);
    ProduccionDAO prd = new ProduccionDAO(conn);
    List<ProduccionBean> lista = new LinkedList<>();

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

        String nombreproduccion = request.getParameter("nombreproduccion");
        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        ProduccionBean prb = new ProduccionBean(0);
        prb.setNombreproduccion(nombreproduccion);
        prodb.setIdproductora(idproductora);
        prb.setIdproductora(prodb);

        res = prd.insertar(prb);
        lista = prd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleproduccion.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = prd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleproduccion.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        ProductoraBean prodb = new ProductoraBean();

        int idproduccion = Integer.parseInt(request.getParameter("idproduccion"));
        String nombreproduccion = request.getParameter("nombreproduccion");
        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        ProduccionBean prb = new ProduccionBean(idproduccion);
        prb.setNombreproduccion(nombreproduccion);
        prodb.setIdproductora(idproductora);
        prb.setIdproductora(prodb);

        res = prd.Actualizar(prb);
        lista = prd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleproduccion.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idproduccion = Integer.parseInt(request.getParameter("idproduccion"));

        res = prd.eliminar(idproduccion);
        lista = prd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaproductora", prodd.mostrar());
        rd = request.getRequestDispatcher("/detalleproduccion.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ProduccionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ProduccionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

