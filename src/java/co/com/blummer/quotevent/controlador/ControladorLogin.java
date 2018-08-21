/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.controlador;


import co.com.blummer.quotevent.modelo.service.SolicitudService;
import co.com.blummer.quotevent.modelo.service.UsuarioService;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import co.com.blummer.quotevent.util.Util;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ControladorLogin extends HttpServlet {
    
    private SolicitudService solicitudService;
    private UsuarioVO usuarioVO;
    private UsuarioService usuarioService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            if (request.getParameter("opcion") != null || !request.getParameter("opcion").equals("")) {
                //Variable que nos permita saber la opcion a ejecutar
                int opcion = Integer.parseInt(request.getParameter("opcion"));
                //Lammamos al metodo que procesa la peticion
                this.procesarPeticion(opcion,request,response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (NullPointerException npe) {
            response.sendRedirect("login.jsp");
        } catch(NumberFormatException nfe){
            response.sendRedirect("login.jsp");
        }
    }

    private void procesarPeticion(int opcion,HttpServletRequest request, HttpServletResponse response) {
       
        //se crea la sesión
        HttpSession session = request.getSession(true);
        //Se obtiene la vista
        RequestDispatcher vista = null;
        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);
        
        
        try {
            String url = "";
            
            switch (opcion) {
                case 1://Entrar
                    url = this.entrar(request,response,session);
                    break;
                case 2://Salir
                    url = this.salir(session);
                    break;
                case 3://Restablecer contraseña 
                    url = this.restablecerClave(request,session);
                    break;
                default:
                    session.setAttribute("mensaje", "Esta opcion no ha sido implementada");
            }
            
            vista = request.getRequestDispatcher(url);
            vista.forward(request,response);
        } catch (ServletException ex) {
            System.out.println("ServletException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
        }

    }

    private String entrar(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String usuario = request.getParameter("username");
        String clave = request.getParameter("password");
            

        //inicializa el objeto service
        this.usuarioService = new UsuarioService();
        this.usuarioVO = usuarioService.autenticarUsuario(usuario, clave);
        
        String pagina = "";

        if (usuarioVO != null) {
            //Obtenemos el nombre del empleado vinculado a ese usuario
            String empleado = usuarioVO.getEmpleadoVO().getNombre() + "  "
                    + usuarioVO.getEmpleadoVO().getApellido();
            
            int rol = usuarioVO.getEmpleadoVO().getCargoVO().getIdCargo();

            session.setAttribute("usuario", usuario);
            session.setAttribute("empleado", empleado);
            session.setAttribute("rol", Integer.toString(rol));

            switch (usuarioVO.getEmpleadoVO().getCargoVO().getIdCargo()) {
                case 1:
                  this.listaSolicitud(request, response);
                    pagina = "indexGerente.jsp";
                    break;
                case 2:
                    
                    pagina = "indexAdministrador.jsp";
                    break;
                case 3:
                    
                    pagina = "indexSupervisor.jsp";
                    break;
                case 4:
                    
                    pagina = "indexChef.jsp";
                    break;
                case 5:
                    
                    pagina = "indexBarman.jsp";
                    break;
                case 6:
                    pagina = "indexExtra.jsp";
                    break;
                default:
                    this.salir(session);
            }
        } else {
            session.setAttribute("mensaje", " Error al autenticar, por favor verifique los datos.");
            pagina = "login.jsp";
        }
        
        return pagina;
    }

    private String salir(HttpSession session)throws Exception {
        session.invalidate();
        return "login.jsp";
    }
    
    private String restablecerClave(HttpServletRequest request,HttpSession session)throws Exception{
        String username = request.getParameter("nomUsuario");
        
        //inicializa el objeto service
        this.usuarioService = new UsuarioService();
        usuarioVO = usuarioService.validarNomUsuario(username); 
        if( usuarioVO != null){
            usuarioVO.setClave(Util.getCadenaAlfanumAleatoria());
            if(usuarioService.restablecerClave(usuarioVO)){
                session.setAttribute("mensaje", " El restablecimiento de la contraseña se ha realizado con éxito. Por favor revise su correo.");
            }else{
                session.setAttribute("mensaje", " No se ha podido procesar la solicitud. Porfavor intente más tarde.");
            }       
        }else{
            session.setAttribute("mensaje", " El nombre de usuario no existe, por favor verifique. ");
        }
        
        return "login.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    
    public void listaSolicitud(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        solicitudService = new SolicitudService();
        ArrayList<SolicitudVO> listaSolicitudes = solicitudService.listar();
        req.setAttribute("listaSolicitud", listaSolicitudes);  
    }
    

}
