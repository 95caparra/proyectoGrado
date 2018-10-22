package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.MedidaDAO;
import co.com.blummer.quotevent.modelo.dao.MedidaDAOMS;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SuministroDAO;
import co.com.blummer.quotevent.modelo.dao.SuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;

public class MedidaService {

    private static MedidaDAO medidaDAO;

    public MedidaService() {
        medidaDAO = new MedidaDAOMS();
    }

    public int insertar(MedidaProductoVO suministroVO) throws Exception {
        int resultado = -1;

        try {
           // resultado = suministroDAO.insertarSuministro(suministroVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(MedidaProductoVO suministroVO) throws Exception {
        int resultado = -1;

        try {
           // resultado = suministroDAO.actualizarSuministro(suministroVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<MedidaProductoVO> listar() throws Exception {

        ArrayList<MedidaProductoVO> lista = new ArrayList<MedidaProductoVO>();
        try {
            lista = medidaDAO.listarMedidas();
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public MedidaProductoVO consultarPorId(long idSuministro) throws Exception {
        MedidaProductoVO suministroVO = null;
        try {
           // suministroVO = suministroDAO.consultarSuministroPorId(idSuministro);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return suministroVO;
        }
    }
}
