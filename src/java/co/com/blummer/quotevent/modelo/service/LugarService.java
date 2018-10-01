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
    
    public  ArrayList<LugarVO> listarLugar(){
        ArrayList<LugarVO> listaLugares = new ArrayList<>();
        try {
            listaLugares = lugarDAO.listarLugar();
        } catch (Exception e) {
            System.out.println(" LugarService: Se presento un error al "
                    + "listar la tabla lugar:  " + e.getMessage());

        } finally {
            return listaLugares;
        }
    }
    
}
