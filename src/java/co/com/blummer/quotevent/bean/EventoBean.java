package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.ClienteService;
import co.com.blummer.quotevent.modelo.service.DetalleEventoEmpleadoService;
import co.com.blummer.quotevent.modelo.service.DetallePaqueteProductoService;
import co.com.blummer.quotevent.modelo.service.DetalleProductoSuministroService;
import co.com.blummer.quotevent.modelo.service.EmpleadoService;
import co.com.blummer.quotevent.modelo.service.EstadoEventoService;
import co.com.blummer.quotevent.modelo.service.EventoService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.service.SolicitudService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.DetalleProductoSuministroVO;
import co.com.blummer.quotevent.modelo.vo.EmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
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
import org.primefaces.event.TransferEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
    
@ManagedBean(name = "eventoBean")
@ViewScoped
public class EventoBean implements Serializable {

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

    private Date horaInicioEvento;
    private Date horaFinEvento;
    private Integer cantidadMeseros;

    private BarChartModel animatedModel2;

    private String nombreCliente;
    private Long identificacionCliente;
    private String tipoEvento;
    private String lugarEvento;
    private Integer cantidadPersonasEvento;
    private Integer cantidadMeserosEvento;
    private Time horaInicioEventoDetalle;
    private Time horaFinEventoDetalle;
    private Date fechaEventoDetalle;
    private Double precioEvento;
    private String observacionesEvento;
    private String estadoEvento;

    private Date fechaEvento;

    private Integer idPaquete;
    private PaqueteVO paqueteVO;
    private EventoVO eventoVO;
    private SolicitudVO solicitudVO;
    private Integer idEvento;
    private Integer idSolicitud;
    private EventoVO selectedEvento;
    private EstadoEventoVO estadoEventoVO;
    private DetalleEventoEmpleadoVO detalleEventoEmpleadoVO;
    private EstadoEventoService estadoEventoService;
    private EmpleadoService empleadoService;
    private PaqueteService paqueteService;
    private EventoService eventoService;
    private DetalleEventoEmpleadoService detalleEventoEmpleadoService;
    private List<DetalleEventoEmpleadoVO> detallesEventoEmpleado;
    private SolicitudService solicitudService;
    private DetallePaqueteProductoService detallePaqueteProductoService;
    private DetalleProductoSuministroService detalleProductoSuministroService;
    private OpcionBean opcionBean;
    private PieChartModel pieModel;
    private ClasificacionService clasificacionService;
    private List<ClasificacionVO> clasificaciones;
    private List<PaqueteVO> paquetes;
    private ClienteService clienteService;
    private Integer selectedCliente;
    private Integer selectedEstadoEvento;
    private List<ClienteVO> clientes;
    private List<EventoVO> eventos;
    private List<EventoVO> eventosGraficaMeses;
    private List<EventoVO> eventosGraficaMeseEstado;
    private List<EventoVO> eventosVivos;
    private List<EstadoEventoVO> estadosEventos;
    private List<EmpleadoVO> empleados;
    private List<EmpleadoVO> empleadosDetalle;

    private List<EventoVO> eventosFiltro;

    private List<ProductoVO> productos;
    private ProductoVO productoVO;
    private ProductoService productoService;
    private List<ProductoVO> droppedProductos;
    private DetallePaqueteProductoVO detallePaqueteProductoVO;
    private List<DetallePaqueteProductoVO> detallePaqueteProductos;
    private LugarService lugarService;
    private List<LugarVO> lugares;

    private List<Long> empleadoSource;
    private List<Long> empleadoTarget;
    private List<Long> identificacionEmpleado;
    private DualListModel<Long> empleadosDual;

    private LoginBean login;
    private ClasificacionBean clasificacionBean;
    private PaqueteBean paqueteBean;
    private SolicitudBean solicitudBean;
    
    private BarChartModel barModel;
    private BarChartModel barModel2;
    private HorizontalBarChartModel horizontalBarModel;
    
    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();

