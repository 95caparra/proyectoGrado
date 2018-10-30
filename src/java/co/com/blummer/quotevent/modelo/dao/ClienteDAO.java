package co.com.blummer.quotevent.modelo.dao;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;

public interface ClienteDAO {
    
    public ArrayList<ClienteVO> listarClientes() throws Exception;
    
    public int actualizar(ClienteVO clienteVO) throws Exception;
    
    public int insertar(ClienteVO clienteVO) throws Exception;
    
    public boolean validarExistenciaCliente(long idCliente) throws Exception;
    
    public long consultarUltimoId() throws Exception;
}