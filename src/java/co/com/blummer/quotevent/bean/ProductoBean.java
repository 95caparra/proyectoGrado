package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.MedidaService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.service.SuministroService;
import co.com.blummer.quotevent.modelo.service.TipoProductoService;
import co.com.blummer.quotevent.modelo.service.DetalleProductoSuministroService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import co.com.blummer.quotevent.util.Path;
import static groovy.xml.Entity.reg;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

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
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private String path;

    private String nombre;
    private UploadedFile foto;
    private String nombreFoto;
    private Integer selectedTipoProducto;
    private TipoProductoVO tipoProductoVO;
    private Integer cantidad;
    private Integer selectedMedidaProducto;
    private MedidaProductoVO medidaProductoVO;
    private Double precioUnidad;
    private String observaciones;
    private String estado;

    private ProductoVO selectedProducto;
    private DetalleProductoSuministroVO detalleProductoSuministroVO;
    private DetalleProductoSuministroService detalleProductoSuministroService;
    private List<SuministroVO> droppedSuministros;
    private List<DetalleProductoSuministroVO> detalleProductoSuministros;

    private ProductoVO productoVO;
    private ProductoService productoService;
    private List<ProductoVO> productos;

    private List<SuministroVO> suministros;

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
    private OpcionBean opcionBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            setLogin(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));

            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            try {
              //  FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                medidaService = new MedidaService();
                tipoProductoService = new TipoProductoService();
                productoService = new ProductoService();
                suministroService = new SuministroService();
                detalleProductoSuministroService = new DetalleProductoSuministroService();

                medidas = medidaService.listar();
                tiposProducto = tipoProductoService.listar();
                productos = productoService.listar();
                suministros = suministroService.listar();

                droppedSuministros = new ArrayList<SuministroVO>();

                path = Path.getPathArchivos();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void onDrop(DragDropEvent ddEvent) {
        suministroVO = ((SuministroVO) ddEvent.getData());

        droppedSuministros.add(suministroVO);
        suministros.remove(suministroVO);
    }

    public void insertarProducto() throws Exception {
        try {
            productoVO = new ProductoVO();

            productoVO.setNombre(nombre);
            productoVO.setFoto(nombreFoto);
            productoVO.getTipoProductoVO().setIdTipoPriducto(selectedTipoProducto);
            productoVO.setCantidad(cantidad);
            productoVO.getMedidaProductoVO().setMedidaProducto(selectedMedidaProducto);
            productoVO.setPrecioUnidad(precioUnidad);
            productoVO.setObservaciones(observaciones);

            productoService.insertar(productoVO);

            int ultimoId = productoService.consultarUltimoId();
            for (SuministroVO s : droppedSuministros) {

                detalleProductoSuministroVO = new DetalleProductoSuministroVO();

                detalleProductoSuministroVO.getProductoVO().setIdProducto(ultimoId);
                detalleProductoSuministroVO.getSuministroVO().setIdSuministro(s.getIdSuministro());
                detalleProductoSuministroVO.setCantidad(5);

                detalleProductoSuministroService.insertar(detalleProductoSuministroVO);
            }
            
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            
            RequestContext.getCurrentInstance().update("frmOpciones:growl");
            opcionBean.setearDetalles();
            opcionBean.setearOpciones();
            
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }

    }

    public void verInformacionProducto(Integer id) throws Exception {
        try {
            productoVO = productoService.consultarPorId(id);

            nombre = productoVO.getNombre();
            nombreFoto = productoVO.getFoto();
            selectedTipoProducto = productoVO.getTipoProductoVO().getIdTipoPriducto();
            cantidad = productoVO.getCantidad();
            selectedMedidaProducto = productoVO.getMedidaProductoVO().getMedidaProducto();
            precioUnidad = productoVO.getPrecioUnidad();
            observaciones = productoVO.getObservaciones();

            opcionBean.verInfoProducto();

            detalleProductoSuministros = detalleProductoSuministroService.listarPorId(id);

            for (DetalleProductoSuministroVO dps : detalleProductoSuministros) {

                droppedSuministros.add(suministroService.consultarPorId(dps.getSuministroVO().getIdSuministro()));
            }

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
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidadMinima the cantidadMinima to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * @param precioUnidad the precioUnidad to set
     */
    public void setPrecioUnidad(Double precioUnidad) {
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

    /**
     * @return the selectedTipoProducto
     */
    public Integer getSelectedTipoProducto() {
        return selectedTipoProducto;
    }

    /**
     * @param selectedTipoProducto the selectedTipoProducto to set
     */
    public void setSelectedTipoProducto(Integer selectedTipoProducto) {
        this.selectedTipoProducto = selectedTipoProducto;
    }

    /**
     * @return the selectedMedidaProducto
     */
    public Integer getSelectedMedidaProducto() {
        return selectedMedidaProducto;
    }

    /**
     * @param selectedMedidaProducto the selectedMedidaProducto to set
     */
    public void setSelectedMedidaProducto(Integer selectedMedidaProducto) {
        this.selectedMedidaProducto = selectedMedidaProducto;
    }

    /**
     * @return the productos
     */
    public List<ProductoVO> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the selectedProducto
     */
    public ProductoVO getSelectedProducto() {
        return selectedProducto;
    }

    /**
     * @param selectedProducto the selectedProducto to set
     */
    public void setSelectedProducto(ProductoVO selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    /**
     * @return the suministros
     */
    public List<SuministroVO> getSuministros() {
        return suministros;
    }

    /**
     * @param suministros the suministros to set
     */
    public void setSuministros(List<SuministroVO> suministros) {
        this.suministros = suministros;
    }

    /**
     * @return the droppedSuministros
     */
    public List<SuministroVO> getDroppedSuministros() {
        return droppedSuministros;
    }

    /**
     * @param droppedSuministros the droppedSuministros to set
     */
    public void setDroppedSuministros(List<SuministroVO> droppedSuministros) {
        this.droppedSuministros = droppedSuministros;
    }

    /**
     * @return the detalleProductoSuministroVO
     */
    public DetalleProductoSuministroVO getDetalleProductoSuministroVO() {
        return detalleProductoSuministroVO;
    }

    /**
     * @param detalleProductoSuministroVO the detalleProductoSuministroVO to set
     */
    public void setDetalleProductoSuministroVO(DetalleProductoSuministroVO detalleProductoSuministroVO) {
        this.detalleProductoSuministroVO = detalleProductoSuministroVO;
    }

    /**
     * @return the detalleProductoSuministroService
     */
    public DetalleProductoSuministroService getDetalleProductoSuministroService() {
        return detalleProductoSuministroService;
    }

    /**
     * @param detalleProductoSuministroService the
     * detalleProductoSuministroService to set
     */
    public void setDetalleProductoSuministroService(DetalleProductoSuministroService detalleProductoSuministroService) {
        this.detalleProductoSuministroService = detalleProductoSuministroService;
    }

    /**
     * @return the opcionBean
     */
    public OpcionBean getOpcionBean() {
        return opcionBean;
    }

    /**
     * @param opcionBean the opcionBean to set
     */
    public void setOpcionBean(OpcionBean opcionBean) {
        this.opcionBean = opcionBean;
    }

    /**
     * @return the detalleProductoSuministros
     */
    public List<DetalleProductoSuministroVO> getDetalleProductoSuministros() {
        return detalleProductoSuministros;
    }

    /**
     * @param detalleProductoSuministros the detalleProductoSuministros to set
     */
    public void setDetalleProductoSuministros(List<DetalleProductoSuministroVO> detalleProductoSuministros) {
        this.detalleProductoSuministros = detalleProductoSuministros;
    }

}
