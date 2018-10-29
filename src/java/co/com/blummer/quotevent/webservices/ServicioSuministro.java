/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author CAMILO
 */
public class ServicioSuministro {

    public ArrayList<SuministroVO> lista() throws Exception {
        ArrayList<Suministro> lista = new ArrayList<>();
        ArrayList<SuministroVO> listaVO = new ArrayList<>();
        SuministroVO suministro = null;
        try {
            ServicioSuministro suministros = new ServicioSuministro();
            lista = new ArrayList<>(suministros.obtenerSuministros(0,"","",0,0,0,
                    new BigDecimal(0), "","Activo").suministro);            
            
            for (Suministro s: lista) {
                suministro = new SuministroVO();
                
                suministro.setNombre(s.getNombre().getValue());
                suministro.setFoto(s.getNombre().getValue());
                suministro.setCantidad(s.getCantidad().getValue());
                suministro.setCantidadMinima(s.getCantidadMinima().getValue());
                suministro.getMedidaProductoVO().setMedidaProducto(s.getMedida().getValue());
                suministro.setPrecioUnidad(s.getPrecioUnidad().getValue().doubleValue());
                suministro.setObservaciones(s.getObservaciones().getValue());
                suministro.setEstado(s.getEstado().getValue());
                
                listaVO.add(suministro);
            }            
            
        } catch (Exception e) {
            e.getMessage();
        }
        return listaVO;
    }
    
    public int insertarSuministro(SuministroVO suministroVO) {
        int opcion = 1;
        Suministro suministroWS = new Suministro();
        ObjectFactory factory = new ObjectFactory();
        
        JAXBElement<String> nombre = factory.createSuministroNombre(suministroVO.getNombre().toString());
        JAXBElement<String> foto = factory.createSuministroFoto(suministroVO.getFoto().toString());
        JAXBElement<Integer> cantidad = factory.createSuministroCantidad(suministroVO.getCantidad());
        JAXBElement<Integer> cantidadMinima = factory.createSuministroCantidadMinima(suministroVO.getCantidadMinima());
        JAXBElement<Integer> medidaProducto = factory.createSuministroMedida(suministroVO.getMedidaProductoVO().getMedidaProducto());
        JAXBElement<BigDecimal> precioUnidad = factory.createSuministroPrecioUnidad(new BigDecimal (suministroVO.getPrecioUnidad()));
        JAXBElement<String> observaciones = factory.createSuministroObservaciones(suministroVO.getObservaciones().toString());
        JAXBElement<String> estado = factory.createSuministroEstado(suministroVO.getEstado().toString());
        
        suministroWS.setNombre(nombre);
        suministroWS.setFoto(foto);
        suministroWS.setCantidad(cantidad);
        suministroWS.setCantidadMinima(cantidadMinima);
        suministroWS.setMedida(medidaProducto);
        suministroWS.setPrecioUnidad(precioUnidad);
        suministroWS.setObservaciones(observaciones);
        suministroWS.setEstado(estado);
        
        String result = cudSuministro(opcion, suministroWS);
        int resultado = 0;
        
        if(result != ""){
            resultado = 1; 
        }else{
            resultado = 0;
        }
        
        return resultado;
    }
    
    public int actualizarSuministro(SuministroVO suministroVO) {
        int opcion = 2;
        Suministro suministroWS = new Suministro();
        ObjectFactory factory = new ObjectFactory();
        
        JAXBElement<String> nombre = factory.createSuministroNombre(suministroVO.getNombre());
        JAXBElement<String> foto = factory.createSuministroFoto(suministroVO.getFoto());
        JAXBElement<Integer> cantidad = factory.createSuministroCantidad(suministroVO.getCantidad());
        JAXBElement<Integer> cantidadMinima = factory.createSuministroCantidadMinima(suministroVO.getCantidadMinima());
        JAXBElement<Integer> medidaProducto = factory.createSuministroMedida(suministroVO.getMedidaProductoVO().getMedidaProducto());
        JAXBElement<BigDecimal> precioUnidad = factory.createSuministroPrecioUnidad(new BigDecimal (suministroVO.getPrecioUnidad()));
        JAXBElement<String> observaciones = factory.createSuministroObservaciones(suministroVO.getObservaciones());
        JAXBElement<String> estado = factory.createSuministroObservaciones(suministroVO.getEstado());
        
        suministroWS.setNombre(nombre);
        suministroWS.setFoto(foto);
        suministroWS.setCantidad(cantidad);
        suministroWS.setCantidadMinima(cantidadMinima);
        suministroWS.setMedida(medidaProducto);
        suministroWS.setPrecioUnidad(precioUnidad);
        suministroWS.setObservaciones(observaciones);
        suministroWS.setEstado(estado);
        
        String result = cudSuministro(opcion, suministroWS);
        int resultado = 0;
        
        if(result != ""){
            resultado = 1; 
        }else{
            resultado = 0;
        }
        
        return resultado;
    }

    public String cudSuministro(Integer opcion, Suministro suministro) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.cudSuministro(opcion, suministro);
    }

    public ArrayOfsuministro obtenerSuministros(Integer idSuministro, String nombreSuministro, String foto, Integer cantidad, Integer cantidadMinima, Integer medida, java.math.BigDecimal precioUnidad, String observaciones, String estado) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.obtenerSuministros(idSuministro, nombreSuministro, foto, cantidad, cantidadMinima, medida, precioUnidad, observaciones, estado);
    }
    
    

}
