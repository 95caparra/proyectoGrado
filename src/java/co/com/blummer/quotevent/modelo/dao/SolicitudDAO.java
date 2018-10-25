
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public interface SolicitudDAO {

    public int insertar(SolicitudVO solicitudVO) throws Exception;
    
    public int actualizar(int idPaquete, int idSlicitud) throws Exception ;

    public int eliminar(long idSolicitud) throws Exception;

    public ArrayList<SolicitudVO> listar() throws Exception;

    public SolicitudVO consultarPorId(long idSolicitud) throws Exception;

    public ArrayList<SolicitudVO> buscar(String  parametro) throws Exception;
    
    public String nombrePdf(int idPaquete) throws Exception;
    
    public int visto(int idSolicitud) throws Exception; 
    
}
