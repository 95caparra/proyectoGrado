
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetalleProveedorDAOMS extends ConexionMySQL  implements DetalleProveedorDAO {

    @Override
    public int insertar(DetalleProveedorVO detalleProveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            
                String consulta = "INSERT INTO detalle_proveedor  "
                        + "(proveedor_id_proveedor,producto_id_producto,estado) " 
                        +" VALUES (?,?,'Activo') ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, detalleProveedorVO.getProveedorVO().getIdProveedor());
            pstm.setLong(2, detalleProveedorVO.getProductoVO().getIdProducto());
            
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
    public int insertarProductos(DetalleProveedorVO detalleProveedorVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            
                String consulta = "INSERT INTO detalle_proveedor  "
                        + "(proveedor_id_proveedor,producto_id_producto,estado) " 
                        +" VALUES (?,?,'Activo') ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, detalleProveedorVO.getProveedorVO().getIdProveedor());
            pstm.setLong(2, detalleProveedorVO.getProductoVO().getIdProducto());
            
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
    public int actualizar(DetalleProveedorVO detalleProveedorVO) throws Exception {
      int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE detalle_proveedor SET "
                    + "idProducto = ?, "
                    + "idProveedor = ? "
                    + "WHERE idProducto = ? AND idProveedor=?";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, detalleProveedorVO.getProductoVO().getIdProducto());
            pstm.setLong(2, detalleProveedorVO.getProveedorVO().getIdProveedor());
           
            
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
    public int eliminar(long idProducto,long idProveedor) throws Exception {
          int resultado = -1;
        try {
            this.conectar();
            String consulta = "DELETE FROM  detalle_proveedor"
                    + " WHERE idProducto = ? OR idProveedor = ?";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idProducto);
            pstm.setLong(2, idProveedor);
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al eliminar una calificación. " 
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetalleProveedorVO> listar() throws Exception {
         ArrayList<DetalleProveedorVO> lista = new ArrayList<DetalleProveedorVO>();
        DetalleProveedorVO detalleProveedorVO;
        try {
            this.conectar();
            String consulta = "SELECT p.idProducto,p.nombre, p.tipo,p.cantidad," 
                    +"p.estado,pv.idProveedor,pv.razonSocial,pv.direccion,pv.telefono " 
                    + "FROM detalle_proveedor dp  "
                    +"INNER JOIN producto p ON (p.idProducto = dp.idProducto) "
                    +"INNER JOIN proveedor pv ON (pv.idProveedor = dp.idProveedor)";/* Se traen sólo los campos más relevantes */
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                detalleProveedorVO = new DetalleProveedorVO();
                
//                detalleProveedorVO.getProductoVO().setIdProducto(rs.getLong(1));
//                detalleProveedorVO.getProductoVO().setNombre(rs.getString(2));
//                detalleProveedorVO.getProductoVO().setTipo(rs.getString(3));
//                detalleProveedorVO.getProductoVO().setCantidad(rs.getInt(4));
//                detalleProveedorVO.getProductoVO().setEstado(rs.getString(5));
//                detalleProveedorVO.getProveedorVO().setIdProveedor(rs.getLong(6));
//                detalleProveedorVO.getProveedorVO().setRazonSocial(rs.getString(7));
//                detalleProveedorVO.getProveedorVO().setDireccion(rs.getString(8));
//                detalleProveedorVO.getProveedorVO().setTelefono(rs.getString(9));
//                lista.add(detalleProveedorVO);
            }
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al consultar tabla calificacion. " 
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    @Override
    public DetalleProveedorVO consultaPorId(long idProducto, long idProveedor) throws Exception {
       DetalleProveedorVO detalleProveedorVO = null;
        try {
            this.conectar();
            String consulta = "SELECT p.idProducto,p.nombre, p.tipo,p.cantidad," 
                    +"p.estado,pv.idProveedor,pv.razonSocial,pv.direccion,pv.telefono " 
                    + "FROM detalle_proveedor dp  "
                    +"INNER JOIN producto p ON (p.idProducto = dp.idProducto) "
                    +"INNER JOIN proveedor pv ON (pv.idProveedor = dp.idProveedor)" 
                    +"WHERE p.idProducto=? AND pv.idProveedor=?";/* Se traen sólo los campos más relevantes */
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, idProducto);
            pstm.setLong(2, idProveedor);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                detalleProveedorVO = new DetalleProveedorVO();
                
//                detalleProveedorVO.getProductoVO().setIdProducto(rs.getLong(1));
//                detalleProveedorVO.getProductoVO().setNombre(rs.getString(2));
//                detalleProveedorVO.getProductoVO().setTipo(rs.getString(3));
//                detalleProveedorVO.getProductoVO().setCantidad(rs.getInt(4));
//                detalleProveedorVO.getProductoVO().setEstado(rs.getString(5));
//                detalleProveedorVO.getProveedorVO().setIdProveedor(rs.getLong(6));
//                detalleProveedorVO.getProveedorVO().setRazonSocial(rs.getString(7));
//                detalleProveedorVO.getProveedorVO().setDireccion(rs.getString(8));
//                detalleProveedorVO.getProveedorVO().setTelefono(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: "
                    + "Se presentó un error al consultar tabla calificacion por id. " 
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return detalleProveedorVO;
        }
    }

    @Override
    public int multi(String[] proveedores) throws Exception {
        int resultado = -1;
        long prov = Long.parseLong(proveedores.toString());
        try {
            this.conectar();
            
            for (int i = 0; i <proveedores.length; i++) {
                 String consulta = "INSERT INTO detalle_proveedor("
                    + "idProducto, idProveedor) "
                    + "VALUES (1,?)";
            
            
            PreparedStatement pstm =
                  this.conection.prepareStatement(consulta);
            
            pstm.setLong(1, 1);
            pstm.setLong(2, prov);
            
            resultado = pstm.executeUpdate();
            }
           
            
        } catch (Exception e) {
        }
        return resultado;
    }
    
    @Override
    public   ArrayList<DetalleProveedorVO> consultarProveedores(long idProducto) throws Exception {
        ArrayList<DetalleProveedorVO> listaProveedores = new ArrayList<DetalleProveedorVO>();
        DetalleProveedorVO detalleProveedorVO;
        try {
            this.conectar();
            String consulta = "SELECT pv.razon_social FROM " 
                    +"producto p INNER JOIN detalle_proveedor dp ON dp.producto_id_producto = p.id_producto " 
                    +"INNER JOIN proveedor pv ON pv.id_proveedor = dp.proveedor_id_proveedor "
                    +"WHERE p.id_producto = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                detalleProveedorVO = new DetalleProveedorVO();

                detalleProveedorVO.getProveedorVO().setRazonSocial(rs.getString(1));
              
                listaProveedores.add(detalleProveedorVO);
            }

        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listaProveedores;
        }
    }
    
     @Override
    public  ArrayList<DetalleProveedorVO> consultarProductos(long idProveedor) throws Exception {
        ArrayList<DetalleProveedorVO> listaProductos = new ArrayList<DetalleProveedorVO>();
        DetalleProveedorVO detalleProveedorVO;
        try {
            this.conectar();
            String consulta = "SELECT p.nombre FROM " 
                    +"producto p INNER JOIN detalle_proveedor dp ON dp.producto_id_producto = p.id_producto "
                    +"INNER JOIN proveedor pv ON pv.id_proveedor = dp.proveedor_id_proveedor "
                    +"WHERE pv.id_proveedor = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProveedor);

            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                detalleProveedorVO = new DetalleProveedorVO();

                detalleProveedorVO.getProductoVO().setNombre(rs.getString(1));
              
                listaProductos.add(detalleProveedorVO);
            }

        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listaProductos;
        }
    }
    
    public   ArrayList<DetalleProveedorVO> consultarIdProveedores(long idProducto) throws Exception {
        ArrayList<DetalleProveedorVO> listaProveedores = new ArrayList<DetalleProveedorVO>();
        DetalleProveedorVO detalleProveedorVO;
        try {
            this.conectar();
            String consulta = "SELECT  pv.id_proveedor FROM " 
                    +"producto p INNER JOIN detalle_proveedor dp ON dp.producto_id_producto = p.id_producto " 
                    +"INNER JOIN proveedor pv ON pv.id_proveedor = dp.proveedor_id_proveedor "
                    +"WHERE p.id_producto = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                detalleProveedorVO = new DetalleProveedorVO();

                detalleProveedorVO.getProveedorVO().setIdProveedor(rs.getInt(1));
              
                listaProveedores.add(detalleProveedorVO);
            }

        } catch (Exception e) {
            System.out.println("DetalleProveedorDAOMS: Se presento un ERROR al consultar IdProducto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listaProveedores;
        }
    }
    
}
