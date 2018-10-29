/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface DetallePaqueteProductoDAO {
    
    public int insertarDetallePaqueteProducto(DetallePaqueteProductoVO detallePaqueteProductoVO) throws Exception;
    
    public ArrayList<DetallePaqueteProductoVO> listarDetallePaqueteProducto() throws Exception;
    
    public int actualizarDetallePaqueteProducto(DetallePaqueteProductoVO detallePaqueteProductoVO) throws Exception;
    
    public ArrayList<DetallePaqueteProductoVO> listarDetallePaqueteProductoPorId(long idPaquete) throws Exception;
    
    
}
