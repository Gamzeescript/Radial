package Controlador;

import Conexion.Conexion;
import DAO.GeneroDAO;
import DAO.ProgramaDAO;
import DAO.RadioDAO;
import Modelo.GeneroBean;
import Modelo.ProgramaBean;
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

public class ProgramaServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    RadioDAO radd = new RadioDAO(conn);
    GeneroDAO gend = new GeneroDAO(conn);
    ProgramaDAO prod = new ProgramaDAO(conn);
    List<ProgramaBean> lista = new LinkedList<>();

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
            case "mostrargeneral":
                mostrargeneral(request, response);
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

        GeneroBean genb = new GeneroBean();
        RadioBean radb = new RadioBean();

        String nombreprograma = request.getParameter("nombreprograma");
        String descripcion = request.getParameter("descripcion");
        int idgenero = Integer.parseInt(request.getParameter("idgenero"));
        int idradio = Integer.parseInt(request.getParameter("idradio"));

        ProgramaBean prob = new ProgramaBean(0);
        prob.setNombreprograma(nombreprograma);
        prob.setDescripcion(descripcion);
        genb.setIdgenero(idgenero);
        prob.setIdgenero(genb);
        radb.setIdradio(idradio);
        prob.setIdradio(radb);

        res = prod.insertar(prob);
        lista = prod.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listagenero", gend.mostrar());
        request.setAttribute("listaradio", radd.mostrar());
        rd = request.getRequestDispatcher("/detalleprograma.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = prod.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listagenero", gend.mostrar());
        request.setAttribute("listaradio", radd.mostrar());
        rd = request.getRequestDispatcher("/detalleprograma.jsp");
        rd.forward(request, response);

    }

    protected void mostrargeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = prod.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listagenero", gend.mostrar());
        request.setAttribute("listaradio", radd.mostrar());
        rd = request.getRequestDispatcher("/detalleprogramageneral.jsp");
        rd.forward(request, response);

    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        GeneroBean genb = new GeneroBean();
        RadioBean radb = new RadioBean();

        int idprograma = Integer.parseInt(request.getParameter("idprograma"));

        String nombreprograma = request.getParameter("nombreprograma");
        String descripcion = request.getParameter("descripcion");
        int idgenero = Integer.parseInt(request.getParameter("idgenero"));
        int idradio = Integer.parseInt(request.getParameter("idradio"));

        ProgramaBean prob = new ProgramaBean(idprograma);
        prob.setNombreprograma(nombreprograma);
        prob.setDescripcion(descripcion);
        genb.setIdgenero(idgenero);
        prob.setIdgenero(genb);
        radb.setIdradio(idradio);
        prob.setIdradio(radb);

        res = prod.Actualizar(prob);
        lista = prod.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listagenero", gend.mostrar());
        request.setAttribute("listaradio", radd.mostrar());
        rd = request.getRequestDispatcher("/detalleprograma.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idprograma = Integer.parseInt(request.getParameter("idprograma"));

        res = prod.eliminar(idprograma);
        lista = prod.mostrar();

       request.setAttribute("lista", lista);
        request.setAttribute("listagenero", gend.mostrar());
        request.setAttribute("listaradio", radd.mostrar());
        rd = request.getRequestDispatcher("/detalleprograma.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProgramaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProgramaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
