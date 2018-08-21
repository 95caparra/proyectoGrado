package co.com.blummer.quotevent.modelo.vo;

public class ProductoVO {
    
    private int idProducto;
    private String nombre;
    private String foto;
    private TipoProductoVO tipoProductoVO;
    private int cantidad;
    private int cantidadMinima;
    private MedidaProductoVO medidaProductoVO;
    private double precioUnidad;
    private EstadoProductoVO estadoProductoVO;
    private String observaciones;
    private String estado;
    private CategoriaPaqueteVO categoriaPaqueteVO;

    public ProductoVO(){        
        this.tipoProductoVO = new TipoProductoVO();
        this.medidaProductoVO = new MedidaProductoVO();
        this.estadoProductoVO = new EstadoProductoVO();
        this.categoriaPaqueteVO = new CategoriaPaqueteVO();
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public MedidaProductoVO getMedidaProductoVO() {
        return medidaProductoVO;
    }

    public void setMedidaProductoVO(MedidaProductoVO medidaProductoVO) {
        this.medidaProductoVO = medidaProductoVO;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public EstadoProductoVO getEstadoProductoVO() {
        return estadoProductoVO;
    }

    public void setEstadoProductoVO(EstadoProductoVO estadoProductoVO) {
        this.estadoProductoVO = estadoProductoVO;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
     public String toString() {
        return "IdProducto "+"\t"+ idProducto+"\n"+"Nombre "+"\t"+nombre+"\n"+"Tipo "+"\t"+tipoProductoVO.getNombre()
                +"\n"+"Cantidad "+cantidad+"\n"+"\n"+"CamtidadMinima"+"\t"+cantidadMinima+"Gramaje "+medidaProductoVO.getNombreMedida()+"\t"
                +"\n"+"Precio Unidad "+precioUnidad+"\n"+"Estado Producto"+"\t"+estadoProductoVO.getDescripcion()+"\t"
                +"\n"+"Estado A/I "+"\t"+estado;
            
     } 

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the categoriaPaqueteVO
     */
    public CategoriaPaqueteVO getCategoriaPaqueteVO() {
        return categoriaPaqueteVO;
    }

    /**
     * @param categoriaPaqueteVO the categoriaPaqueteVO to set
     */
    public void setCategoriaPaqueteVO(CategoriaPaqueteVO categoriaPaqueteVO) {
        this.categoriaPaqueteVO = categoriaPaqueteVO;
    }

  
   

  
}
