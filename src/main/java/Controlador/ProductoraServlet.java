package Controlador;

import Conexion.Conexion;
import DAO.ConsorcioDAO;
import DAO.ProductoraDAO;
import Modelo.ConsorcioBean;
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


public class ProductoraServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    ProductoraDAO prodd = new ProductoraDAO(conn);
    ConsorcioDAO cond = new ConsorcioDAO(conn);
    List<ProductoraBean> lista = new LinkedList<>();

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

        ConsorcioBean conb = new ConsorcioBean();

        String nombreproductora = request.getParameter("nombreproductora");
        String rfc = request.getParameter("rfc");
        String telefono = request.getParameter("telefono");
        int idconsorcio = Integer.parseInt(request.getParameter("idconsorcio"));

        ProductoraBean prodb = new ProductoraBean(0);
        prodb.setNombreproductora(nombreproductora);
        prodb.setRfc(rfc);
        prodb.setTelefono(telefono);
        conb.setIdconsorcio(idconsorcio);
        prodb.setIdconsorcio(conb);

        res = prodd.insertar(prodb);
        lista = prodd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleproductora.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = prodd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleproductora.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        ConsorcioBean conb = new ConsorcioBean();

        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        String nombreproductora = request.getParameter("nombreproductora");
        String rfc = request.getParameter("rfc");
        String telefono = request.getParameter("telefono");
        int idconsorcio = Integer.parseInt(request.getParameter("idconsorcio"));
        

        ProductoraBean prodb = new ProductoraBean(idproductora);
        prodb.setNombreproductora(nombreproductora);
        prodb.setRfc(rfc);
        prodb.setTelefono(telefono);
        conb.setIdconsorcio(idconsorcio);
        prodb.setIdconsorcio(conb);

        res = prodd.Actualizar(prodb);
        lista = prodd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleproductora.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idproductora = Integer.parseInt(request.getParameter("idproductora"));

        res = prodd.eliminar(idproductora);
        lista = prodd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleproductora.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ProductoraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ProductoraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
