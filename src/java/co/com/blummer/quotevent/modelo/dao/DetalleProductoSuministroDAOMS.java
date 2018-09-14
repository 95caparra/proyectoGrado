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
    public ArrayList<DetalleProductoSuministroVO> listarSuministros() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
