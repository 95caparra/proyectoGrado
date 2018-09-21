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

@ManagedBean(name = "lugarBean")
@ViewScoped
public class LugarBean implements Serializable {
	private static final long serialVersionUID = 4545919119678482516L;
        
        
	@PostConstruct
	public void init() {
            
	}
}
