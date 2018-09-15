package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.CategoriaPaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.CategoriaPaqueteDAOMS;
import co.com.blummer.quotevent.modelo.vo.CategoriaPaqueteVO;
import java.util.ArrayList;

public class CategoriaPaqueteService {
    private static CategoriaPaqueteDAO categoriaPaqueteDAO;
    
    public CategoriaPaqueteService(){
        categoriaPaqueteDAO = new CategoriaPaqueteDAOMS();
    }
    
    public ArrayList<CategoriaPaqueteVO> listarCategorias(){
        ArrayList<CategoriaPaqueteVO> listaCategorias = new ArrayList<CategoriaPaqueteVO>();
        try {
            listaCategorias = categoriaPaqueteDAO.listarCategoria();
        } catch (Exception e) {
            System.out.println(" CategoriaService: Se presento un error al "
                    + "listar la tabla categoria:  " + e.getMessage());

        } finally {
            return listaCategorias;
        }
    }
}
