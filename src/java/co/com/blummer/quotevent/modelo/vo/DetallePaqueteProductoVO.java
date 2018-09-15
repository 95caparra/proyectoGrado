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
public class DetallePaqueteProductoVO {

    private PaqueteVO paqueteVO;
    private ProductoVO productoVO;
    private int cantidad;
    private String estado;

    public DetallePaqueteProductoVO() {
        this.productoVO = new ProductoVO();
        this.paqueteVO = new PaqueteVO();
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the paqueteVO
     */
    public PaqueteVO getPaqueteVO() {
        return paqueteVO;
    }

    /**
     * @param paqueteVO the paqueteVO to set
     */
    public void setPaqueteVO(PaqueteVO paqueteVO) {
        this.paqueteVO = paqueteVO;
    }
    
    

}
