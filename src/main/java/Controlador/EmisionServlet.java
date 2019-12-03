package Controlador;

import Conexion.Conexion;
import DAO.EmisionDAO;
import DAO.ProgramaDAO;
import Modelo.EmisionBean;
import Modelo.ProgramaBean;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmisionServlet extends HttpServlet {


    Conexion conn = new Conexion();
    RequestDispatcher rd;
    String msg = "";
    boolean res;
    SimpleDateFormat ffechai;
    SimpleDateFormat fhorai;
    SimpleDateFormat ffechaf;
    SimpleDateFormat fhoraf;
    List<EmisionBean> lista = new LinkedList<>();
    EmisionDAO emd = new EmisionDAO(conn);
    ProgramaDAO prod = new ProgramaDAO(conn);

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

        ffechai = new SimpleDateFormat("yyyy-MM-dd");
        fhorai = new SimpleDateFormat("HH:mm");
        ffechaf = new SimpleDateFormat("yyyy-MM-dd");
        fhoraf = new SimpleDateFormat("HH:mm");

        ProgramaBean prob = new ProgramaBean();

        int idprograma = Integer.parseInt(request.getParameter("idprograma"));
        Date fechainicio = ffechai.parse("fechainicio");
        Date horainicio = fhorai.parse("horainicio");
        Date fechafin = ffechaf.parse("fechafin");
        Date horafin = fhoraf.parse("horafin");
        boolean repeticion = Boolean.parseBoolean(request.getParameter("repeticion"));

        EmisionBean emb = new EmisionBean(0);
        prob.setIdprograma(idprograma);
        emb.setIdprograma(prob);
        emb.setFechainicio(fechainicio);
        emb.setHorainicio(horainicio);
        emb.setFechafin(fechafin);
        emb.setHorafin(horafin);
        emb.setRepeticion(repeticion);

        res = emd.insertar(emb);
        lista = emd.mostrar();

        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleemision.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = emd.mostrar();

        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleemision.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        ffechai = new SimpleDateFormat("yyyy-MM-dd");
        fhorai = new SimpleDateFormat("HH:mm");
        ffechaf = new SimpleDateFormat("yyyy-MM-dd");
        fhoraf = new SimpleDateFormat("HH:mm");

        ProgramaBean prob = new ProgramaBean();
       
        int idemision = Integer.parseInt(request.getParameter("idemision"));
        int idprograma = Integer.parseInt(request.getParameter("idprograma"));
        Date fechainicio = ffechai.parse("fechainicio");
        Date horainicio = fhorai.parse("horainicio");
        Date fechafin = ffechaf.parse("fechafin");
        Date horafin = fhoraf.parse("horafin");
        boolean repeticion = Boolean.parseBoolean(request.getParameter("repeticion"));

        EmisionBean emb = new EmisionBean(idemision);
        prob.setIdprograma(idprograma);
        emb.setIdprograma(prob);
        emb.setFechainicio(fechainicio);
        emb.setHorainicio(horainicio);
        emb.setFechafin(fechafin);
        emb.setHorafin(horafin);
        emb.setRepeticion(repeticion);

        res = emd.Actualizar(emb);
        lista = emd.mostrar();

        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleemision.jsp");
        rd.forward(request, response);


    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idemision = Integer.parseInt(request.getParameter("idemision"));

        res = emd.eliminar(idemision);
        lista = emd.mostrar();

        request.setAttribute("listaprograma", prod.mostrar());
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleemision.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EmisionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmisionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EmisionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmisionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
