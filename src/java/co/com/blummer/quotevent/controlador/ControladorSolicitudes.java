package co.com.blummer.quotevent.controlador;

import co.com.blummer.quotevent.modelo.service.EventoService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.com.blummer.quotevent.modelo.service.MailService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.SolicitudService;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import co.com.blummer.quotevent.util.Util;
import com.google.gson.Gson;

/**
 *
 * @author CCC
 */
public class ControladorSolicitudes extends PrincipalControl {

    //objetos Service
    private SolicitudService solicitudService;
    private PaqueteService paqueteService;
    private EventoService eventoService;
    private MailService mailService;
    //ObjetoVO
    private SolicitudVO solicitudVO;
    private EventoVO eventoVO;
    //id para actualizar y eliminar
    private long id;
    private int idSolicitud;

    private int resultado;
    private ArrayList<SolicitudVO> listaSolicitudes;
    private ArrayList<TipoEventoVO> listaTipoEvento;

    private Util util = new Util();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        this.request = req;
        this.response = res;

        //se crea la sesión
        session = request.getSession(true);

        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);

        //variable que me permite saber la acción a realizar
        String opc = req.getParameter("opcion").toString();
        //la pasamos a int para usarla en el switch
        int opcion = Integer.parseInt(opc);

        this.procesaPeticion(opcion);
    }

    private void procesaPeticion(int opcion) {
        try {
            
            //Inicializacion del objeto service 
            solicitudService = new SolicitudService();
            
            response.setContentType("application/json");
            
            switch (opcion) {

                case 1:// Descripcion solicitud
                    this.listarSolicitudes();
                    break;
                case 2://Listar solicitudes
                    this.descripcionSolicitud();
                    break;
                case 3:// Insertar solicitud
                    this.insertarSolicitud();
                    break;
                case 4:// Eliminar solicitud
                    this.eliminarSolicitud();
                    break;
                case 5://Formulario para responder solicitud
                    this.listaPaqueteEnviar();
                    break;
                case 6://Enviar correo
                    this.enviar();
                    break;
                case 7://Mostrar Formulariode cotizacion
                    this.mostrarFormCotizacion();
                    break;
                case 8:
                    this.listarTipoEvento();
                    break;
                case 9://paquete grande
                    this.listaPaqueteSegunG();
                    break;
                case 10://paquete mediano
                    this.listaPaqueteSegunM();
                    break;
                case 11://paquete pequeño
                    this.listaPaqueteSegunP();
                    break;
                case 12:
                    this.buscador();
                    break;
                case 13:
                    this.mensajeVisto();
                    break;
                default:
                    this.request.setAttribute("mensaje", "Esta opcion no ha sido implementada ");
                    this.request.setAttribute("opcion", "3");
                    vista = this.request.getRequestDispatcher("respuesta.jsp");
                    vista.forward(this.request, this.response);
                    break;
            }

            //vista.forward(this.request, this.response);
        } catch (ServletException ex) {
            System.out.println("ServletException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
        }

    }

    private void descripcionSolicitud() throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        id = Long.parseLong(this.request.getParameter("id").toString());
        solicitudVO = solicitudService.consultarPorId(id);
        this.request.setAttribute("solicitudVO", this.solicitudVO);
        vista = this.request.getRequestDispatcher("pages/solicitudes/descripcionSolicitud.jsp");
        vista.forward(this.request, this.response);

    }

    private void insertarSolicitud() throws Exception {
        solicitudVO = new SolicitudVO();
    
        solicitudVO.setNombreCliente(this.request.getParameter("nombre"));
        solicitudVO.setEmail(this.request.getParameter("correo"));
        solicitudVO.setTelefono(this.request.getParameter("telefono"));
        solicitudVO.getTipoEvento().setIdTipoEvento(Integer.parseInt(this.request.getParameter("tipoEvento")));
        solicitudVO.setHora(this.request.getParameter("horaEvento"));
        solicitudVO.setFecha(Util.convertirFecha(this.request.getParameter("fechaEvento")));
        solicitudVO.setCantidadPersonas(Integer.parseInt(this.request.getParameter("cantidadPersonas")));
        solicitudVO.setObservaciones(this.request.getParameter("observaciones"));
        solicitudVO.setVisto(Byte.parseByte("0"));
        solicitudVO.getPaquete().setIdPaquete(0);

        //llamamos al método insertar de SolicitudService
        if (solicitudService.insertar(solicitudVO) > 0) {
            session.setAttribute("mensaje", " La solicitud fue enviada con exitó ");
        } else {
            session.setAttribute("mensaje", "Error al enviar tu solicitud");
        }

        response.sendRedirect("index.jsp");
    }

    private void eliminarSolicitud() throws Exception {
        id = Long.parseLong(this.request.getParameter("id").toString());

        if (solicitudService.eliminar(id) > 0) {
            session.setAttribute("mensaje", "Proveedor Eliminado con éxito");
        } else {
            session.setAttribute("mensaje", "Error al eliminar el proveedor ");
        }
        this.listarSolicitudes();
    }

    private void listarSolicitudes() throws Exception {
        //response.getWriter().write(new Gson().toJson(new SolicitudService().listar()));
        ArrayList<SolicitudVO> listaSolicitud = solicitudService.listar();
        this.request.setAttribute("listaSolicitud", listaSolicitud);
        vista = this.request.getRequestDispatcher("indexGerente.jsp");
    }

    private void listarTipoEvento() throws Exception {
        eventoService = new EventoService();
        listaTipoEvento = eventoService.listarTipoEvento();
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(listaTipoEvento));
    }

    private void listaPaqueteEnviar() throws Exception {
        idSolicitud = Integer.parseInt(this.request.getParameter("id").toString());
        solicitudVO = solicitudService.consultarPorId(id);

        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listar();
        this.request.setAttribute("idSolicitud", idSolicitud);
        this.request.setAttribute("lista", listaPaquete);
        this.request.setAttribute("correo", this.solicitudVO.getEmail());
        this.request.setAttribute("nombre", this.solicitudVO.getNombreCliente());
        vista = this.request.getRequestDispatcher("responderSolicitud.jsp");
        vista.forward(this.request, this.response);
    }

    protected void enviar() throws Exception {
        try {
            String[] idPaquete = this.request.getParameterValues("idPaquete[]");
            idSolicitud = Integer.parseInt(this.request.getParameter("idSolicitud"));

            String correo = this.request.getParameter("mail").toString();
            String asunto = "Blummer Eventos Respuesta a tu solicitud";
            String mensaje = this.request.getParameter("mensaje").toString();
            String mensajeSinAcento = util.remover(mensaje);
            String archivo[] = new String[idPaquete.length];
            for (int i = 0; i < idPaquete.length; i++) {
                archivo[i] = solicitudService.nombrePdf(Integer.parseInt(idPaquete[i]));
            }
            // String archivo = solicitudService.nombrePdf(idPaquete);
            String ruta = request.getServletContext().getRealPath("/archivos");

            mailService = new MailService();
            mailService.envioCorreo(correo, asunto, mensajeSinAcento, archivo, ruta);

            //mailService.envioCorreo(correo, asunto, mensaje, archivo, ruta);
            //solicitudService.actualizar(idPaquete, idSolicitud);
            response.getWriter().write(new Gson().toJson("Mensaje Enviado con éxito"));
        } catch (Exception e) {
            response.getWriter().write(new Gson().toJson("Error al responder una solicitud"));
        }

    }

    private void listaPaqueteSegunG() throws Exception {
        int tipo = Integer.parseInt(this.request.getParameter("tipo").toString());
        //solicitudVO = solicitudService.consultarPorId(id);

        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listarPaqueteSegunTipo(tipo);
        //this.request.setAttribute("idSolicitud", idSolicitud);
        this.request.setAttribute("lista", listaPaquete);
        this.request.setAttribute("correo", this.solicitudVO.getEmail());
        this.request.setAttribute("nombre", this.solicitudVO.getNombreCliente());
        
        vista = this.request.getRequestDispatcher("paquetesGrandes.jsp");
        vista.forward(this.request, this.response);
    }
    
    private void listaPaqueteSegunM() throws Exception {
        int tipo = Integer.parseInt(this.request.getParameter("tipo").toString());
        //solicitudVO = solicitudService.consultarPorId(id);

        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listarPaqueteSegunTipo(tipo);
        //this.request.setAttribute("idSolicitud", idSolicitud);
        this.request.setAttribute("lista", listaPaquete);
        this.request.setAttribute("correo", this.solicitudVO.getEmail());
        this.request.setAttribute("nombre", this.solicitudVO.getNombreCliente());
        
        vista = this.request.getRequestDispatcher("paquetesMedianos.jsp");
        vista.forward(this.request, this.response);
    }
    
    private void listaPaqueteSegunP() throws Exception {
        int tipo = Integer.parseInt(this.request.getParameter("tipo").toString());
        //solicitudVO = solicitudService.consultarPorId(id);

        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listarPaqueteSegunTipo(tipo);
        //this.request.setAttribute("idSolicitud", idSolicitud);
        this.request.setAttribute("lista", listaPaquete);
        this.request.setAttribute("correo", this.solicitudVO.getEmail());
        this.request.setAttribute("nombre", this.solicitudVO.getNombreCliente());
        
        vista = this.request.getRequestDispatcher("paquetesPequeños.jsp");
        vista.forward(this.request, this.response);
    }

    //Metodo para enviar los datos de la solicitud y mostrar el jsp crearCotizacion
    private void mostrarFormCotizacion() throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        
        idSolicitud = Integer.parseInt(this.request.getParameter("id"));
        solicitudVO = solicitudService.consultarPorId(idSolicitud);
       
        request.setAttribute("solicitud", this.solicitudVO);
        vista = request.getRequestDispatcher("cotizacion.jsp");
        vista.forward(this.request, this.response);
    }
    
    public void buscador() throws Exception {
        solicitudService = new SolicitudService();
        String parametro = this.request.getParameter("parametro").toString().trim();
        ArrayList<SolicitudVO> listaSolicitudBuscado = solicitudService.buscar(parametro);
        response.getWriter().write(new Gson().toJson(listaSolicitudBuscado));
    }
    
    //Metodo privado de este controlador para actualizar visto de la solicitud 
    private void mensajeVisto() throws Exception{
        idSolicitud = Integer.parseInt(this.request.getParameter("id"));
        
        if(this.solicitudService.visto(idSolicitud) > 0){
            response.getWriter().write(new Gson().toJson(true));
        }else{
            response.getWriter().write(new Gson().toJson(false));
        }
    }

}
