package co.com.blummer.quotevent.modelo.service;

import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.dao.DetalleProveedorDAO;
import co.com.blummer.quotevent.modelo.dao.DetalleProveedorDAOMS;
import co.com.blummer.quotevent.modelo.dao.ProductoDAO;
import co.com.blummer.quotevent.modelo.dao.ProductoDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;

public class ProductoService {

    private static ProductoDAO productoDAO;

    public ProductoService() {
        productoDAO = new ProductoDAOMS();

    }

    public int insertar(ProductoVO productoVO) throws Exception {
        int resultado = -1;

        try {
            resultado = productoDAO.insertar(productoVO);
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
            resultado = productoDAO.actualizar(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "actualizar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int eliminar(long idProducto) throws Exception {
        int resultado = -1;
        try {
            resultado = productoDAO.eliminar(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "eliminar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int eliminacionLogica(long idProducto) throws Exception {
        int resultado = -1;
        try {
            resultado = productoDAO.eliminacionLogica(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "eliminar un producto: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<ProductoVO> listarTodo() throws Exception {

        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.listarTodos();
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
     public ArrayList<ProductoVO> listarSegun(int tipo) throws Exception {

        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.listarPaqueteSegunTipo(tipo);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla producto: " + e.getMessage());

        } finally {
            return lista;
        }
    }
     
      public ArrayList<ProductoVO> listarSegunP(int id) throws Exception {

        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.consultarListaPorId(id);
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
            productoVO = productoDAO.consultarPorId(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return productoVO;
        }
    }

    public ArrayList<ProductoVO> buscar(String parametro) throws Exception {
        ArrayList<ProductoVO> busca = new ArrayList<ProductoVO>();
        ProductoVO productoVO = null;
        try {
            busca = productoDAO.buscar(parametro);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return busca;
        }
    }

    public int consultarIdProducto() throws Exception {
        int idProducto = -1;
        try {
            idProducto = productoDAO.idProducto();

        } catch (Exception e) {
            System.out.println("ProductoService:"
                    + "Se presento un error al buscar el id del producto "
                    + e.getMessage());
        } finally {
            return idProducto;
        }
    }

    public String validar(String nombre) throws Exception {
        String validacion = "";
        try {
            validacion = productoDAO.validarProducto(nombre);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al validar producto"
                    + e.getMessage());
        } finally {
            return validacion;
        }
    }

    public int consultarStock(int idCatalogo) throws Exception {
        int cantidad = 0;
        try {
            cantidad = productoDAO.consultarStock(idCatalogo);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al validar producto"
                    + e.getMessage());
        } finally {
            return cantidad;
        }
    }

    public ArrayList<String> consultarNom(int idCatalogo) throws Exception {
        ArrayList<String> nombre = null;
        try {
            nombre = productoDAO.consultarNom(idCatalogo);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al validar producto"
                    + e.getMessage());
        } finally {
            return nombre;
        }
    }

    public void descontarStock(int cantidad, String nombre) throws Exception {       
        try {
             productoDAO.descontarStock(cantidad, nombre);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al validar producto"
                    + e.getMessage());
        } finally {
        }
    }

}
