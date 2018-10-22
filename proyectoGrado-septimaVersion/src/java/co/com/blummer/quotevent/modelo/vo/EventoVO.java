/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.vo;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Danny
 */
public class EventoVO {
    private  int idEvento;
    private SolicitudVO solicitudVO;
    private ClienteVO clienteVO;
    private TipoEventoVO tipoEventoVO;
    private LugarVO lugarVO;
    private int cantidadPersonas;
    private int cantidadMeseros;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;
    private double precio;
    private PedidoVO pedidoVO;
    private String observaciones;
    private EstadoEventoVO estadoEvento;
    
    public EventoVO(){
        this.solicitudVO = new SolicitudVO();
        this.clienteVO = new ClienteVO();
        this.tipoEventoVO = new TipoEventoVO();
        this.pedidoVO = new PedidoVO();
        this.estadoEvento = new EstadoEventoVO();
        this.lugarVO = new LugarVO();
    }

    public TipoEventoVO getTipoEventoVO() {
        return tipoEventoVO;
    }

    public void setTipoEventoVO(TipoEventoVO tipoEventoVO) {
        this.tipoEventoVO = tipoEventoVO;
    }
    
    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time hora_inicio) {
        this.horaInicio = hora_inicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time hora_fin) {
        this.horaFin = hora_fin;
    }
   

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public SolicitudVO getSolicitudVO() {
        return solicitudVO;
    }

    public void setSolicitudVO(SolicitudVO solicitudVO) {
        this.solicitudVO = solicitudVO;
    }

    public ClienteVO getClienteVO() {
        return clienteVO;
    }

    public void setClienteVO(ClienteVO clienteVO) {
        this.clienteVO = clienteVO;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadMeseros() {
        return cantidadMeseros;
    }

    public void setCantidadMeseros(int cantidadMeseros) {
        this.cantidadMeseros = cantidadMeseros;
    }

   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public PedidoVO getPedidoVO() {
        return pedidoVO;
    }

    public void setPedidoVO(PedidoVO pedidoVO) {
        this.pedidoVO = pedidoVO;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoEventoVO getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEventoVO estadoEvento) {
        this.estadoEvento = estadoEvento;
    }
    
     public String toString() {
        return "IdEvento"+"\t"+ idEvento+"\n";
            
     } 

    /**
     * @return the lugarVO
     */
    public LugarVO getLugarVO() {
        return lugarVO;
    }

    /**
     * @param lugarVO the lugarVO to set
     */
    public void setLugarVO(LugarVO lugarVO) {
        this.lugarVO = lugarVO;
    }
    
}
