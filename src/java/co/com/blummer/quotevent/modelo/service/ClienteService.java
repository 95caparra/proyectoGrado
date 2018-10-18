package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.ClienteDAO;
import co.com.blummer.quotevent.modelo.dao.ClienteDAOMS;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import java.util.ArrayList;

public class ClienteService {
    private static ClienteDAO clienteDAO;
    
    public ClienteService(){
        clienteDAO =  new ClienteDAOMS();
    }
    
    public  ArrayList<ClienteVO> listarClientes(){
        ArrayList<ClienteVO> listaClientes = new ArrayList<>();
        try {
            listaClientes = clienteDAO.listarClientes();
        } catch (Exception e) {
            System.out.println(" ClasificacionService: Se presento un error al "
                    + "listar la tabla clasificacion:  " + e.getMessage());

        } finally {
            return listaClientes;
        }
    }
    
    public int insertar(ClienteVO clienteVO) throws Exception {
        int resultado = -1;
        try {
            resultado = clienteDAO.insertar(clienteVO);
        } catch (Exception e) {
            System.out.println(" ClasificacionService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public int actualizar(ClienteVO clienteVO) throws Exception {
        int resultado = -1;
        try {
            resultado = clienteDAO.actualizar(clienteVO);
        } catch (Exception e) {
            System.out.println(" ClasificacionService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public boolean validarExistenciaCliente(long idCliente) throws Exception {
        boolean resultado = false;
        try {
            resultado = clienteDAO.validarExistenciaCliente(idCliente);
        } catch (Exception e) {
            System.out.println(" ClasificacionService: Se presento un error al "
                    + "actualizar un cliente:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
