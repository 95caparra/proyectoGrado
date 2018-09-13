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
    public int insertarTipoProducto(TipoProductoVO tipoProductoVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoProductoVO> listarTiposProducto() throws Exception {
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
                
                tipoProductoVO.setIdTipoPriducto(rs.getInt(c++));
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
    public int actualizarTipoProducto(TipoProductoVO tipoProductoVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProductoVO consultarTipoProductoPorId(long idTipoProducto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
