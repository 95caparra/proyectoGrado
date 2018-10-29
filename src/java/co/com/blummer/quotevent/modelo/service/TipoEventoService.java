package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.MedidaDAO;
import co.com.blummer.quotevent.modelo.dao.MedidaDAOMS;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SuministroDAO;
import co.com.blummer.quotevent.modelo.dao.SuministroDAOMS;
import co.com.blummer.quotevent.modelo.dao.TipoEventoDAO;
import co.com.blummer.quotevent.modelo.dao.TipoEventoDAOMS;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;

public class TipoEventoService {

    private static TipoEventoDAO tipoEventoDAO;

    public TipoEventoService() {
        tipoEventoDAO = new TipoEventoDAOMS();
    }

    public int insertar(TipoEventoVO tipoEventoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = tipoEventoDAO.insertar(tipoEventoVO);
        } catch (Exception e) {
            System.out.println("TipoEventoService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(TipoEventoVO tipoEventoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = tipoEventoDAO.actualizar(tipoEventoVO);
        } catch (Exception e) {
            System.out.println("TipoEventoService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<TipoEventoVO> listar() throws Exception {

        ArrayList<TipoEventoVO> lista = new ArrayList<TipoEventoVO>();
        try {
            lista = tipoEventoDAO.listar();
        } catch (Exception e) {
            System.out.println("TipoEventoService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public TipoEventoVO consultarPorId(long id) throws Exception {
        TipoEventoVO tipoEventoVO = null;
        try {
            tipoEventoVO = tipoEventoDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("TipoEventoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return tipoEventoVO;
        }
    }
}
