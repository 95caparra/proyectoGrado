
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lagos
 */

public interface EstadoEventoDAO {
    
    public int insertar(EstadoEventoVO estadoEventoVO) throws Exception;

    public ArrayList<EstadoEventoVO> listar() throws Exception;  
    
    public int actualizar(EstadoEventoVO estadoEventoVO) throws Exception;
    
    public EstadoEventoVO consultarPorId(long id) throws Exception;
}
