package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import java.util.ArrayList;

public interface DetallePaqueteDAO {
    
    public int insertar(DetallePaqueteVO detallePaqueteVO) throws Exception;  
    
    public int insertarProductos(DetallePaqueteVO detallePaqueteVO) throws Exception;
   
    public int actualizar(DetallePaqueteVO detallePaqueteVO, int idProductoA) throws Exception;

    public int eliminar(int idProducto, int idPaquete) throws Exception;
    
    public int eliminarTodo() throws Exception;

    public ArrayList<DetallePaqueteVO> listar() throws Exception;

    public ArrayList<DetallePaqueteVO> consultaPorId(long idPaquete) throws Exception;
    
    public int consultaPorId2(long idPaquete) throws Exception;
    
}
