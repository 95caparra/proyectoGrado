/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.blummer.quotevent.modelo.vo;

import java.sql.Date;

/**
 *
 * @author Lagos
 */
public class PedidoVO {
    private int idPedido;
    private ProductoVO productoVO;
    private ProveedorVO proveedorVO;
    private Date fechaPedido;
    private double precioTotal;
    private MedidaProductoVO medidaProductoVO;
    private int cantidad;
    private String observaciones;
    private String fechaSugerida;
    
    public PedidoVO(){
        this.productoVO = new ProductoVO();
        this.proveedorVO = new ProveedorVO();
        this.medidaProductoVO = new MedidaProductoVO();
    }
    
     public String toString() {
        return "IdPedido  "+"\t"+idPedido+"\n"+"Nombre Producto  "+"\t"+productoVO.getNombre()+"\n"+" Proveedor  "+"\t"+proveedorVO.getRazonSocial()
                +"\n"+"Cantidad    "+"\t"+cantidad+"\n"+"Precio Total    "+"\t"+precioTotal+"\n"+"Observaciones    "+"\t"+observaciones;
            
     } 

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public MedidaProductoVO getMedidaProductoVO() {
        return medidaProductoVO;
    }

    public void setMedidaProductoVO(MedidaProductoVO medidaProductoVO) {
        this.medidaProductoVO = medidaProductoVO;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaSugerida() {
        return fechaSugerida;
    }

    public void setFechaSugerida(String fechaSugerida) {
        this.fechaSugerida = fechaSugerida;
    }
}
