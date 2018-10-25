/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import co.com.blummer.quotevent.util.Util;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author CAMILO
 */
public class ServicioSolicitud {

    public ArrayList<SolicitudVO> lista() throws Exception {
        ArrayList<Solicitud> lista = new ArrayList<>();
        ArrayList<SolicitudVO> listaVO = new ArrayList<>();
        SolicitudVO solicitud = null;
        try {
            ServicioSolicitud solicitudes = new ServicioSolicitud();
            lista = new ArrayList<>(solicitudes.obtenerSolicitudes(0, "", 0, "", "", 0, "", null, "", "", false).solicitud);
            TipoEventoVO tipoEvento = new TipoEventoVO();
            
            for (Solicitud s : lista) {
                solicitud = new SolicitudVO();
                

                solicitud.setNombreCliente(s.getNombreCliente().getValue());
                solicitud.setCantidadPersonas(s.getCantidadPersonas().getValue());
                solicitud.setTelefono(s.getTelefono().getValue());
                solicitud.setEmail(s.getEmail().getValue());
                solicitud.getTipoEventoVO().setIdTipoEvento(s.getTipoEvento().getValue().getIdTipoEvento());                
                //FALTA PAQUETE
                solicitud.setHora(new java.sql.Time(Long.parseLong(s.getHora().getValue())));
                solicitud.setFecha(new java.sql.Date(Util.toDate(s.getFecha().getValue().normalize())));
                solicitud.setObservaciones(s.getObservaciones().getValue());
                solicitud.setEstado(s.getEstado().getValue());

                listaVO.add(solicitud);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return listaVO;
    }

    public int insertarSolicitud(SolicitudVO solicitudVO) throws DatatypeConfigurationException {
        int opcion = 1;
        Solicitud solicitudWS = new Solicitud();
        TipoEvento tipoEventoWS = new TipoEvento();
        
        ObjectFactory factory = new ObjectFactory();
        
        JAXBElement<String> nombreTipoEvento = factory.createTipoEventoNombre(solicitudVO.getTipoEventoVO().getNombreTipoEvento());
        
        tipoEventoWS.setIdTipoEvento(solicitudVO.getTipoEventoVO().getIdTipoEvento());
        tipoEventoWS.setNombre(nombreTipoEvento);
        
        JAXBElement<String> nombreCliente = factory.createSolicitudNombreCliente(solicitudVO.getNombreCliente());
        JAXBElement<Integer> cantidadPersonas = factory.createSolicitudCantidadPersonas(solicitudVO.getCantidadPersonas());
        JAXBElement<String> telefono = factory.createSolicitudTelefono(solicitudVO.getTelefono());
        JAXBElement<String> email = factory.createSolicitudTelefono(solicitudVO.getEmail());
        JAXBElement<TipoEvento> tipoEvento = factory.createSolicitudTipoEvento(tipoEventoWS);
        //falta paquete
        //JAXBElement<TipoEvento> tipoEvento = factory.createSolicitud(tipoEventoWS);
        JAXBElement<String> hora = factory.createSolicitudHora(solicitudVO.getHora().toString());
        JAXBElement<XMLGregorianCalendar> fecha = factory.createSolicitudFecha(Util.toXMLGregorianCalendar(solicitudVO.getFecha()));
        JAXBElement<String> observaciones = factory.createSolicitudObservaciones(solicitudVO.getObservaciones());
        JAXBElement<String> estado = factory.createSolicitudObservaciones(solicitudVO.getEstado());

        solicitudWS.setNombreCliente(nombreCliente);
        solicitudWS.setCantidadPersonas(cantidadPersonas);
        solicitudWS.setTelefono(telefono);
        solicitudWS.setEmail(email);
        solicitudWS.setTipoEvento(tipoEvento);
        solicitudWS.setHora(hora);
        solicitudWS.setFecha(fecha);
        solicitudWS.setObservaciones(observaciones);
        solicitudWS.setEstado(estado);

        String result = cudSolicitud(opcion, solicitudWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public int actualizarSolicitud(SolicitudVO solicitudVO) throws DatatypeConfigurationException {
        int opcion = 2;
        Solicitud solicitudWS = new Solicitud();
        TipoEvento tipoEventoWS = new TipoEvento();
        
        ObjectFactory factory = new ObjectFactory();
        
        JAXBElement<String> nombreTipoEvento = factory.createTipoEventoNombre(solicitudVO.getTipoEventoVO().getNombreTipoEvento());
        
        tipoEventoWS.setIdTipoEvento(solicitudVO.getTipoEventoVO().getIdTipoEvento());
        tipoEventoWS.setNombre(nombreTipoEvento);
        
        JAXBElement<String> nombreCliente = factory.createSolicitudNombreCliente(solicitudVO.getNombreCliente());
        JAXBElement<Integer> cantidadPersonas = factory.createSolicitudCantidadPersonas(solicitudVO.getCantidadPersonas());
        JAXBElement<String> telefono = factory.createSolicitudTelefono(solicitudVO.getTelefono());
        JAXBElement<String> email = factory.createSolicitudTelefono(solicitudVO.getEmail());
        JAXBElement<TipoEvento> tipoEvento = factory.createSolicitudTipoEvento(tipoEventoWS);
        //falta paquete
        //JAXBElement<TipoEvento> tipoEvento = factory.createSolicitud(tipoEventoWS);
        JAXBElement<String> hora = factory.createSolicitudHora(solicitudVO.getHora().toString());
        JAXBElement<XMLGregorianCalendar> fecha = factory.createSolicitudFecha(Util.toXMLGregorianCalendar(solicitudVO.getFecha()));
        JAXBElement<String> observaciones = factory.createSolicitudObservaciones(solicitudVO.getObservaciones());
        JAXBElement<String> estado = factory.createSolicitudObservaciones(solicitudVO.getEstado());

        solicitudWS.setNombreCliente(nombreCliente);
        solicitudWS.setCantidadPersonas(cantidadPersonas);
        solicitudWS.setTelefono(telefono);
        solicitudWS.setEmail(email);
        solicitudWS.setTipoEvento(tipoEvento);
        solicitudWS.setHora(hora);
        solicitudWS.setFecha(fecha);
        solicitudWS.setObservaciones(observaciones);
        solicitudWS.setEstado(estado);

        String result = cudSolicitud(opcion, solicitudWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public String cudSolicitud(Integer opcion, Solicitud solicitud) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.cudSolicitudes(opcion, solicitud);
    }
                                            
    public ArrayOfsolicitud obtenerSolicitudes(Integer idSolicitud, String nombreCliente, Integer cantidadPersonas, String telefono, String email, Integer tipoEvento, String hora, javax.xml.datatype.XMLGregorianCalendar fecha, String observaciones, String estado, java.lang.Boolean visto) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
         return port.obtenerSolicitudes(idSolicitud, nombreCliente, cantidadPersonas, telefono, email, tipoEvento, hora, fecha, observaciones, estado, visto);
    }
    
    
    
    

}
