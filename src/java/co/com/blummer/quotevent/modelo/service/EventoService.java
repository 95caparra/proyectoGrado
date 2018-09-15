package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.EventoDAO;
import co.com.blummer.quotevent.modelo.dao.EventoDAOMS;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author CCC
 */
public class EventoService {

    private static EventoDAO eventoDAO;

    public EventoService() {
        eventoDAO = new EventoDAOMS();
    }

    public int insertar(EventoVO eventoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = eventoDAO.insertar(eventoVO);
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "insertar un evento:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizarEstado(long idEvento, int estadoE) throws Exception {
        int resultado = -1;
        try {
            resultado = eventoDAO.modificarEstado(idEvento, estadoE);
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "actualizar un estado:  " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<EventoVO> listar() throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        try {
            lista = eventoDAO.listar();
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "listar la tabla evento:  " + e.getMessage());

        } finally {
            return lista;
        }
    }

    public EventoVO consultarPorId(long idEvento) throws Exception {
        EventoVO eventoVO = null;
        try {
            eventoVO = eventoDAO.consultarPorId(idEvento);
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "consultar por id a un evento:  " + e.getMessage());
        } finally {
            return eventoVO;
        }
    }

    public ArrayList<EventoVO> listarSegunE(int estado) throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        try {
            lista = eventoDAO.listarEventosSegunE(estado);
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "listar la tabla evento:  " + e.getMessage());

        } finally {
            return lista;
        }
    }

    public ArrayList<TipoEventoVO> listarTipoEvento() throws Exception {
        ArrayList<TipoEventoVO> lista = new ArrayList<TipoEventoVO>();
        try {
            lista = eventoDAO.listarTipoEvento();
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "listar la tabla evento:  " + e.getMessage());

        } finally {
            return lista;
        }
    }

    public int consultarIdDelUltimoEvento() throws Exception {
        int idEvento = -1;
        try {
            idEvento = eventoDAO.consultarIdDelEvento();
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "consultar el id del evento:  " + e.getMessage());
        } finally {
            return idEvento;
        }
    }

    public int disponibilidadFecha(Date fecha) throws Exception {
        int cantEventos = 0;
        try {
            cantEventos = eventoDAO.disponibilidadFecha(fecha);
        } catch (Exception e) {
            System.out.println(" EventoService: Se presento un error al "
                    + "consultar la disponibilidad de una fecha:  " + e.getMessage());
        } finally {
            return cantEventos;
        }
    }

    public ArrayList<EventoVO> buscar(String parametro) throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO = null;
        try {
            lista = eventoDAO.buscar(parametro);
        } catch (Exception e) {
            System.out.println("solicitudService: Se presento un error al buscar en la tabla Solicitudes" + e.getMessage());
        } finally {
            return lista;
        }
    }
    
    public boolean validarFecha(int mes, int anio) throws Exception{
        Date fecha = null;
        boolean bandera = false;
        try {
            fecha = eventoDAO.validarFecha(mes, anio);
            if(fecha != null){
                bandera = true;
            }            
        } catch (Exception e) {
            System.out.println("solicitudService: Se presento un error al buscar en la tabla Solicitudes" + e.getMessage());
        }finally{
            return bandera;
        }
                
    } 
}
