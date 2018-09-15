package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import java.util.ArrayList;

public interface PaqueteDAO {

    public int insertar(PaqueteVO paqueteVO) throws Exception;

    public int actualizar(PaqueteVO paqueteVO) throws Exception;

    public int eliminar(long idPaquete) throws Exception;

    public ArrayList<PaqueteVO> listar() throws Exception;
    
    public ArrayList<PaqueteVO> listarIdPaquete(int idPaquete) throws Exception;

    public ArrayList<PaqueteVO> listarPaqueteSegunTipo(int tipo) throws Exception;

    public PaqueteVO consultarPorId(long idPaquete) throws Exception;
    
    public int ultimoId () throws Exception;

    
    public ArrayList<PaqueteVO> buscar(String parametro) throws Exception;
    
    public String validarPaquete(String nombre) throws Exception;

}
