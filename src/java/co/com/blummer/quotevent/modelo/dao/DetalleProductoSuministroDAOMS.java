/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class DetalleProductoSuministroDAOMS extends ConexionMySQL implements DetalleProductoSuministroDAO {

    @Override
    public int insertarDetalleProductoSuministro(DetalleProductoSuministroVO detalleProductoSuministroVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();

            String consulta = "INSERT INTO detalle_producto_suministro  "
                    + "(id_producto,id_suministro,cantidad,estado) "
                    + " VALUES (?,?,?,'Activo') ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detalleProductoSuministroVO.getProductoVO().getIdProducto());
            pstm.setLong(2, detalleProductoSuministroVO.getSuministroVO().getIdSuministro());
            pstm.setLong(3, detalleProductoSuministroVO.getCantidad());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProductoSuministroDAOMS: "
                    + "Se presentó un error al insertar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetalleProductoSuministroVO> listarDetalleProductoSuministroPorId(long idProducto) throws Exception {
        ArrayList<DetalleProductoSuministroVO> lista = new ArrayList<DetalleProductoSuministroVO>();
        DetalleProductoSuministroVO detalleProductoSuministroVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" select id_detalle_producto_suministro, id_producto, id_suministro, cantidad, estado "
                    + "from detalle_producto_suministro where id_producto = ? ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            pstm.setLong(1, idProducto);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                detalleProductoSuministroVO = new DetalleProductoSuministroVO();

                detalleProductoSuministroVO.setIdDetalleProductoSuministro(rs.getInt(c++));
                detalleProductoSuministroVO.getProductoVO().setIdProducto(rs.getInt(c++));
                detalleProductoSuministroVO.getSuministroVO().setIdSuministro(rs.getInt(c++));
                detalleProductoSuministroVO.setCantidad(rs.getInt(c++));
                detalleProductoSuministroVO.setEstado(rs.getString(c++));
                
                lista.add(detalleProductoSuministroVO);
            }

        } catch (Exception e) {
            System.out.println("DetalleProductoSuministroDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public int actualizarDetalleProductoSuministro(DetalleProductoSuministroVO detalleProductoSuministroVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleProductoSuministroVO consultarDetalleProductoSuministroPorId(long idDetalleProductoSuministro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
