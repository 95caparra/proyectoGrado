/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author CAMILO
 */

public class ServicioMedidaProducto {

    public ArrayList<MedidaProductoVO>  listar() throws Exception {
        ArrayList<MedidaProducto> lista = new ArrayList<>();
        ArrayList<MedidaProductoVO> listaVO = new ArrayList<>();
        MedidaProductoVO medida = null;
        try {
            lista = new ArrayList<>(this.obtenerMedidas(0, "").medidaProducto);    
            
            for (MedidaProducto mp: lista) {
                medida = new MedidaProductoVO();
                medida.setMedidaProducto(mp.getIdMedida());
                medida.setNombreMedida(mp.getNombre().getValue());    
                listaVO.add(medida);
            }                        
        } catch (Exception e) {
            e.getMessage();
        }
        return listaVO;
    }
    
    public ArrayOfmedidaProducto obtenerMedidas(Integer idMedidaProducto, String nombreMedidaProducto) {
        ServiceCRUD service = new ServiceCRUD();
        IServiceCRUD port = service.getBasicHttpBindingIServiceCRUD();
        return port.obtenerMedidas(idMedidaProducto, nombreMedidaProducto);
    }

}
