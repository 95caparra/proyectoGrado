package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAOMS extends ConexionMySQL implements UsuarioDAO {

    @Override
    public int insertar(UsuarioVO usuarioVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO usuario(empleado_n_identificacion,usuario,contrasenia,estado) "
                    + "VALUES(?,?,?,'Activo') ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, usuarioVO.getEmpleadoVO().getIdentificacionEmpleado());
            pstm.setString(2, usuarioVO.getUsuario());
            pstm.setString(3, usuarioVO.getClave());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: se presento un error al insertar "
                    + "un usuario" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(UsuarioVO usuarioVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE usuario SET "
                    + "usuario = ?, "
                    + "contrasenia = ? "
                    + "WHERE id_usuario = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, usuarioVO.getUsuario());
            pstm.setString(2, usuarioVO.getClave());
            pstm.setInt(3, usuarioVO.getIdUsuario());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: se presento un error al "
                    + "actualizar un usuario "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminar(int idUsuario) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE usuario SET estado = 'Inactivo' "
                    + "WHERE id_usuario = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, idUsuario);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: se presento un error al eliminar"
                    + " un usuario "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<UsuarioVO> listar() throws Exception {
        ArrayList<UsuarioVO> listar = new ArrayList<UsuarioVO>();
        UsuarioVO usuarioVO;

        try {
            this.conectar();
            String consulta = " SELECT U.id_usuario,U.empleado_n_identificacion,E.nombre, E.apellido,U.usuario, u.contrasenia, u.estado "
                    +" FROM usuario U " 
                    +" JOIN empleado E ON U.empleado_n_identificacion = E.n_identificacion "
                    +" WHERE U.estado = 'Activo' ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                usuarioVO = new UsuarioVO();
                int t = 1;
                
                usuarioVO.setIdUsuario(rs.getInt(t++));
                usuarioVO.getEmpleadoVO().setIdentificacionEmpleado(rs.getLong(t++));
                usuarioVO.getEmpleadoVO().setNombre(rs.getString(t++));
                usuarioVO.getEmpleadoVO().setApellido(rs.getString(t++));
                usuarioVO.setUsuario(rs.getString(t++));
                usuarioVO.setClave(rs.getString(t++));
                usuarioVO.setEstado(rs.getString(t++));

                listar.add(usuarioVO);
            }
        } catch (Exception e) {
            System.out.println(" UsuarioDAOMS: Se presento un ERROR al consultar la tabla"
                    + " usuario: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listar;
        }
    }

    @Override
    public UsuarioVO consultarPorId(int idUsuario) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            this.conectar();
            String consulta = "SELECT R.id_usuario,R.usuario,E.n_identificacion,E.cargo_id_cargo,E.nombre,"
                    + "E.apellido"
                    + "FROM usuario R INNER JOIN empleado E ON R.empleado_n_identificacion = E.n_identificacion "
                    + "WHERE R.estado like 'Activo' ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, idUsuario);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuarioVO = new UsuarioVO();

                usuarioVO.setIdUsuario(rs.getInt(1));
                usuarioVO.setUsuario(rs.getString(2));
                usuarioVO.getEmpleadoVO().setIdentificacionEmpleado(rs.getLong(3));
                usuarioVO.setUsuario(rs.getString(4));
                usuarioVO.setClave(rs.getString(5));
                usuarioVO.setEstado(rs.getString(6));
            }

        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: Se presento un ERROR al consultar por idUsuario:  "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return usuarioVO;
        }
    }

    @Override
    public UsuarioVO autenticarUsuario(String nomUsuario, String clave) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            this.conectar();

            String consulta = "SELECT R.id_usuario,E.n_identificacion,E.cargo_id_cargo,E.nombre,"
                    + "E.apellido "
                    + "FROM usuario R INNER JOIN empleado E ON R.empleado_n_identificacion = E.n_identificacion "
                    + "WHERE usuario = ? AND contrasenia = ? AND R.estado like 'Activo' ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, nomUsuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuarioVO = new UsuarioVO();

                usuarioVO.setIdUsuario(rs.getInt(1));
                usuarioVO.getEmpleadoVO().setIdentificacionEmpleado(rs.getLong(2));
                usuarioVO.getEmpleadoVO().getCargoVO().setIdCargo(rs.getInt(3));
                usuarioVO.getEmpleadoVO().setNombre(rs.getString(4));
                usuarioVO.getEmpleadoVO().setApellido(rs.getString(5));
            } else {
                usuarioVO = null;
            }
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: Se presento un error al autenticar al usuario. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return usuarioVO;
        }
    }

    @Override
    public UsuarioVO validarNomUsuario(String nombreUsuario) throws Exception {
        UsuarioVO usuarioVO = null;
        try {
            this.conectar();

            String consulta = "SELECT R.id_usuario,R.usuario,E.nombre,"
                    + "E.apellido,E.correo "
                    + "FROM usuario R INNER JOIN empleado E ON R.empleado_n_identificacion = E.n_identificacion "
                    + "WHERE R.usuario = ? AND R.estado like 'Activo' ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setString(1, nombreUsuario);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuarioVO = new UsuarioVO();

                usuarioVO.setIdUsuario(rs.getInt(1));
                usuarioVO.setUsuario(rs.getString(2));
                usuarioVO.getEmpleadoVO().setNombre(rs.getString(3));
                usuarioVO.getEmpleadoVO().setApellido(rs.getString(4));
                usuarioVO.getEmpleadoVO().setCorreo(rs.getString(5));
            } else {
                usuarioVO = null;
            }
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: Se prsento un error al validar el nombre del usuario.   "
                    + e.getMessage());
        } finally {
            this.desconectar();
            return usuarioVO;
        }
    }

    @Override
    public int cambiarContrasena(String contrasenia, String contraseniaNueva) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE usuario SET contrasenia = ? "
                    + "WHERE contrasenia = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setString(1, contraseniaNueva);
            pstm.setString(2, contrasenia);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: se presento un error al actualizar contrasenia"
                    + " un usuario "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    public long Identificacion(String contrasenia) throws Exception {
        long id = 0;
        try {
            this.conectar();

            String consulta = "SELECT empleado_n_identificacion "
                    + "FROM usuario "
                    + "WHERE contrasenia = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setString(1, contrasenia);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                id = rs.getLong(1);
            }
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: Se prsento un error al validar el nombre del usuario.   "
                    + e.getMessage());
        } finally {
            this.desconectar();
            return id;
        }
    }

    @Override
    public boolean validarExistencia(int idUsuario) throws Exception {
        boolean bandera = false;
       long id = 0;
       try {
            this.conectar();
            
            String consulta = " SELECT u.id_usuario "
                    +" FROM usuario u "
                    +" WHERE u.id_usuario = ? ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, idUsuario);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                int t=1;
                id = rs.getLong(t++);
            }
            
            if(id != 0){
                bandera = true;
            }else{
                bandera = false;
            }
            
        } catch (Exception e) {
            System.out.println("UsuarioDAOMS: Se presento un ERROR al listar la tabla usuario: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
       return bandera;
    }


}
