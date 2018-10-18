/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.service;
import co.com.blummer.quotevent.util.Mail;
/**
 *
 * @author sena
 */
public class MailService {
   private Mail mail = new Mail();
   
  public void envioCorreo (String correo,String asunto, String mensaje,String archivo[], String ruta){
        mail.envioCorreo(correo,asunto,mensaje, archivo, ruta);
   }
   
   public void solicitarProducto(String producto, String correo, String cantidad, String gramaje, String observaciones, String fecha){
        mail.solicitarProducto(producto, correo, cantidad, gramaje, observaciones,fecha);
   }
   
     public void envioContasena (String correo, String usuario, String contrasenia){
        mail.envioContasena(correo, usuario, contrasenia);
   }
}