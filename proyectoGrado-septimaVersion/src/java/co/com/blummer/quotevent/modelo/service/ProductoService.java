package co.com.blummer.quotevent.modelo.service;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.ProductoDAO;
import co.com.blummer.quotevent.modelo.dao.ProductoDAOMS;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;

public class ProductoService {

    private static ProductoDAO productoDAO;

    public ProductoService() {
        productoDAO = new ProductoDAOMS();

    }

    public int insertar(ProductoVO productoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = productoDAO.insertarProducto(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "insertar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(ProductoVO productoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = productoDAO.actualizarProducto(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "actualizar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<ProductoVO> listar() throws Exception {

        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.listarProductos();
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }

    public ProductoVO consultarPorId(long idProducto) throws Exception {

        ProductoVO productoVO = null;
        try {
            productoVO = productoDAO.consultarProductoPorId(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return productoVO;
        }
    }

    public int consultarUltimoId() throws Exception {
        int id = 0;
        try {
            id = productoDAO.consultarUltimoId();
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());
        } finally {
            return id;
        }
    }
    
    
    public int actualizarCantidadProducto(int nuevaCantidad, int idProducto) throws Exception {
        int resultado = -1;

        try {
            resultado = productoDAO.actualizarCantidadProducto(nuevaCantidad, idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "actualizar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }
}
