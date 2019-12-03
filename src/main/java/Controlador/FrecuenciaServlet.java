package Controlador;

import Conexion.Conexion;
import DAO.FrecuenciaDAO;
import DAO.TransmisionDAO;
import Modelo.FrecuenciaBean;
import Modelo.TransmisionBean;
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

public class FrecuenciaServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    FrecuenciaDAO frecd = new FrecuenciaDAO(conn);
    TransmisionDAO transd = new TransmisionDAO(conn);
    List<FrecuenciaBean> lista = new LinkedList<>();

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

        TransmisionBean transb = new TransmisionBean();

        String nombrefrecuencia = request.getParameter("nombrefrecuencia");
        String descripcion = request.getParameter("descripcion");
        String frecuencia = request.getParameter("frecuencia");
        int idtransmision = Integer.parseInt(request.getParameter("idtransmision"));

        FrecuenciaBean frecb = new FrecuenciaBean(0);
        frecb.setNombrefrecuencia(nombrefrecuencia);
        frecb.setDescripcion(descripcion);
        frecb.setFrecuencia(frecuencia);
        transb.setIdtransmision(idtransmision);
        frecb.setIdtransmision(transb);
        
        res = frecd.insertar(frecb);
        lista = frecd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listatransmision", transd.mostrar());
        rd = request.getRequestDispatcher("/detallefrecuencia.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = frecd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listatransmision", transd.mostrar());
        rd = request.getRequestDispatcher("/detallefrecuencia.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        TransmisionBean transb = new TransmisionBean();

        int idfrecuencia = Integer.parseInt(request.getParameter("idfrecuencia"));

        String nombrefrecuencia = request.getParameter("nombrefrecuencia");
        String descripcion = request.getParameter("descripcion");
        String frecuencia = request.getParameter("frecuencia");
        int idtransmision = Integer.parseInt(request.getParameter("idtransmision"));

        FrecuenciaBean frecb = new FrecuenciaBean(idfrecuencia);
        frecb.setNombrefrecuencia(nombrefrecuencia);
        frecb.setDescripcion(descripcion);
        frecb.setFrecuencia(frecuencia);
        transb.setIdtransmision(idtransmision);
        frecb.setIdtransmision(transb);

        res = frecd.Actualizar(frecb);
        lista = frecd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listatransmision", transd.mostrar());
        rd = request.getRequestDispatcher("/detallefrecuencia.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idfrecuencia = Integer.parseInt(request.getParameter("idfrecuencia"));

        res = frecd.eliminar(idfrecuencia);
        lista = frecd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listatransmision", transd.mostrar());
        rd = request.getRequestDispatcher("/detallefrecuencia.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(FrecuenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrecuenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(FrecuenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrecuenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
