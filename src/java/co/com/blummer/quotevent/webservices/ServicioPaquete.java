/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
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
public class ServicioPaquete {

    public ArrayList<PaqueteVO> lista() throws Exception {
        ArrayList<Paquete> lista = new ArrayList<>();
        ArrayList<PaqueteVO> listaVO = new ArrayList<>();
        PaqueteVO paquete = null;
        try {
            ServicioPaquete paquetes = new ServicioPaquete();
            lista = new ArrayList<>(paquetes.obtenerPaquetes(0, "", 0, "", 0, 0,
                    new BigDecimal(0), "", "","Activo").paquete);
            TipoEventoVO tipoEvento = new TipoEventoVO();
            
            for (Paquete p : lista) {
                paquete = new PaqueteVO();
                
                paquete.setNombre(p.getNombre().getValue());
                paquete.getClasificacionVO().setIdClasificacion(p.getClasificacionIdClasificacion().getValue());
                paquete.setDescripcion(p.getDescripcion().getValue());
                paquete.getLugarVO().setIdLugar(p.getIdPaquete());
                paquete.setCantidadPersonas(p.getCantidadPersonas().getValue());
                paquete.setPrecio(p.getPrecio().getValue().doubleValue());
                paquete.setPdf(p.getPdf().getValue());
                paquete.setFoto(p.getFoto().getValue());
                paquete.setEstado(p.getEstado().getValue());
                
                listaVO.add(paquete);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return listaVO;
    }

    public int insertarPaquete(PaqueteVO paqueteVO) throws DatatypeConfigurationException {
        int opcion = 1;
        Paquete paqueteWS = new Paquete();
        
        Clasificacion clasificacionWS = new Clasificacion();
        Lugar lugarWS = new Lugar();
        
        ObjectFactory factory = new ObjectFactory();
        
        lugarWS.setIdLugar(paqueteVO.getLugarVO().getIdLugar());
                
        JAXBElement<String> nombre = factory.createPaqueteNombre(paqueteVO.getNombre());
        JAXBElement<Integer> clasificacion = factory.createPaqueteClasificacionIdClasificacion(paqueteVO.getClasificacionVO().getIdClasificacion());
        JAXBElement<String> descripcion = factory.createPaqueteDescripcion(paqueteVO.getDescripcion());
        JAXBElement<Integer> lugar = factory.createPaqueteIdLugar(paqueteVO.getLugarVO().getIdLugar());
        JAXBElement<Lugar> lugarObjeto = factory.createPaqueteLugar(lugarWS);
        JAXBElement<Integer> cantidadPersonas = factory.createPaqueteCantidadPersonas(paqueteVO.getCantidadPersonas());
        JAXBElement<BigDecimal> precioPaquete = factory.createPaquetePrecio(new BigDecimal(paqueteVO.getPrecio()));
        JAXBElement<String> pdf = factory.createPaquetePdf(paqueteVO.getPdf());
        JAXBElement<String> foto = factory.createPaqueteFoto(paqueteVO.getFoto());
        JAXBElement<String> estado = factory.createPaqueteEstado(paqueteVO.getEstado());
        
        paqueteWS.setNombre(nombre);
        paqueteWS.setClasificacionIdClasificacion(clasificacion);
        paqueteWS.setDescripcion(descripcion);
        paqueteWS.setLugar(lugarObjeto);
        paqueteWS.setCantidadPersonas(cantidadPersonas);
        paqueteWS.setPrecio(precioPaquete);
        paqueteWS.setPdf(pdf);
        paqueteWS.setFoto(foto);
        paqueteWS.setEstado(estado);

        String result = cudPaquete(opcion, paqueteWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public int actualizarPaquete(PaqueteVO paqueteVO) throws DatatypeConfigurationException {
        int opcion = 2;
        Paquete paqueteWS = new Paquete();
        
        Clasificacion clasificacionWS = new Clasificacion();
        Lugar lugarWS = new Lugar();
        
        ObjectFactory factory = new ObjectFactory();
        
        lugarWS.setIdLugar(paqueteVO.getLugarVO().getIdLugar());
                
        JAXBElement<String> nombre = factory.createPaqueteNombre(paqueteVO.getNombre());
        JAXBElement<Integer> clasificacion = factory.createPaqueteClasificacionIdClasificacion(paqueteVO.getClasificacionVO().getIdClasificacion());
        JAXBElement<String> descripcion = factory.createPaqueteDescripcion(paqueteVO.getDescripcion());
        JAXBElement<Integer> lugar = factory.createPaqueteIdLugar(paqueteVO.getLugarVO().getIdLugar());
        JAXBElement<Lugar> lugarObjeto = factory.createPaqueteLugar(lugarWS);
        JAXBElement<Integer> cantidadPersonas = factory.createPaqueteCantidadPersonas(paqueteVO.getCantidadPersonas());
        JAXBElement<BigDecimal> precioPaquete = factory.createPaquetePrecio(new BigDecimal(paqueteVO.getPrecio()));
        JAXBElement<String> pdf = factory.createPaquetePdf(paqueteVO.getPdf());
        JAXBElement<String> foto = factory.createPaqueteFoto(paqueteVO.getFoto());
        JAXBElement<String> estado = factory.createPaqueteEstado(paqueteVO.getEstado());
        
        paqueteWS.setNombre(nombre);
        paqueteWS.setClasificacionIdClasificacion(clasificacion);
        paqueteWS.setDescripcion(descripcion);
        paqueteWS.setLugar(lugarObjeto);
        paqueteWS.setCantidadPersonas(cantidadPersonas);
        paqueteWS.setPrecio(precioPaquete);
        paqueteWS.setPdf(pdf);
        paqueteWS.setFoto(foto);
        paqueteWS.setEstado(estado);

        String result = cudPaquete(opcion, paqueteWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public String cudPaquete(Integer opcion, Paquete paquete) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.cudPaquete(opcion, paquete);
    }
                                            
  
    public ArrayOfpaquete obtenerPaquetes(Integer idPaquete, String nombrePaquete, Integer idClasificacion, String descripcion, Integer idLugar, Integer cantidadPersonas, java.math.BigDecimal precio, String pdf, String foto, String estado) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.obtenerPaquetes(idPaquete, nombrePaquete, idClasificacion, descripcion, idLugar, cantidadPersonas, precio, pdf, foto, estado);
    }

    
    
    
    
    

}
