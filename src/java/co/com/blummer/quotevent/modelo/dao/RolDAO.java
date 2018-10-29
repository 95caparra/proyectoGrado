package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;

public interface RolDAO {
    
    public int insertar(RolVO rolVO) throws Exception;
    
    public ArrayList<RolVO> listar() throws Exception;
    
    public int actualizar(RolVO rolVO) throws Exception;
    
    public RolVO consultarPorId(long id) throws Exception;
    
}