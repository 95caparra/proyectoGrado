package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.CiudadService;
import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.EstadoEventoService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.MedidaService;
import co.com.blummer.quotevent.modelo.service.RolService;
import co.com.blummer.quotevent.modelo.service.TipoDocumentoService;
import co.com.blummer.quotevent.modelo.service.TipoEventoService;
import co.com.blummer.quotevent.modelo.service.TipoProductoService;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
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
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "tipoDocumentoBean")
@ViewScoped
public class TipoDocumentoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private TipoProductoService tipoProductoService;
    private TipoProductoVO tipoProductoVO;
    private List<TipoProductoVO> tiposProducto;
    private TipoProductoVO selectedTipoProducto;
    private List<TipoProductoVO> tiposProductoFiltro;

    private TipoEventoService tipoEventoService;
    private TipoEventoVO tipoEventoVO;
    private List<TipoEventoVO> tiposEvento;
    private TipoEventoVO selectedTipoEvento;
    private List<TipoEventoVO> tiposEventoFiltro;

    private TipoDocumentoService tipoDocumentoService;
    private TipoDocumentoVO tipoDocumentoVO;
    private List<TipoDocumentoVO> tiposDocumento;
    private TipoDocumentoVO selectedTipoDocumento;
    private List<TipoDocumentoVO> tiposDocumentoFiltro;

    private RolService rolService;
    private RolVO rolVO;
    private List<RolVO> roles;
    private RolVO selectedRol;
    private List<RolVO> rolesFiltro;

    private MedidaService medidaService;
    private MedidaProductoVO medidaProductoVO;
    private List<MedidaProductoVO> medidas;
    private MedidaProductoVO selectedMedida;
    private List<MedidaProductoVO> medidasFiltro;

    private LugarService lugarService;
    private LugarVO lugarVO;
    private List<LugarVO> lugares;
    private LugarVO selectedLugar;
    private List<LugarVO> lugaresFiltro;

    private EstadoEventoService estadoEventoService;
    private EstadoEventoVO estadoEventoVO;
    private List<EstadoEventoVO> estadosEvento;
    private EstadoEventoVO selectedEstadoEvento;
    private List<EstadoEventoVO> estadosEventoFiltro;

    private ClasificacionService clasificacionService;
    private ClasificacionVO clasificacionVO;
    private List<ClasificacionVO> clasificaciones;
    private ClasificacionVO selectedClasificacion;
    private List<ClasificacionVO> clasificacionesFiltro;

    private CiudadService ciudadService;
    private CiudadVO ciudadVO;
    private List<CiudadVO> ciudades;
    private CiudadVO selectedCiudad;
    private List<CiudadVO> ciudadesFiltro;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                tipoProductoService = new TipoProductoService();
                tipoEventoService = new TipoEventoService();
                tipoDocumentoService = new TipoDocumentoService();
                rolService = new RolService();
                medidaService = new MedidaService();
                lugarService = new LugarService();
                estadoEventoService = new EstadoEventoService();
                clasificacionService = new ClasificacionService();
                ciudadService = new CiudadService();

                tiposProducto = tipoProductoService.listar();
                tiposDocumento = tipoDocumentoService.listar();
                tiposEvento = tipoEventoService.listar();
                roles = rolService.listar();
                medidas = medidaService.listar();
                lugares = lugarService.listar();
                estadosEvento = estadoEventoService.listar();
                clasificaciones = clasificacionService.listar();
                ciudades = ciudadService.listar();

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            /*LugarVO lugarVO = new LugarVO();
            lugares = lugarService.listar();
            lugares.add(lugarVO);*/
        } catch (Exception e) {
        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {

            this.init();
        } catch (Exception e) {
        }

    }

    public void onRowCancel(RowEditEvent event) {

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
     * @return the tipoProductoService
     */
    public TipoProductoService getTipoProductoService() {
        return tipoProductoService;
    }

    /**
     * @param tipoProductoService the tipoProductoService to set
     */
    public void setTipoProductoService(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    /**
     * @return the tipoProductoVO
     */
    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    /**
     * @param tipoProductoVO the tipoProductoVO to set
     */
    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
    }

    /**
     * @return the tiposProducto
     */
    public List<TipoProductoVO> getTiposProducto() {
        return tiposProducto;
    }

    /**
     * @param tiposProducto the tiposProducto to set
     */
    public void setTiposProducto(List<TipoProductoVO> tiposProducto) {
        this.tiposProducto = tiposProducto;
    }

    /**
     * @return the selectedTipoProducto
     */
    public TipoProductoVO getSelectedTipoProducto() {
        return selectedTipoProducto;
    }

    /**
     * @param selectedTipoProducto the selectedTipoProducto to set
     */
    public void setSelectedTipoProducto(TipoProductoVO selectedTipoProducto) {
        this.selectedTipoProducto = selectedTipoProducto;
    }

    /**
     * @return the tiposProductoFiltro
     */
    public List<TipoProductoVO> getTiposProductoFiltro() {
        return tiposProductoFiltro;
    }

    /**
     * @param tiposProductoFiltro the tiposProductoFiltro to set
     */
    public void setTiposProductoFiltro(List<TipoProductoVO> tiposProductoFiltro) {
        this.tiposProductoFiltro = tiposProductoFiltro;
    }

    /**
     * @return the tipoEventoService
     */
    public TipoEventoService getTipoEventoService() {
        return tipoEventoService;
    }

    /**
     * @param tipoEventoService the tipoEventoService to set
     */
    public void setTipoEventoService(TipoEventoService tipoEventoService) {
        this.tipoEventoService = tipoEventoService;
    }

    /**
     * @return the tipoEventoVO
     */
    public TipoEventoVO getTipoEventoVO() {
        return tipoEventoVO;
    }

    /**
     * @param tipoEventoVO the tipoEventoVO to set
     */
    public void setTipoEventoVO(TipoEventoVO tipoEventoVO) {
        this.tipoEventoVO = tipoEventoVO;
    }

    /**
     * @return the tiposEvento
     */
    public List<TipoEventoVO> getTiposEvento() {
        return tiposEvento;
    }

    /**
     * @param tiposEvento the tiposEvento to set
     */
    public void setTiposEvento(List<TipoEventoVO> tiposEvento) {
        this.tiposEvento = tiposEvento;
    }

    /**
     * @return the selectedTipoEvento
     */
    public TipoEventoVO getSelectedTipoEvento() {
        return selectedTipoEvento;
    }

    /**
     * @param selectedTipoEvento the selectedTipoEvento to set
     */
    public void setSelectedTipoEvento(TipoEventoVO selectedTipoEvento) {
        this.selectedTipoEvento = selectedTipoEvento;
    }

    /**
     * @return the tiposEventoFiltro
     */
    public List<TipoEventoVO> getTiposEventoFiltro() {
        return tiposEventoFiltro;
    }

    /**
     * @param tiposEventoFiltro the tiposEventoFiltro to set
     */
    public void setTiposEventoFiltro(List<TipoEventoVO> tiposEventoFiltro) {
        this.tiposEventoFiltro = tiposEventoFiltro;
    }

    /**
     * @return the tipoDocumentoService
     */
    public TipoDocumentoService getTipoDocumentoService() {
        return tipoDocumentoService;
    }

    /**
     * @param tipoDocumentoService the tipoDocumentoService to set
     */
    public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    /**
     * @return the tipoDocumentoVO
     */
    public TipoDocumentoVO getTipoDocumentoVO() {
        return tipoDocumentoVO;
    }

    /**
     * @param tipoDocumentoVO the tipoDocumentoVO to set
     */
    public void setTipoDocumentoVO(TipoDocumentoVO tipoDocumentoVO) {
        this.tipoDocumentoVO = tipoDocumentoVO;
    }

    /**
     * @return the tiposDocumento
     */
    public List<TipoDocumentoVO> getTiposDocumento() {
        return tiposDocumento;
    }

    /**
     * @param tiposDocumento the tiposDocumento to set
     */
    public void setTiposDocumento(List<TipoDocumentoVO> tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    /**
     * @return the selectedTipoDocumento
     */
    public TipoDocumentoVO getSelectedTipoDocumento() {
        return selectedTipoDocumento;
    }

    /**
     * @param selectedTipoDocumento the selectedTipoDocumento to set
     */
    public void setSelectedTipoDocumento(TipoDocumentoVO selectedTipoDocumento) {
        this.selectedTipoDocumento = selectedTipoDocumento;
    }

    /**
     * @return the tiposDocumentoFiltro
     */
    public List<TipoDocumentoVO> getTiposDocumentoFiltro() {
        return tiposDocumentoFiltro;
    }

    /**
     * @param tiposDocumentoFiltro the tiposDocumentoFiltro to set
     */
    public void setTiposDocumentoFiltro(List<TipoDocumentoVO> tiposDocumentoFiltro) {
        this.tiposDocumentoFiltro = tiposDocumentoFiltro;
    }

    /**
     * @return the rolService
     */
    public RolService getRolService() {
        return rolService;
    }

    /**
     * @param rolService the rolService to set
     */
    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

    /**
     * @return the rolVO
     */
    public RolVO getRolVO() {
        return rolVO;
    }

    /**
     * @param rolVO the rolVO to set
     */
    public void setRolVO(RolVO rolVO) {
        this.rolVO = rolVO;
    }

    /**
     * @return the roles
     */
    public List<RolVO> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<RolVO> roles) {
        this.roles = roles;
    }

    /**
     * @return the selectedRol
     */
    public RolVO getSelectedRol() {
        return selectedRol;
    }

    /**
     * @param selectedRol the selectedRol to set
     */
    public void setSelectedRol(RolVO selectedRol) {
        this.selectedRol = selectedRol;
    }

    /**
     * @return the rolesFiltro
     */
    public List<RolVO> getRolesFiltro() {
        return rolesFiltro;
    }

    /**
     * @param rolesFiltro the rolesFiltro to set
     */
    public void setRolesFiltro(List<RolVO> rolesFiltro) {
        this.rolesFiltro = rolesFiltro;
    }

    /**
     * @return the medidaService
     */
    public MedidaService getMedidaService() {
        return medidaService;
    }

    /**
     * @param medidaService the medidaService to set
     */
    public void setMedidaService(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    /**
     * @return the medidaProductoVO
     */
    public MedidaProductoVO getMedidaProductoVO() {
        return medidaProductoVO;
    }

    /**
     * @param medidaProductoVO the medidaProductoVO to set
     */
    public void setMedidaProductoVO(MedidaProductoVO medidaProductoVO) {
        this.medidaProductoVO = medidaProductoVO;
    }

    /**
     * @return the medidas
     */
    public List<MedidaProductoVO> getMedidas() {
        return medidas;
    }

    /**
     * @param medidas the medidas to set
     */
    public void setMedidas(List<MedidaProductoVO> medidas) {
        this.medidas = medidas;
    }

    /**
     * @return the selectedMedida
     */
    public MedidaProductoVO getSelectedMedida() {
        return selectedMedida;
    }

    /**
     * @param selectedMedida the selectedMedida to set
     */
    public void setSelectedMedida(MedidaProductoVO selectedMedida) {
        this.selectedMedida = selectedMedida;
    }

    /**
     * @return the medidasFiltro
     */
    public List<MedidaProductoVO> getMedidasFiltro() {
        return medidasFiltro;
    }

    /**
     * @param medidasFiltro the medidasFiltro to set
     */
    public void setMedidasFiltro(List<MedidaProductoVO> medidasFiltro) {
        this.medidasFiltro = medidasFiltro;
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
     * @return the lugarVO
     */
    public LugarVO getLugarVO() {
        return lugarVO;
    }

    /**
     * @param lugarVO the lugarVO to set
     */
    public void setLugarVO(LugarVO lugarVO) {
        this.lugarVO = lugarVO;
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
     * @return the selectedLugar
     */
    public LugarVO getSelectedLugar() {
        return selectedLugar;
    }

    /**
     * @param selectedLugar the selectedLugar to set
     */
    public void setSelectedLugar(LugarVO selectedLugar) {
        this.selectedLugar = selectedLugar;
    }

    /**
     * @return the lugaresFiltro
     */
    public List<LugarVO> getLugaresFiltro() {
        return lugaresFiltro;
    }

    /**
     * @param lugaresFiltro the lugaresFiltro to set
     */
    public void setLugaresFiltro(List<LugarVO> lugaresFiltro) {
        this.lugaresFiltro = lugaresFiltro;
    }

    /**
     * @return the estadoEventoService
     */
    public EstadoEventoService getEstadoEventoService() {
        return estadoEventoService;
    }

    /**
     * @param estadoEventoService the estadoEventoService to set
     */
    public void setEstadoEventoService(EstadoEventoService estadoEventoService) {
        this.estadoEventoService = estadoEventoService;
    }

    /**
     * @return the estadoEventoVO
     */
    public EstadoEventoVO getEstadoEventoVO() {
        return estadoEventoVO;
    }

    /**
     * @param estadoEventoVO the estadoEventoVO to set
     */
    public void setEstadoEventoVO(EstadoEventoVO estadoEventoVO) {
        this.estadoEventoVO = estadoEventoVO;
    }

    /**
     * @return the estadosEvento
     */
    public List<EstadoEventoVO> getEstadosEvento() {
        return estadosEvento;
    }

    /**
     * @param estadosEvento the estadosEvento to set
     */
    public void setEstadosEvento(List<EstadoEventoVO> estadosEvento) {
        this.estadosEvento = estadosEvento;
    }

    /**
     * @return the selectedEstadoEvento
     */
    public EstadoEventoVO getSelectedEstadoEvento() {
        return selectedEstadoEvento;
    }

    /**
     * @param selectedEstadoEvento the selectedEstadoEvento to set
     */
    public void setSelectedEstadoEvento(EstadoEventoVO selectedEstadoEvento) {
        this.selectedEstadoEvento = selectedEstadoEvento;
    }

    /**
     * @return the estadosEventoFiltro
     */
    public List<EstadoEventoVO> getEstadosEventoFiltro() {
        return estadosEventoFiltro;
    }

    /**
     * @param estadosEventoFiltro the estadosEventoFiltro to set
     */
    public void setEstadosEventoFiltro(List<EstadoEventoVO> estadosEventoFiltro) {
        this.estadosEventoFiltro = estadosEventoFiltro;
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
     * @return the clasificacionVO
     */
    public ClasificacionVO getClasificacionVO() {
        return clasificacionVO;
    }

    /**
     * @param clasificacionVO the clasificacionVO to set
     */
    public void setClasificacionVO(ClasificacionVO clasificacionVO) {
        this.clasificacionVO = clasificacionVO;
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
     * @return the selectedClasificacion
     */
    public ClasificacionVO getSelectedClasificacion() {
        return selectedClasificacion;
    }

    /**
     * @param selectedClasificacion the selectedClasificacion to set
     */
    public void setSelectedClasificacion(ClasificacionVO selectedClasificacion) {
        this.selectedClasificacion = selectedClasificacion;
    }

    /**
     * @return the clasificacionesFiltro
     */
    public List<ClasificacionVO> getClasificacionesFiltro() {
        return clasificacionesFiltro;
    }

    /**
     * @param clasificacionesFiltro the clasificacionesFiltro to set
     */
    public void setClasificacionesFiltro(List<ClasificacionVO> clasificacionesFiltro) {
        this.clasificacionesFiltro = clasificacionesFiltro;
    }

    /**
     * @return the ciudadService
     */
    public CiudadService getCiudadService() {
        return ciudadService;
    }

    /**
     * @param ciudadService the ciudadService to set
     */
    public void setCiudadService(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    /**
     * @return the ciudadVO
     */
    public CiudadVO getCiudadVO() {
        return ciudadVO;
    }

    /**
     * @param ciudadVO the ciudadVO to set
     */
    public void setCiudadVO(CiudadVO ciudadVO) {
        this.ciudadVO = ciudadVO;
    }

    /**
     * @return the ciudades
     */
    public List<CiudadVO> getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(List<CiudadVO> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the selectedCiudad
     */
    public CiudadVO getSelectedCiudad() {
        return selectedCiudad;
    }

    /**
     * @param selectedCiudad the selectedCiudad to set
     */
    public void setSelectedCiudad(CiudadVO selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    /**
     * @return the ciudadesFiltro
     */
    public List<CiudadVO> getCiudadesFiltro() {
        return ciudadesFiltro;
    }

    /**
     * @param ciudadesFiltro the ciudadesFiltro to set
     */
    public void setCiudadesFiltro(List<CiudadVO> ciudadesFiltro) {
        this.ciudadesFiltro = ciudadesFiltro;
    }

}
