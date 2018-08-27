package co.com.blummer.quotevent.modelo.vo;

public class PaqueteVO {
    
    private int idPaquete;
    private String nombre;
    private ClasificacionVO clasificacionVO;
    private String descripcion;
    private LugarVO lugarVO;
    private int cantidadPersonas;
    private double precio;
    private String pdf;
    private String foto;
    private String estado;
    
    public PaqueteVO(){
        this.clasificacionVO = new ClasificacionVO();
        this.lugarVO = new LugarVO();
    }

    /**
     * @return the idPaquete
     */
    public int getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaquete to set
     */
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the clasificacionVO
     */
    public ClasificacionVO getClasificacionVO() {
        return clasificacionVO;
    }

    /**
     * @param clasificacionVO the clasificacionVO to set
     */
    public void setClasificacionVO(ClasificacionVO clasificacionVO) {
        this.clasificacionVO = clasificacionVO;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the lugarVO
     */
    public LugarVO getLugarVO() {
        return lugarVO;
    }

    /**
     * @param lugarVO the lugarVO to set
     */
    public void setLugarVO(LugarVO lugarVO) {
        this.lugarVO = lugarVO;
    }

    /**
     * @return the cantidadPersonas
     */
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * @param cantidadPersonas the cantidadPersonas to set
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the pdf
     */
    public String getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(String pdf) {
        this.pdf = pdf;
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
