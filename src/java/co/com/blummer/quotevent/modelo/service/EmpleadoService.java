package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.EmpleadoDAO;
import co.com.blummer.quotevent.modelo.dao.EmpleadoDAOMS;
import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import java.util.ArrayList;

public class EmpleadoService {
    private static EmpleadoDAO empleadoDAO;
    
    public EmpleadoService(){
        empleadoDAO =  new EmpleadoDAOMS();
    }
    
    public  ArrayList<EmpleadoVO> listar(){
        ArrayList<EmpleadoVO> lista = new ArrayList<>();
        try {
            lista= empleadoDAO.listar();
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "listar la tabla empleado:  " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public int insertar(EmpleadoVO empleadoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = empleadoDAO.insertar(empleadoVO);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un empleado:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public int actualizar(EmpleadoVO empleadoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = empleadoDAO.actualizar(empleadoVO);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un empleado:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public boolean validarExistencia(long idEmpleado) throws Exception {
        boolean resultado = false;
        try {
            resultado = empleadoDAO.validarExistenciaEmpleado(idEmpleado);
        } catch (Exception e) {
            System.out.println(" EmpleadoService: Se presento un error al "
                    + "actualizar un empleado:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public EmpleadoVO consultarPorId(long idEmpleado) throws Exception {

        EmpleadoVO empleadoVO = null;
        try {
            empleadoVO = empleadoDAO.consultarPorId(idEmpleado);
        } catch (Exception e) {
            System.out.println("EmpleadoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return empleadoVO;
        }
    }
    
}
