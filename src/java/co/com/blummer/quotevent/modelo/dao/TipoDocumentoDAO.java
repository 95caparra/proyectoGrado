package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public interface TipoDocumentoDAO {
    
    public int insertar(TipoDocumentoVO tipoDocumentoVO) throws Exception;
    
    public ArrayList<TipoDocumentoVO> listar() throws Exception;
    
    public int actualizar(TipoDocumentoVO tipoDocumentoVO) throws Exception;
    
    public TipoDocumentoVO consultarPorId(long id) throws Exception;
    
     public boolean validarExistencia(long id) throws Exception;
}