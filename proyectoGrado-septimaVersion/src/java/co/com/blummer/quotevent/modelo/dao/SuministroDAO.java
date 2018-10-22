/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface SuministroDAO {
    
    public int insertarSuministro(SuministroVO suministroVO) throws Exception;
    
    public ArrayList<SuministroVO> listarSuministros() throws Exception;
    
    public int actualizarSuministro(SuministroVO suministroVO) throws Exception;
    
    public SuministroVO consultarSuministroPorId(long idSuministro) throws Exception;
    
    
}
