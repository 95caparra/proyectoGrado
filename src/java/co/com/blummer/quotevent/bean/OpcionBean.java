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

    @PostConstruct
    public void init() {

    }

    public void verPaquete() {
        setearOpciones();
        opcionPaquete = 1;
        RequestContext.getCurrentInstance().update("pnlConteido");
    }

    public void setearOpciones() {
        opcionPaquete = 0;
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

}
