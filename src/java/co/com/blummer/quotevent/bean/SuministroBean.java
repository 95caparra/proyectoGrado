package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.MedidaService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.SuministroService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
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
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "suministroBean")
@ViewScoped
public class SuministroBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idSuministro;
    private String nombre;
    private UploadedFile foto;
    private String nombreFoto;
    private Integer cantidad;
    private Integer cantidadMinima;
    private MedidaProductoVO medidaProductoVO;
    private Double precioUnidad;
    private String observaciones;
    private String estado;

    private Integer selectedMedida;

    private SuministroVO suministroVO;
    private SuministroService suministroService;

    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;

    private MedidaService medidaService;
    private List<MedidaProductoVO> medidas;
    private List<SuministroVO> suministros;

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
            setClasificacionBean(application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class));
            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            try {
                //  FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                medidaService = new MedidaService();
                suministroService = new SuministroService();

                medidas = medidaService.listar();
                suministros = suministroService.listar();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertarSuministro() throws Exception {
        try {
            suministroVO = new SuministroVO();

            suministroVO.setNombre(nombre);
            suministroVO.setFoto(nombreFoto);
            suministroVO.setCantidad(cantidad);
            suministroVO.setCantidadMinima(cantidadMinima);
            suministroVO.getMedidaProductoVO().setMedidaProducto(selectedMedida);
            suministroVO.setPrecioUnidad(precioUnidad);
            suministroVO.setObservaciones(observaciones);

            suministroService.insertar(suministroVO);

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

    public void verInformacionSuministro(Integer id) throws Exception {
        try {
            suministroVO = suministroService.consultarPorId(id);

            nombre = suministroVO.getNombre();
            nombreFoto = suministroVO.getFoto();
            cantidad = suministroVO.getCantidad();
            cantidadMinima = suministroVO.getCantidadMinima();
            selectedMedida = suministroVO.getMedidaProductoVO().getMedidaProducto();
            precioUnidad = suministroVO.getPrecioUnidad();
            observaciones = suministroVO.getObservaciones();

            opcionBean.verInfoSuministro();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }
    }

    /**
     * @return the idSuministro
     */
    public Integer getIdSuministro() {
        return idSuministro;
    }

    /**
     * @param idSuministro the idSuministro to set
     */
    public void setIdSuministro(Integer idSuministro) {
        this.idSuministro = idSuministro;
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
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the cantidadMinima
     */
    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * @param cantidadMinima the cantidadMinima to set
     */
    public void setCantidadMinima(Integer cantidadMinima) {
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
     * @return the SuministroVO
     */
    public SuministroVO getSuministroVO() {
        return suministroVO;
    }

    /**
     * @param paqueteVO the paqueteVO to set
     */
    public void setSuministroVO(SuministroVO suministroVO) {
        this.suministroVO = suministroVO;
    }

    /**
     * @return the paqueteService
     */
    public SuministroService getSuministroService() {
        return suministroService;
    }

    /**
     * @param paqueteService the paqueteService to set
     */
    public void setSuministroService(SuministroService suministro) {
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
     * @return the selectedMedida
     */
    public Integer getSelectedMedida() {
        return selectedMedida;
    }

    /**
     * @param selectedMedida the selectedMedida to set
     */
    public void setSelectedMedida(Integer selectedMedida) {
        this.selectedMedida = selectedMedida;
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

}
