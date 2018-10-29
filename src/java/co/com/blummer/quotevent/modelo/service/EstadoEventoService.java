package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClasificacionDAO;
import co.com.blummer.quotevent.modelo.dao.ClasificacionDAOMS;
import co.com.blummer.quotevent.modelo.dao.EstadoEventoDAO;
import co.com.blummer.quotevent.modelo.dao.EstadoEventoDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import java.util.ArrayList;

public class EstadoEventoService {
    private static EstadoEventoDAO estadoEventoDAO;
    
    public EstadoEventoService(){
        estadoEventoDAO =  new EstadoEventoDAOMS();
    }
    
    public int insertar(EstadoEventoVO estadoEventoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = estadoEventoDAO.insertar(estadoEventoVO);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(EstadoEventoVO estadoEventoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = estadoEventoDAO.actualizar(estadoEventoVO);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<EstadoEventoVO> listar() throws Exception {

        ArrayList<EstadoEventoVO> lista = new ArrayList<EstadoEventoVO>();
        try {
            lista = estadoEventoDAO.listar();
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public EstadoEventoVO consultarPorId(long id) throws Exception {
        EstadoEventoVO estadoEventoVO = null;
        try {
            estadoEventoVO = estadoEventoDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("EstadoEventoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return estadoEventoVO;
        }
    }
    
}
