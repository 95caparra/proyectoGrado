package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;

public interface ProveedorDAO {
    
    public ArrayList<ProveedorVO> listar() throws Exception;
    
    public int actualizar(ProveedorVO proveedorVO) throws Exception;
    
    public int insertar(ProveedorVO proveedorVO) throws Exception;
    
    public boolean validarExistencia(long idProveedor) throws Exception;
    
    public long buscarProveedorPorNombre(String razonSocial) throws Exception;
    
    public ProveedorVO consultarPorId(long idProveedor) throws Exception;
}