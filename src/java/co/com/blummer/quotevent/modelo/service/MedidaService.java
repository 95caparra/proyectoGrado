package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.MedidaDAO;
import co.com.blummer.quotevent.modelo.dao.MedidaDAOMS;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SuministroDAO;
import co.com.blummer.quotevent.modelo.dao.SuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.webservices.ServicioMedidaProducto;
import java.util.List;

public class MedidaService {

    private static MedidaDAO medidaDAO;
    private static ServicioMedidaProducto servicioMedidaProducto;

    public MedidaService() {
        medidaDAO = new MedidaDAOMS();
        servicioMedidaProducto = new ServicioMedidaProducto();
    }

    public int insertar(MedidaProductoVO medidaProductoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = medidaDAO.insertarMedida(medidaProductoVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(MedidaProductoVO medidaProductoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = medidaDAO.actualizarMedida(medidaProductoVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<MedidaProductoVO> listar() throws Exception {
        ArrayList<MedidaProductoVO> lista = new ArrayList<>();
        try {            
            lista = servicioMedidaProducto.listar();
            if(lista.isEmpty()){
                lista = medidaDAO.listarMedidas();
            }
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return  lista;
        }
    }
    
    public MedidaProductoVO consultarPorId(long idMedida) throws Exception {
        MedidaProductoVO medidaProductoVO = null;
        try {
            medidaProductoVO = medidaDAO.consultarMedidaPorId(idMedida);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return medidaProductoVO;
        }
    }
    
    public boolean validarExistencia(long id) throws Exception {
        boolean resultado = false;
        try {
            resultado = medidaDAO.validarExistencia(id);
        } catch (Exception e) {
            System.out.println(" MedidaService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
}
