package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.DetallePaqueteProductoService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
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

@ManagedBean(name = "paqueteBean")
@ViewScoped
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
    private String nombreFoto;
    private String nombrePdf;
    
    
    private Integer idPaquete;
    private PaqueteVO paqueteVO;

    private PaqueteService paqueteService;
    private OpcionBean opcionBean;

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

    private LoginBean login;
    private ClasificacionBean clasificacionBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
            clasificacionBean = application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class);

            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            try {
                //   FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                clasificacionService = new ClasificacionService();
                lugarService = new LugarService();
                paqueteService = new PaqueteService();
                productoService = new ProductoService();
                detallePaqueteProductoService = new DetallePaqueteProductoService();

                lugares = lugarService.listarLugar();
                clasificaciones = clasificacionService.listarClasificacion();
                productos = productoService.listar();
                paquetes = paqueteService.listar();

                droppedProductos = new ArrayList<ProductoVO>();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void onDrop(DragDropEvent ddEvent) {
        productoVO = ((ProductoVO) ddEvent.getData());

        droppedProductos.add(productoVO);
        productos.remove(productoVO);
    }

    public void insertarPaquete() throws Exception {
        try {
            paqueteVO = new PaqueteVO();

            paqueteVO.setNombre(nombre);
            paqueteVO.getClasificacionVO().setIdClasificacion(selectedClasificacion);
            paqueteVO.setDescripcion(descripcion);
            paqueteVO.getLugarVO().setIdLugar(selectedLugar);
            paqueteVO.setCantidadPersonas(cantidadPersonas);
            paqueteVO.setPrecio(precio);
            paqueteVO.setPdf(nombrePdf);
            paqueteVO.setFoto(nombreFoto);

            paqueteService.insertar(paqueteVO);

            int ultimoId = paqueteService.ultimoIdPaquete();

            for (ProductoVO p : droppedProductos) {

                detallePaqueteProductoVO = new DetallePaqueteProductoVO();

                detallePaqueteProductoVO.getPaqueteVO().setIdPaquete(ultimoId);
                detallePaqueteProductoVO.getProductoVO().setIdProducto(p.getIdProducto());
                detallePaqueteProductoVO.setCantidad(5);

                detallePaqueteProductoService.insertar(detallePaqueteProductoVO);
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
    
    public void actualizarPaquete() throws Exception {
        try {
            paqueteVO = new PaqueteVO();
            
            paqueteVO.setIdPaquete(idPaquete);
            paqueteVO.setNombre(nombre);
            paqueteVO.getClasificacionVO().setIdClasificacion(selectedClasificacion);
            paqueteVO.setDescripcion(descripcion);
            paqueteVO.getLugarVO().setIdLugar(selectedLugar);
            paqueteVO.setCantidadPersonas(cantidadPersonas);
            paqueteVO.setPrecio(precio);
            paqueteVO.setPdf(nombrePdf);
            paqueteVO.setFoto(nombreFoto);
            paqueteVO.setEstado("Activo");

            paqueteService.actualizar(paqueteVO);

            int ultimoId = paqueteService.ultimoIdPaquete();

            for (ProductoVO p : droppedProductos) {

                detallePaqueteProductoVO = new DetallePaqueteProductoVO();

                detallePaqueteProductoVO.getPaqueteVO().setIdPaquete(ultimoId);
                detallePaqueteProductoVO.getProductoVO().setIdProducto(p.getIdProducto());
                detallePaqueteProductoVO.setCantidad(5);

                //detallePaqueteProductoService.insertar(detallePaqueteProductoVO);
            }

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se actualizo "));

            RequestContext.getCurrentInstance().update("frmOpciones:growl");
            opcionBean.setearDetalles();
            opcionBean.setearOpciones();

        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }
    }

    public void verInformacionPaquete(Integer id) throws Exception {
        idPaquete = id;
        try {
            paqueteVO = paqueteService.consultarPorId(idPaquete);

            nombre = paqueteVO.getNombre();
            selectedClasificacion = paqueteVO.getClasificacionVO().getIdClasificacion();
            descripcion = paqueteVO.getDescripcion();
            selectedLugar = paqueteVO.getLugarVO().getIdLugar();
            cantidadPersonas = paqueteVO.getCantidadPersonas();
            precio = paqueteVO.getPrecio();
            nombrePdf = paqueteVO.getPdf();
            nombreFoto = paqueteVO.getFoto();
            
            
            opcionBean.verInfoPaquete();

            detallePaqueteProductos = detallePaqueteProductoService.listarPorId(idPaquete);

            for (DetallePaqueteProductoVO dpp : detallePaqueteProductos) {

                droppedProductos.add(productoService.consultarPorId(dpp.getProductoVO().getIdProducto()));
            }

        } catch (Exception e) {
            e.getMessage();
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
     * @return the idPaquete
     */
    public Integer getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaquete to set
     */
    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

}
