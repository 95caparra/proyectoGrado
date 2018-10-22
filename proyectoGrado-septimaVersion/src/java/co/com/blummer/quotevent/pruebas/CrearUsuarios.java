/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.pruebas;

import co.com.blummer.quotevent.modelo.service.UsuarioService;
import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author sena
 */
public class CrearUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        UsuarioService usuario = new UsuarioService();
        UsuarioVO rol = new UsuarioVO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\t REGISTRAR USUARIOS ");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" Digite el numero de identificacion del empleado al que se se le va a asociar: ");
        rol.getEmpleadoVO().setIdentificacionEmpleado(Long.parseLong(br.readLine()));
        System.out.println(" Digite el nombre de usuario: ");
        rol.setUsuario(br.readLine());
        System.out.println(" Digite la clave: ");
        rol.setClave(br.readLine());
        System.out.println(" ----------------------------------------------------- ");
        if(usuario.insertar(rol)>0){
            System.out.println(" El usuario fue insertado con exito ");
        }else{
            System.out.println(" Ocurrio un error ");
        }
        
        
    }
    
}
