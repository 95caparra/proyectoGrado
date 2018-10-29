package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public interface CiudadDAO {
    
    public int insertar(CiudadVO ciudadVO) throws Exception;
    
    public ArrayList<CiudadVO> listar() throws Exception;
    
     public int actualizar(CiudadVO ciudadVO) throws Exception;
    
    public CiudadVO consultarPorId(long id) throws Exception;
    
     public boolean validarExistencia(long id) throws Exception;
}