package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetalleProductoSuministroService {

    private DetalleProductoSuministroDAO detalleProductoSuministroDAO;
    private boolean bandera;

    public DetalleProductoSuministroService() {
        this.detalleProductoSuministroDAO = new DetalleProductoSuministroDAOMS();
    }

    public int insertar(DetalleProductoSuministroVO detalleProductoSuministroVO) throws Exception {
        int resultado = -1;

        try {
            resultado = detalleProductoSuministroDAO.insertarDetalleProductoSuministro(detalleProductoSuministroVO);
        } catch (Exception e) {
            System.out.println("DetalleProductoSuministroService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }
    
    public ArrayList<DetalleProductoSuministroVO> listarPorId(long idProducto) throws Exception {

        ArrayList<DetalleProductoSuministroVO> lista = new ArrayList<DetalleProductoSuministroVO>();
        try {
            lista = detalleProductoSuministroDAO.listarDetalleProductoSuministroPorId(idProducto);
        } catch (Exception e) {
            System.out.println("DetalleProductoSuministroService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }
}
