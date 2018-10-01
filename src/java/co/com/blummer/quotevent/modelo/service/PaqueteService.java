package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.PaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.PaqueteDAOMS;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import java.util.ArrayList;

/**
 *
 * @author Danny
 */
public class PaqueteService {
    private static PaqueteDAO paqueteDAO;
    
    public PaqueteService() {
        paqueteDAO = new PaqueteDAOMS();
    }

    public int insertar(PaqueteVO paqueteVO) throws Exception {
        int resultado = -1;

        try {
            resultado = paqueteDAO.insertar(paqueteVO);
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al "
                    + "insertar un paquete: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int actualizar(PaqueteVO paqueteVO) throws Exception {
        int resultado = -1;

        try {
            resultado = paqueteDAO.actualizar(paqueteVO);
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al "
                    + "actualizar un paquete: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public int eliminar(long idPaquete) throws Exception {
        int resultado = -1;
        try {
            resultado = paqueteDAO.eliminar(idPaquete);
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al "
                    + "eliminar un paquete: " + e.getMessage());

        } finally {
            return resultado;
        }
    }

    public ArrayList<PaqueteVO> listar() throws Exception {

        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        try {
            lista = paqueteDAO.listar();
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al "
                    + "listar la tabla paquete: " + e.getMessage());

        } finally {
            return lista;
        }
    }
    
    public PaqueteVO consultarPorId(long idPaquete) throws Exception {
        PaqueteVO paqueteVO = null;
        try {
            paqueteVO = paqueteDAO.consultarPaquetePorId(idPaquete);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return paqueteVO;
        }
    }
    
     public ArrayList<PaqueteVO> listarPaqueteSegunTipo(int tipo) throws Exception {

        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        try {
            lista = paqueteDAO.listarPaqueteSegunTipo(tipo);
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al "
                    + "listar la tabla paquete: " + e.getMessage());

        } finally {
            return lista;
        }
    }

    
    public ArrayList<PaqueteVO> buscar(String parametro) throws Exception {
        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        PaqueteVO clienteVO = null;
        try {
            lista = paqueteDAO.buscar(parametro);
        } catch (Exception e) {
            System.out.println("solicitudService: Se presento un error al buscar en la tabla Solicitudes" + e.getMessage());
        } finally {
            return lista;
        }
    }
    
    public String validarPaquete (String nombre) throws Exception{
        String nombreP = "";
        try{
            nombreP = paqueteDAO.validarPaquete(nombre);
        }catch(Exception e){
            System.out.println("solicitudService: Se presento un error al validar paquete" + e.getMessage());
        }finally{
            return nombreP;
        }
    }
    
    public int ultimoIdPaquete() throws Exception {
        int idPaquete = -1;
        try {
            idPaquete = paqueteDAO.ultimoId();

        } catch (Exception e) {
            System.out.println("ProductoService:"
                    + "Se presento un error al buscar el id del producto "
                    + e.getMessage());
        } finally {
            return idPaquete;
        }
    }
    
}
