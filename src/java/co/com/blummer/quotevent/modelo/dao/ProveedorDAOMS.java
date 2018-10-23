package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
public class ProveedorDAOMS extends ConexionMySQL implements ProveedorDAO {

    @Override
    public ArrayList<ProveedorVO> listar() throws Exception {
       ArrayList<ProveedorVO> lista = new ArrayList<>();
        ProveedorVO proveedorVO;
        try {
            this.conectar();
            
            String consulta = " SELECT p.id_proveedor, p.razon_social, p.direccion, p.telefono, p.correo, "
                    +" p.estado FROM proveedor p "
                    +" WHERE p.estado = 'Activo' ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                int t=1;
                proveedorVO = new  ProveedorVO();
                        
                proveedorVO.setIdProveedor(rs.getInt(t++));
                proveedorVO.setRazonSocial(rs.getString(t++));
                proveedorVO.setDireccion(rs.getString(t++));
                proveedorVO.setTelefono(rs.getString(t++));
                proveedorVO.setCorreo(rs.getString(t++));
                proveedorVO.setEstado(rs.getString(t++));
                
                lista.add(proveedorVO);
            }
        } catch (Exception e) {
            System.out.println("ProveeedorDAOMS: Se presento un ERROR al listar la tabla proveedor: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE proveedor SET "
                    + " razon_social = ?, "
                    + " direccion = ?, "
                    + " telefono = ?, "
                    + " correo = ?, "
                    + " estado = ? "
                    + " WHERE id_proveedor = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, proveedorVO.getRazonSocial());
            pstm.setString(t++, proveedorVO.getDireccion());
            pstm.setString(t++, proveedorVO.getTelefono());
            pstm.setString(t++, proveedorVO.getCorreo());
            pstm.setString(t++, proveedorVO.getEstado());
            
            pstm.setInt(t++, proveedorVO.getIdProveedor());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public boolean validarExistencia(long idProveedor) throws Exception {
       boolean bandera = false;
       long id = 0;
       try {
            this.conectar();
            
            String consulta = " SELECT id_proveedor "
                    +" FROM proveedor p "
                    +" WHERE p.id_proveedor = ? ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, idProveedor);
            
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
            System.out.println("ProveedorDAOMS: Se presento un ERROR al listar la tabla proveedor: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
       return bandera;
    }

    @Override
    public int insertar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO proveedor ( "
                    + " razon_social, "
                    + " direccion, "
                    + " telefono, "
                    + " correo, "
                    + " estado "
                    + " ) "
                    + " VALUES (?,?,?,?,'Activo') ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, proveedorVO.getRazonSocial());
            pstm.setString(t++, proveedorVO.getDireccion());
            pstm.setString(t++, proveedorVO.getTelefono());
            pstm.setString(t++, proveedorVO.getCorreo());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }
    
    
}