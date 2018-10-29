
package co.com.blummer.quotevent.modelo.vo;

/**
 *
 * @author Jhon Lagos
 */
public class UsuarioVO {
    private int idUsuario;
    private EmpleadoVO empleadoVO;
    private String usuario;
    private String clave;
    private String estado;
    
    
    public UsuarioVO(){
        this.empleadoVO = new EmpleadoVO();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EmpleadoVO getEmpleadoVO() {
        return empleadoVO;
    }

    public void setEmpleadoVO(EmpleadoVO empleado) {
        this.empleadoVO = empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
