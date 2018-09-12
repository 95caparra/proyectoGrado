package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.LugarVO;

public interface LugarDAO {
    
    public ArrayList<LugarVO> listarLugar() throws Exception;
}