package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;

public interface ProductoDAO {
    
    public int insertar(ProductoVO productoVO) throws Exception;
    
    public int insertarDetalle(DetalleProveedorVO detalleProveedorVO) throws Exception;
    
    public int actualizar(ProductoVO productoVO) throws Exception;
    
    public int eliminar(long idProducto) throws Exception;
    
    public ArrayList<ProductoVO> listarTodos() throws Exception;
    
    public ArrayList<ProductoVO> listarPaqueteSegunTipo(int tipo) throws Exception;
           
    public ProductoVO consultarPorId(long idProducto)throws Exception;   
    
    public ArrayList<ProductoVO> consultarListaPorId(long idProducto)throws Exception;   
    
    public ArrayList<ProductoVO> buscar(String  parametro) throws Exception;
    
    public int idProducto() throws Exception;
    
    public int eliminacionLogica(long idProducto) throws Exception;
    
    public String validarProducto(String nombre) throws Exception;
    
    public int consultarStock(int idCatalogo) throws Exception;
    
    public ArrayList<String> consultarNom(int idCatalogo) throws Exception;
    
    public void descontarStock(int cantidad,String nombre) throws Exception;
}
