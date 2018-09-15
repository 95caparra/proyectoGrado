package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.UsuarioDAO;
import co.com.blummer.quotevent.modelo.dao.UsuarioDAOMS;
import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import co.com.blummer.quotevent.util.Mail;
import co.com.blummer.quotevent.util.Util;
import java.util.ArrayList;

public class UsuarioService {

    private static UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAOMS();
    }

    public int insertar(UsuarioVO usuarioVO) throws Exception {
        int resultado = -1;

        try {
            usuarioVO.setClave(Util.cifrar(usuarioVO.getClave()));
            resultado = usuarioDAO.insertar(usuarioVO);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "insertar un usuario: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(UsuarioVO usuarioVO) throws Exception {
        int resultado = -1;

        try {
            usuarioVO.setClave(Util.cifrar(usuarioVO.getClave()));
            resultado = usuarioDAO.actualizar(usuarioVO);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "actualizar un usuario: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int eliminar(int idUsuario) throws Exception {
        int resultado = -1;
        try {
            resultado = usuarioDAO.eliminar(idUsuario);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "eliminar un usuario: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<UsuarioVO> listar() throws Exception {
        ArrayList<UsuarioVO> lista = new ArrayList<UsuarioVO>();
        try {
            lista = usuarioDAO.listar();
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "listar la tabla usuarios: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public UsuarioVO consultarPorId(int idUsuario) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            usuarioVO = usuarioDAO.consultarPorId(idUsuario);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al realizar la"
                    + "consulta por id: " + e.getMessage());

        } finally {
            return usuarioVO;
        }
    }

    public UsuarioVO autenticarUsuario(String nomUsuario, String clave) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            clave = Util.cifrar(clave);
            usuarioVO = usuarioDAO.autenticarUsuario(nomUsuario, clave);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al autenticar"
                    + " un usuario: " + e.getMessage());
        } finally {
            return usuarioVO;
        }
    }

    public UsuarioVO validarNomUsuario(String nomUsuario) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            usuarioVO = usuarioDAO.validarNomUsuario(nomUsuario);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al validar el "
                    + "nombre del usuario: " + e.getMessage());
        } finally {
            return usuarioVO;
        }

    }

    public boolean restablecerClave(UsuarioVO usuarioVO) throws Exception {
        boolean verificacion = false;
        try {

            String asunto = " Recuperación de contraseña -- Quotevent ";
            String mensaje = " Estimado " + usuarioVO.getEmpleadoVO().getNombre() + "  "
                    + usuarioVO.getEmpleadoVO().getApellido() + ": \n"
                    + " Su solicitud para restablecer su clave se ha realizado satisfactoriamente. Su nueva contraseña es: \n "
                    + usuarioVO.getClave() + "\n "
                    + " Desde este momento podra ingresar al sistema informático Quotevent con la contraseña anterior. \n"
                    + " Cordialmente: Quotevent ";

            if (verificacion = Mail.envioCorreo(usuarioVO.getEmpleadoVO().getCorreo(), mensaje, asunto)) {
                if (this.actualizar(usuarioVO) > 0) {
                    verificacion = true;
                } else {
                    verificacion = false;
                }
            } else {
                verificacion = false;
            }

        } catch (Exception e) {
            System.out.println(" UsuarioService: Ocurrio un error al restablecer la clave del usuario. "
                    + e.getMessage());
        } finally {
            return verificacion;
        }

    }

    public int cambiarContrasenia(String contrasenia, String contraseniaNueva) throws Exception {
        int resultado = -1;
        try {
            String claveAntigua = Util.cifrar(contrasenia);
            String claveNueva = Util.cifrar(contraseniaNueva);
            resultado = usuarioDAO.cambiarContrasena(claveAntigua, claveNueva);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "actualizar contrasenia " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public long identificacion(String contrasenia) throws Exception {
        long id = 0;
        try {
            id = usuarioDAO.Identificacion(contrasenia);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "actualizar contrasenia " + e.getMessage());
        } finally {
            return id;
        }
    }

}
