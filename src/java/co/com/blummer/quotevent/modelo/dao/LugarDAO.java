package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.LugarVO;

public interface LugarDAO {
    
    public int insertar(LugarVO lugarVO) throws Exception;
    
    public ArrayList<LugarVO> listarLugar() throws Exception;
    
    public int actualizar(LugarVO lugarVO) throws Exception;
    
    public LugarVO consultarPorId(long id) throws Exception;
    
     public boolean validarExistencia(long id) throws Exception;
}