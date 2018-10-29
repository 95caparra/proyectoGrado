/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.vo;

/**
 *
 * @author CAMILO
 */
public class DetalleEventoEmpleadoVO {

    private int idDetalleEventoEmpleado;
    private EventoVO eventoVO;
    private EmpleadoVO empleadoVO;
    private String estado;

    public DetalleEventoEmpleadoVO() {
        eventoVO = new EventoVO();
        empleadoVO = new EmpleadoVO();
    }

    /**
     * @return the idDetalleEventoEmpleado
     */
    public int getIdDetalleEventoEmpleado() {
        return idDetalleEventoEmpleado;
    }

    /**
     * @param idDetalleEventoEmpleado the idDetalleEventoEmpleado to set
     */
    public void setIdDetalleEventoEmpleado(int idDetalleEventoEmpleado) {
        this.idDetalleEventoEmpleado = idDetalleEventoEmpleado;
    }

    /**
     * @return the eventoVO
     */
    public EventoVO getEventoVO() {
        return eventoVO;
    }

    /**
     * @param eventoVO the eventoVO to set
     */
    public void setEventoVO(EventoVO eventoVO) {
        this.eventoVO = eventoVO;
    }

    /**
     * @return the empleadoVO
     */
    public EmpleadoVO getEmpleadoVO() {
        return empleadoVO;
    }

    /**
     * @param empleadoVO the empleadoVO to set
     */
    public void setEmpleadoVO(EmpleadoVO empleadoVO) {
        this.empleadoVO = empleadoVO;
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
