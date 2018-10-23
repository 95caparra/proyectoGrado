package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClasificacionDAO;
import co.com.blummer.quotevent.modelo.dao.ClasificacionDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import java.util.ArrayList;

public class ClasificacionService {
    private static ClasificacionDAO clasificacionDAO;
    
    public ClasificacionService(){
        clasificacionDAO =  new ClasificacionDAOMS();
    }
    
    public  ArrayList<ClasificacionVO> listarClasificacion(){
        ArrayList<ClasificacionVO> listaClasificaciones = new ArrayList<>();
        try {
            listaClasificaciones = clasificacionDAO.listarClasificacion();
        } catch (Exception e) {
            System.out.println(" ClasificacionService: Se presento un error al "
                    + "listar la tabla clasificacion:  " + e.getMessage());

        } finally {
            return listaClasificaciones;
        }
    }
    
}
