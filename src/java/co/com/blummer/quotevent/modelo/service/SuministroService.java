package co.com.blummer.quotevent.modelo.service;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.SuministroDAO;
import co.com.blummer.quotevent.modelo.dao.SuministroDAOMS;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;

public class SuministroService {

    private static SuministroDAO suministroDAO;

    public SuministroService() {
        suministroDAO = new SuministroDAOMS();

    }

    public int insertar(SuministroVO suministroVO) throws Exception {
        int resultado = -1;

        try {
            resultado = suministroDAO.insertarSuministro(suministroVO);
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(SuministroVO suministroVO) throws Exception {
        int resultado = -1;

        try {
            resultado = suministroDAO.actualizarSuministro(suministroVO);
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<SuministroVO> listar() throws Exception {

        ArrayList<SuministroVO> lista = new ArrayList<SuministroVO>();
        try {
            lista = suministroDAO.listarSuministros();
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public SuministroVO consultarPorId(long idSuministro) throws Exception {
        SuministroVO suministroVO = null;
        try {
            suministroVO = suministroDAO.consultarSuministroPorId(idSuministro);
            
        } catch (Exception e) {
            System.out.println("SuministroService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return suministroVO;
        }
    }
}
