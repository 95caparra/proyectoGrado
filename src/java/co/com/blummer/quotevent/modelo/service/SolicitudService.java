
package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.SolicitudDAOMS;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SolicitudDAO;

/**
 *
 * @author Cristian
 */
public class SolicitudService {

    private static SolicitudDAO solicitudDAO;

    public SolicitudService() {
        solicitudDAO = new SolicitudDAOMS();
    }

    public int insertar(SolicitudVO solicitudVO) throws Exception {
        int resultado = -1;
        try {
            resultado = solicitudDAO.insertar(solicitudVO);
        } catch (Exception e) {
            System.out.println("SolicitudService :Error al enviar la solicitud: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(int idPaquete, int idSlicitud) throws Exception {
        int resultado = -1;
        try {
            resultado = solicitudDAO.actualizar(idPaquete, idSlicitud);
        } catch (Exception e) {
            System.out.println("SolicitudService: Se presento un error al actualizar un paqete al enviar correo: " + e.getMessage());
        } finally {

            return resultado;
        }

    }

    public int eliminar(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = solicitudDAO.eliminar(id);

        } catch (Exception e) {
            System.out.println("SolicitudService: Error al eliminar la solicitud " + e.getMessage());
        } finally {

            return resultado;
        }

    }

    public ArrayList<SolicitudVO> listar() throws Exception {
        ArrayList<SolicitudVO> lista = new ArrayList<SolicitudVO>();
        try {
            lista = solicitudDAO.listar();
        } catch (Exception e) {
            System.out.println("SolicitudService: Error al listar las solicitudes " + e.getMessage());
        } finally {

            return lista;
        }
    }

    public ArrayList<SolicitudVO> buscar(String parametro) throws Exception {
        ArrayList<SolicitudVO> lista = new ArrayList<SolicitudVO>();
        SolicitudVO solicitudVO = null;
        try {
            lista = solicitudDAO.buscar(parametro);
        } catch (Exception e) {
            System.out.println("solicitudService: Se presento un error al buscar en la tabla Solicitudes" + e.getMessage());
        } finally {
            return lista;
        }
    }

    public SolicitudVO consultarPorId(long idSolicitud) throws Exception {
        SolicitudVO solicitudVO = null;
        try {
            solicitudVO = solicitudDAO.consultarPorId(idSolicitud);
        } catch (Exception e) {
            System.out.println(" SolicitudService: Se presento un error al "
                    + "consultar por id a una Solicitud:  " + e.getMessage());
        } finally {
            return solicitudVO;
        }
    }

    public String nombrePdf(int idPaquete) throws Exception {
        String nombre = "";
        try {
            nombre = solicitudDAO.nombrePdf(idPaquete);
        } catch (Exception e) {
            System.out.println(" SolicitudService: Se presento un error al "
                    + "consultar el nombre del PDF:  " + e.getMessage());
        } finally {
            return nombre;
        }
    }
    
    public int visto(int idSolicitud) throws Exception{
        int resultado = 0;
        
        try {
            resultado = solicitudDAO.visto(idSolicitud);
        } catch (Exception e) {
            System.out.println(" SolicitudService: Ocurrio un error al actualizar el visto de una solicitud. ");
        }
        
        return resultado;
    }
}
