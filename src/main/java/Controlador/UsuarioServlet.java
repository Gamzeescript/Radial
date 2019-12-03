
package Controlador;

import Conexion.Conexion;
import DAO.RatingDAO;
import DAO.UsuarioDAO;
import Modelo.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
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

public class UsuarioServlet extends HttpServlet {
    
    boolean res;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    UsuarioDAO userd = new UsuarioDAO(conn);
    List<UsuarioBean> lista = new LinkedList<>();

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

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        UsuarioBean userb = new UsuarioBean(0);
        userb.setNombre(nombre);
        userb.setApellido(apellido);
        userb.setUsuario(usuario);
        userb.setPass(pass);
        userb.setEmail(email);
        userb.setTelefono(telefono);

        res = userd.insertar(userb);
        lista = userd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleusuario.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        lista = userd.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleusuario.jsp");
        rd.forward(request, response);
        

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        UsuarioBean userb = new UsuarioBean(idusuario);
        userb.setNombre(nombre);
        userb.setApellido(apellido);
        userb.setUsuario(usuario);
        userb.setPass(pass);
        userb.setEmail(email);
        userb.setTelefono(telefono);

        res = userd.Actualizar(userb);
        lista = userd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleusuario.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        int idusuario = Integer.parseInt(request.getParameter("idusuario"));

        res = userd.eliminar(idusuario);
        lista = userd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/detalleusuario.jsp");
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
