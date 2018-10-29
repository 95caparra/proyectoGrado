package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.RolDAO;
import co.com.blummer.quotevent.modelo.dao.RolDAOMS;
import co.com.blummer.quotevent.modelo.vo.RolVO;
import java.util.ArrayList;

public class RolService {
    private static RolDAO rolDAO;
    
    public RolService(){
        rolDAO =  new RolDAOMS();
    }
    
    public int insertar(RolVO rolVO) throws Exception {
        int resultado = -1;

        try {
            resultado = rolDAO.insertar(rolVO);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(RolVO rolVO) throws Exception {
        int resultado = -1;

        try {
            resultado = rolDAO.actualizar(rolVO);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<RolVO> listar() throws Exception {

        ArrayList<RolVO> lista = new ArrayList<RolVO>();
        try {
            lista = rolDAO.listar();
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public RolVO consultarPorId(long id) throws Exception {
        RolVO rolVO = null;
        try {
            rolVO = rolDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return rolVO;
        }
    }
    
}
