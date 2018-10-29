package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;

public class ClienteDAOMS extends ConexionMySQL implements ClienteDAO {

    @Override
    public ArrayList<ClienteVO> listarClientes() throws Exception {
       ArrayList<ClienteVO> lista = new ArrayList<>();
        ClienteVO clienteVO;
        try {
            this.conectar();
            
            String consulta = " SELECT n_identificacion, "
                    +" cl.tipo_documento, tpd.descripcion_documento as documento, cl.nombre,cl.apellido,"
                    +" telefono,celular,direccion, "
                    +" cl.ciudad, ciu.nombre as nombre_ciudad,correo "
                    +" FROM cliente cl "
                    +" JOIN ciudad ciu on ciu.id_ciudad = cl.ciudad "
                    +" JOIN tipo_documento tpd on tpd.id_tipo_documento = cl.tipo_documento "
                    +" WHERE cl.estado = 'Activo' ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                int t=1;
                clienteVO = new ClienteVO();
                
                clienteVO.setNumeroIdentificacion(rs.getLong(t++));
                clienteVO.getDocumentoVO().setIdTipoDocumento(rs.getInt(t++));
                clienteVO.getDocumentoVO().setNombreDocumento(rs.getString(t++));
                clienteVO.setNombre(rs.getString(t++));
                clienteVO.setApellido(rs.getString(t++));
                clienteVO.setTelefono(rs.getString(t++));
                clienteVO.setCelular(rs.getString(t++));
                clienteVO.setDireccion(rs.getString(t++));
                clienteVO.getCiudadVO().setIdCiudad(rs.getInt(t++));
                clienteVO.getCiudadVO().setNombreCiudad(rs.getString(t++));
                clienteVO.setCorreo(rs.getString(t++));

                lista.add(clienteVO);

            }
        } catch (Exception e) {
            System.out.println("ClienteDAOMS: Se presento un ERROR al listar la tabla cliente: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public int actualizar(ClienteVO clienteVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE cliente SET "
                    + " tipo_documento = ?, "
                    + " nombre = ?, "
                    + " apellido = ?, "
                    + " telefono = ?, "
                    + " celular = ?, "
                    + " direccion = ?, "
                    + " ciudad = ?, "
                    + " correo = ? "
                    + " WHERE n_identificacion = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            pstm.setInt(t++, clienteVO.getDocumentoVO().getIdTipoDocumento());
            pstm.setString(t++, clienteVO.getNombre());
            pstm.setString(t++, clienteVO.getApellido());
            pstm.setString(t++, clienteVO.getTelefono());
            pstm.setString(t++, clienteVO.getCelular());
            pstm.setString(t++, clienteVO.getDireccion());
            pstm.setInt(t++, clienteVO.getCiudadVO().getIdCiudad());
            pstm.setString(t++, clienteVO.getCorreo());
            
            pstm.setLong(t++, clienteVO.getNumeroIdentificacion());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ClienteDAOMS: Se presento un error al actualizar un cliente."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public boolean validarExistenciaCliente(long idCliente) throws Exception {
       boolean bandera = false;
       long id = 0;
       try {
            this.conectar();
            
            String consulta = " SELECT n_identificacion "
                    +" FROM cliente cl "
                    +" WHERE cl.n_identificacion = ? ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, idCliente);
            
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
            System.out.println("ClienteDAOMS: Se presento un ERROR al listar la tabla cliente: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
       return bandera;
    }

    @Override
    public int insertar(ClienteVO clienteVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO cliente ( "
                    + " n_identificacion, "
                    + " tipo_documento, "
                    + " nombre, "
                    + " apellido, "
                    + " telefono, "
                    + " celular, "
                    + " direccion, "
                    + " ciudad, "
                    + " correo, "
                    + " estado "
                    + " ) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,'Activo') ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setLong(t++, clienteVO.getNumeroIdentificacion());
            pstm.setInt(t++, clienteVO.getDocumentoVO().getIdTipoDocumento());
            pstm.setString(t++, clienteVO.getNombre());
            pstm.setString(t++, clienteVO.getApellido());
            pstm.setString(t++, clienteVO.getTelefono());
            pstm.setString(t++, clienteVO.getCelular());
            pstm.setString(t++, clienteVO.getDireccion());
            pstm.setInt(t++, clienteVO.getCiudadVO().getIdCiudad());
            pstm.setString(t++, clienteVO.getCorreo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ClienteDAOMS: Se presento un error al actualizar un cliente."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }
    
    
}