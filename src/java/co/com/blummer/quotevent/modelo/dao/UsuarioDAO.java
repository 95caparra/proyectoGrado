package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lagos
 */

public interface UsuarioDAO {
    
    public int insertar(UsuarioVO usuarioVO) throws Exception;
    
    public int actualizar(UsuarioVO usuarioVO) throws Exception;
    
    public int eliminar(int idUsuario) throws Exception;
    
    public ArrayList<UsuarioVO> listar() throws Exception;
    
    public UsuarioVO consultarPorId(int idUsuario)throws Exception;
    
    public UsuarioVO autenticarUsuario(String nomUsuario, String clave) throws Exception;
    
    public UsuarioVO validarNomUsuario(String nombreUsuario) throws Exception;
    
    public int cambiarContrasena(String contrasenia, String contraseniaNueva) throws Exception;
    
    public long Identificacion(String contrasenia) throws Exception;
    
}
