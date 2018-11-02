/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author CAMILO
 */
public class ServicioProducto {

    public ArrayList<ProductoVO> lista() throws Exception {
        ArrayList<Producto> lista = new ArrayList<>();
        ArrayList<ProductoVO> listaVO = new ArrayList<>();
        ProductoVO producto = null;
        try {
            ServicioProducto productos = new ServicioProducto();
            lista = new ArrayList<>(productos.obtenerProductos(0, "", "", 0, 0, 0,
                    new BigDecimal(0), "", "Activo").producto);
            
            for (Producto p : lista) {
                producto = new ProductoVO();

                producto.setNombre(p.getNombre().getValue());
                producto.setFoto(p.getNombre().getValue());
                producto.getTipoProductoVO().setIdTipoProducto(p.getTipoProducto().getValue().getIdTipoProducto());
                producto.setCantidad(p.getCantidadMinima().getValue());
                producto.getMedidaProductoVO().setMedidaProducto(p.getMedida().getValue());
                producto.setPrecioUnidad(p.getPrecioUnidad().getValue().doubleValue());
                producto.setObservaciones(p.getObservaciones().getValue());
                producto.setEstado(p.getEstado().getValue());

                listaVO.add(producto);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return listaVO;
    }

    public int insertarProducto(ProductoVO productoVO) {
        int opcion = 1;
        Producto productoWS = new Producto();
        ObjectFactory factory = new ObjectFactory();

        JAXBElement<String> nombre = factory.createProductoNombre(productoVO.getNombre());
        JAXBElement<String> foto = factory.createProductoFoto(productoVO.getFoto());
        JAXBElement<Integer> tipoProducto = factory.createProductoTipo(productoVO.getTipoProductoVO().getIdTipoProducto());
        JAXBElement<Integer> cantidad = factory.createProductoCantidadMinima(productoVO.getCantidad());
        JAXBElement<BigDecimal> precioUnidad = factory.createProductoPrecioUnidad(new BigDecimal(productoVO.getPrecioUnidad()));
        JAXBElement<String> observaciones = factory.createProductoObservaciones(productoVO.getObservaciones());
        JAXBElement<String> estado = factory.createProductoObservaciones(productoVO.getEstado());

        productoWS.setNombre(nombre);
        productoWS.setFoto(foto);
        productoWS.setTipo(tipoProducto);
        productoWS.setCantidadMinima(cantidad);
        productoWS.setPrecioUnidad(precioUnidad);
        productoWS.setObservaciones(observaciones);
        productoWS.setEstado(estado);

        String result = cudProducto(opcion, productoWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public int actualizarProducto(ProductoVO productoVO) {
        int opcion = 2;
        Producto productoWS = new Producto();
        ObjectFactory factory = new ObjectFactory();

        JAXBElement<String> nombre = factory.createProductoNombre(productoVO.getNombre());
        JAXBElement<String> foto = factory.createProductoFoto(productoVO.getFoto());
        JAXBElement<Integer> tipoProducto = factory.createProductoTipo(productoVO.getTipoProductoVO().getIdTipoProducto());
        JAXBElement<Integer> cantidad = factory.createProductoCantidadMinima(productoVO.getCantidad());
        JAXBElement<BigDecimal> precioUnidad = factory.createProductoPrecioUnidad(new BigDecimal(productoVO.getPrecioUnidad()));
        JAXBElement<String> observaciones = factory.createProductoObservaciones(productoVO.getObservaciones());
        JAXBElement<String> estado = factory.createProductoObservaciones(productoVO.getEstado());

        productoWS.setNombre(nombre);
        productoWS.setFoto(foto);
        productoWS.setTipo(tipoProducto);
        productoWS.setCantidadMinima(cantidad);
        productoWS.setPrecioUnidad(precioUnidad);
        productoWS.setObservaciones(observaciones);
        productoWS.setEstado(estado);

        String result = cudProducto(opcion, productoWS);
        int resultado = 0;

        if (result != "") {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public String cudProducto(Integer opcion, Producto producto) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.cudProducto(opcion, producto);
    }
                                            
    public ArrayOfproducto obtenerProductos(Integer idProducto, String nombreProducto, String foto, Integer cantidad, Integer cantidadMinima, Integer medida, BigDecimal precioUnidad, String observaciones, String estado) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.obtenerProductos(idProducto, nombreProducto, foto, cantidad, cantidadMinima, medida, precioUnidad, observaciones, estado);
    }

}
