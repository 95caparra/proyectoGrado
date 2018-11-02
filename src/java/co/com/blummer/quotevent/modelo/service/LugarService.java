package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.LugarDAO;
import co.com.blummer.quotevent.modelo.dao.LugarDAOMS;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import java.util.ArrayList;

public class LugarService {
    private static LugarDAO lugarDAO;
    
    public LugarService(){
        lugarDAO =  new LugarDAOMS();
    }
    
    public int insertar(LugarVO lugarVO) throws Exception {
        int resultado = -1;

        try {
            resultado = lugarDAO.insertar(lugarVO);
        } catch (Exception e) {
            System.out.println("LugarService: Se presento un error al "
                    + "insertar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(LugarVO lugarVO) throws Exception {
        int resultado = -1;

        try {
            resultado = lugarDAO.actualizar(lugarVO);
        } catch (Exception e) {
            System.out.println("LugarService: Se presento un error al "
                    + "actualizar un suministro: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<LugarVO> listar() throws Exception {

        ArrayList<LugarVO> lista = new ArrayList<LugarVO>();
        try {
            lista = lugarDAO.listarLugar();
        } catch (Exception e) {
            System.out.println("LugarService: Se presento un error al "
                    + "listar la tabla suministro: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public LugarVO consultarPorId(long id) throws Exception {
        LugarVO lugarVO = null;
        try {
            lugarVO = lugarDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("LugarService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return lugarVO;
        }
    }
    
    public boolean validarExistencia(long id) throws Exception {
        boolean resultado = false;
        try {
            resultado = lugarDAO.validarExistencia(id);
        } catch (Exception e) {
            System.out.println(" LugarService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
