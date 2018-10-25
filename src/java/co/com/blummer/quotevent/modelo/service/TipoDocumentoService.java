package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClasificacionDAO;
import co.com.blummer.quotevent.modelo.dao.ClasificacionDAOMS;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAO;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import java.util.ArrayList;

public class TipoDocumentoService {
    private static TipoDocumentoDAO tipoDocumentoDAO;
    
    public TipoDocumentoService(){
        tipoDocumentoDAO =  new TipoDocumentoDAOMS();
    }
    
    public  ArrayList<TipoDocumentoVO> listar(){
        ArrayList<TipoDocumentoVO> lista = new ArrayList<>();
        try {
            lista = tipoDocumentoDAO.listar();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoService: Se presento un error al "
                    + "listar la tabla tipo documento:  " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
}
