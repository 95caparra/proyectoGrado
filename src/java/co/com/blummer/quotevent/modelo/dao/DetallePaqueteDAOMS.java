/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class DetallePaqueteDAOMS extends ConexionMySQL implements DetallePaqueteDAO {

    @Override
    public int insertar(DetallePaqueteVO detallePaqueteVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();

            String consulta = "INSERT INTO detalle_paquete  "
                    + "(producto_id_producto,paquete_id_paquete,cantidad,estado) "
                    + " VALUES (?,?,?,'Activo') ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detallePaqueteVO.getProductoVO().getIdProducto());
            pstm.setLong(2, detallePaqueteVO.getPaqueteVO().getIdPaquete());
            pstm.setLong(3, detallePaqueteVO.getCantidad());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al insertar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int insertarProductos(DetallePaqueteVO detallePaqueteVO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(DetallePaqueteVO detallePaqueteVO, int idProductoA) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE detalle_paquete SET "
                    + "producto_id_producto = ?, "
                    + "cantidad = ? "
                    + "WHERE paquete_id_paquete = ? and producto_id_producto = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detallePaqueteVO.getProductoVO().getIdProducto());
            pstm.setInt(2, detallePaqueteVO.getCantidad());
            pstm.setLong(3, detallePaqueteVO.getPaqueteVO().getIdPaquete());
            pstm.setLong(4, idProductoA);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al actualizar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminar(int idProducto, int idPaquete) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "DELETE FROM detalle_paquete "
                    + " WHERE paquete_id_paquete = ? and producto_id_producto = ?  ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, idPaquete);
            pstm.setInt(2, idProducto);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al actualizar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetallePaqueteVO> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetallePaqueteVO> consultaPorId(long idPaquete) throws Exception {
        ArrayList<DetallePaqueteVO> lista = new ArrayList<DetallePaqueteVO>();
        DetallePaqueteVO detallePaqueteVO;
        try {
            this.conectar();
            String consulta = "SELECT p.id_producto, p.foto, p.precio_unidad, dp.cantidad, pq.nombre FROM detalle_paquete dp "
                    + "INNER JOIN paquete pq ON  pq.id_paquete = dp.paquete_id_paquete "
                    + "INNER JOIN producto p ON p.id_producto = dp.producto_id_producto "
                    + "WHERE pq.id_paquete = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idPaquete);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                detallePaqueteVO = new DetallePaqueteVO();

                detallePaqueteVO.getProductoVO().setIdProducto(rs.getInt(1));
                detallePaqueteVO.getProductoVO().setFoto(rs.getString(2));
                detallePaqueteVO.getProductoVO().setPrecioUnidad(rs.getDouble(3));
                detallePaqueteVO.setCantidad(rs.getInt(4));
                detallePaqueteVO.getPaqueteVO().setNombre(rs.getString(5));

                lista.add(detallePaqueteVO);
            }

        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar IdPaquete"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    @Override
    public int eliminarTodo() throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "DELETE FROM detalle_paquete ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al actualizar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public int consultaPorId2(long idPaquete) throws Exception {
        ArrayList<DetallePaqueteVO> lista = new ArrayList<DetallePaqueteVO>();
        int idProducto = 0;
        DetallePaqueteVO detallePaqueteVO;
        try {
            this.conectar();
            String consulta = "SELECT p.id_producto FROM detalle_paquete dp "
                    + "INNER JOIN paquete pq ON  pq.id_paquete = dp.paquete_id_paquete "
                    + "INNER JOIN producto p ON p.id_producto = dp.producto_id_producto "
                    + "WHERE pq.id_paquete = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idPaquete);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                detallePaqueteVO = new DetallePaqueteVO();
                idProducto = (rs.getInt(1));

            }

        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar IdPaquete"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return idProducto;
        }
    }

}
