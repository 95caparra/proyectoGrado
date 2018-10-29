/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author CAMILO
 */
public class Medidas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       ServicioMedidaProducto medidas = new ServicioMedidaProducto();

        ArrayList<MedidaProductoVO> listaVO = new ArrayList<>();
        listaVO = medidas.listar();
        for (MedidaProductoVO mp : listaVO) {

            System.out.println("id " + mp.getMedidaProducto());
            System.out.println("nombre " + mp.getNombreMedida());
        }
    }

}
