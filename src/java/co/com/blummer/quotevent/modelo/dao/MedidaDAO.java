/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface MedidaDAO {
    
    public int insertarMedida(MedidaProductoVO medidaProductoVO) throws Exception;
    
    public ArrayList<MedidaProductoVO> listarMedidas() throws Exception;
    
    public int actualizarMedida(MedidaProductoVO medidaProductoVO) throws Exception;
    
    public MedidaProductoVO consultarMedidaPorId(long idMedida) throws Exception;
    
     public boolean validarExistencia(long id) throws Exception;
    
}
