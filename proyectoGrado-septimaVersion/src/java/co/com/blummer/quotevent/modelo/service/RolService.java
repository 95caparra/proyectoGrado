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
    
    public  ArrayList<RolVO> listar(){
        ArrayList<RolVO> lista = new ArrayList<>();
        try {
            lista = rolDAO.listar();
        } catch (Exception e) {
            System.out.println(" RolService: Se presento un error al "
                    + "listar la tabla Rol:  " + e.getMessage());
        } finally {
            return lista;
        }
    }
    
}
