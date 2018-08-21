package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.util.Util;

public class ProductoDAOMS extends ConexionMySQL implements ProductoDAO {

    @Override
    public int insertar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO producto "
                    + "(nombre, precio_unidad, foto, id_categoria, estado) "
                    + "VALUES(?,?,?,?,'Activo')";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, productoVO.getNombre());
            pstm.setDouble(2, productoVO.getPrecioUnidad());
            pstm.setString(3, productoVO.getFoto());
            pstm.setInt(4, productoVO.getCategoriaPaqueteVO().getIdCategoria());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: se presento un error al insertar "
                    + "un producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int insertarDetalle(DetalleProveedorVO detalleProveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO detalle_proveedor("
                    + "idProducto, idProveedor) "
                    + "VALUES (?,?)";
            PreparedStatement pstm
                    = this.conection.prepareStatement(consulta);
            pstm.setLong(1, detalleProveedorVO.getProductoVO().getIdProducto());
            pstm.setLong(2, detalleProveedorVO.getProveedorVO().getIdProveedor());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE producto SET "
                    + "nombre = ?, "
                    + "precio_unidad = ?, "
                    + "id_categoria = ?, "
                    + "foto = ? "
                    + "WHERE id_producto = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, productoVO.getNombre());
            pstm.setDouble(2, productoVO.getPrecioUnidad());
            pstm.setInt(3, productoVO.getCategoriaPaqueteVO().getIdCategoria());
            pstm.setString(4, productoVO.getFoto());

            pstm.setInt(5, productoVO.getIdProducto());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: se presento un error al "
                    + "actualizar un producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminar(long idProducto) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String eliminar = "DELETE FROM producto WHERE id_producto = ?";
            PreparedStatement pstm = this.conection.prepareStatement(eliminar);
            pstm.setLong(1, idProducto);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: se presento un error al eliminar"
                    + " un producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminacionLogica(long idProducto) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String eliminar = "UPDATE producto "
                    + "SET estado = 'Inactivo'"
                    + "WHERE id_producto = ?";
            PreparedStatement pstm = this.conection.prepareStatement(eliminar);
            pstm.setLong(1, idProducto);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: se presento un error al eliminar"
                    + " un producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<ProductoVO> listarTodos() throws Exception {
        ArrayList<ProductoVO> listarTodo = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        try {
            this.conectar();

            String consulta = " SELECT p.id_producto, p.nombre, p.precio_unidad, p.foto, c.id_categoria, c.nombre "
                    + " FROM producto p  JOIN  categoria c ON c.id_categoria = p.id_categoria "
                    + " WHERE p.estado = 'Activo' "
                    + " ORDER BY p.nombre ASC ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(1));
                productoVO.setNombre(rs.getString(2));
                productoVO.setPrecioUnidad(rs.getDouble(3));
                productoVO.setFoto(rs.getString(4));
                productoVO.getCategoriaPaqueteVO().setIdCategoria(rs.getInt(5));
                productoVO.getCategoriaPaqueteVO().setNombre(rs.getString(6));

                listarTodo.add(productoVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductosDAOMS: Se presento un ERROR al listar la tabla productos"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listarTodo;
        }
    }

    @Override
    public ProductoVO consultarPorId(long idProducto) throws Exception {
        ProductoVO productoVO = null;
        try {
            this.conectar();
            String consulta = "SELECT p.id_producto, p.nombre, p.precio_unidad, p.foto, c.id_categoria, c.nombre "
                    + " FROM producto p INNER JOIN categoria c ON c.id_categoria = p.id_categoria "
                    + " WHERE p.id_producto = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(1));
                productoVO.setNombre(rs.getString(2));
                productoVO.setPrecioUnidad(rs.getDouble(3));
                productoVO.setFoto(rs.getString(4));
                productoVO.getCategoriaPaqueteVO().setIdCategoria(rs.getInt(5));
                productoVO.getCategoriaPaqueteVO().setNombre(rs.getString(6));

            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return productoVO;
        }
    }

    @Override
    public ArrayList<ProductoVO> buscar(String parametro) throws Exception {

        ArrayList<ProductoVO> busca = new ArrayList<ProductoVO>();
        ProductoVO productoVO = null;
        try {
            this.conectar();
            String consulta = "SELECT id_producto, nombre "
                    + " FROM producto "
                    + " WHERE nombre like '%" + parametro + "%' ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            //pstm.setString(1, parametro);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(1));
                productoVO.setNombre(rs.getString(2));

                busca.add(productoVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return busca;
        }
    }

    //Metodo para saber el id del ultimo producto insertado en la base de datos
    public int idProducto() throws Exception {
        int idProducto = -1;
        try {
            this.conectar();
            String consulta = "SELECT id_producto "
                    + "FROM producto ORDER BY 1 DESC LIMIT 1 ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar el id del producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return idProducto;
        }
    }

    @Override
    public String validarProducto(String nombre) throws Exception {
        String nombreProducto = "";
        try {
            this.conectar();
            String validacion = "SELECT nombre "
                    + "FROM producto "
                    + "WHERE nombre = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(validacion);

            pstm.setString(1, nombre);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                nombreProducto = rs.getString(1);
            }

            //String formatoJSON = gson.toJson(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: ocurrio un error al validar producto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return nombreProducto;
        }
    }

    @Override
    public int consultarStock(int idCatalogo) throws Exception {
        int cant = 0;
        try {
            this.conectar();
            String consulta = "SELECT p.cantidad "
                    + "FROM catalogo c INNER JOIN ingredientes i ON i.catalogo_id_catalogo = c.id_catalogo "
                    + "INNER JOIN producto p ON p.id_producto = i.producto_id_producto "
                    + "WHERE c.id_catalogo = " + idCatalogo + " ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cant = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return cant;
        }
    }

    @Override
    public ArrayList<String> consultarNom(int idCatalogo) throws Exception {
        ArrayList<String> nom = new ArrayList<String>();
        String nomb = "";
        try {
            this.conectar();
            String consulta = "SELECT p.nombre "
                    + "FROM catalogo c INNER JOIN ingredientes i ON i.catalogo_id_catalogo = c.id_catalogo "
                    + "INNER JOIN producto p ON p.id_producto = i.producto_id_producto "
                    + "WHERE c.id_catalogo = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idCatalogo);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                nomb = rs.getString(1);
                nom.add(nomb);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return nom;
        }

    }

    public void descontarStock(int cantidad, String nombre) throws Exception {
        try {
            this.conectar();
            String consulta = "UPDATE producto SET "
                    + "cantidad = ? "
                    + "WHERE nombre = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, cantidad);
            pstm.setString(2, nombre);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: se presento un error al "
                    + "actualizar un producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public ArrayList<ProductoVO> listarPaqueteSegunTipo(int tipo) throws Exception {
        ArrayList<ProductoVO> listarSegun = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        try {
            this.conectar();

            String consulta = " SELECT p.id_producto, p.nombre, p.precio_unidad, p.foto, c.id_categoria, c.nombre "
                    +" FROM producto p  JOIN  categoria c ON c.id_categoria = p.id_categoria "
                    +" WHERE c.id_categoria = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setInt(1, tipo);
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(1));
                productoVO.setNombre(rs.getString(2));
                productoVO.setPrecioUnidad(rs.getDouble(3));
                productoVO.setFoto(rs.getString(4));
                productoVO.getCategoriaPaqueteVO().setIdCategoria(rs.getInt(5));
                productoVO.getCategoriaPaqueteVO().setNombre(rs.getString(6));

                listarSegun.add(productoVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductosDAOMS: Se presento un ERROR al listar la tabla productos"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listarSegun;
        }
    }

    @Override
    public ArrayList<ProductoVO> consultarListaPorId(long idProducto) throws Exception {
        ProductoVO productoVO = null;
        ArrayList<ProductoVO> listarSegun = new ArrayList<ProductoVO>();
        try {
            this.conectar();
            String consulta = "SELECT p.id_producto, p.nombre, p.precio_unidad, p.foto, c.id_categoria, c.nombre "
                    + " FROM producto p INNER JOIN categoria c ON c.id_categoria = p.id_categoria "
                    + " WHERE p.id_producto = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                productoVO = new ProductoVO();

                productoVO.setIdProducto(rs.getInt(1));
                productoVO.setNombre(rs.getString(2));
                productoVO.setPrecioUnidad(rs.getDouble(3));
                productoVO.setFoto(rs.getString(4));
                productoVO.getCategoriaPaqueteVO().setIdCategoria(rs.getInt(5));
                productoVO.getCategoriaPaqueteVO().setNombre(rs.getString(6));
                
                listarSegun.add(productoVO);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listarSegun;
        }
    }

}
