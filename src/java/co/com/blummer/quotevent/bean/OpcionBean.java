package co.com.blummer.quotevent.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import java.util.List;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "opcionBean")
@ViewScoped
public class OpcionBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private int opcionSolicitudes;
    private int opcionPaquete;
    private int opcionProducto;
    private int opcionInfoProducto;
    private int opcionVerProducto;
    private int opcionVerSuministro;
    private int opcionEvento;
    private int opcionVerEvento;
    private int opcionVerCliente;
    private int opcionVerEmpleado;
    private int opcionVerProveedor;
    private int opcionVerUsuario;
    private int opcionVerPaquete;
    private int opcionInfoSuministro;
    private int opcionInfoSolicitud;
    private int opcionInfoPaquete;
    private int opcionSuministro;

    private SuministroBean suministroBean;
    private SolicitudBean solicitudBean;
    private ProductoBean productoBean;
    private PaqueteBean paqueteBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            try {
                opcionSolicitudes = 1;
                suministroBean = application.evaluateExpressionGet(context, "#{suministroBean}", SuministroBean.class);
                productoBean = application.evaluateExpressionGet(context, "#{productoBean}", ProductoBean.class);
                paqueteBean = application.evaluateExpressionGet(context, "#{paqueteBean}", PaqueteBean.class);
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public void verPaquete() {
        setearOpciones();
        setearDetalles();
        opcionPaquete = 1;
        paqueteBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verEvento() {
        setearOpciones();
        setearDetalles();
        opcionEvento = 1;
        paqueteBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verListaPaquete() {
        setearOpciones();
        setearDetalles();
        opcionVerPaquete = 1;
        paqueteBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");

    }
    
    public void verListaEvento() {
        setearOpciones();
        setearDetalles();
        opcionVerEvento = 1;   
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verListaCliente() {
        setearOpciones();
        setearDetalles();
        opcionVerCliente = 1;   
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verListaEmpleado() {
        setearOpciones();
        setearDetalles();
        opcionVerEmpleado = 1;   
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verListaProveedor() {
        setearOpciones();
        setearDetalles();
        opcionVerProveedor = 1;   
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verListaUsuario() {
        setearOpciones();
        setearDetalles();
        setOpcionVerUsuario(1);   
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verInfoPaquete() {
        setearDetalles();
        opcionInfoPaquete = 1;
        paqueteBean.init();
        RequestContext.getCurrentInstance().update("pnlDetalles");
        RequestContext.getCurrentInstance().update("pnlInformacionProductosSolicitud");
    }

    public void verProducto() {
        setearOpciones();
        setearDetalles();
        opcionProducto = 1;
        productoBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verListaProducto() {
        setearOpciones();
        setearDetalles();
        opcionVerProducto = 1;
        productoBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verInfoProducto() {
        setearDetalles();
        opcionInfoProducto = 1;
        productoBean.init();
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verSuministro() throws IOException {
        setearOpciones();
        setearDetalles();
        opcionSuministro = 1;
        suministroBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verListaSuministro() {
        setearOpciones();
        setearDetalles();
        opcionVerSuministro = 1;
        suministroBean.init();
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verInfoSuministro() {
        setearDetalles();
        opcionInfoSuministro = 1;
        suministroBean.init();
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }
    
    public void verInfoSolicitud() {
        setearDetalles();
        opcionInfoSolicitud = 1;
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void setearOpciones() {
        opcionPaquete = 0;
        opcionProducto = 0;
        opcionSuministro = 0;
        opcionVerProducto = 0;
        opcionVerSuministro = 0;
        opcionVerPaquete = 0;
        opcionSolicitudes = 0;
        opcionVerEvento = 0;
        opcionVerProveedor = 0;
        opcionVerEmpleado = 0;
        opcionVerCliente = 0;
        setOpcionVerUsuario(0);
    }

    public void setearDetalles() {
        opcionInfoSuministro = 0;
        opcionInfoProducto = 0;
        opcionInfoPaquete = 0;
        opcionInfoSolicitud = 0;
        opcionEvento = 0;
    }

    public void volverInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
        } catch (Exception e) {
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
     * @return the opcionPaquete
     */
    public int getOpcionPaquete() {
        return opcionPaquete;
    }

    /**
     * @param opcionPaquete the opcionPaquete to set
     */
    public void setOpcionPaquete(int opcionPaquete) {
        this.opcionPaquete = opcionPaquete;
    }

    /**
     * @return the opcionProducto
     */
    public int getOpcionProducto() {
        return opcionProducto;
    }

    /**
     * @param opcionProducto the opcionProducto to set
     */
    public void setOpcionProducto(int opcionProducto) {
        this.opcionProducto = opcionProducto;
    }

    /**
     * @return the opcionSuministro
     */
    public int getOpcionSuministro() {
        return opcionSuministro;
    }

    /**
     * @param opcionSuministro the opcionSuministro to set
     */
    public void setOpcionSuministro(int opcionSuministro) {
        this.opcionSuministro = opcionSuministro;
    }

    /**
     * @return the opcionVerProducto
     */
    public int getOpcionVerProducto() {
        return opcionVerProducto;
    }

    /**
     * @param opcionVerProducto the opcionVerProducto to set
     */
    public void setOpcionVerProducto(int opcionVerProducto) {
        this.opcionVerProducto = opcionVerProducto;
    }

    /**
     * @return the opcionVerSuministro
     */
    public int getOpcionVerSuministro() {
        return opcionVerSuministro;
    }

    /**
     * @param opcionVerSuministro the opcionVerSuministro to set
     */
    public void setOpcionVerSuministro(int opcionVerSuministro) {
        this.opcionVerSuministro = opcionVerSuministro;
    }

    /**
     * @return the opcionInfoSuministro
     */
    public int getOpcionInfoSuministro() {
        return opcionInfoSuministro;
    }

    /**
     * @param opcionInfoSuministro the opcionInfoSuministro to set
     */
    public void setOpcionInfoSuministro(int opcionInfoSuministro) {
        this.opcionInfoSuministro = opcionInfoSuministro;
    }

    /**
     * @return the opcionInfoProducto
     */
    public int getOpcionInfoProducto() {
        return opcionInfoProducto;
    }

    /**
     * @param opcionInfoProducto the opcionInfoProducto to set
     */
    public void setOpcionInfoProducto(int opcionInfoProducto) {
        this.opcionInfoProducto = opcionInfoProducto;
    }

    /**
     * @return the opcionVerPaquete
     */
    public int getOpcionVerPaquete() {
        return opcionVerPaquete;
    }

    /**
     * @param opcionVerPaquete the opcionVerPaquete to set
     */
    public void setOpcionVerPaquete(int opcionVerPaquete) {
        this.opcionVerPaquete = opcionVerPaquete;
    }

    /**
     * @return the opcionInfoPaquete
     */
    public int getOpcionInfoPaquete() {
        return opcionInfoPaquete;
    }

    /**
     * @param opcionInfoPaquete the opcionInfoPaquete to set
     */
    public void setOpcionInfoPaquete(int opcionInfoPaquete) {
        this.opcionInfoPaquete = opcionInfoPaquete;
    }

    /**
     * @return the suministroBean
     */
    public SuministroBean getSuministroBean() {
        return suministroBean;
    }

    /**
     * @param suministroBean the suministroBean to set
     */
    public void setSuministroBean(SuministroBean suministroBean) {
        this.suministroBean = suministroBean;
    }

    /**
     * @return the productoBean
     */
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    /**
     * @param productoBean the productoBean to set
     */
    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
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
     * @return the opcionSolicitudes
     */
    public int getOpcionSolicitudes() {
        return opcionSolicitudes;
    }

    /**
     * @param opcionSolicitudes the opcionSolicitudes to set
     */
    public void setOpcionSolicitudes(int opcionSolicitudes) {
        this.opcionSolicitudes = opcionSolicitudes;
    }

    /**
     * @return the opcionInfoSolicitud
     */
    public int getOpcionInfoSolicitud() {
        return opcionInfoSolicitud;
    }

    /**
     * @param opcionInfoSolicitud the opcionInfoSolicitud to set
     */
    public void setOpcionInfoSolicitud(int opcionInfoSolicitud) {
        this.opcionInfoSolicitud = opcionInfoSolicitud;
    }

    /**
     * @return the solicitudBean
     */
    public SolicitudBean getSolicitudBean() {
        return solicitudBean;
    }

    /**
     * @param solicitudBean the solicitudBean to set
     */
    public void setSolicitudBean(SolicitudBean solicitudBean) {
        this.solicitudBean = solicitudBean;
    }

    /**
     * @return the opcionEvento
     */
    public int getOpcionEvento() {
        return opcionEvento;
    }

    /**
     * @param opcionEvento the opcionEvento to set
     */
    public void setOpcionEvento(int opcionEvento) {
        this.opcionEvento = opcionEvento;
    }

    /**
     * @return the opcionVerEvento
     */
    public int getOpcionVerEvento() {
        return opcionVerEvento;
    }

    /**
     * @param opcionVerEvento the opcionVerEvento to set
     */
    public void setOpcionVerEvento(int opcionVerEvento) {
        this.opcionVerEvento = opcionVerEvento;
    }

    /**
     * @return the opcionVerCliente
     */
    public int getOpcionVerCliente() {
        return opcionVerCliente;
    }

    /**
     * @param opcionVerCliente the opcionVerCliente to set
     */
    public void setOpcionVerCliente(int opcionVerCliente) {
        this.opcionVerCliente = opcionVerCliente;
    }

    /**
     * @return the opcionVerEmpleado
     */
    public int getOpcionVerEmpleado() {
        return opcionVerEmpleado;
    }

    /**
     * @param opcionVerEmpleado the opcionVerEmpleado to set
     */
    public void setOpcionVerEmpleado(int opcionVerEmpleado) {
        this.opcionVerEmpleado = opcionVerEmpleado;
    }

    /**
     * @return the opcionVerProveedor
     */
    public int getOpcionVerProveedor() {
        return opcionVerProveedor;
    }

    /**
     * @param opcionVerProveedor the opcionVerProveedor to set
     */
    public void setOpcionVerProveedor(int opcionVerProveedor) {
        this.opcionVerProveedor = opcionVerProveedor;
    }

    /**
     * @return the opcionVerUsuario
     */
    public int getOpcionVerUsuario() {
        return opcionVerUsuario;
    }

    /**
     * @param opcionVerUsuario the opcionVerUsuario to set
     */
    public void setOpcionVerUsuario(int opcionVerUsuario) {
        this.opcionVerUsuario = opcionVerUsuario;
    }

    

}
