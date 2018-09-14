/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface DetalleProductoSuministroDAO {
    
    public int insertarDetalleProductoSuministro(DetalleProductoSuministroVO detalleProductoSuministroVO) throws Exception;
    
    public ArrayList<DetalleProductoSuministroVO> listarSuministros() throws Exception;
    
    public int actualizarDetalleProductoSuministro(DetalleProductoSuministroVO detalleProductoSuministroVO) throws Exception;
    
    public DetalleProductoSuministroVO consultarDetalleProductoSuministroPorId(long idDetalleProductoSuministro) throws Exception;
    
    
}
