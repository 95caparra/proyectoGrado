/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.vo;

/**
 *
 * @author Cristian
 */
public class ProveedorVO {

    private int idProveedor;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String correo;
    private String estado;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return "Id Proveedor "+"\t"+ idProveedor+"\n"+"Razon Social "+"\t"+razonSocial+"\n"+"Direccion "+"\t"+direccion
                +"\n"+ "Telefono" +"\t"+telefono+"\n"+  "Correo " +"\t"+correo
                +"\n"+ "Estado" +"\t"+estado;
            
     } 
}
