/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface TipoEventoDAO {
    
    public int insertar(TipoEventoVO tipoEventoVO) throws Exception;
    
    public ArrayList<TipoEventoVO> listar() throws Exception;
    
    public int actualizar(TipoEventoVO tipoEventoVO) throws Exception;
    
    public TipoEventoVO consultarPorId(long id) throws Exception;
    
    
}
