/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface TipoProductoDAO {
    
    public int insertarTipoProducto(TipoProductoVO tipoProductoVO) throws Exception;
    
    public ArrayList<TipoProductoVO> listarTiposProducto() throws Exception;
    
    public int actualizarTipoProducto(TipoProductoVO tipoProductoVO) throws Exception;
    
    public TipoProductoVO consultarTipoProductoPorId(long idTipoProducto) throws Exception;
    
    
}
