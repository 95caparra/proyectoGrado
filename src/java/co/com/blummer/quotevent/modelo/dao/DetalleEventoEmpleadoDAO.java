/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public interface DetalleEventoEmpleadoDAO {
    
    public int insertarDetalleEventoEmpleado(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) throws Exception;
    
    public ArrayList<DetalleEventoEmpleadoVO> listarDetalleEventoEmpleado() throws Exception;
    
    public int actualizarDetalleEventoEmpleado(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) throws Exception;
    
    public ArrayList<DetalleEventoEmpleadoVO> listarDetalleEventoEmpleadoPorId(long idEvento) throws Exception;
    
    
}
