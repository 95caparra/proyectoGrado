
package co.com.blummer.quotevent.modelo.vo;

public class DetalleProveedorVO {
    
    private ProductoVO productoVO;
    private ProveedorVO proveedorVO;
    
    public DetalleProveedorVO() {
        productoVO = new ProductoVO();
        proveedorVO = new ProveedorVO();
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
    
}
