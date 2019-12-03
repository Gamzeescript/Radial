package Controlador;

import Conexion.Conexion;
import DAO.EncuestaDAO;
import DAO.ProgramaDAO;
import DAO.RatingDAO;
import DAO.UsuarioDAO;
import Modelo.EncuestaBean;
import Modelo.ProgramaBean;
import Modelo.RatingBean;
import Modelo.UsuarioBean;
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


public class EncuestaServlet extends HttpServlet {


    Conexion conn = new Conexion();
    RequestDispatcher rd;
    boolean res;
    List<EncuestaBean> lista = new LinkedList<>();
    EncuestaDAO encd = new EncuestaDAO(conn);
    UsuarioDAO userd = new UsuarioDAO(conn);
    ProgramaDAO prod = new ProgramaDAO(conn);
    RatingDAO ratd = new RatingDAO(conn);

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

        UsuarioBean userb = new UsuarioBean();
        ProgramaBean prob = new ProgramaBean();
        RatingBean ratb = new RatingBean();

        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        int idprograma = Integer.parseInt(request.getParameter("idprograma"));
        int idrating = Integer.parseInt(request.getParameter("idrating"));

        EncuestaBean encb = new EncuestaBean(0);
        userb.setIdusuario(idusuario);
        encb.setIdusuario(userb);
        prob.setIdprograma(idprograma);
        encb.setIdprograma(prob);
        ratb.setIdrating(idrating);
        encb.setIdrating(ratb);

        res = encd.insertar(encb);
        lista = encd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaclausuario", userd.mostrar());
        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("listarating", ratd.mostrar());
        rd = request.getRequestDispatcher("/detalleencuesta.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = encd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaclausuario", userd.mostrar());
        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("listarating", ratd.mostrar());
        rd = request.getRequestDispatcher("/detalleencuesta.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        UsuarioBean userb = new UsuarioBean();
        ProgramaBean prob = new ProgramaBean();
        RatingBean ratb = new RatingBean();

        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        int idprograma = Integer.parseInt(request.getParameter("idprograma"));
        int idrating = Integer.parseInt(request.getParameter("idrating"));

        EncuestaBean encb = new EncuestaBean(0);
        userb.setIdusuario(idusuario);
        encb.setIdusuario(userb);
        prob.setIdprograma(idprograma);
        encb.setIdprograma(prob);
        ratb.setIdrating(idrating);
        encb.setIdrating(ratb);

        res = encd.Actualizar(encb);
        lista = encd.mostrar();

        request.setAttribute("lista", lista);
        request.setAttribute("listaclausuario", userd.mostrar());
        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("listarating", ratd.mostrar());
        rd = request.getRequestDispatcher("/detalleencuesta.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));

        res = encd.eliminar(idpelicula);
        lista = encd.mostrar();

       request.setAttribute("lista", lista);
        request.setAttribute("listaclausuario", userd.mostrar());
        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("listarating", ratd.mostrar());
        rd = request.getRequestDispatcher("/detalleencuesta.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(EncuestaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(EncuestaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

