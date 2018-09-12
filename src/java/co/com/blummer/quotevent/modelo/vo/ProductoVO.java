package co.com.blummer.quotevent.modelo.vo;

public class ProductoVO {
    
    private int idProducto;
    private String nombre;
    private String foto;
    private TipoProductoVO tipoProductoVO;
    private int cantidadMinima;
    private MedidaProductoVO medidaProductoVO;
    private double precioUnidad;
    private String observaciones;
    private String estado;

    public ProductoVO(){        
        this.tipoProductoVO = new TipoProductoVO();
        this.medidaProductoVO = new MedidaProductoVO();
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
                +"\n"+"Cantidad "+"\n"+"\n"+"CamtidadMinima"+"\t"+cantidadMinima+"Gramaje "+medidaProductoVO.getNombreMedida()+"\t"
                +"\n"+"Precio Unidad "+precioUnidad+"\n"+"Estado Producto"+"\t"+"\t"
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


  
   

  
}
