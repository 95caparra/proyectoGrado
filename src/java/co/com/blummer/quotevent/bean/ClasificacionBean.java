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

@ManagedBean(name = "clasificacionBean")
@ViewScoped
public class ClasificacionBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    @PostConstruct
    public void init() {
        
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

}
