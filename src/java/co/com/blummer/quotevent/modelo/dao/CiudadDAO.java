package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public interface CiudadDAO {
    
    public ArrayList<CiudadVO> listar() throws Exception;
}