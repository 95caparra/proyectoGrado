/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.dao;
import java.sql.Connection;
/**
 *
 * @author Cristian
 */
public abstract class Conexion {
    public Connection conection;
    public abstract void conectar() throws Exception;
    public abstract void desconectar() throws Exception;
}
