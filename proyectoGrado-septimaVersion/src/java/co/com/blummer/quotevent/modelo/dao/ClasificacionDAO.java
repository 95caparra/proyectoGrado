package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;

public interface ClasificacionDAO {
    
    public ArrayList<ClasificacionVO> listarClasificacion() throws Exception;
}