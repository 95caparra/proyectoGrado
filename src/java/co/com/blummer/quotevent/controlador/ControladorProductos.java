/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.controlador;

import co.com.blummer.quotevent.modelo.service.ProductoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.com.blummer.quotevent.util.Util;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;

public class ControladorProductos extends PrincipalControl {

    //objeto Service
  
    //objeto VO
   
    //un entero id, se usarÃ¡ al actualizar y eliminar
    private long id;
    private int resultado;
    private int idProducto;
    private String nombre;
    String[] proveedor;
    
    Util util = new Util();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.request = req;
        this.response = resp;

        //se crea la sesiÃ³n
        session = request.getSession(true);

        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);
        //Variable que nos permita saber la opcion a ejecutar
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        //Lammamos al metodo que procesa la peticion
        this.procesaPeticion(opcion);
    }

    private void procesaPeticion(int opcion) {

        try {
            response.setContentType("application/json");
            switch (opcion) {

                case 1:// 
                   
                    break;

                case 2://buscar productos
                    break;

                case 3://Formulario para insertar Producto
                    break;

                case 4://Insertar producto
                    break;

                case 5:// formulario  para actualizar producto
                    break;

                case 6:// Actualizar producto
                    break;

                case 7:// Eliminar producto
                    break;

                case 8://Solicitar Producto
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;
                    
                case 12:             
                    break;
                    
                case 13:        
                    this.listarSegun();
                    break;

                default:
                    response.setContentType("text/html; charset=UTF-8");
                    this.request.setAttribute("mensaje", "Esta opcion no ha sido implementada ");
                    this.request.setAttribute("opcion", "8");
                    vista = this.request.getRequestDispatcher("respuesta.jsp");
                    vista.forward(this.request, this.response);
                    break;
            }
        } catch (ServletException ex) {
            System.out.println("ServletException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("IOException " + ex.getMessage());

        }        
    }
    
    public void listarSegun() throws Exception {
        int tipo = Integer.parseInt(this.request.getParameter("tipo").toString());
        response.getWriter().write(new Gson().toJson(new ProductoService().listarSegun(tipo)));
    }
    
}

   