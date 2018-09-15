/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.vo;

/**
 *
 * @author Jhon
 */
public class ClienteVO {
    private long numeroIdentificacion;
    private TipoDocumentoVO documentoVO;
    private String nombre;
    private String apellido;
    private String telefono;
    private String celular;
    private String direccion;
    private CiudadVO ciudadVO;
    private String correo;
    
    public ClienteVO(){
        this.documentoVO = new TipoDocumentoVO();
        this.ciudadVO = new CiudadVO();
    }

    public long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public TipoDocumentoVO getDocumentoVO() {
        return documentoVO;
    }

    public void setDocumentoVO(TipoDocumentoVO documentoVO) {
        this.documentoVO = documentoVO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public CiudadVO getCiudadVO() {
        return ciudadVO;
    }

    public void setCiudadVO(CiudadVO ciudadVO) {
        this.ciudadVO = ciudadVO;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
       public String toString() {
        return "identificacion cliente "+"\t"+ numeroIdentificacion+"\n"+"tipo"+"\t"+documentoVO.getNombreDocumento()+""
                +"Nombre "+"\t"+nombre+"\n"+"Apellido "+"\t"+apellido+"\n"+"Telefono"+"\t"+telefono+"\n"+"Celular"+celular+"\t"
                +"Direccion"+direccion+"\n"+"Ciudad"+ciudadVO.getNombreCiudad()
                +"\t"+"Correo"+"\t"+correo;
            
     } 

   
}
