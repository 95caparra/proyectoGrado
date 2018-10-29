/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class TipoProductoDAOMS extends ConexionMySQL implements TipoProductoDAO {

    @Override
    public int insertar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO tipo_producto ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoProductoVO.getNombre());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<TipoProductoVO> listar() throws Exception {
        ArrayList<TipoProductoVO> lista = new ArrayList<TipoProductoVO>();
        TipoProductoVO tipoProductoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_tipo_producto,");
            sql.append(" nombre");
            sql.append(" FROM tipo_producto order by 1 ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                tipoProductoVO = new TipoProductoVO();
                
                tipoProductoVO.setIdTipoProducto(rs.getInt(c++));
                tipoProductoVO.setNombre(rs.getString(c++));
                
                lista.add(tipoProductoVO);
            }

        } catch (Exception e) {
            System.out.println("TipoProductoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();           
        }
         return lista;
    }

    @Override
    public int actualizar(TipoProductoVO tipoProductoVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE tipo_producto SET "
                    + " nombre = ? "
                    + " WHERE id_tipo_producto = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoProductoVO.getNombre());
            
            pstm.setInt(t++, tipoProductoVO.getIdTipoProducto());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public TipoProductoVO consultarPorId(long idTipoProducto) throws Exception {
        TipoProductoVO tipoProductoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_tipo_producto,");
            sql.append(" nombre");
            sql.append(" FROM tipo_producto ");
            sql.append(" WHERE id_tipo_producto = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, idTipoProducto);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                tipoProductoVO = new TipoProductoVO();

                tipoProductoVO.setIdTipoProducto(rs.getInt(c++));
                tipoProductoVO.setNombre(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("TipoProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return tipoProductoVO;
    }


}
