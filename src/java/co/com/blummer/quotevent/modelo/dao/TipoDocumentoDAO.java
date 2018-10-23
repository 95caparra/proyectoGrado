package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public interface TipoDocumentoDAO {
    
    public ArrayList<TipoDocumentoVO> listar() throws Exception;
}