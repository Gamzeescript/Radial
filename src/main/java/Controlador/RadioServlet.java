package Controlador;

import Conexion.Conexion;
import DAO.ConsorcioDAO;
import DAO.FrecuenciaDAO;
import DAO.RadioDAO;
import Modelo.ConsorcioBean;
import Modelo.FrecuenciaBean;
import Modelo.RadioBean;
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

public class RadioServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    RadioDAO radd = new RadioDAO(conn);
    FrecuenciaDAO frecd = new FrecuenciaDAO(conn);
    ConsorcioDAO cond = new ConsorcioDAO(conn);
    List<RadioBean> lista = new LinkedList<>();

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

        FrecuenciaBean frecb = new FrecuenciaBean();
        ConsorcioBean conb = new ConsorcioBean();

        String nombreradio = request.getParameter("nombreradio");
        String descripcion = request.getParameter("descripcion");
        int idfrecuencia = Integer.parseInt(request.getParameter("idfrecuencia"));
        int idconsorcio = Integer.parseInt(request.getParameter("idconscorcio"));

        RadioBean radb = new RadioBean(0);
        radb.setNombreradio(nombreradio);
        radb.setDescripcion(descripcion);
        frecb.setIdfrecuencia(idfrecuencia);
        radb.setIdfrecuencia(frecb);
        conb.setIdconsorcio(idconsorcio);
        radb.setIdconsorcio(conb);

        res = radd.insertar(radb);
        lista = radd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listafrecuencia", frecd.mostrar());
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleradio.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = radd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listafrecuencia", frecd.mostrar());
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleradio.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        FrecuenciaBean frecb = new FrecuenciaBean();
        ConsorcioBean conb = new ConsorcioBean();

        int idradio = Integer.parseInt(request.getParameter("idradio"));
        
        String nombreradio = request.getParameter("nombreradio");
        String descripcion = request.getParameter("descripcion");
        int idfrecuencia = Integer.parseInt(request.getParameter("idfrecuencia"));
        int idconsorcio = Integer.parseInt(request.getParameter("idconscorcio"));

        RadioBean radb = new RadioBean(idradio);
        radb.setNombreradio(nombreradio);
        radb.setDescripcion(descripcion);
        frecb.setIdfrecuencia(idfrecuencia);
        radb.setIdfrecuencia(frecb);
        conb.setIdconsorcio(idconsorcio);
        radb.setIdconsorcio(conb);

        res = radd.Actualizar(radb);
        lista = radd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listafrecuencia", frecd.mostrar());
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleradio.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idradio = Integer.parseInt(request.getParameter("idradio"));

        res = radd.eliminar(idradio);
        lista = radd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listafrecuencia", frecd.mostrar());
        request.setAttribute("listaconsorcio", cond.mostrar());
        rd = request.getRequestDispatcher("/detalleradio.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RadioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RadioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RadioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RadioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
