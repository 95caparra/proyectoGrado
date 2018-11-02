package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.CiudadService;
import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.ClienteService;
import co.com.blummer.quotevent.modelo.service.DetallePaqueteProductoService;
import co.com.blummer.quotevent.modelo.service.DetalleProductoSuministroService;
import co.com.blummer.quotevent.modelo.service.EmpleadoService;
import co.com.blummer.quotevent.modelo.service.EstadoEventoService;
import co.com.blummer.quotevent.modelo.service.EventoService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.service.ProveedorService;
import co.com.blummer.quotevent.modelo.service.SolicitudService;
import co.com.blummer.quotevent.modelo.service.TipoDocumentoService;
import co.com.blummer.quotevent.modelo.service.UsuarioService;
import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.ProveedorVO;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;
import co.com.blummer.quotevent.modelo.vo.UsuarioVO;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private static long serialVersionUID = 4545919119678482516L;

    private String nombre;
    private Integer selectedClasificacion;
    private Integer selectedLugar;
    private String descripcion;
    private Integer cantidadPersonas;
    private Double precio;
    private UploadedFile pdf;
    private UploadedFile foto;
    private String nombreFoto;
    private String nombrePdf;
    private Integer cantidadMeseros;

    private Long numIdentificacion;
    private String usuario;
    private String contraseniaUsuario;
    private String estadoUsuario;
    
    private Date horaInicioEvento;
    private Date horaFinEvento;
    private Date fechaEvento;

    private Integer idPaquete;
    private PaqueteVO paqueteVO;
    private EventoVO eventoVO;
    private SolicitudVO solicitudVO;
    private Integer idEvento;
    private Integer idProveedor;
    private Integer idUsuario;
    private EventoVO selectedEvento;
    private ClienteVO selectedClienteVO;
    private ProveedorVO selectedProveedor;
    private EstadoEventoVO estadoEventoVO;
    private ProveedorVO proveedorVO;
    private UsuarioVO usuarioVO;
    private List<ProveedorVO> proveedores;
    private ProveedorService proveedorService;
    private EstadoEventoService estadoEventoService;
    private TipoDocumentoService tipoDocumentoService;
    private CiudadService ciudadService;
    private PaqueteService paqueteService;
    private EventoService eventoService;
    private SolicitudService solicitudService;
    private DetallePaqueteProductoService detallePaqueteProductoService;
    private DetalleProductoSuministroService detalleProductoSuministroService;
    private OpcionBean opcionBean;

    private List<TipoDocumentoVO> tiposDocumentos;
    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;
    private List<PaqueteVO> paquetes;
    private ClienteService clienteService;
    private Integer selectedCliente;
    private Integer selectedEstadoEvento;
    private Integer selectedTiposDocumento;
    private Long selectedEmpleado;
    private Integer selectedCiudad;
    private List<ClienteVO> clientes;
    private List<EventoVO> eventos;
    private List<EventoVO> eventosVivos;
    private List<EstadoEventoVO> estadosEventos;
    private List<EventoVO> eventosFiltro;
    private List<ClienteVO> clientesFiltro;
    private List<ProveedorVO> proveedoresFiltro;
    private List<CiudadVO> ciudades;
    private ClienteVO clienteVO;

    private List<ProductoVO> productos;
    private ProductoVO productoVO;
    private ProductoService productoService;
    private List<ProductoVO> droppedProductos;
    private DetallePaqueteProductoVO detallePaqueteProductoVO;
    private List<DetallePaqueteProductoVO> detallePaqueteProductos;
    private LugarService lugarService;
    private UsuarioService usuarioService;
    private EmpleadoService empleadoService;
    private List<LugarVO> lugares;
    private List<UsuarioVO> usuarios;
    private List<EmpleadoVO> empleados;
    private UsuarioVO selectedUsuario;
    private List<UsuarioVO> usuariosFiltro;
    
    private LoginBean login;
    private ClasificacionBean clasificacionBean;
    private SolicitudBean solicitudBean;
    

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
            clasificacionBean = application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class);
            solicitudBean = application.evaluateExpressionGet(context, "#{solicitudBean}", SolicitudBean.class);
            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            try {
                //   FacesContext.getCurrentInstance().getExternalContext().redirect("/Paquetes/pages/inicio/inicio.xhtml?faces-redirect=true");
                clasificacionService = new ClasificacionService();
                lugarService = new LugarService();
                paqueteService = new PaqueteService();
                productoService = new ProductoService();
                detallePaqueteProductoService = new DetallePaqueteProductoService();
                clienteService = new ClienteService();
                eventoService = new EventoService();
                solicitudService = new SolicitudService();
                detalleProductoSuministroService = new DetalleProductoSuministroService();
                estadoEventoService = new EstadoEventoService();
                tipoDocumentoService = new TipoDocumentoService();
                ciudadService = new CiudadService();
                proveedorService = new ProveedorService();
                usuarioService = new UsuarioService();
                empleadoService = new EmpleadoService();
                
                empleados = empleadoService.listar();
                usuarios = usuarioService.listar();
                proveedores = proveedorService.listar();
                ciudades = ciudadService.listar();
                estadosEventos = estadoEventoService.listar();
                tiposDocumentos = tipoDocumentoService.listar();
                lugares = lugarService.listar();
                clasificaciones = clasificacionService.listar();
                productos = productoService.listar();
                paquetes = paqueteService.listar();
                clientes = clienteService.listarClientes();

                droppedProductos = new ArrayList<ProductoVO>();

                eventos = eventoService.listar();
                eventosVivos = eventoService.listarEventosVivos();

                eventModel = new DefaultScheduleModel();

                for (EventoVO e : eventosVivos) {

                    Date fechaIni = new Date(e.getFecha().getTime());
                    Date fechaF = new Date(e.getFecha().getTime());

                    int horaI = e.getHoraInicio().getHours();
                    int horaF = e.getHoraFin().getHours();

                    eventModel.addEvent(new DefaultScheduleEvent(e.getObservaciones(), fechaInicio(fechaIni, horaI), fechaFin(fechaF, horaF)));
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    

    public void onAddNew() throws Exception {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarios = usuarioService.listar();
        usuarios.add(usuarioVO);
    }

    public void actualizarEvento() {
        try {
            idEvento = selectedEvento.getIdEvento();

            FacesMessage msg = new FacesMessage("id", idEvento.toString());
        } catch (Exception e) {

        }

    }

    public void onRowEdit(RowEditEvent event) {
        try {
            idUsuario = selectedUsuario.getIdUsuario();
                   
            numIdentificacion = ((UsuarioVO) event.getObject()).getEmpleadoVO().getIdentificacionEmpleado();
            usuario = ((UsuarioVO) event.getObject()).getUsuario();
            contraseniaUsuario = ((UsuarioVO) event.getObject()).getClave();
            estadoUsuario = ((UsuarioVO) event.getObject()).getEstado();

            boolean bandera = usuarioService.validarExistencia(idUsuario);

            usuarioVO = new UsuarioVO();
            
            usuarioVO.setIdUsuario(idUsuario);
            usuarioVO.getEmpleadoVO().setIdentificacionEmpleado(selectedEmpleado);
            usuarioVO.setUsuario(usuario);
            usuarioVO.setClave(contraseniaUsuario);
            usuarioVO.setEstado(estadoUsuario);
                        
            if (bandera == true) {
                usuarioService.actualizar(usuarioVO);
            }else{
                usuarioService.insertar(usuarioVO);
            }

            this.init();
        } catch (Exception e) {
        }

    }

    public void onRowCancel(RowEditEvent event) {

    }

    public void formularioDatos() {
        try {
            RequestContext.getCurrentInstance().update("pnlDatosEvento");
        } catch (Exception e) {
        }
    }

    public void onDrop(DragDropEvent ddEvent) {
        productoVO = ((ProductoVO) ddEvent.getData());

        droppedProductos.add(productoVO);
        productos.remove(productoVO);
    }

    public void insertarEvento() throws Exception {
        try {
            eventoVO = new EventoVO();

            eventoVO.getSolicitudVO().setIdSolicitud(solicitudBean.getIdSolicitud());
            eventoVO.getClienteVO().setNumeroIdentificacion(getSelectedCliente());
            eventoVO.getTipoEventoVO().setIdTipoEvento(selectedClasificacion);
            eventoVO.getLugarVO().setIdLugar(selectedLugar);
            eventoVO.setCantidadPersonas(solicitudBean.getCantidadPersonasSolicitud());
            eventoVO.setCantidadMeseros(cantidadMeseros);
            eventoVO.setHoraInicio(new Time(horaInicioEvento.getTime()));
            eventoVO.setHoraFin(new Time(horaFinEvento.getTime()));
            eventoVO.setFecha(new java.sql.Date(solicitudBean.getFecha().getTime()));
            eventoVO.setPrecio(solicitudBean.getPrecioPaquete());
            eventoVO.setObservaciones(solicitudBean.getObservaciones());
            eventoVO.getEstadoEvento().setIdEstadoEvento(1);

            eventoService.insertar(eventoVO);
            solicitudService.eliminar(solicitudBean.getIdSolicitud());

            solicitudVO = solicitudService.consultarPorId(solicitudBean.getIdSolicitud());

            Integer idPaquete = solicitudVO.getPaqueteVO().getIdPaquete();

            List<DetallePaqueteProductoVO> lista = detallePaqueteProductoService.listarPorId(idPaquete);

            Integer idProducto = null;
            for (DetallePaqueteProductoVO dpp : lista) {
                idProducto = dpp.getProductoVO().getIdProducto();
            }

            List<DetalleProductoSuministroVO> lista2 = detalleProductoSuministroService.listarPorId(idProducto);

            Integer cantPorcionSolicitada = null;

            for (DetalleProductoSuministroVO dps : lista2) {
                cantPorcionSolicitada = dps.getCantidad();
            }

            productoVO = productoService.consultarPorId(idProducto);

            Integer cantidadStock = productoVO.getCantidad();

            Integer cantidadFinal = (cantidadStock - solicitudBean.getCantidadPersonasSolicitud());

            productoService.actualizarCantidadProducto(cantidadFinal, idProducto);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));

            RequestContext.getCurrentInstance().update("frmOpciones:growl");
            opcionBean.setearDetalles();
            opcionBean.setearOpciones();

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            e.getStackTrace();
        } finally {

        }
    }

    public void verInformacionPaquete(Integer id) throws Exception {
        idPaquete = id;
        try {
            paqueteVO = paqueteService.consultarPorId(idPaquete);

            nombre = paqueteVO.getNombre();
            selectedClasificacion = paqueteVO.getClasificacionVO().getIdClasificacion();
            descripcion = paqueteVO.getDescripcion();
            selectedLugar = paqueteVO.getLugarVO().getIdLugar();
            cantidadPersonas = paqueteVO.getCantidadPersonas();
            precio = paqueteVO.getPrecio();
            nombrePdf = paqueteVO.getPdf();
            nombreFoto = paqueteVO.getFoto();

            opcionBean.verInfoPaquete();

            detallePaqueteProductos = getDetallePaqueteProductoService().listarPorId(id);

            for (DetallePaqueteProductoVO dpp : detallePaqueteProductos) {

                droppedProductos.add(productoService.consultarPorId(dpp.getProductoVO().getIdProducto()));
            }

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
     * @return the selectedClasificacion
     */
    public Integer getSelectedClasificacion() {
        return selectedClasificacion;
    }

    /**
     * @param selectedClasificacion the selectedClasificacion to set
     */
    public void setSelectedClasificacion(Integer selectedClasificacion) {
        this.selectedClasificacion = selectedClasificacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the selectedLugar
     */
    public Integer getSelectedLugar() {
        return selectedLugar;
    }

    /**
     * @param selectedLugar the selectedLugar to set
     */
    public void setSelectedLugar(Integer selectedLugar) {
        this.selectedLugar = selectedLugar;
    }

    /**
     * @return the cantidadPersonas
     */
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * @param cantidadPersonas the cantidadPersonas to set
     */
    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the pdf
     */
    public UploadedFile getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(UploadedFile pdf) {
        this.pdf = pdf;
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
     * @return the clasificacion
     */
    public ClasificacionBean getClasificacion() {
        return clasificacionBean;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
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
     * @return the paqueteService
     */
    public PaqueteService getPaqueteService() {
        return paqueteService;
    }

    /**
     * @param paqueteService the paqueteService to set
     */
    public void setPaqueteService(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
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
     * @return the nombrePdf
     */
    public String getNombrePdf() {
        return nombrePdf;
    }

    /**
     * @param nombrePdf the nombrePdf to set
     */
    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

    /**
     * @return the productos
     */
    public List<ProductoVO> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }

    /**
     * @return the productoService
     */
    public ProductoService getProductoService() {
        return productoService;
    }

    /**
     * @param productoService the productoService to set
     */
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * @return the productoVO
     */
    public ProductoVO getProductoVO() {
        return productoVO;
    }

    /**
     * @param productoVO the productoVO to set
     */
    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    /**
     * @return the droppedProductos
     */
    public List<ProductoVO> getDroppedProductos() {
        return droppedProductos;
    }

    /**
     * @param droppedProductos the droppedProductos to set
     */
    public void setDroppedProductos(List<ProductoVO> droppedProductos) {
        this.droppedProductos = droppedProductos;
    }

    /**
     * @return the detallePaqueteProductoVO
     */
    public DetallePaqueteProductoVO getDetallePaqueteProductoVO() {
        return detallePaqueteProductoVO;
    }

    /**
     * @param detallePaqueteProductoVO the detallePaqueteProductoVO to set
     */
    public void setDetallePaqueteProductoVO(DetallePaqueteProductoVO detallePaqueteProductoVO) {
        this.detallePaqueteProductoVO = detallePaqueteProductoVO;
    }

    /**
     * @return the detallePaqueteProductoService
     */
    public DetallePaqueteProductoService getDetallePaqueteProductoService() {
        return detallePaqueteProductoService;
    }

    /**
     * @param detallePaqueteProductoService the detallePaqueteProductoService to
     * set
     */
    public void setDetallePaqueteProductoService(DetallePaqueteProductoService detallePaqueteProductoService) {
        this.detallePaqueteProductoService = detallePaqueteProductoService;
    }

    /**
     * @return the paquetes
     */
    public List<PaqueteVO> getPaquetes() {
        return paquetes;
    }

    /**
     * @param paquetes the paquetes to set
     */
    public void setPaquetes(List<PaqueteVO> paquetes) {
        this.paquetes = paquetes;
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
     * @return the detallePaqueteProductos
     */
    public List<DetallePaqueteProductoVO> getDetallePaqueteProductos() {
        return detallePaqueteProductos;
    }

    /**
     * @param detallePaqueteProductos the detallePaqueteProductos to set
     */
    public void setDetallePaqueteProductos(List<DetallePaqueteProductoVO> detallePaqueteProductos) {
        this.detallePaqueteProductos = detallePaqueteProductos;
    }

    /**
     * @return the idPaquete
     */
    public Integer getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaquete to set
     */
    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    /**
     * @return the clientes
     */
    public List<ClienteVO> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<ClienteVO> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the clienteService
     */
    public ClienteService getClienteService() {
        return clienteService;
    }

    /**
     * @param clienteService the clienteService to set
     */
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * @return the selectedCliente
     */
    public Integer getSelectedCliente() {
        return selectedCliente;
    }

    /**
     * @param selectedCliente the selectedCliente to set
     */
    public void setSelectedCliente(Integer selectedCliente) {
        this.setSelectedCliente(selectedCliente);
    }

    /**
     * @return the cantidadMeseros
     */
    public Integer getCantidadMeseros() {
        return cantidadMeseros;
    }

    /**
     * @param cantidadMeseros the cantidadMeseros to set
     */
    public void setCantidadMeseros(Integer cantidadMeseros) {
        this.cantidadMeseros = cantidadMeseros;
    }

    /**
     * |
     *
     * @return the horaInicioEvento
     */
    public Date getHoraInicioEvento() {
        return horaInicioEvento;
    }

    /**
     * @param horaInicioEvento the horaInicioEvento to set
     */
    public void setHoraInicioEvento(Date horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    /**
     * @return the horaFinEvento
     */
    public Date getHoraFinEvento() {
        return horaFinEvento;
    }

    /**
     * @param horaFinEvento the horaFinEvento to set
     */
    public void setHoraFinEvento(Date horaFinEvento) {
        this.horaFinEvento = horaFinEvento;
    }

    /**
     * @return the fechaEvento
     */
    public Date getFechaEvento() {
        return fechaEvento;
    }

    /**
     * @param fechaEvento the fechaEvento to set
     */
    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    /**
     * @return the eventoVO
     */
    public EventoVO getEventoVO() {
        return eventoVO;
    }

    /**
     * @param eventoVO the eventoVO to set
     */
    public void setEventoVO(EventoVO eventoVO) {
        this.eventoVO = eventoVO;
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
     * @return the eventoService
     */
    public EventoService getEventoService() {
        return eventoService;
    }

    /**
     * @param eventoService the eventoService to set
     */
    public void setEventoService(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    /**
     * @return the eventModel
     */
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    /**
     * @param eventModel the eventModel to set
     */
    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    /**
     * @return the lazyEventModel
     */
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    /**
     * @param lazyEventModel the lazyEventModel to set
     */
    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    /**
     * @return the event
     */
    public ScheduleEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
        return t.getTime();
    }

    private Date fechaInicio(Date fechaEvento, int horaI) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.AM_PM, Calendar.PM);
        cal.setTime(fechaEvento);
        cal.set(Calendar.HOUR, horaI);
        return cal.getTime();
    }

    private Date fechaFin(Date fechaEvento, int horaF) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.AM_PM, Calendar.PM);
        cal.setTime(fechaEvento);
        cal.set(Calendar.HOUR, horaF);
        return cal.getTime();
    }

    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);

        return t.getTime();
    }

    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }

    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);

        return t.getTime();
    }

    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the eventos
     */
    public List<EventoVO> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<EventoVO> eventos) {
        this.eventos = eventos;
    }

    /**
     * @return the solicitudService
     */
    public SolicitudService getSolicitudService() {
        return solicitudService;
    }

    /**
     * @param solicitudService the solicitudService to set
     */
    public void setSolicitudService(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    /**
     * @return the solicitudVO
     */
    public SolicitudVO getSolicitudVO() {
        return solicitudVO;
    }

    /**
     * @param solicitudVO the solicitudVO to set
     */
    public void setSolicitudVO(SolicitudVO solicitudVO) {
        this.solicitudVO = solicitudVO;
    }

    /**
     * @return the selectedEvento
     */
    public EventoVO getSelectedEvento() {
        return selectedEvento;
    }

    /**
     * @param selectedEvento the selectedEvento to set
     */
    public void setSelectedEvento(EventoVO selectedEvento) {
        this.selectedEvento = selectedEvento;
    }

    /**
     * @return the eventosFiltro
     */
    public List<EventoVO> getEventosFiltro() {
        return eventosFiltro;
    }

    /**
     * @param eventosFiltro the eventosFiltro to set
     */
    public void setEventosFiltro(List<EventoVO> eventosFiltro) {
        this.eventosFiltro = eventosFiltro;
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
     * @return the estadosEventos
     */
    public List<EstadoEventoVO> getEstadosEventos() {
        return estadosEventos;
    }

    /**
     * @param estadosEventos the estadosEventos to set
     */
    public void setEstadosEventos(List<EstadoEventoVO> estadosEventos) {
        this.estadosEventos = estadosEventos;
    }

    /**
     * @return the selectedEstadoEvento
     */
    public Integer getSelectedEstadoEvento() {
        return selectedEstadoEvento;
    }

    /**
     * @param selectedEstadoEvento the selectedEstadoEvento to set
     */
    public void setSelectedEstadoEvento(Integer selectedEstadoEvento) {
        this.selectedEstadoEvento = selectedEstadoEvento;
    }

    /**
     * @return the idEvento
     */
    public Integer getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the eventosVivos
     */
    public List<EventoVO> getEventosVivos() {
        return eventosVivos;
    }

    /**
     * @param eventosVivos the eventosVivos to set
     */
    public void setEventosVivos(List<EventoVO> eventosVivos) {
        this.eventosVivos = eventosVivos;
    }

    /**
     * @return the selectedClienteVO
     */
    public ClienteVO getSelectedClienteVO() {
        return selectedClienteVO;
    }

    /**
     * @param selectedClienteVO the selectedClienteVO to set
     */
    public void setSelectedClienteVO(ClienteVO selectedClienteVO) {
        this.selectedClienteVO = selectedClienteVO;
    }

    /**
     * @return the clientesFiltro
     */
    public List<ClienteVO> getClientesFiltro() {
        return clientesFiltro;
    }

    /**
     * @param clientesFiltro the clientesFiltro to set
     */
    public void setClientesFiltro(List<ClienteVO> clientesFiltro) {
        this.clientesFiltro = clientesFiltro;
    }

    /**
     * @return the tiposDocumentos
     */
    public List<TipoDocumentoVO> getTiposDocumentos() {
        return tiposDocumentos;
    }

    /**
     * @param tiposDocumentos the tiposDocumentos to set
     */
    public void setTiposDocumentos(List<TipoDocumentoVO> tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
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
     * @return the selectedTiposDocumento
     */
    public Integer getSelectedTiposDocumento() {
        return selectedTiposDocumento;
    }

    /**
     * @param selectedTiposDocumento the selectedTiposDocumento to set
     */
    public void setSelectedTiposDocumento(Integer selectedTiposDocumento) {
        this.selectedTiposDocumento = selectedTiposDocumento;
    }

    /**
     * @return the selectedCiudad
     */
    public Integer getSelectedCiudad() {
        return selectedCiudad;
    }

    /**
     * @param selectedCiudad the selectedCiudad to set
     */
    public void setSelectedCiudad(Integer selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
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
     * @return the clienteVO
     */
    public ClienteVO getClienteVO() {
        return clienteVO;
    }

    /**
     * @param clienteVO the clienteVO to set
     */
    public void setClienteVO(ClienteVO clienteVO) {
        this.clienteVO = clienteVO;
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
     * @return the proveedoresFiltro
     */
    public List<ProveedorVO> getProveedoresFiltro() {
        return proveedoresFiltro;
    }

    /**
     * @param proveedoresFiltro the proveedoresFiltro to set
     */
    public void setProveedoresFiltro(List<ProveedorVO> proveedoresFiltro) {
        this.proveedoresFiltro = proveedoresFiltro;
    }

    /**
     * @return the selectedProveedor
     */
    public ProveedorVO getSelectedProveedor() {
        return selectedProveedor;
    }

    /**
     * @param selectedProveedor the selectedProveedor to set
     */
    public void setSelectedProveedor(ProveedorVO selectedProveedor) {
        this.selectedProveedor = selectedProveedor;
    }

    /**
     * @return the idProveedor
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * @return the usuarios
     */
    public List<UsuarioVO> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<UsuarioVO> usuarios) {
        this.usuarios = usuarios;
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
     * @return the selectedUsuario
     */
    public UsuarioVO getSelectedUsuario() {
        return selectedUsuario;
    }

    /**
     * @param selectedUsuario the selectedUsuario to set
     */
    public void setSelectedUsuario(UsuarioVO selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    /**
     * @return the usuariosFiltro
     */
    public List<UsuarioVO> getUsuariosFiltro() {
        return usuariosFiltro;
    }

    /**
     * @param usuariosFiltro the usuariosFiltro to set
     */
    public void setUsuariosFiltro(List<UsuarioVO> usuariosFiltro) {
        this.usuariosFiltro = usuariosFiltro;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the numIdentificacion
     */
    public Long getNumIdentificacion() {
        return numIdentificacion;
    }

    /**
     * @param numIdentificacion the numIdentificacion to set
     */
    public void setNumIdentificacion(Long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseniaUsuario
     */
    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    /**
     * @param contraseniaUsuario the contraseniaUsuario to set
     */
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    /**
     * @return the estadoUsuario
     */
    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     * @param estadoUsuario the estadoUsuario to set
     */
    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
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

    /**
     * @return the selectedEmpleado
     */
    public Long getSelectedEmpleado() {
        return selectedEmpleado;
    }

    /**
     * @param selectedEmpleado the selectedEmpleado to set
     */
    public void setSelectedEmpleado(Long selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }

    /**
     * @return the empleadoService
     */
    public EmpleadoService getEmpleadoService() {
        return empleadoService;
    }

    /**
     * @param empleadoService the empleadoService to set
     */
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    /**
     * @return the empleados
     */
    public List<EmpleadoVO> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<EmpleadoVO> empleados) {
        this.empleados = empleados;
    }

}
