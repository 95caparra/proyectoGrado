package co.com.blummer.quotevent.modelo.vo;

public class DetallePaqueteVO {

    private ProductoVO productoVO;
    private PaqueteVO paqueteVO;
    private int cantidad;
    private String estado;

    public DetallePaqueteVO() {
        productoVO = new ProductoVO();
        paqueteVO = new PaqueteVO();
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public PaqueteVO getPaqueteVO() {
        return paqueteVO;
    }

    public void setPaqueteVO(PaqueteVO paqueteVO) {
        this.paqueteVO = paqueteVO;
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
