package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClasificacionDAO;
import co.com.blummer.quotevent.modelo.dao.ClasificacionDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import java.util.ArrayList;

public class ClasificacionService {
    private static ClasificacionDAO clasificacionDAO;
    
    public ClasificacionService(){
        clasificacionDAO =  new ClasificacionDAOMS();
    }
    
    public int insertar(ClasificacionVO clasificacionVO) throws Exception {
        int resultado = -1;

        try {
            resultado = clasificacionDAO.insertar(clasificacionVO);
        } catch (Exception e) {
            System.out.println("ClasificacionService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(ClasificacionVO clasificacionVO) throws Exception {
        int resultado = -1;

        try {
            resultado = clasificacionDAO.actualizar(clasificacionVO);
        } catch (Exception e) {
            System.out.println("ClasificacionService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<ClasificacionVO> listar() throws Exception {

        ArrayList<ClasificacionVO> lista = new ArrayList<ClasificacionVO>();
        try {
            lista = clasificacionDAO.listarClasificacion();
        } catch (Exception e) {
            System.out.println("ClasificacionService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public ClasificacionVO consultarPorId(long id) throws Exception {
        ClasificacionVO clasificacionVO = null;
        try {
            clasificacionVO = clasificacionDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("ClasificacionService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return clasificacionVO;
        }
    }
    
    public boolean validarExistencia(long id) throws Exception {
        boolean resultado = false;
        try {
            resultado = clasificacionDAO.validarExistencia(id);
        } catch (Exception e) {
            System.out.println(" ProveedorService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
