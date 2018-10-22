package co.com.blummer.quotevent.modelo.vo;

public class TipoProductoVO {
    
   private int idTipoProducto;
   private String nombre;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idTipoProducto
     */
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }
    
}
