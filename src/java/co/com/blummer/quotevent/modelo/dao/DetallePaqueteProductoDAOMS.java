/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
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
public class DetallePaqueteProductoDAOMS extends ConexionMySQL implements DetallePaqueteProductoDAO {

    @Override
    public int insertarDetallePaqueteProducto(DetallePaqueteProductoVO detallePaqueteProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();

            String consulta = "INSERT INTO detalle_paquete_producto  "
                    + "(id_paquete,id_producto,cantidad,estado) "
                    + " VALUES (?,?,?,'Activo') ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detallePaqueteProductoVO.getPaqueteVO().getIdPaquete());
            pstm.setLong(2, detallePaqueteProductoVO.getProductoVO().getIdProducto());
            pstm.setLong(3, detallePaqueteProductoVO.getCantidad());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetallePaqueteProductoDAOMS: "
                    + "Se presentó un error al insertar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetallePaqueteProductoVO> listarDetallePaqueteProducto() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarDetallePaqueteProducto(DetallePaqueteProductoVO detallePaqueteProductoVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetallePaqueteProductoVO> listarDetallePaqueteProductoPorId(long idPaquete) throws Exception {
        ArrayList<DetallePaqueteProductoVO> lista = new ArrayList<DetallePaqueteProductoVO>();
        DetallePaqueteProductoVO detallePaqueteProductoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT dpp.id_detalle_paquete_producto, dpp.id_paquete, "
                    + " dpp.id_producto, dpp.cantidad,dpp.estado "
                    + " FROM detalle_paquete_producto dpp " 
                    + " WHERE dpp.id_paquete = ? ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            pstm.setLong(1, idPaquete);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                detallePaqueteProductoVO = new DetallePaqueteProductoVO();
                
                detallePaqueteProductoVO.setIdDetallePaqueteProducto(rs.getLong(c++));
                detallePaqueteProductoVO.getPaqueteVO().setIdPaquete(rs.getInt(c++));
                detallePaqueteProductoVO.getProductoVO().setIdProducto(rs.getInt(c++));
                detallePaqueteProductoVO.setCantidad(rs.getInt(c++));
                detallePaqueteProductoVO.setEstado(rs.getString(c++));
                
                lista.add(detallePaqueteProductoVO);
            }

        } catch (Exception e) {
            System.out.println("DetallePaqueteProductoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    
}
