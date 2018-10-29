package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetalleEventoEmpleadoDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleEventoEmpleadoDAOMS;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProductoSuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetalleEventoEmpleadoService {

    private static DetalleEventoEmpleadoDAO detalleEventoEmpleadoDAO;
    private boolean bandera;

    public DetalleEventoEmpleadoService() {
        this.detalleEventoEmpleadoDAO = new DetalleEventoEmpleadoDAOMS();
    }

    public int insertar(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = detalleEventoEmpleadoDAO.insertarDetalleEventoEmpleado(detalleEventoEmpleadoVO);
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }
    
    public ArrayList<DetalleEventoEmpleadoVO> listarPorId(long idEvento) throws Exception {

        ArrayList<DetalleEventoEmpleadoVO> lista = new ArrayList<DetalleEventoEmpleadoVO>();
        try {
            lista = detalleEventoEmpleadoDAO.listarDetalleEventoEmpleadoPorId(idEvento);
        } catch (Exception e) {
            System.out.println("DetalleEventoEmpleadoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    
}
