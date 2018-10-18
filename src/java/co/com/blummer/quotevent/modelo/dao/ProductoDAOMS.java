package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import co.com.blummer.quotevent.util.Util;

public class ProductoDAOMS extends ConexionMySQL implements ProductoDAO {

    @Override
    public int insertarProducto(ProductoVO productoVO) throws Exception {
        int inserto = -1;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();

            sql.append(" INSERT INTO producto ( ");
            sql.append(" nombre, ");
            sql.append(" foto, ");
            sql.append(" tipo, ");
            sql.append(" cantidad, ");
            sql.append(" medida, ");
            sql.append(" precio_unidad, ");
            sql.append(" observaciones, ");
            sql.append(" estado ");
            sql.append(" )");
            sql.append(" VALUES (?,?,?,?,?,?,?,'Activo') ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            int c = 1;

            pstm.setString(c++, productoVO.getNombre());
            pstm.setString(c++, productoVO.getFoto());
            pstm.setInt(c++, productoVO.getTipoProductoVO().getIdTipoPriducto());
            pstm.setInt(c++, productoVO.getCantidad());
            pstm.setInt(c++, productoVO.getMedidaProductoVO().getMedidaProducto());
            pstm.setDouble(c++, productoVO.getPrecioUnidad());
            pstm.setString(c++, productoVO.getObservaciones());

            inserto = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al insertar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return inserto;
    }

    @Override
    public ArrayList<ProductoVO> listarProductos() throws Exception {
        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT p.id_producto, p.nombre, p.foto, "
                    + " p.tipo, tp.nombre,  p.cantidad, p.medida, mp.nombre, "
                    + " p.precio_unidad, p.observaciones, p.estado FROM producto p "
                    + " LEFT JOIN tipo_producto tp ON (tp.id_tipo_producto = p.tipo) "
                    + " LEFT JOIN medida_producto mp ON (mp.id_medida = p.medida) "
                    + " order by 1  ");
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(c++));
                productoVO.setNombre(rs.getString(c++));
                productoVO.setFoto(rs.getString(c++));
                productoVO.getTipoProductoVO().setIdTipoPriducto(rs.getInt(c++));
                productoVO.getTipoProductoVO().setNombre(rs.getString(c++));
                productoVO.setCantidad(rs.getInt(c++));
                productoVO.getMedidaProductoVO().setMedidaProducto(rs.getInt(c++));
                productoVO.getMedidaProductoVO().setNombreMedida(rs.getString(c++));
                productoVO.setPrecioUnidad(rs.getDouble(c++));
                productoVO.setObservaciones(rs.getString(c++));
                productoVO.setEstado(rs.getString(c++));

                lista.add(productoVO);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public int actualizarProducto(ProductoVO productoVO) throws Exception {
        int actualizo = -1;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" UPDATE producto SET ");
            sql.append("	nombre = ?, ");
            sql.append("	foto = ?, ");
            sql.append("	tipo = ?, ");
            sql.append("	cantidad_minima = ?,");
            sql.append("	medida = ?, ");
            sql.append("	precio_unidad = ?, ");
            sql.append("	observaciones = ?, ");
            sql.append("	estado = ? ");
            sql.append(" WHERE ");
            sql.append(" id_suministro = ? ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            c = 1;

            pstm.setString(c++, productoVO.getNombre());
            pstm.setString(c++, productoVO.getFoto());
            pstm.setInt(c++, productoVO.getTipoProductoVO().getIdTipoPriducto());
            pstm.setInt(c++, productoVO.getCantidad());
            pstm.setInt(c++, productoVO.getMedidaProductoVO().getMedidaProducto());
            pstm.setDouble(c++, productoVO.getPrecioUnidad());
            pstm.setString(c++, productoVO.getObservaciones());
            pstm.setString(c++, productoVO.getEstado());
            pstm.setLong(c++, productoVO.getIdProducto());

            actualizo = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al actualizar un producto."
                    + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return actualizo;
    }

    @Override
    public ProductoVO consultarProductoPorId(long idProducto) throws Exception {
        ProductoVO productoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT p.id_producto, p.nombre, p.foto, "
                    + " p.tipo, tp.nombre,  p.cantidad, p.medida, mp.nombre, "
                    + " p.precio_unidad, p.observaciones, p.estado FROM producto p "
                    + " LEFT JOIN tipo_producto tp ON (tp.id_tipo_producto = p.tipo) "
                    + " LEFT JOIN medida_producto mp ON (mp.id_medida = p.medida) ");
            sql.append(" WHERE ");
            sql.append(" p.id_producto = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(c++));
                productoVO.setNombre(rs.getString(c++));
                productoVO.setFoto(rs.getString(c++));
                productoVO.getTipoProductoVO().setIdTipoPriducto(rs.getInt(c++));
                productoVO.getTipoProductoVO().setNombre(rs.getString(c++));
                productoVO.setCantidad(rs.getInt(c++));
                productoVO.getMedidaProductoVO().setMedidaProducto(rs.getInt(c++));
                productoVO.getMedidaProductoVO().setNombreMedida(rs.getString(c++));
                productoVO.setPrecioUnidad(rs.getDouble(c++));
                productoVO.setObservaciones(rs.getString(c++));
                productoVO.setEstado(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return productoVO;
    }

    @Override
    public int consultarUltimoId() throws Exception {
        int id = 0;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT id_producto FROM producto order by 1 desc LIMIT 1 " );
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;                
                id = rs.getInt(c++);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return id;
    }

    @Override
    public int actualizarCantidadProducto(int nuevaCantidad, int idProducto) throws Exception {
       int actualizo = -1;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" UPDATE producto SET ");
            sql.append("	cantidad = ? ");
            sql.append(" WHERE ");
            sql.append(" id_producto = ? ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            c = 1;

            pstm.setInt(c++, nuevaCantidad);
            pstm.setInt(c++, idProducto);
            

            actualizo = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al actualizar un producto."
                    + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return actualizo;
    }

}
