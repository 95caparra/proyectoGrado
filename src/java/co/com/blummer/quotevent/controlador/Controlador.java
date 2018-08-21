package co.com.blummer.quotevent.controlador;

import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends PrincipalControl {

    //objeto Service
    private PaqueteService paqueteService;
    //objeto VO
    private EmpleadoVO empleadoVO;
    //un entero id, se usará al actualizar y eliminar
    private long id;
    private int resultado;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.request = req;
        this.response = resp;

        //se crea la sesión
        session = request.getSession(true);

        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);

        //evaluamos la opcion que llega desde la pagina y la enviamos a el metodo procesaPeticion()
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
        } catch (NumberFormatException nfe) {
            response.sendRedirect("login.jsp");
        }
    }

    private void procesaPeticion(int opcion) {
        try {

            switch (opcion) {

                case 1://Vista Gerente
                    this.vistaGerente();
                    break;

                case 2:// Lista de clintes
                    break;

                case 3:// Lista de Proveedores
                    break;

                case 4://Lista de Productos
                    break;

                // Clasificacion de productos 
                case 5:// Listar producto (Licor)
//                    this.listaLicor();
                    break;

                case 6:// Listar producto (Menaje)
                    //                  this.listaMenaje();
                    break;

                case 7:// Listar producto (Alimentos)
                    //                this.listaAlimento();
                    break;
                // Fin productos

                case 8: //Listar Empleados

                    break;

                case 9:// Listar Paquetes
                    this.listaPaquete();
                    break;

                case 10:

                    break;

                case 11:

                    break;

                case 12:

                    break;

                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:

                    break;
                case 17:// Listar Catálogos
                    break;
                case 18:// Listar Catalogos Platos
                    break;
                case 19:// Listar Catálogos Bebidas
                    break;
                case 20:// Listar Catálogos Servicios
                    break;

                case 21: // Listar Eventos Aprobados
                    break;

                case 22: // Listar Eventos Abonados
                    break;

                case 23: // Listar Eventos Cancelados
                    break;

                case 24: // Listar Eventos Finalizados
                    break;

                case 25://Solicitud administrador
                    break;
                case 26://Solicitud supervisor
                    break;
                case 27://Solicitud chef
                    break;
                case 28://Solicitud barman
                    break;
                case 29://Solicitud extra
                    break;
                default:
                    this.request.setAttribute("mensaje", "Esta opcion no ha sido implementada ");
                    this.request.setAttribute("opcion", "1");
                    vista = this.request.getRequestDispatcher("respuesta.jsp");
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

    // Vista Gerente
    public void vistaGerente() {
        vista = this.request.getRequestDispatcher("indexGerente.jsp");
    }

    //Lista Paquetes
    public void listaPaquete() throws Exception {
        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listar();
        this.request.setAttribute("listaPaquetes", listaPaquete);
        vista = this.request.getRequestDispatcher("pages/paquetes/listarPaquete.jsp");
    }

}
