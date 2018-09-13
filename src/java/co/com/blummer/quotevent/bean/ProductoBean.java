package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.MedidaService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.service.SuministroService;
import co.com.blummer.quotevent.modelo.service.TipoProductoService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import co.com.blummer.quotevent.util.Path;
import static groovy.xml.Entity.reg;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private String nombre;
    private UploadedFile foto;
    private String nombreFoto;
    private TipoProductoVO tipoProductoVO;
    private int cantidadMinima;
    private MedidaProductoVO medidaProductoVO;
    private double precioUnidad;
    private String observaciones;
    private String estado;
    
    private ProductoVO productoVO;    
    private ProductoService productoService;
    
    private MedidaService medidaService;
    private List<MedidaProductoVO> medidas;
    
    private TipoProductoService tipoProductoService;
    private List<TipoProductoVO> tiposProducto;
    
    private SuministroVO suministroVO;    
    private SuministroService suministroService;

    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;

    private LugarService lugarService;
    private List<LugarVO> lugares;

    private LoginBean login;
    private ClasificacionBean clasificacionBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            
            setLogin(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
          
            try {
                medidaService = new MedidaService();
                tipoProductoService = new TipoProductoService();
                productoService = new ProductoService();
                
                medidas = medidaService.listar();
                tiposProducto = tipoProductoService.listar();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertarPaquete() throws Exception {
        try {
           

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                            "se guardó "));
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }

    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
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
     * @return the foto
     */
    public UploadedFile getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    /**
     * @return the nombreFoto
     */
    public String getNombreFoto() {
        return nombreFoto;
    }

    /**
     * @param nombreFoto the nombreFoto to set
     */
    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    /**
     * @return the tipoProductoVO
     */
    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    /**
     * @param tipoProductoVO the tipoProductoVO to set
     */
    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
    }

    /**
     * @return the cantidadMinima
     */
    public int getCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * @param cantidadMinima the cantidadMinima to set
     */
    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    /**
     * @return the medidaProductoVO
     */
    public MedidaProductoVO getMedidaProductoVO() {
        return medidaProductoVO;
    }

    /**
     * @param medidaProductoVO the medidaProductoVO to set
     */
    public void setMedidaProductoVO(MedidaProductoVO medidaProductoVO) {
        this.medidaProductoVO = medidaProductoVO;
    }

    /**
     * @return the precioUnidad
     */
    public double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * @param precioUnidad the precioUnidad to set
     */
    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    /**
     * @return the productoVO
     */
    public ProductoVO getProductoVO() {
        return productoVO;
    }

    /**
     * @param productoVO the productoVO to set
     */
    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    /**
     * @return the productoService
     */
    public ProductoService getProductoService() {
        return productoService;
    }

    /**
     * @param productoService the productoService to set
     */
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * @return the medidaService
     */
    public MedidaService getMedidaService() {
        return medidaService;
    }

    /**
     * @param medidaService the medidaService to set
     */
    public void setMedidaService(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    /**
     * @return the medidas
     */
    public List<MedidaProductoVO> getMedidas() {
        return medidas;
    }

    /**
     * @param medidas the medidas to set
     */
    public void setMedidas(List<MedidaProductoVO> medidas) {
        this.medidas = medidas;
    }

    /**
     * @return the tipoProductoService
     */
    public TipoProductoService getTipoProductoService() {
        return tipoProductoService;
    }

    /**
     * @param tipoProductoService the tipoProductoService to set
     */
    public void setTipoProductoService(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    /**
     * @return the tiposProducto
     */
    public List<TipoProductoVO> getTiposProducto() {
        return tiposProducto;
    }

    /**
     * @param tiposProducto the tiposProducto to set
     */
    public void setTiposProducto(List<TipoProductoVO> tiposProducto) {
        this.tiposProducto = tiposProducto;
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
     * @return the suministroService
     */
    public SuministroService getSuministroService() {
        return suministroService;
    }

    /**
     * @param suministroService the suministroService to set
     */
    public void setSuministroService(SuministroService suministroService) {
        this.suministroService = suministroService;
    }

    /**
     * @return the clasificacionService
     */
    public ClasificacionService getClasificacionService() {
        return clasificacionService;
    }

    /**
     * @param clasificacionService the clasificacionService to set
     */
    public void setClasificacionService(ClasificacionService clasificacionService) {
        this.clasificacionService = clasificacionService;
    }

    /**
     * @return the clasificaciones
     */
    public List<ClasificacionVO> getClasificaciones() {
        return clasificaciones;
    }

    /**
     * @param clasificaciones the clasificaciones to set
     */
    public void setClasificaciones(List<ClasificacionVO> clasificaciones) {
        this.clasificaciones = clasificaciones;
    }

    /**
     * @return the lugarService
     */
    public LugarService getLugarService() {
        return lugarService;
    }

    /**
     * @param lugarService the lugarService to set
     */
    public void setLugarService(LugarService lugarService) {
        this.lugarService = lugarService;
    }

    /**
     * @return the lugares
     */
    public List<LugarVO> getLugares() {
        return lugares;
    }

    /**
     * @param lugares the lugares to set
     */
    public void setLugares(List<LugarVO> lugares) {
        this.lugares = lugares;
    }

    /**
     * @return the login
     */
    public LoginBean getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(LoginBean login) {
        this.login = login;
    }

    /**
     * @return the clasificacionBean
     */
    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }

    /**
     * @param clasificacionBean the clasificacionBean to set
     */
    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
    }


}
