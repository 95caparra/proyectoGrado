package co.com.blummer.quotevent.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private String usuario;
    private String password;
    private String ipCliente;

    @ManagedProperty(value = "#{navegacionBean}")
    private NavegacionBean navegacionBean;

    @PostConstruct
    public void init() {
        usuario = new String();
        password = new String();
    }

    public String doLogin() {

        if (usuario.equals("cochoa")) {
            if (password.equals("1234")) {
                return navegacionBean.redireccionInicio;
            }
        }
        return "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NavegacionBean getNavegacionBean() {
        return navegacionBean;
    }

    public void setNavegacionBean(NavegacionBean navegacionBean) {
        this.navegacionBean = navegacionBean;
    }

    public String getIpCliente() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

}
