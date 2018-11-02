package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.UsuarioService;
import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
    private UsuarioService usuarioService;
    private UsuarioVO usuarioVO;

    @ManagedProperty(value = "#{navegacionBean}")
    private NavegacionBean navegacionBean;

    @PostConstruct
    public void init() {
        usuario = new String();
        password = new String();
        usuarioService = new UsuarioService();
    }

    public boolean estaAutenticado() throws Exception {
        boolean autenticado = false;
        usuarioVO = usuarioService.autenticarUsuario(usuario, password);
        if (usuario != null && !usuario.equals("")) {
            if (usuarioVO != null) {
                autenticado = true;
            } else {
                autenticado = false;
            }
        } else {
            autenticado = false;
        }
        return autenticado;
    }

    public String doLogin() throws Exception {
            if (estaAutenticado()) {
            return navegacionBean.redireccionInicio;
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o clave incorrecto"));
        }
        return "";
    }

    public void doLoginPaquetes(Integer id) throws Exception {
         navegacionBean.redireccionarDatosPaquete(id);
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

    /**
     * @return the usuarioService
     */
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    /**
     * @param usuarioService the usuarioService to set
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * @return the usuarioVO
     */
    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    /**
     * @param usuarioVO the usuarioVO to set
     */
    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

}
