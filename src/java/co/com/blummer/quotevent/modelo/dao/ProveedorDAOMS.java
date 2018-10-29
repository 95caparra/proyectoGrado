package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
import co.com.blummer.quotevent.util.Archivos;

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

    @Override
    public long buscarProveedorPorNombre(String razonSocial) throws Exception {
       long id = 0;
       try {
            this.conectar();
            
            String consulta = " SELECT id_proveedor "
                    +" FROM proveedor p "
                    +" WHERE p.razon_social = ? ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setString(1, razonSocial);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                int t=1;
                id = rs.getLong(t++);
            }
            
        } catch (Exception e) {
            System.out.println("ProveedorDAOMS: Se presento un ERROR al buscarProveedorPorNombre en la tabla proveedor: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
       return id;
    }

    @Override
    public ProveedorVO consultarPorId(long idProveedor) throws Exception {
        ProveedorVO proveedorVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT "
                    +" pv.id_proveedor,pv.razon_social, pv.direccion,pv.telefono,pv.correo,pv.estado "
                    +" FROM proveedor pv "
                    +" WHERE pv.estado = 'Activo' AND pv.id_proveedor = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, idProveedor);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                proveedorVO = new ProveedorVO();

                proveedorVO.setIdProveedor(rs.getInt(c++));
                proveedorVO.setRazonSocial(rs.getString(c++));
                proveedorVO.setDireccion(rs.getString(c++));
                proveedorVO.setTelefono(rs.getString(c++));
                proveedorVO.setCorreo(rs.getString(c++));
                proveedorVO.setEstado(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("ProveedorDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return proveedorVO;
    }
    
    
}