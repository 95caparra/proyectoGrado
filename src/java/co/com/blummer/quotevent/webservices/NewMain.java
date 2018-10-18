/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.webservices;

/**
 *
 * @author cochoa
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consumo con = new Consumo();
        
        System.out.println("la suma es "+con.add(5, 4));
        System.out.println("la division es  "+con.divide(12, 2));
        
    }
    
}
