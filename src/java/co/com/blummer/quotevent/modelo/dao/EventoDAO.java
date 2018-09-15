
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lagos
 */

public interface EventoDAO {

    public int insertar(EventoVO eventoVO) throws Exception;

    public int modificarEstado(long idEvento, int estadoE) throws Exception;

    public ArrayList<EventoVO> listar() throws Exception;

    public EventoVO consultarPorId(long idEvento) throws Exception;

    public ArrayList<EventoVO> listarEventosSegunE(int estado) throws Exception;

    public ArrayList<TipoEventoVO> listarTipoEvento() throws Exception;

    public int consultarIdDelEvento() throws Exception;
    
    public ArrayList<EventoVO> buscar(String  parametro) throws Exception;
    
    public int disponibilidadFecha(Date fecha) throws Exception; 
    
    public Date validarFecha(int dia, int anio) throws Exception;
}
