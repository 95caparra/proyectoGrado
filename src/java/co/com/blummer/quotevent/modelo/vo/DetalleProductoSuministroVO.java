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
public class DetalleProductoSuministroVO {

    private int idDetalleProductoSuministro;
    private ProductoVO productoVO;
    private SuministroVO suministroVO;
    private int cantidad;
    private String estado;

    public DetalleProductoSuministroVO() {
        this.productoVO = new ProductoVO();
        this.suministroVO = new SuministroVO();
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public SuministroVO getSuministroVO() {
        return suministroVO;
    }

    public void setSuministroVO(SuministroVO suministroVO) {
        this.suministroVO = suministroVO;
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
     * @return the idDetalleProductoSuministro
     */
    public int getIdDetalleProductoSuministro() {
        return idDetalleProductoSuministro;
    }

    /**
     * @param idDetalleProductoSuministro the idDetalleProductoSuministro to set
     */
    public void setIdDetalleProductoSuministro(int idDetalleProductoSuministro) {
        this.idDetalleProductoSuministro = idDetalleProductoSuministro;
    }
    
    

}
