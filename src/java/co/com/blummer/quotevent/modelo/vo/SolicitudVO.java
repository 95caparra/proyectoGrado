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
    private PaqueteVO paquete;
    private String nombreCliente;
    private int cantidadPersonas;
    private String telefono;
    private String email;
    private byte visto;
    private TipoEventoVO tipoEvento;
    private String hora;
    private Date fecha;
    private String  observaciones;

    public byte getVisto() {
        return visto;
    }

    public void setVisto(byte visto) {
        this.visto = visto;
    }

    public TipoEventoVO getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoVO tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public SolicitudVO(){
        this.paquete = new PaqueteVO();
        this.tipoEvento = new TipoEventoVO();
    }
    
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public PaqueteVO getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteVO paquete) {
        this.paquete = paquete;
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

    
}
