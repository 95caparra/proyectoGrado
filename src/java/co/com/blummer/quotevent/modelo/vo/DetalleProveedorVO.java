
package co.com.blummer.quotevent.modelo.vo;

public class DetalleProveedorVO {
    
    private int idDetalleProveedor;
    private SuministroVO suministroVO;
    private ProveedorVO proveedorVO;
    private String estado;
    
    public DetalleProveedorVO() {
        suministroVO = new SuministroVO();
        proveedorVO = new ProveedorVO();
    }    
    

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    /**
     * @return the suministroVO
     */
    public SuministroVO getSuministroVO() {
        return suministroVO;
    }

    /**
     * @param suministroVO the suministroVO to set
     */
    public void setSuministroVO(SuministroVO suministroVO) {
        this.suministroVO = suministroVO;
    }

    /**
     * @return the idDetalleProveedor
     */
    public int getIdDetalleProveedor() {
        return idDetalleProveedor;
    }

    /**
     * @param idDetalleProveedor the idDetalleProveedor to set
     */
    public void setIdDetalleProveedor(int idDetalleProveedor) {
        this.idDetalleProveedor = idDetalleProveedor;
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
