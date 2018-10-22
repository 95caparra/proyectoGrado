package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ProveedorDAO;
import co.com.blummer.quotevent.modelo.dao.ProveedorDAOMS;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
import java.util.ArrayList;

public class ProveedorService {
    private static ProveedorDAO proveedorDAO;
    
    public ProveedorService(){
        proveedorDAO =  new ProveedorDAOMS();
    }
    
    public  ArrayList<ProveedorVO> listar(){
        ArrayList<ProveedorVO> lista = new ArrayList<>();
        try {
            lista= proveedorDAO.listar();
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "listar la tabla empleado:  " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public int insertar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = proveedorDAO.insertar(proveedorVO);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = proveedorDAO.actualizar(proveedorVO);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public boolean validarExistencia(long idProveedor) throws Exception {
        boolean resultado = false;
        try {
            resultado = proveedorDAO.validarExistencia(idProveedor);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
