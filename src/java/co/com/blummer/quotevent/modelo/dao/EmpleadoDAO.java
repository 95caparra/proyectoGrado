

package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import java.util.ArrayList;

/**
 *
 * @author JHON
 */
public interface EmpleadoDAO {
    
    public int insertar(EmpleadoVO empleadoVO)throws Exception;
    
    public int actualizar(EmpleadoVO empleadoVO)throws Exception;
    
    public int eliminar(long idEmpleado)throws Exception;
    
    public ArrayList<EmpleadoVO> listar() throws Exception; 
    
    public EmpleadoVO consultarPorId(long idEmpleado) throws Exception;
    
    public String correoEmpleado(long idEmpleado) throws Exception;
    
    public ArrayList<EmpleadoVO> buscar(String parametro) throws Exception;
}
