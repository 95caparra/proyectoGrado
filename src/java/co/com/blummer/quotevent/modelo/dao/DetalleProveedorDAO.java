package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import java.util.ArrayList;

public interface DetalleProveedorDAO {
    
    public int insertar(DetalleProveedorVO detalleProveedorVO) throws Exception;  
    
    public int insertarProductos(DetalleProveedorVO detalleProveedorVO) throws Exception;
   
    public int actualizar(DetalleProveedorVO detalleProveedorVO) throws Exception;

    public int eliminar(long idProducto, long idProveedor) throws Exception;

    public ArrayList<DetalleProveedorVO> listar() throws Exception;

    public DetalleProveedorVO consultaPorId(long idProducto, long idProveedor) throws Exception;

    public int multi (String[] proveedores) throws Exception;
    
    public ArrayList<DetalleProveedorVO> consultarProveedores(long idProducto)throws Exception;
    
    public ArrayList<DetalleProveedorVO> consultarProductos(long idProveedor)throws Exception;
    
    public ArrayList<DetalleProveedorVO> consultarIdProveedores(long idProducto)throws Exception;
}
