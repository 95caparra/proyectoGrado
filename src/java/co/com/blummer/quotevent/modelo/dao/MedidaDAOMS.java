/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class MedidaDAOMS extends ConexionMySQL implements MedidaDAO {

    @Override
    public int insertarMedida(MedidaProductoVO medidaProductoVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedidaProductoVO> listarMedidas() throws Exception {
        ArrayList<MedidaProductoVO> lista = new ArrayList<MedidaProductoVO>();
        MedidaProductoVO medidaProductoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_medida,");
            sql.append(" nombre");
            sql.append(" FROM medida_producto order by 1 ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                medidaProductoVO = new MedidaProductoVO();

                medidaProductoVO.setMedidaProducto(rs.getInt(c++));
                medidaProductoVO.setNombreMedida(rs.getString(c++));
                
                lista.add(medidaProductoVO);
            }

        } catch (Exception e) {
            System.out.println("MedidaDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();           
        }
         return lista;
    }

    @Override
    public int actualizarMedida(MedidaProductoVO medidaProductoVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedidaProductoVO consultarMedidaPorId(long idMedida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
