package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.CiudadDAO;
import co.com.blummer.quotevent.modelo.dao.CiudadDAOMS;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAO;
import co.com.blummer.quotevent.modelo.dao.TipoDocumentoDAOMS;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import java.util.ArrayList;

public class CiudadService {
    private static CiudadDAO ciudadDAO;
    
    public CiudadService(){
        ciudadDAO =  new CiudadDAOMS();
    }
    
    public int insertar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;

        try {
            resultado = ciudadDAO.insertar(ciudadVO);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;

        try {
            resultado = ciudadDAO.actualizar(ciudadVO);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<CiudadVO> listar() throws Exception {

        ArrayList<CiudadVO> lista = new ArrayList<CiudadVO>();
        try {
            lista = ciudadDAO.listar();
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public CiudadVO consultarPorId(long id) throws Exception {
        CiudadVO ciudadVO = null;
        try {
            ciudadVO = ciudadDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return ciudadVO;
        }
    }
    
}
