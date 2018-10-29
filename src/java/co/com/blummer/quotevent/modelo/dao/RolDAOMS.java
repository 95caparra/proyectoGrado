package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;
import co.com.blummer.quotevent.util.Archivos;

public class RolDAOMS extends ConexionMySQL implements RolDAO {

    @Override
    public ArrayList<RolVO> listar() throws Exception {
       ArrayList<RolVO> listar = new ArrayList<>();
        RolVO rolVO;
        try {
            this.conectar();
            
            String consulta = "SELECT id_rol, nombre FROM rol ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                rolVO = new RolVO();
                
                rolVO.setIdRol(rs.getInt(1));
                rolVO.setNombreRolString(rs.getString(2));
                
                listar.add(rolVO);

            }
        } catch (Exception e) {
            System.out.println("RolDAOMS: Se presento un ERROR al listar la tabla rol: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }

    @Override
    public int insertar(RolVO rolVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO rol ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, rolVO.getNombreRolString());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(RolVO rolVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE rol SET "
                    + " nombre = ? "
                    + " WHERE id_rol = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, rolVO.getNombreRolString());
            
            pstm.setInt(t++, rolVO.getIdRol());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public RolVO consultarPorId(long id) throws Exception {
        RolVO rolVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_rol,");
            sql.append(" nombre");
            sql.append(" FROM rol ");
            sql.append(" WHERE id_rol = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                rolVO = new RolVO();

                rolVO.setIdRol(rs.getInt(c++));
                rolVO.setNombreRolString(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("RolDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return rolVO;
    }
    
}