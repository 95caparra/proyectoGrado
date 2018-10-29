/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.dao;

import java.sql.DriverManager;

/**
 *
 * @author Cristian
 */
public class ConexionMySQL extends Conexion {

    @Override
    public void conectar() throws Exception {
        try{
            //usamos el driver de MySQL para la conexion 
            Class.forName("com.mysql.jdbc.Driver");
            //Ponemos el nombre de nuestra base de datos asi como el usuario y contraseña
            //this.conection=DriverManager.getConnection("jdbc:mysql://localhost/quotevent","root","");           
            this.conection=DriverManager.getConnection("jdbc:mysql://localhost/quotevent","proyecto","1234");           
            
        }catch(Exception e){
            System.out.println("ConexionMySQL - ERROR: "+ e.getMessage());
            throw e;
        }
        
    }

    @Override
    public void desconectar() throws Exception {
        try{
            if(this.conection != null && !this.conection.isClosed()){
                this.conection.close();
            }
        }catch(Exception e){
            System.out.println("ConexionMySQL - ERROR : "+ e.getMessage());
            throw e;
        }
    }
    
}
    

