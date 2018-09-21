/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.vo;
import java.sql.Date;

/**
 *
 * @author sena
 */
public class SolicitudVO {
    
    private int idSolicitud;   
    private String nombreCliente;
    private int cantidadPersonas;
    private String telefono;
    private String email;
    private TipoEventoVO tipoEventoVO;
    private PaqueteVO paqueteVO;  
    private String hora;
    private Date fecha;
    private String  observaciones;
    private String  estado;
    private int visto;
    
    public SolicitudVO (){
        this.paqueteVO = new PaqueteVO();
        this.tipoEventoVO = new TipoEventoVO();
    }

    public int getVisto() {
        return visto;
    }

    public void setVisto(int visto) {
        this.visto = visto;
    }

    public TipoEventoVO getTipoEventoVO() {
        return tipoEventoVO;
    }

    public void setTipoEvento(TipoEventoVO tipoEventoVO) {
        this.tipoEventoVO = tipoEventoVO;
    }

    
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public PaqueteVO getPaqueteVO() {
        return paqueteVO;
    }

    public void setPaquete(PaqueteVO paqueteVO) {
        this.paqueteVO = paqueteVO;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   

   

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


    
}
