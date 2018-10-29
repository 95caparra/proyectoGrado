package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.DetalleProveedorDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProveedorDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetalleSuministroProveedorService {

    private static DetalleProveedorDAO detalleProveedorDAO;
    private boolean bandera;

    public DetalleSuministroProveedorService() {
        this.detalleProveedorDAO = new DetalleProveedorDAOMS();
    }

    public int insertar(DetalleProveedorVO detalleProveedorVO) throws Exception {
        int resultado = -1;

        try {
            resultado = detalleProveedorDAO.insertar(detalleProveedorVO);
        } catch (Exception e) {
            System.out.println("DetalleProductoSuministroService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }
    
   public ArrayList<DetalleProveedorVO> listarPorId(long idSuministro) throws Exception {

        ArrayList<DetalleProveedorVO> lista = new ArrayList<DetalleProveedorVO>();
        try {
            lista = detalleProveedorDAO.listarDetalleSuministroProveedorPorId(idSuministro);
        } catch (Exception e) {
            System.out.println("DetalleEventoEmpleadoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }
}
