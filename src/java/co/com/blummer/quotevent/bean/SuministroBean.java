package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.DetalleSuministroProveedorService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.MedidaService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProveedorService;
import co.com.blummer.quotevent.modelo.service.SuministroService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProveedorVO;
import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;

import co.com.blummer.quotevent.util.Path;
import co.com.blummer.quotevent.webservices.ServicioMedidaProducto;
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
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "suministroBean")
@ViewScoped
public class SuministroBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idSuministro;
    private String nombre;
    private UploadedFile foto;
    private String nombreFoto;
    private Integer cantidad;
    private Integer cantidadMinima;
    private MedidaProductoVO medidaProductoVO;
    private Double precioUnidad;
    private String observaciones;
    private String estado;
    private Integer selectedMedida;
    private DualListModel<String> proveedoresDual;
    private SuministroVO suministroVO;
    private SuministroService suministroService;
    private ProveedorService proveedorService;
    private DetalleSuministroProveedorService detalleSuministroProveedorService;
    private List<ProveedorVO> proveedores;
    private List<String> nombresProveedores;
    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;

    private DetalleProveedorVO detalleProveedorVO;
    private List<DetalleProveedorVO> detallesSuministroProveedor;
    private MedidaService medidaService;
    private ServicioMedidaProducto servicioMedida;
    private List<MedidaProductoVO> medidas;
    private List<SuministroVO> suministros;
    private List<String> proveedorSource;
    private List<String> proveedorTarget;

    private LugarService lugarService;
    private List<LugarVO> lugares;
    private ProveedorVO proveedorVO;
    private LoginBean login;
    private ClasificacionBean clasificacionBean;
    private OpcionBean opcionBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            setLogin(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
            setClasificacionBean(application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class));
            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            try {
                //  FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                medidaService = new MedidaService();
                suministroService = new SuministroService();
                servicioMedida = new ServicioMedidaProducto();
                proveedorService = new ProveedorService();
                detalleSuministroProveedorService = new DetalleSuministroProveedorService();

                medidas = medidaService.listar();
                // medidas = servicioMedida.listar();
                suministros = suministroService.listar();

                proveedores = proveedorService.listar();

                proveedorSource = new ArrayList<>();
                proveedorTarget = new ArrayList<>();

                for (ProveedorVO p : proveedores) {
                    proveedorSource.add(p.getRazonSocial());
                }

                proveedoresDual = new DualListModel<String>(proveedorSource, proveedorTarget);

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        nombresProveedores = new ArrayList<String>();
        for (Object item : event.getItems()) {
            builder.append(((Object) item)).append("<br />");

            StringBuilder nom = new StringBuilder();
            nom.append(((Object) item));
            String nombre = nom.toString();
            nombresProveedores.add(nombre);
            for (int i = 0; i < nombresProveedores.size(); i++) {
                System.out.println(" **** " + nombresProveedores.get(i));
            }

            // identificacionEmpleado.add((Long) Long.parseLong(builder.toString()));
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        //Long idEmpleado = ((EmpleadoVO) event.getObject()).getIdentificacionEmpleado();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }

    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }

    public void insertarSuministro() throws Exception {
        try {
            int insertar = 0;
            suministroVO = new SuministroVO();
            detalleProveedorVO = new DetalleProveedorVO();

            suministroVO.setNombre(nombre);
            suministroVO.setFoto(nombreFoto);
            suministroVO.setCantidad(cantidad);
            suministroVO.setCantidadMinima(cantidadMinima);
            suministroVO.getMedidaProductoVO().setMedidaProducto(selectedMedida);
            suministroVO.setPrecioUnidad(precioUnidad);
            suministroVO.setObservaciones(observaciones);
            suministroVO.setEstado("Activo");

            insertar = suministroService.insertar(suministroVO);

            long ultimoId = suministroService.ultimoId();

            for (String ps : nombresProveedores) {
                long idProveedor = proveedorService.buscarProveedorPorNombre(ps);

                detalleProveedorVO.getSuministroVO().setIdSuministro(ultimoId);
                detalleProveedorVO.getProveedorVO().setIdProveedor((int) idProveedor);

                detalleSuministroProveedorService.insertar(detalleProveedorVO);
            }
            if (insertar >= 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

            this.init();
            RequestContext.getCurrentInstance().update("frmOpciones:growl");
            opcionBean.setearDetalles();
            opcionBean.setearOpciones();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }
    }

    public void actualizarSuministro() throws Exception {
        try {
            int actualizar = 0;

            suministroVO = new SuministroVO();
            suministroVO.setIdSuministro(idSuministro);
            suministroVO.setNombre(nombre);
            suministroVO.setFoto(nombreFoto);
            suministroVO.setCantidad(cantidad);
            suministroVO.setCantidadMinima(cantidadMinima);
            suministroVO.getMedidaProductoVO().setMedidaProducto(selectedMedida);
            suministroVO.setPrecioUnidad(precioUnidad);
            suministroVO.setObservaciones(observaciones);
            suministroVO.setEstado("Activo");

            actualizar = suministroService.actualizar(suministroVO);

            if (actualizar == 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se actualizo "));
            }
            
            for (String ps : nombresProveedores) {
                long idProveedor = proveedorService.buscarProveedorPorNombre(ps);

                detalleProveedorVO.getSuministroVO().setIdSuministro(idSuministro);
                detalleProveedorVO.getProveedorVO().setIdProveedor((int) idProveedor);

                //detalleSuministroProveedorService(detalleProveedorVO);
            }

            RequestContext.getCurrentInstance().update("frmOpciones:growl");
            opcionBean.setearDetalles();
            opcionBean.setearOpciones();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }
    }

    public void verInformacionSuministro(Integer id) throws Exception {
        try {            
            proveedorVO = new ProveedorVO();
            
            suministroVO = suministroService.consultarPorId(id);
            idSuministro = id;
            nombre = suministroVO.getNombre();
            nombreFoto = suministroVO.getFoto();
            cantidad = suministroVO.getCantidad();
            cantidadMinima = suministroVO.getCantidadMinima();
            selectedMedida = suministroVO.getMedidaProductoVO().getMedidaProducto();
            precioUnidad = suministroVO.getPrecioUnidad();
            observaciones = suministroVO.getObservaciones();

            detallesSuministroProveedor = detalleSuministroProveedorService.listarPorId(idSuministro);
            nombresProveedores = new ArrayList<>();
            proveedorSource = new ArrayList<>();
            proveedorTarget = new ArrayList<>();
            proveedores = new ArrayList<>();

            for (DetalleProveedorVO dsp : detallesSuministroProveedor) {
                proveedorVO = proveedorService.consultarPorId(dsp.getProveedorVO().getIdProveedor());
                proveedorTarget.add(proveedorVO.getRazonSocial());
            }

            proveedores = proveedorService.listar();

            for (ProveedorVO p : proveedores) {
                proveedorSource.add(p.getRazonSocial());
            }

            proveedoresDual = new DualListModel<String>(proveedorSource, proveedorTarget);

            opcionBean.verInfoSuministro();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

        }
    }

    /**
     * @return the idSuministro
     */
    public Integer getIdSuministro() {
        return idSuministro;
    }

    /**
     * @param idSuministro the idSuministro to set
     */
    public void setIdSuministro(Integer idSuministro) {
        this.idSuministro = idSuministro;
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
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the cantidadMinima
     */
    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * @param cantidadMinima the cantidadMinima to set
     */
    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
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
     * @return the precioUnidad
     */
    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * @param precioUnidad the precioUnidad to set
     */
    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the SuministroVO
     */
    public SuministroVO getSuministroVO() {
        return suministroVO;
    }

    /**
     * @param paqueteVO the paqueteVO to set
     */
    public void setSuministroVO(SuministroVO suministroVO) {
        this.suministroVO = suministroVO;
    }

    /**
     * @return the paqueteService
     */
    public SuministroService getSuministroService() {
        return suministroService;
    }

    /**
     * @param paqueteService the paqueteService to set
     */
    public void setSuministroService(SuministroService suministro) {
        this.suministroService = suministroService;
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
     * @return the clasificacionBean
     */
    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }

    /**
     * @param clasificacionBean the clasificacionBean to set
     */
    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
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
    public Integer getSelectedMedida() {
        return selectedMedida;
    }

    /**
     * @param selectedMedida the selectedMedida to set
     */
    public void setSelectedMedida(Integer selectedMedida) {
        this.selectedMedida = selectedMedida;
    }

    /**
     * @return the suministros
     */
    public List<SuministroVO> getSuministros() {
        return suministros;
    }

    /**
     * @param suministros the suministros to set
     */
    public void setSuministros(List<SuministroVO> suministros) {
        this.suministros = suministros;
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
     * @return the servicioMedida
     */
    public ServicioMedidaProducto getServicioMedida() {
        return servicioMedida;
    }

    /**
     * @param servicioMedida the servicioMedida to set
     */
    public void setServicioMedida(ServicioMedidaProducto servicioMedida) {
        this.servicioMedida = servicioMedida;
    }

    /**
     * @return the proveedoresDual
     */
    public DualListModel<String> getProveedoresDual() {
        return proveedoresDual;
    }

    /**
     * @param proveedoresDual the proveedoresDual to set
     */
    public void setProveedoresDual(DualListModel<String> proveedoresDual) {
        this.proveedoresDual = proveedoresDual;
    }

    /**
     * @return the nombresProveedores
     */
    public List<String> getNombresProveedores() {
        return nombresProveedores;
    }

    /**
     * @param nombresProveedores the nombresProveedores to set
     */
    public void setNombresProveedores(List<String> nombresProveedores) {
        this.nombresProveedores = nombresProveedores;
    }

    /**
     * @return the proveedores
     */
    public List<ProveedorVO> getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(List<ProveedorVO> proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * @return the proveedorService
     */
    public ProveedorService getProveedorService() {
        return proveedorService;
    }

    /**
     * @param proveedorService the proveedorService to set
     */
    public void setProveedorService(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    /**
     * @return the proveedorSource
     */
    public List<String> getProveedorSource() {
        return proveedorSource;
    }

    /**
     * @param proveedorSource the proveedorSource to set
     */
    public void setProveedorSource(List<String> proveedorSource) {
        this.proveedorSource = proveedorSource;
    }

    /**
     * @return the proveedorTarget
     */
    public List<String> getProveedorTarget() {
        return proveedorTarget;
    }

    /**
     * @param proveedorTarget the proveedorTarget to set
     */
    public void setProveedorTarget(List<String> proveedorTarget) {
        this.proveedorTarget = proveedorTarget;
    }

    /**
     * @return the detalleSuministroProveedorService
     */
    public DetalleSuministroProveedorService getDetalleSuministroProveedorService() {
        return detalleSuministroProveedorService;
    }

    /**
     * @param detalleSuministroProveedorService the
     * detalleSuministroProveedorService to set
     */
    public void setDetalleSuministroProveedorService(DetalleSuministroProveedorService detalleSuministroProveedorService) {
        this.detalleSuministroProveedorService = detalleSuministroProveedorService;
    }

    /**
     * @return the detalleProveedorVO
     */
    public DetalleProveedorVO getDetalleProveedorVO() {
        return detalleProveedorVO;
    }

    /**
     * @param detalleProveedorVO the detalleProveedorVO to set
     */
    public void setDetalleProveedorVO(DetalleProveedorVO detalleProveedorVO) {
        this.detalleProveedorVO = detalleProveedorVO;
    }

    /**
     * @return the detallesSuministroProveedor
     */
    public List<DetalleProveedorVO> getDetallesSuministroProveedor() {
        return detallesSuministroProveedor;
    }

    /**
     * @param detallesSuministroProveedor the detallesSuministroProveedor to set
     */
    public void setDetallesSuministroProveedor(List<DetalleProveedorVO> detallesSuministroProveedor) {
        this.detallesSuministroProveedor = detallesSuministroProveedor;
    }

    /**
     * @return the proveedorVO
     */
    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    /**
     * @param proveedorVO the proveedorVO to set
     */
    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

}
