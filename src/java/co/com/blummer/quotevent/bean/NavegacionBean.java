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


@ManagedBean(name = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {
	private static final long serialVersionUID = 4545919119678482516L;

	private String ruta;
	private Integer pagina;
	private Integer tipificacion;
	private Integer tabActivo;
	private boolean render;

	public static final String redireccionInicio = "/pages/inicio/inicio.xhmtl?faces-redirect=true";
        //public static final String redireccionInicio = "/pages/paquete/insertarPaquete.xhmtl?faces-redirect=true";
	public static final String redireccionGestion = "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	public static final String redireccionUrl = "/pages/obligacion/obligacion.xhtml?faces-redirect=true";
	public static final String redireccionUrlNoExiste = "/pages/cliente/clienteNoExiste.xhtml?faces-redirect=true";

	@PostConstruct
	public void init() {
		tabActivo = 0;
		pagina = 2;
		render = false;
	}
        
	public void redireccionFinGestion() throws Exception {
		tipificacion = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		LoginBean loginBean = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("../../pages/finGestion/finGestion.xhtml?faces-redirect=true");
		// FacesContext.getCurrentInstance().getExternalContext().redirect("http://"+loginBean.getIpCliente()+":80/apiagentbox?action=chur&cod=LE&comm=FIN_LLAMADA");

	}

	public void redireccionRegresar() throws Exception {
		tipificacion = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		LoginBean loginBean = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("../../pages/obligacion/obligacion.xhtml");
		// FacesContext.getCurrentInstance().getExternalContext().redirect("http://"+loginBean.getIpCliente()+":80/apiagentbox?action=chur&cod=LE&comm=FIN_LLAMADA");

	}

	public void redireccionBusquueda() throws Exception {
		pagina = 1;
		RequestContext.getCurrentInstance().update("frmBuscar:contenidoBusqueda");
	}

	public void redireccionFinNC() throws Exception {
		pagina = 8;
		RequestContext.getCurrentInstance().update("frmNoContacto:pnlNoContacto");
	}

	public void redireccionObligacion() throws Exception {
		pagina = 2;
		RequestContext.getCurrentInstance().update("contenido");
	}

	public void redireccionGestionNoContacto() throws Exception {
		tipificacion = 1;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionPromesa() throws Exception {
		tipificacion = 2;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionYaPago() throws Exception {
		tipificacion = 3;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionReclamo() throws Exception {
		tipificacion = 4;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionOtro() throws Exception {
		tipificacion = 5;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionTercero() throws Exception {
		tipificacion = 6;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionAcuerdoComite() throws Exception {
		tipificacion = 7;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionComite() throws Exception {
		tipificacion = 8;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(Integer tipificacion) {
		this.tipificacion = tipificacion;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public Integer getTabActivo() {
		return tabActivo;
	}

	public void setTabActivo(Integer tabActivo) {
		this.tabActivo = tabActivo;
	}

	public void clienteNoExiste() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("../../pages/obligacion/obligacion.xhtml");
	}

        
        
}
