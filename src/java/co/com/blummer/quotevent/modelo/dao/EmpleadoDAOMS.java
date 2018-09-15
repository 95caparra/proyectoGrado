package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleadoDAOMS extends ConexionMySQL implements EmpleadoDAO {

    @Override
    public int insertar(EmpleadoVO empleadoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = " INSERT INTO empleado(n_identificacion,id_tipo_documento,nombre,"
                    + "apellido,cargo_id_cargo,correo,direccion,telefono,barrio,estado) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,'Activo') ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, empleadoVO.getnIdentificacionEmpleado());
            pstm.setInt(2, empleadoVO.getDocumentoVO().getIdTipoDocumento());
            pstm.setString(3, empleadoVO.getNombre());
            pstm.setString(4, empleadoVO.getApellido());
            pstm.setInt(5, empleadoVO.getCargoVO().getIdCargo());
            pstm.setString(6, empleadoVO.getCorreo());
            pstm.setString(7, empleadoVO.getDireccion());
            pstm.setString(8, empleadoVO.getTelefono());
            pstm.setString(9, empleadoVO.getBarrio());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EmpleadoDAOMS: Se presento un error al insertar un empleado."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(EmpleadoVO empleadoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE empleado SET "
                    + "id_tipo_documento = ?,"
                    + "nombre = ?,"
                    + "apellido = ?,"
                    + "cargo_id_cargo = ?,"
                    + "correo = ?,"
                    + "direccion = ?,"
                    + "telefono = ?,"
                    + "barrio = ? "
                    + "WHERE n_identificacion = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, empleadoVO.getDocumentoVO().getIdTipoDocumento());
            pstm.setString(2, empleadoVO.getNombre());
            pstm.setString(3, empleadoVO.getApellido());
            pstm.setInt(4, empleadoVO.getCargoVO().getIdCargo());
            pstm.setString(5, empleadoVO.getCorreo());
            pstm.setString(6, empleadoVO.getDireccion());
            pstm.setString(7, empleadoVO.getTelefono());
            pstm.setString(8, empleadoVO.getBarrio());
            pstm.setLong(9, empleadoVO.getnIdentificacionEmpleado());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EmpleadoDAOMS: Se presento un error al actualizar un empleado."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminar(long idEmpleado) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE empleado SET estado = 'Inactivo' "
                    + "WHERE n_identificacion=? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idEmpleado);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EmpleadoDAOMS: Se presento un error al eliminar un empleado."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<EmpleadoVO> listar() throws Exception {
        ArrayList<EmpleadoVO> lista = new ArrayList<EmpleadoVO>();
        EmpleadoVO empleadoVO;
        try {
            this.conectar();
            String consulta = "SELECT n_identificacion,nombre,apellido " +
                        "FROM empleado WHERE estado = 'Activo' ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                empleadoVO = new EmpleadoVO();
                empleadoVO.setnIdentificacionEmpleado(rs.getLong(1));
                empleadoVO.setNombre(rs.getString(2));
                empleadoVO.setApellido(rs.getString(3));

                lista.add(empleadoVO);
            }
        } catch (Exception e) {
            System.out.println(" EmpleadoDAOMS: Se presento un error al consultar la tabla empleado. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    @Override
    public EmpleadoVO consultarPorId(long idEmpleado) throws Exception {
        EmpleadoVO empleadoVO = null;
        try {
            this.conectar();

            String consulta = "SELECT e.n_identificacion,td.id_tipo_documento,td.descripcion_documento," +  
                        "e.nombre,e.apellido,e.cargo_id_cargo,c.nombre,e.correo,e.direccion,e.telefono,e.barrio " +
                        "FROM (empleado e INNER JOIN tipo_documento td ON e.id_tipo_documento = td.id_tipo_documento) " +
                        "INNER JOIN cargo c ON e.cargo_id_cargo = c.id_cargo WHERE  e.n_identificacion = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idEmpleado);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                empleadoVO = new EmpleadoVO();
                empleadoVO.setnIdentificacionEmpleado(rs.getLong(1));
                empleadoVO.getDocumentoVO().setIdTipoDocumento(rs.getInt(2));
                empleadoVO.getDocumentoVO().setNombreDocumento(rs.getString(3));
                empleadoVO.setNombre(rs.getString(4));
                empleadoVO.setApellido(rs.getString(5));
                empleadoVO.getCargoVO().setIdCargo(rs.getInt(6));
                empleadoVO.getCargoVO().setNombreCargo(rs.getString(7));
                empleadoVO.setCorreo(rs.getString(8));
                empleadoVO.setDireccion(rs.getString(9));
                empleadoVO.setTelefono(rs.getString(10));
                System.out.println(rs.getString(10));
                System.out.println(empleadoVO.getTelefono());
                empleadoVO.setBarrio(rs.getString(11));
            }

        } catch (Exception e) {
            System.out.println(" EmpleadoDAOMS: Se presento un error al consultar por id a un empleado. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return empleadoVO;
        }
    }
    
     @Override
    public String correoEmpleado(long idEmpleado) throws Exception {
        String correo = "";
        try {
            this.conectar();
            String consulta = "SELECT correo " 
                    +"FROM empleado "
                    +"WHERE n_identificacion = ? ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, idEmpleado); 
            
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()){
                correo = rs.getString(1);   
            }
            
            //String formatoJSON = gson.toJson(productoVO);
            
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: ocurrio un error al validar producto"
            +e.getMessage());
            throw e;
        }
        finally{
            this.desconectar();
            return correo;
        }
    }
    
    @Override
    public ArrayList<EmpleadoVO> buscar(String parametro) throws Exception {
        ArrayList<EmpleadoVO> busca = new ArrayList<EmpleadoVO>();
        EmpleadoVO empleadoVO = null;
        try {
            this.conectar();
            String consulta = "SELECT n_identificacion, nombre " 
                    +"FROM empleado " 
                    +"WHERE n_identificacion LIKE  '%"+parametro+"%' OR nombre LIKE  '%"+parametro+"%' OR apellido LIKE  '%"+parametro+"%' OR correo LIKE  '%"+parametro+"%' OR direccion LIKE  '%"+parametro+"%' OR telefono LIKE  '%"+parametro+"%' OR barrio LIKE  '%"+parametro+"%'   ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                empleadoVO = new EmpleadoVO();
                
                empleadoVO.setnIdentificacionEmpleado(rs.getLong(1));
                empleadoVO.setNombre(rs.getString(2));

                busca.add(empleadoVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return busca;
        }
    }

}
