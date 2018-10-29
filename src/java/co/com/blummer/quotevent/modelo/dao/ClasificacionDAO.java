package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;

public interface ClasificacionDAO {
    
    public int insertar(ClasificacionVO clasificacionVO) throws Exception;
    
    public ArrayList<ClasificacionVO> listarClasificacion() throws Exception;
    
    public int actualizar(ClasificacionVO clasificacionVO) throws Exception;
    
    public ClasificacionVO consultarPorId(long id) throws Exception;
}