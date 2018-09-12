package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "paqueteBean")
@RequestScoped
public class PaqueteBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private String nombre;
    private Integer selectedClasificacion;
    private Integer selectedLugar;
    private String descripcion;
    private Integer cantidadPersonas;
    private Double precio;
    private UploadedFile pdf;
    private UploadedFile foto;

    private PaqueteVO paqueteVO;
    private PaqueteService paqueteService;

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
            setClasificacion(application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class));
            try {
                clasificacionService = new ClasificacionService();
                lugarService = new LugarService();
                paqueteService = new PaqueteService();

                lugares = lugarService.listarLugar();
                clasificaciones = clasificacionService.listarClasificacion();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertarPaquete() throws Exception {
        try {
            paqueteVO = new PaqueteVO();

            paqueteVO.setNombre(nombre);
            paqueteVO.setIdClasificacion(selectedClasificacion);
            paqueteVO.setDescripcion(descripcion);
            paqueteVO.setIdLugar(selectedLugar);
            paqueteVO.setCantidadPersonas(cantidadPersonas);
            paqueteVO.setPrecio(precio);

            if (pdf != null) {
                paqueteVO.setPdf(pdf.getFileName());
            }

            if (foto != null) {
                paqueteVO.setFoto(foto.getFileName());
            }

            paqueteService.insertar(paqueteVO);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                            "se guardó "));
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }

    }

    public void fileUploadListener(FileUploadEvent e) {
        // Get uploaded file from the FileUploadEvent
        foto = e.getFile();
        pdf = e.getFile();
        // Print out the information of the file
        System.out.println("PDF " + pdf.getFileName() + " :: Uploaded File Size :: " + pdf.getSize());
        System.out.println("FOTO " + foto.getFileName() + " :: Uploaded File Size :: " + foto.getSize());
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
     * @return the selectedClasificacion
     */
    public Integer getSelectedClasificacion() {
        return selectedClasificacion;
    }

    /**
     * @param selectedClasificacion the selectedClasificacion to set
     */
    public void setSelectedClasificacion(Integer selectedClasificacion) {
        this.selectedClasificacion = selectedClasificacion;
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
     * @return the selectedLugar
     */
    public Integer getSelectedLugar() {
        return selectedLugar;
    }

    /**
     * @param selectedLugar the selectedLugar to set
     */
    public void setSelectedLugar(Integer selectedLugar) {
        this.selectedLugar = selectedLugar;
    }

    /**
     * @return the cantidadPersonas
     */
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * @param cantidadPersonas the cantidadPersonas to set
     */
    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the pdf
     */
    public UploadedFile getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(UploadedFile pdf) {
        this.pdf = pdf;
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
     * @return the clasificacion
     */
    public ClasificacionBean getClasificacion() {
        return clasificacionBean;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
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
     * @return the paqueteService
     */
    public PaqueteService getPaqueteService() {
        return paqueteService;
    }

    /**
     * @param paqueteService the paqueteService to set
     */
    public void setPaqueteService(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

}
