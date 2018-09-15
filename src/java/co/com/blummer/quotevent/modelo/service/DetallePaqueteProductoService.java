package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteProductoDAO;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteProductoDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetallePaqueteProductoService {

    private DetallePaqueteProductoDAO detallePaqueteProductoDAO;
    private boolean bandera;

    public DetallePaqueteProductoService() {
        this.detallePaqueteProductoDAO = new DetallePaqueteProductoDAOMS();
    }

    public int insertar(DetallePaqueteProductoVO detallePaqueteProductoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = detallePaqueteProductoDAO.insertarDetallePaqueteProducto(detallePaqueteProductoVO);
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }

    }
}
