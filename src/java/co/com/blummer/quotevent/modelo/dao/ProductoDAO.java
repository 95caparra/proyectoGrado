package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;

public interface ProductoDAO {
    
   public int insertarProducto(ProductoVO productoVO) throws Exception;
    
    public ArrayList<ProductoVO> listarProductos() throws Exception;
    
    public int actualizarProducto(ProductoVO productoVO) throws Exception;
    
    public ProductoVO consultarProductoPorId(long idProducto) throws Exception;
    
    public int consultarUltimoId() throws Exception;
}