            login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
            clasificacionBean = application.evaluateExpressionGet(context, "#{clasificacionBean}", ClasificacionBean.class);
            solicitudBean = application.evaluateExpressionGet(context, "#{solicitudBean}", SolicitudBean.class);
            opcionBean = application.evaluateExpressionGet(context, "#{opcionBean}", OpcionBean.class);
            paqueteBean = application.evaluateExpressionGet(context, "#{paqueteBean}", PaqueteBean.class);
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
                empleadoService = new EmpleadoService();
                detalleEventoEmpleadoService = new DetalleEventoEmpleadoService();

                empleados = empleadoService.listar();

                empleadoSource = new ArrayList<Long>();
                empleadoTarget = new ArrayList<Long>();

                for (EmpleadoVO e : empleados) {
                    empleadoSource.add(e.getIdentificacionEmpleado());
                }
                createBarModels();
                createAnimatedModels();
                empleadosDual = new DualListModel<Long>(empleadoSource, empleadoTarget);

                estadosEventos = estadoEventoService.listar();
                lugares = lugarService.listarLugar();
                clasificaciones = clasificacionService.listarClasificacion();
                productos = productoService.listar();
                paquetes = paqueteService.listar();
                clientes = clienteService.listarClientes();

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
                droppedProductos = new ArrayList<>();
                empleadosDetalle = new ArrayList<>();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void createAnimatedModels() throws Exception {
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    private BarChartModel initBarModel() throws Exception {
        BarChartModel model = new BarChartModel();

        eventosGraficaMeses = eventoService.listarEventosMeses();
        ChartSeries data = new ChartSeries();
        data.setLabel("Eventos Por Mes");

        for (EventoVO eg : eventosGraficaMeses) {            
            data.set(mesEspanol(eg.getMesEventos()), eg.getCantidadEventos());
        }

        model.addSeries(data);

        return model;
    }    
     
    private BarChartModel initBarModelEstado() throws Exception {
        BarChartModel model = new BarChartModel();

        eventosGraficaMeseEstado = eventoService.listarEventosEstado();
        ChartSeries data = new ChartSeries();
        data.setLabel("Eventos Por Estado");

        for (EventoVO eg : eventosGraficaMeseEstado) {            
            data.set(eg.getEstadoEvento().getNombre(), eg.getCantidadEventos());
        }

        model.addSeries(data);

        return model;
    }
    
    private void createBarModels() throws Exception {
        createBarModel();
        //createHorizontalBarModel();
    }
    
    private void createBarModel() throws Exception {
        barModel = initBarModel();
        barModel2 = initBarModelEstado();
        
        getBarModel().setTitle("Bar Chart");
        getBarModel().setLegendPosition("ne");
         
        Axis xAxis = getBarModel().getAxis(AxisType.X);
        xAxis.setLabel("Eventos");
         
        Axis yAxis = getBarModel().getAxis(AxisType.Y);
        yAxis.setLabel("Eventos");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private void createHorizontalBarModel() throws Exception {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        
        eventosGraficaMeses = eventoService.listarEventosMeses();
               
        for (EventoVO eg : eventosGraficaMeses) {            
            boys.set(mesEspanol(eg.getMesEventos()), eg.getCantidadEventos());
        }
        getHorizontalBarModel().addSeries(boys);        
         
        getHorizontalBarModel().setTitle("Horizontal and Stacked");
        getHorizontalBarModel().setLegendPosition("e");
        getHorizontalBarModel().setStacked(true);
         
        Axis xAxis = getHorizontalBarModel().getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = getHorizontalBarModel().getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
    
    public String mesEspanol(String numeroMes) {
        String mesLetra = "";
        switch (numeroMes) {
            case "1":
                mesLetra = "Enero";
                break;
            case "2":
                mesLetra = "Febrero";
                break;
            case "3":
                mesLetra = "Marzo";
                break;
            case "4":
                mesLetra = "Abril";
                break;
            case "5":
                mesLetra = "Mayo";
                break;
            case "6":
                mesLetra = "Junio";
                break;
            case "7":
                mesLetra = "Julio";
                break;
            case "8":
                mesLetra = "Agosto";
                break;
            case "9":
                mesLetra = "Septiembre";
                break;
            case "10":
                mesLetra = "Octubre";
                break;
            case "11":
                mesLetra = "Noviembre";
                break;
            case "12":
                mesLetra = "Diciembre";
                break;

        }
        return mesLetra;
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        identificacionEmpleado = new ArrayList<Long>();
        for (Object item : event.getItems()) {
            builder.append(((Object) item)).append("<br />");

            StringBuilder id = new StringBuilder();
            id.append(((Object) item));
            Long identificacion = Long.parseLong(id.toString());
            identificacionEmpleado.add(identificacion);
            for (int i = 0; i < identificacionEmpleado.size(); i++) {
                System.out.println(" **** " + identificacionEmpleado.get(i));
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

        Long idEmpleado = ((EmpleadoVO) event.getObject()).getIdentificacionEmpleado();
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

    public void consultarPorId() {
        try {

            idEvento = selectedEvento.getIdEvento();

            eventoVO = eventoService.consultarPorId(idEvento);

            nombreCliente = eventoVO.getClienteVO().getNombre();
            identificacionCliente = eventoVO.getClienteVO().getNumeroIdentificacion();
            tipoEvento = eventoVO.getTipoEventoVO().getNombreTipoEvento();
            lugarEvento = eventoVO.getLugarVO().getNombre();
            cantidadPersonasEvento = eventoVO.getCantidadPersonas();
            cantidadMeserosEvento = eventoVO.getCantidadMeseros();
            horaInicioEventoDetalle = eventoVO.getHoraInicio();
            horaFinEventoDetalle = eventoVO.getHoraFin();
            fechaEventoDetalle = eventoVO.getFecha();
            precioEvento = eventoVO.getPrecio();
            observacionesEvento = eventoVO.getObservaciones();
            estadoEvento = eventoVO.getEstadoEvento().getNombre();

            idSolicitud = eventoVO.getSolicitudVO().getIdSolicitud();
            idPaquete = eventoVO.getSolicitudVO().getPaqueteVO().getIdPaquete();

            paqueteVO = paqueteService.consultarPorId(idPaquete);

            nombre = paqueteVO.getNombre();
            selectedClasificacion = paqueteVO.getClasificacionVO().getIdClasificacion();
            descripcion = paqueteVO.getDescripcion();
            selectedLugar = paqueteVO.getLugarVO().getIdLugar();
            cantidadPersonas = paqueteVO.getCantidadPersonas();
            precio = paqueteVO.getPrecio();
            nombrePdf = paqueteVO.getPdf();
            nombreFoto = paqueteVO.getFoto();

            detallePaqueteProductos = detallePaqueteProductoService.listarPorId(idPaquete);

            for (DetallePaqueteProductoVO dpp : detallePaqueteProductos) {

                droppedProductos.add(productoService.consultarPorId(dpp.getProductoVO().getIdProducto()));
            }
            productos = droppedProductos;

            detallesEventoEmpleado = detalleEventoEmpleadoService.listarPorId(idEvento);

            for (DetalleEventoEmpleadoVO dee : detallesEventoEmpleado) {
                empleadosDetalle.add(empleadoService.consultarPorId(dee.getEmpleadoVO().getIdentificacionEmpleado()));
            }

            opcionBean.verDetalleEvento();
            //this.init();

        } catch (Exception e) {
            e.getMessage();
        }
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
            idEvento = selectedEvento.getIdEvento();
            Integer estadoNuevo = selectedEstadoEvento;
            Integer estadoAnterior = ((EventoVO) event.getObject()).getEstadoEvento().getIdEstadoEvento();

            java.sql.Date nuevaFecha = (new java.sql.Date(solicitudBean.getFecha().getTime()));

            eventoService.actualizarEstado(idEvento, estadoNuevo, nuevaFecha);

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
            detalleEventoEmpleadoVO = new DetalleEventoEmpleadoVO();

            eventoVO.getSolicitudVO().setIdSolicitud(solicitudBean.getIdSolicitud());

            if (selectedCliente == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por seleccione el cliente"));
            } else {
                eventoVO.getClienteVO().setNumeroIdentificacion(selectedCliente);
            }

            if (selectedClasificacion == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por seleccione la clasificación"));
            } else {
                eventoVO.getTipoEventoVO().setIdTipoEvento(selectedClasificacion);
            }

            if (selectedLugar == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por seleccione el lugar"));
            } else {
                eventoVO.getLugarVO().setIdLugar(selectedLugar);
            }

            eventoVO.setCantidadPersonas(solicitudBean.getCantidadPersonasSolicitud());
            eventoVO.setCantidadMeseros(cantidadMeseros);
            eventoVO.setHoraInicio(new java.sql.Time(getHoraInicioEvento().getTime()));
            eventoVO.setHoraFin(new java.sql.Time(getHoraFinEvento().getTime()));
            eventoVO.setFecha(new java.sql.Date(solicitudBean.getFecha().getTime()));
            eventoVO.setPrecio(solicitudBean.getPrecioPaquete());
            eventoVO.setObservaciones(solicitudBean.getObservaciones());
            eventoVO.getEstadoEvento().setIdEstadoEvento(1);

            eventoService.insertar(eventoVO);

            int ultimoId = eventoService.ultimoId();

            for (Long dee : identificacionEmpleado) {
                detalleEventoEmpleadoVO.getEmpleadoVO().setIdentificacionEmpleado(dee.longValue());
                detalleEventoEmpleadoVO.getEventoVO().setIdEvento(ultimoId);
                detalleEventoEmpleadoVO.setEstado("Activo");

                detalleEventoEmpleadoService.insertar(detalleEventoEmpleadoVO);
            }

            solicitudService.eliminar(solicitudBean.getIdSolicitud());

            solicitudVO = solicitudService.consultarPorId(solicitudBean.getIdSolicitud());

            Integer idPaquete = solicitudVO.getPaqueteVO().getIdPaquete();

            List<DetallePaqueteProductoVO> lista = detallePaqueteProductoService.listarPorId(idPaquete);

            Integer idProducto = null;
            for (DetallePaqueteProductoVO dpp : lista) {
                idProducto = dpp.getProductoVO().getIdProducto();
            }

            List<DetalleProductoSuministroVO> lista2 = getDetalleProductoSuministroService().listarPorId(idProducto);

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
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie todos los campos"));
        } finally {

        }
    }

    public void verInformacionPaquete(Integer id) throws Exception {
        idPaquete = id;
        try {
            setPaqueteVO(paqueteService.consultarPorId(idPaquete));

            nombre = getPaqueteVO().getNombre();
            selectedClasificacion = getPaqueteVO().getClasificacionVO().getIdClasificacion();
            descripcion = getPaqueteVO().getDescripcion();
            selectedLugar = getPaqueteVO().getLugarVO().getIdLugar();
            cantidadPersonas = getPaqueteVO().getCantidadPersonas();
            precio = getPaqueteVO().getPrecio();
            nombrePdf = getPaqueteVO().getPdf();
            nombreFoto = getPaqueteVO().getFoto();

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
        return getClasificacionBean();
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(ClasificacionBean clasificacionBean) {
        this.setClasificacionBean(clasificacionBean);
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
        this.selectedCliente = selectedCliente;
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
     * @return the paqueteVO
     */
    public PaqueteVO getPaqueteVO() {
        return paqueteVO;
    }

    /**
     * @param paqueteVO the paqueteVO to set
     */
    public void setPaqueteVO(PaqueteVO paqueteVO) {
        this.paqueteVO = paqueteVO;
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
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the identificacionCliente
     */
    public Long getIdentificacionCliente() {
        return identificacionCliente;
    }

    /**
     * @param identificacionCliente the identificacionCliente to set
     */
    public void setIdentificacionCliente(Long identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    /**
     * @return the tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * @param tipoEvento the tipoEvento to set
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @return the lugarEvento
     */
    public String getLugarEvento() {
        return lugarEvento;
    }

    /**
     * @param lugarEvento the lugarEvento to set
     */
    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    /**
     * @return the cantidadPersonasEvento
     */
    public Integer getCantidadPersonasEvento() {
        return cantidadPersonasEvento;
    }

    /**
     * @param cantidadPersonasEvento the cantidadPersonasEvento to set
     */
    public void setCantidadPersonasEvento(Integer cantidadPersonasEvento) {
        this.cantidadPersonasEvento = cantidadPersonasEvento;
    }

    /**
     * @return the cantidadMeserosEvento
     */
    public Integer getCantidadMeserosEvento() {
        return cantidadMeserosEvento;
    }

    /**
     * @param cantidadMeserosEvento the cantidadMeserosEvento to set
     */
    public void setCantidadMeserosEvento(Integer cantidadMeserosEvento) {
        this.cantidadMeserosEvento = cantidadMeserosEvento;
    }

    /**
     * @return the precioEvento
     */
    public Double getPrecioEvento() {
        return precioEvento;
    }

    /**
     * @param precioEvento the precioEvento to set
     */
    public void setPrecioEvento(Double precioEvento) {
        this.precioEvento = precioEvento;
    }

    /**
     * @return the observacionesEvento
     */
    public String getObservacionesEvento() {
        return observacionesEvento;
    }

    /**
     * @param observacionesEvento the observacionesEvento to set
     */
    public void setObservacionesEvento(String observacionesEvento) {
        this.observacionesEvento = observacionesEvento;
    }

    /**
     * @return the estadoEvento
     */
    public String getEstadoEvento() {
        return estadoEvento;
    }

    /**
     * @param estadoEvento the estadoEvento to set
     */
    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    /**
     * @return the detalleProductoSuministroService
     */
    public DetalleProductoSuministroService getDetalleProductoSuministroService() {
        return detalleProductoSuministroService;
    }

    /**
     * @param detalleProductoSuministroService the
     * detalleProductoSuministroService to set
     */
    public void setDetalleProductoSuministroService(DetalleProductoSuministroService detalleProductoSuministroService) {
        this.detalleProductoSuministroService = detalleProductoSuministroService;
    }

    /**
     * @return the horaInicioEventoDetalle
     */
    public Time getHoraInicioEventoDetalle() {
        return horaInicioEventoDetalle;
    }

    /**
     * @param horaInicioEventoDetalle the horaInicioEventoDetalle to set
     */
    public void setHoraInicioEventoDetalle(Time horaInicioEventoDetalle) {
        this.horaInicioEventoDetalle = horaInicioEventoDetalle;
    }

    /**
     * @return the horaFinEventoDetalle
     */
    public Time getHoraFinEventoDetalle() {
        return horaFinEventoDetalle;
    }

    /**
     * @param horaFinEventoDetalle the horaFinEventoDetalle to set
     */
    public void setHoraFinEventoDetalle(Time horaFinEventoDetalle) {
        this.horaFinEventoDetalle = horaFinEventoDetalle;
    }

    /**
     * @return the fechaEventoDetalle
     */
    public Date getFechaEventoDetalle() {
        return fechaEventoDetalle;
    }

    /**
     * @param fechaEventoDetalle the fechaEventoDetalle to set
     */
    public void setFechaEventoDetalle(Date fechaEventoDetalle) {
        this.fechaEventoDetalle = fechaEventoDetalle;
    }

    /**
     * @return the idSolicitud
     */
    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    /**
     * @return the paqueteBean
     */
    public PaqueteBean getPaqueteBean() {
        return paqueteBean;
    }

    /**
     * @param paqueteBean the paqueteBean to set
     */
    public void setPaqueteBean(PaqueteBean paqueteBean) {
        this.paqueteBean = paqueteBean;
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

    /**
     * @return the empleadosDual
     */
    public DualListModel<Long> getEmpleadosDual() {
        return empleadosDual;
    }

    /**
     * @param empleadosDual the empleadosDual to set
     */
    public void setEmpleadosDual(DualListModel<Long> empleadosDual) {
        this.empleadosDual = empleadosDual;
    }

    /**
     * @return the detalleEventoEmpleadoService
     */
    public DetalleEventoEmpleadoService getDetalleEventoEmpleadoService() {
        return detalleEventoEmpleadoService;
    }

    /**
     * @param detalleEventoEmpleadoService the detalleEventoEmpleadoService to
     * set
     */
    public void setDetalleEventoEmpleadoService(DetalleEventoEmpleadoService detalleEventoEmpleadoService) {
        this.detalleEventoEmpleadoService = detalleEventoEmpleadoService;
    }

    /**
     * @return the detalleEventoEmpleadoVO
     */
    public DetalleEventoEmpleadoVO getDetalleEventoEmpleadoVO() {
        return detalleEventoEmpleadoVO;
    }

    /**
     * @param detalleEventoEmpleadoVO the detalleEventoEmpleadoVO to set
     */
    public void setDetalleEventoEmpleadoVO(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) {
        this.detalleEventoEmpleadoVO = detalleEventoEmpleadoVO;
    }

    /**
     * @return the empleadoSource
     */
    public List<Long> getEmpleadoSource() {
        return empleadoSource;
    }

    /**
     * @param empleadoSource the empleadoSource to set
     */
    public void setEmpleadoSource(List<Long> empleadoSource) {
        this.empleadoSource = empleadoSource;
    }

    /**
     * @return the empleadoTarget
     */
    public List<Long> getEmpleadoTarget() {
        return empleadoTarget;
    }

    /**
     * @param empleadoTarget the empleadoTarget to set
     */
    public void setEmpleadoTarget(List<Long> empleadoTarget) {
        this.empleadoTarget = empleadoTarget;
    }

    /**
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
     * @return the identificacionEmpleado
     */
    public List<Long> getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    /**
     * @param identificacionEmpleado the identificacionEmpleado to set
     */
    public void setIdentificacionEmpleado(List<Long> identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    /**
     * @return the detallesEventoEmpleado
     */
    public List<DetalleEventoEmpleadoVO> getDetallesEventoEmpleado() {
        return detallesEventoEmpleado;
    }

    /**
     * @param detallesEventoEmpleado the detallesEventoEmpleado to set
     */
    public void setDetallesEventoEmpleado(List<DetalleEventoEmpleadoVO> detallesEventoEmpleado) {
        this.detallesEventoEmpleado = detallesEventoEmpleado;
    }

    /**
     * @return the empleadosDetalle
     */
    public List<EmpleadoVO> getEmpleadosDetalle() {
        return empleadosDetalle;
    }

    /**
     * @param empleadosDetalle the empleadosDetalle to set
     */
    public void setEmpleadosDetalle(List<EmpleadoVO> empleadosDetalle) {
        this.empleadosDetalle = empleadosDetalle;
    }

    /**
     * @return the animatedModel2
     */
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    /**
     * @param animatedModel2 the animatedModel2 to set
     */
    public void setAnimatedModel2(BarChartModel animatedModel2) {
        this.animatedModel2 = animatedModel2;
    }

    /**
     * @return the eventosGraficaMeses
     */
    public List<EventoVO> getEventosGraficaMeses() {
        return eventosGraficaMeses;
    }

    /**
     * @param eventosGraficaMeses the eventosGraficaMeses to set
     */
    public void setEventosGraficaMeses(List<EventoVO> eventosGraficaMeses) {
        this.eventosGraficaMeses = eventosGraficaMeses;
    }

    /**
     * @return the pieModel
     */
    public PieChartModel getPieModel() {
        return pieModel;
    }

    /**
     * @param pieModel the pieModel to set
     */
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    /**
     * @return the barModel
     */
    public BarChartModel getBarModel() {
        return barModel;
    }

    /**
     * @param barModel the barModel to set
     */
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    /**
     * @return the horizontalBarModel
     */
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    /**
     * @param horizontalBarModel the horizontalBarModel to set
     */
    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }

    /**
     * @return the barModel2
     */
    public BarChartModel getBarModel2() {
        return barModel2;
    }

    /**
     * @param barModel2 the barModel2 to set
     */
    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }

    /**
     * @return the eventosGraficaMeseEstado
     */
    public List<EventoVO> getEventosGraficaMeseEstado() {
        return eventosGraficaMeseEstado;
    }

    /**
     * @param eventosGraficaMeseEstado the eventosGraficaMeseEstado to set
     */
    public void setEventosGraficaMeseEstado(List<EventoVO> eventosGraficaMeseEstado) {
        this.eventosGraficaMeseEstado = eventosGraficaMeseEstado;
    }

}
