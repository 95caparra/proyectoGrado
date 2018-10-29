package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import co.com.blummer.quotevent.util.Archivos;

public class TipoDocumentoDAOMS extends ConexionMySQL implements TipoDocumentoDAO {

    @Override
    public ArrayList<TipoDocumentoVO> listar() throws Exception {
       ArrayList<TipoDocumentoVO> listar = new ArrayList<>();
        TipoDocumentoVO tipoDocumentoVO;
        try {
            this.conectar();
            
            String consulta = "select id_tipo_documento, descripcion_documento, "
                    + " abreviatura from tipo_documento";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                tipoDocumentoVO = new TipoDocumentoVO();
                
                tipoDocumentoVO.setIdTipoDocumento(rs.getInt(1));
                tipoDocumentoVO.setNombreDocumento(rs.getString(2));
                tipoDocumentoVO.setAbreviatura(rs.getString(3));

                listar.add(tipoDocumentoVO);

            }
        } catch (Exception e) {
            System.out.println("TipoDocumentoDAOMS: Se presento un ERROR al listar la tabla tipo_documento"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }

    @Override
    public int insertar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO tipo_documento ( "
                    + " descripcion_documento,"
                    + " abreviatura "
                    + " ) "
                    + " VALUES (?,?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoDocumentoVO.getNombreDocumento());
            pstm.setString(t++, tipoDocumentoVO.getAbreviatura());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE tipo_documento SET "
                    + " descripcion_documento = ?,"
                    + " abreviatura = ? "
                    + " WHERE id_tipo_evento = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoDocumentoVO.getNombreDocumento());
            pstm.setString(t++, tipoDocumentoVO.getAbreviatura());
            
            pstm.setInt(t++, tipoDocumentoVO.getIdTipoDocumento());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public TipoDocumentoVO consultarPorId(long id) throws Exception {
        TipoDocumentoVO tipoDocumentoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_tipo_documento,");
            sql.append(" descripcion_documento, ");
            sql.append(" abreviatura ");
            sql.append(" FROM tipo_evento ");
            sql.append(" WHERE id_tipo_evento = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                tipoDocumentoVO = new TipoDocumentoVO();

                tipoDocumentoVO.setIdTipoDocumento(rs.getInt(c++));
                tipoDocumentoVO.setNombreDocumento(rs.getString(c++));
                tipoDocumentoVO.setAbreviatura(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("TipoDocumentoDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return tipoDocumentoVO;
    }
    
}