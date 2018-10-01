package co.com.blummer.quotevent.modelo.vo;

public class EmpleadoVO {

    private long nIdentificacionEmpleado;
    private TipoDocumentoVO documentoVO;
    private String nombre;
    private String apellido;
    private CargoVO cargoVO;
    private String correo;
    private String direccion;
    private String telefono;
    private String barrio;

    public EmpleadoVO() {
        this.documentoVO = new TipoDocumentoVO();
        this.cargoVO = new CargoVO();
    }

    public long getnIdentificacionEmpleado() {
        return nIdentificacionEmpleado;
    }

    public void setnIdentificacionEmpleado(long nIdentificacionEmpleado) {
        this.nIdentificacionEmpleado = nIdentificacionEmpleado;
    }

    public TipoDocumentoVO getDocumentoVO() {
        return documentoVO;
    }

    public void setDocumentoVO(TipoDocumentoVO documentoVO) {
        this.documentoVO = documentoVO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public CargoVO getCargoVO() {
        return cargoVO;
    }

    public void setCargoVO(CargoVO cargoVO) {
        this.cargoVO = cargoVO;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String toString() {
        return "IdEmpleado " + "\t" + nIdentificacionEmpleado;

    }
}
