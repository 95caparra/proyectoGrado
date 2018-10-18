package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.CiudadDAO;
import co.com.blummer.quotevent.modelo.dao.CiudadDAOMS;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAO;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAOMS;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import java.util.ArrayList;

public class CiudadService {
    private static CiudadDAO ciudadDAO;
    
    public CiudadService(){
        ciudadDAO =  new CiudadDAOMS();
    }
    
    public  ArrayList<CiudadVO> listar(){
        ArrayList<CiudadVO> lista = new ArrayList<>();
        try {
            lista = ciudadDAO.listar();
        } catch (Exception e) {
            System.out.println(" CiudadService: Se presento un error al "
                    + "listar la tabla ciudad:  " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
}
