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

    public SuministroVO getIngredienteVO() {
        return suministroVO;
    }

    public void setIngredienteVO(SuministroVO suministroVO) {
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
    
    

}