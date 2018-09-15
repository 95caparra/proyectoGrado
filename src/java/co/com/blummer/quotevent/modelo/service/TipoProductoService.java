package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.MedidaDAO;
import co.com.blummer.quotevent.modelo.dao.MedidaDAOMS;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SuministroDAO;
import co.com.blummer.quotevent.modelo.dao.SuministroDAOMS;
import co.com.blummer.quotevent.modelo.dao.TipoProductoDAO;
import co.com.blummer.quotevent.modelo.dao.TipoProductoDAOMS;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;

public class TipoProductoService {

    private static TipoProductoDAO tipoProductoDAO;

    public TipoProductoService() {
        tipoProductoDAO = new TipoProductoDAOMS();
    }

    public int insertar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;

        try {
           // resultado = suministroDAO.insertarSuministro(tipoProductoVO);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;

        try {
           // resultado = suministroDAO.actualizarSuministro(tipoProductoVO);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<TipoProductoVO> listar() throws Exception {

        ArrayList<TipoProductoVO> lista = new ArrayList<TipoProductoVO>();
        try {
            lista = tipoProductoDAO.listarTiposProducto();
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public TipoProductoVO consultarPorId(long idSuministro) throws Exception {
        TipoProductoVO tipoProductoVO = null;
        try {
           // tipoProductoVO = suministroDAO.consultarSuministroPorId(idSuministro);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return tipoProductoVO;
        }
    }
}