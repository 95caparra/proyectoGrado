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
    
    public int insertar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = tipoDocumentoDAO.insertar(tipoDocumentoVO);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = tipoDocumentoDAO.actualizar(tipoDocumentoVO);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<TipoDocumentoVO> listar() throws Exception {

        ArrayList<TipoDocumentoVO> lista = new ArrayList<TipoDocumentoVO>();
        try {
            lista = tipoDocumentoDAO.listar();
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public TipoDocumentoVO consultarPorId(long id) throws Exception {
        TipoDocumentoVO tipoDocumentoVO = null;
        try {
            tipoDocumentoVO = tipoDocumentoDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return tipoDocumentoVO;
        }
    }
    
     public boolean validarExistencia(long id) throws Exception {
        boolean resultado = false;
        try {
            resultado = tipoDocumentoDAO.validarExistencia(id);
        } catch (Exception e) {
            System.out.println(" TipoDocumentoService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
