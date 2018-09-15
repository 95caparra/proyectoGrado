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

    private int opcionPaquete;
    private int opcionProducto;
    private int opcionVerProducto;
    private int opcionVerSuministro;
    private int opcionInfoSuministro;
    private int opcionSuministro;

    @PostConstruct
    public void init() {

    }

    public void verPaquete() {
        setearOpciones();
        setearDetalles();
        opcionPaquete = 1;
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verProducto() {
        setearOpciones();
        setearDetalles();
        opcionProducto = 1;
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verListaProducto() {
        setearOpciones();
        setearDetalles();
        opcionVerProducto = 1;
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verSuministro() {
        setearOpciones();
        setearDetalles();
        opcionSuministro = 1;
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verListaSuministro() {
        setearOpciones();
        setearDetalles();
        opcionVerSuministro = 1;
        RequestContext.getCurrentInstance().update("pnlContenido");
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void verInfoSuministro() {
        setearDetalles();
        opcionInfoSuministro = 1;
        RequestContext.getCurrentInstance().update("pnlDetalles");
    }

    public void setearOpciones() {
        opcionPaquete = 0;
        opcionProducto = 0;
        opcionSuministro = 0;
        opcionVerProducto = 0;
        opcionVerSuministro = 0;
    }

    public void setearDetalles() {
        opcionInfoSuministro = 0;
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

}
