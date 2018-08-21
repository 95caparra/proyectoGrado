package co.com.blummer.quotevent.controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrincipalControl extends HttpServlet {

    //objeto Service
    //private ProductoService productoService;
    //objeto VO
    //private ProductoVO productoVO;
    protected RequestDispatcher vista;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.request = req;
        this.response = resp;

        //se crea la sesión
        session = request.getSession(true);
        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);
        

        try {
            if (request.getParameter("opcion") != null || !request.getParameter("opcion").equals("")) {
                if (estaAutenticado()) {
                    //Variable que nos permita saber la opcion a ejecutar
                    int opcion = Integer.parseInt(request.getParameter("opcion"));
                    //Lammamos al metodo que procesa la peticion
                    this.procesaPeticion(opcion);
                } else {
                    response.sendRedirect("login.jsp");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (NullPointerException npe) {
            response.sendRedirect("login.jsp");
        }
    }

    private void procesaPeticion(int opcion) {

        try {

            switch (opcion) {

                case 27: //Muestra Index
                    this.mostrarIndex();
                    break;

                default:
                    this.mostrarDefault();
                    break;
            }

            vista.forward(this.request, this.response);

        } catch (ServletException ex) {
            System.out.println("ServletException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }

    protected void mostrarDefault() {

        //enviamos un mensaje para indicar que están solicitando una opción no válida 
        request.setAttribute("mensaje", "Esta  opción  no  ha  sido implementada.");
        //le decimos a cual opción ir después de dar clic en el botón Aceptar del JSP de respuesta
        request.setAttribute("opcion", "27");
        //Indica cual JSP va a mostrar la información enviada
        vista = request.getRequestDispatcher("respuesta.jsp");
    }

    protected void mostrarIndex() throws Exception {
    }

    public boolean estaAutenticado() {
        boolean autenticado = false;
        String usuario = (String) this.session.getAttribute("usuario");
        if (usuario != null && !usuario.equals("")) {
            autenticado = true;
            request.setAttribute("usuario", usuario);
        } else {
            request.setAttribute("usuario", null);
        }

        return autenticado;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
