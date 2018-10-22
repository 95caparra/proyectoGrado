package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClasificacionDAO;
import co.com.blummer.quotevent.modelo.dao.ClasificacionDAOMS;
import co.com.blummer.quotevent.modelo.dao.EstadoEventoDAO;
import co.com.blummer.quotevent.modelo.dao.EstadoEventoDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import java.util.ArrayList;

public class EstadoEventoService {
    private static EstadoEventoDAO estadoEventoDAO;
    
    public EstadoEventoService(){
        estadoEventoDAO =  new EstadoEventoDAOMS();
    }
    
    public  ArrayList<EstadoEventoVO> listar(){
        ArrayList<EstadoEventoVO> lista = new ArrayList<>();
        try {
            lista = estadoEventoDAO.listar();
        } catch (Exception e) {
            System.out.println(" EstadoEventoService: Se presento un error al "
                    + "listar la tabla estado_evento:  " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
}
