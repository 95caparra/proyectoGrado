package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.DetallePaqueteProductoService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.service.SolicitudService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import co.com.blummer.quotevent.util.GenerarPDF;
import co.com.blummer.quotevent.util.Mail;
import co.com.blummer.quotevent.util.Path;
import static groovy.xml.Entity.reg;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "solicitudBean")
@ViewScoped
public class SolicitudBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private String nombreCliente;
    private Integer cantidadPersonas;
    private String telefono;
    private String email;
    private String hora;
    private Date fecha;
    private String observaciones;
    private byte visto;

    private String nombreFoto;
    private String nombrePdf;
    private String telefonoCliente;
    private String tipoEvento;
    private String nombrePaquete;
    private Double precioPaquete;
    private Integer cantidadPersonasPaquete;

    private PaqueteVO paqueteVO;
    private SolicitudVO solicitudVO;
    private SolicitudVO selectedSolicitud;

    private PaqueteService paqueteService;
    private SolicitudService solicitudService;
    private OpcionBean opcionBean;

    private Integer idSolicitud;

    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;
    private List<PaqueteVO> paquetes;

    private List<ProductoVO> productos;
    private ProductoVO productoVO;
    private ProductoService productoService;
    private List<ProductoVO> droppedProductos;
    private DetallePaqueteProductoVO detallePaqueteProductoVO;
    private DetallePaqueteProductoService detallePaqueteProductoService;
    private List<DetallePaqueteProductoVO> detallePaqueteProductos;
    private LugarService lugarService;
    private List<LugarVO> lugares;

    private List<SolicitudVO> solicitudes;
    private List<SolicitudVO> solicitudesFiltro;

    private LoginBean login;
    private ClasificacionBean clasificacionBean;
    private PaqueteBean paqueteBean;

    private GenerarPDF generarPDF;
    private Mail mail;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
            clasificacionBean = application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class);

            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            paqueteBean = application.evaluateExpressionGet(context, "#{paqueteBean}", PaqueteBean.class);
            try {
                //   FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                clasificacionService = new ClasificacionService();
                lugarService = new LugarService();
                paqueteService = new PaqueteService();
                productoService = new ProductoService();
                solicitudService = new SolicitudService();
                detallePaqueteProductoService = new DetallePaqueteProductoService();

                lugares = lugarService.listarLugar();
                clasificaciones = clasificacionService.listarClasificacion();
                productos = productoService.listar();
                paquetes = paqueteService.listar();

                solicitudes = solicitudService.listar();

                droppedProductos = new ArrayList<ProductoVO>();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void generarPDF() {
        try {
            generarPDF = new GenerarPDF();
            mail = new Mail();

            String rutaImagen = Path.getPathArchivos() + "\\" + "imagenesProductos" + "\\" + "matrimonio.jpg";

            String salida = Path.getPathArchivos() + "\\" + "imagenesProductos" + "\\" + "prueba.pdf";

            String contenido = " ";
            generarPDF.createPDF("Titulo", contenido, "Pie de pagina", rutaImagen, salida);

            mail.envioCorreoCliente("95camilo.ochoa@gmail.com", "cotización", "esta es una preuba", salida);

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
        }

    }

    public void consultarPorId() {
        try {
            idSolicitud = selectedSolicitud.getIdSolicitud();

            solicitudVO = solicitudService.consultarPorId(idSolicitud);

            nombreCliente = solicitudVO.getNombreCliente();
            nombreFoto = solicitudVO.getPaqueteVO().getFoto();
            telefonoCliente = solicitudVO.getTelefono();
            email = solicitudVO.getEmail();
            nombrePaquete = solicitudVO.getPaqueteVO().getNombre();
            precioPaquete = solicitudVO.getPaqueteVO().getPrecio();
            cantidadPersonasPaquete = solicitudVO.getPaqueteVO().getCantidadPersonas();
            fecha = solicitudVO.getFecha();
            observaciones = solicitudVO.getObservaciones();

            opcionBean.verInfoSolicitud();
        } catch (Exception e) {
        }
    }

    public void formularioDatos() {
        try {
            RequestContext.getCurrentInstance().update("pnlDatosSolicitud");
        } catch (Exception e) {
        }
    }

    public void onDrop(DragDropEvent ddEvent) {
        productoVO = ((ProductoVO) ddEvent.getData());

        droppedProductos.add(productoVO);
        productos.remove(productoVO);
    }

    public void insertarSolicitud() throws Exception {
        try {
            solicitudVO = new SolicitudVO();
            paqueteVO = new PaqueteVO();
            int id = 0;
            if (paqueteBean.getIdPaquete() != null) {
                id = paqueteBean.getIdPaquete();
            } else {
                id = paqueteService.ultimoIdPaquete();
            }

            paqueteVO = paqueteService.consultarPorId(id);

            solicitudVO.setNombreCliente(nombreCliente);
            solicitudVO.setCantidadPersonas(cantidadPersonas);
            solicitudVO.setTelefono(telefono);
            solicitudVO.getTipoEventoVO().setIdTipoEvento(paqueteVO.getClasificacionVO().getIdClasificacion());
            solicitudVO.getPaqueteVO().setIdPaquete(paqueteVO.getIdPaquete());
            solicitudVO.setEmail(email);
            solicitudVO.setHora(hora);
            solicitudVO.setFecha(new java.sql.Date(fecha.getTime()));
            solicitudVO.setObservaciones(observaciones);
            solicitudVO.setVisto(0);

            solicitudService.insertar(solicitudVO);

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
     * @return the droppedProductos
     */
    public List<ProductoVO> getDroppedProductos() {
        return droppedProductos;
    }

    /**
     * @param droppedProductos the droppedProductos to set
     */
    public void setDroppedProductos(List<ProductoVO> droppedProductos) {
        this.droppedProductos = droppedProductos;
    }

    /**
     * @return the detallePaqueteProductoVO
     */
    public DetallePaqueteProductoVO getDetallePaqueteProductoVO() {
        return detallePaqueteProductoVO;
    }

    /**
     * @param detallePaqueteProductoVO the detallePaqueteProductoVO to set
     */
    public void setDetallePaqueteProductoVO(DetallePaqueteProductoVO detallePaqueteProductoVO) {
        this.detallePaqueteProductoVO = detallePaqueteProductoVO;
    }

    /**
     * @return the detallePaqueteProductoService
     */
    public DetallePaqueteProductoService getDetallePaqueteProductoService() {
        return detallePaqueteProductoService;
    }

    /**
     * @param detallePaqueteProductoService the detallePaqueteProductoService to
     * set
     */
    public void setDetallePaqueteProductoService(DetallePaqueteProductoService detallePaqueteProductoService) {
        this.detallePaqueteProductoService = detallePaqueteProductoService;
    }

    /**
     * @return the paquetes
     */
    public List<PaqueteVO> getPaquetes() {
        return paquetes;
    }

    /**
     * @param paquetes the paquetes to set
     */
    public void setPaquetes(List<PaqueteVO> paquetes) {
        this.paquetes = paquetes;
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
     * @return the detallePaqueteProductos
     */
    public List<DetallePaqueteProductoVO> getDetallePaqueteProductos() {
        return detallePaqueteProductos;
    }

    /**
     * @param detallePaqueteProductos the detallePaqueteProductos to set
     */
    public void setDetallePaqueteProductos(List<DetallePaqueteProductoVO> detallePaqueteProductos) {
        this.detallePaqueteProductos = detallePaqueteProductos;
    }

    /**
     * @return the solicitudVO
     */
    public SolicitudVO getSolicitudVO() {
        return solicitudVO;
    }

    /**
     * @param solicitudVO the solicitudVO to set
     */
    public void setSolicitudVO(SolicitudVO solicitudVO) {
        this.solicitudVO = solicitudVO;
    }

    /**
     * @return the solicitudService
     */
    public SolicitudService getSolicitudService() {
        return solicitudService;
    }

    /**
     * @param solicitudService the solicitudService to set
     */
    public void setSolicitudService(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @return the visto
     */
    public byte getVisto() {
        return visto;
    }

    /**
     * @param visto the visto to set
     */
    public void setVisto(byte visto) {
        this.visto = visto;
    }

    /**
     * @return the paqueteVO
     */
    public PaqueteVO getPaqueteVO() {
        return paqueteVO;
    }

    /**
     * @param paqueteVO the paqueteVO to set
     */
    public void setPaqueteVO(PaqueteVO paqueteVO) {
        this.paqueteVO = paqueteVO;
    }

    /**
     * @return the paqueteBean
     */
    public PaqueteBean getPaqueteBean() {
        return paqueteBean;
    }

    /**
     * @param paqueteBean the paqueteBean to set
     */
    public void setPaqueteBean(PaqueteBean paqueteBean) {
        this.paqueteBean = paqueteBean;
    }

    /**
     * @return the solicitudes
     */
    public List<SolicitudVO> getSolicitudes() {
        return solicitudes;
    }

    /**
     * @param solicitudes the solicitudes to set
     */
    public void setSolicitudes(List<SolicitudVO> solicitudes) {
        this.solicitudes = solicitudes;
    }

    /**
     * @return the selectedSolicitud
     */
    public SolicitudVO getSelectedSolicitud() {
        return selectedSolicitud;
    }

    /**
     * @param selectedSolicitud the selectedSolicitud to set
     */
    public void setSelectedSolicitud(SolicitudVO selectedSolicitud) {
        this.selectedSolicitud = selectedSolicitud;
    }

    /**
     * @return the solicitudesFiltro
     */
    public List<SolicitudVO> getSolicitudesFiltro() {
        return solicitudesFiltro;
    }

    /**
     * @param solicitudesFiltro the solicitudesFiltro to set
     */
    public void setSolicitudesFiltro(List<SolicitudVO> solicitudesFiltro) {
        this.solicitudesFiltro = solicitudesFiltro;
    }

    /**
     * @return the idSolicitud
     */
    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
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
     * @return the nombrePdf
     */
    public String getNombrePdf() {
        return nombrePdf;
    }

    /**
     * @param nombrePdf the nombrePdf to set
     */
    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

    /**
     * @return the telefonoCliente
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * @param telefonoCliente the telefonoCliente to set
     */
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    /**
     * @return the tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * @param tipoEvento the tipoEvento to set
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @return the nombrePaquete
     */
    public String getNombrePaquete() {
        return nombrePaquete;
    }

    /**
     * @param nombrePaquete the nombrePaquete to set
     */
    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    /**
     * @return the precioPaquete
     */
    public Double getPrecioPaquete() {
        return precioPaquete;
    }

    /**
     * @param precioPaquete the precioPaquete to set
     */
    public void setPrecioPaquete(Double precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    /**
     * @return the cantidadPersonasPaquete
     */
    public Integer getCantidadPersonasPaquete() {
        return cantidadPersonasPaquete;
    }

    /**
     * @param cantidadPersonasPaquete the cantidadPersonasPaquete to set
     */
    public void setCantidadPersonasPaquete(Integer cantidadPersonasPaquete) {
        this.cantidadPersonasPaquete = cantidadPersonasPaquete;
    }

    /**
     * @return the generarPDF
     */
    public GenerarPDF getGenerarPDF() {
        return generarPDF;
    }

    /**
     * @param generarPDF the generarPDF to set
     */
    public void setGenerarPDF(GenerarPDF generarPDF) {
        this.generarPDF = generarPDF;
    }

    /**
     * @return the mail
     */
    public Mail getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(Mail mail) {
        this.mail = mail;
    }

}
