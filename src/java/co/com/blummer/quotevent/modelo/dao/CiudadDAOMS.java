package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import co.com.blummer.quotevent.util.Archivos;

public class CiudadDAOMS extends ConexionMySQL implements CiudadDAO {

    @Override
    public ArrayList<CiudadVO> listar() throws Exception {
       ArrayList<CiudadVO> listar = new ArrayList<>();
        CiudadVO ciudadVO;
        try {
            this.conectar();
            
            String consulta = "select id_ciudad, nombre from ciudad";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                ciudadVO = new CiudadVO();
                
                ciudadVO.setIdCiudad(rs.getInt(1));
                ciudadVO.setNombreCiudad(rs.getString(2));

                listar.add(ciudadVO);

            }
        } catch (Exception e) {
            System.out.println("CiudadDAOMS: Se presento un ERROR al listar la tabla ciudad"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }

    @Override
    public int insertar(CiudadVO ciudadVO) throws Exception {
       int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO ciudad ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, ciudadVO.getNombreCiudad());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(CiudadVO ciudadVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE ciudad SET "
                    + " nombre = ? "
                    + " WHERE id_ciudad = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, ciudadVO.getNombreCiudad());
            
            pstm.setInt(t++, ciudadVO.getIdCiudad());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public CiudadVO consultarPorId(long id) throws Exception {
         CiudadVO ciudadVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_ciudad,");
            sql.append(" nombre");
            sql.append(" FROM ciudad ");
            sql.append(" WHERE id_ciudad = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                ciudadVO = new CiudadVO();

                ciudadVO.setIdCiudad(rs.getInt(c++));
                ciudadVO.setNombreCiudad(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("CiudadDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return ciudadVO;
    }
    
}