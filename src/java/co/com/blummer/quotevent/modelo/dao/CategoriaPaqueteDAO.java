package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.CategoriaPaqueteVO;

public interface CategoriaPaqueteDAO {

    public ArrayList<CategoriaPaqueteVO> listarCategoria() throws Exception;
}