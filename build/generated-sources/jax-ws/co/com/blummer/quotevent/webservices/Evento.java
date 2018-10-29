
package co.com.blummer.quotevent.webservices;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para evento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidad_meseros" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cantidad_personas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cliente" type="{http://schemas.datacontract.org/2004/07/Dominio}cliente" minOccurs="0"/&gt;
 *         &lt;element name="cliente_id_cliente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="estado_evento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estado_evento1" type="{http://schemas.datacontract.org/2004/07/Dominio}estado_evento" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="hora_fin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="hora_inicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="id_evento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id_lugar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="lugar" type="{http://schemas.datacontract.org/2004/07/Dominio}lugar" minOccurs="0"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="solicitud" type="{http://schemas.datacontract.org/2004/07/Dominio}solicitud" minOccurs="0"/&gt;
 *         &lt;element name="solicitud_id_solicitud" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipo_evento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tipo_evento1" type="{http://schemas.datacontract.org/2004/07/Dominio}tipo_evento" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evento", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "cantidadMeseros",
    "cantidadPersonas",
    "cliente",
    "clienteIdCliente",
    "estadoEvento",
    "estadoEvento1",
    "fecha",
    "horaFin",
    "horaInicio",
    "idEvento",
    "idLugar",
    "lugar",
    "observaciones",
    "precio",
    "solicitud",
    "solicitudIdSolicitud",
    "tipoEvento",
    "tipoEvento1"
})
public class Evento {

    @XmlElementRef(name = "cantidad_meseros", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cantidadMeseros;
    @XmlElementRef(name = "cantidad_personas", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cantidadPersonas;
    @XmlElementRef(name = "cliente", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Cliente> cliente;
    @XmlElementRef(name = "cliente_id_cliente", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> clienteIdCliente;
    @XmlElementRef(name = "estado_evento", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> estadoEvento;
    @XmlElementRef(name = "estado_evento1", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<EstadoEvento> estadoEvento1;
    @XmlElementRef(name = "fecha", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> fecha;
    @XmlElementRef(name = "hora_fin", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> horaFin;
    @XmlElementRef(name = "hora_inicio", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> horaInicio;
    @XmlElement(name = "id_evento")
    protected Long idEvento;
    @XmlElementRef(name = "id_lugar", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> idLugar;
    @XmlElementRef(name = "lugar", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Lugar> lugar;
    @XmlElementRef(name = "observaciones", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> observaciones;
    @XmlElementRef(name = "precio", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> precio;
    @XmlElementRef(name = "solicitud", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Solicitud> solicitud;
    @XmlElementRef(name = "solicitud_id_solicitud", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> solicitudIdSolicitud;
    @XmlElementRef(name = "tipo_evento", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> tipoEvento;
    @XmlElementRef(name = "tipo_evento1", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<TipoEvento> tipoEvento1;

    /**
     * Obtiene el valor de la propiedad cantidadMeseros.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCantidadMeseros() {
        return cantidadMeseros;
    }

    /**
     * Define el valor de la propiedad cantidadMeseros.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCantidadMeseros(JAXBElement<Integer> value) {
        this.cantidadMeseros = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadPersonas.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * Define el valor de la propiedad cantidadPersonas.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCantidadPersonas(JAXBElement<Integer> value) {
        this.cantidadPersonas = value;
    }

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Cliente }{@code >}
     *     
     */
    public JAXBElement<Cliente> getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Cliente }{@code >}
     *     
     */
    public void setCliente(JAXBElement<Cliente> value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteIdCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getClienteIdCliente() {
        return clienteIdCliente;
    }

    /**
     * Define el valor de la propiedad clienteIdCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setClienteIdCliente(JAXBElement<Long> value) {
        this.clienteIdCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEvento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getEstadoEvento() {
        return estadoEvento;
    }

    /**
     * Define el valor de la propiedad estadoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setEstadoEvento(JAXBElement<Integer> value) {
        this.estadoEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEvento1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}
     *     
     */
    public JAXBElement<EstadoEvento> getEstadoEvento1() {
        return estadoEvento1;
    }

    /**
     * Define el valor de la propiedad estadoEvento1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}
     *     
     */
    public void setEstadoEvento1(JAXBElement<EstadoEvento> value) {
        this.estadoEvento1 = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFecha(JAXBElement<XMLGregorianCalendar> value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad horaFin.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getHoraFin() {
        return horaFin;
    }

    /**
     * Define el valor de la propiedad horaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setHoraFin(JAXBElement<XMLGregorianCalendar> value) {
        this.horaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad horaInicio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getHoraInicio() {
        return horaInicio;
    }

    /**
     * Define el valor de la propiedad horaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setHoraInicio(JAXBElement<XMLGregorianCalendar> value) {
        this.horaInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad idEvento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdEvento() {
        return idEvento;
    }

    /**
     * Define el valor de la propiedad idEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdEvento(Long value) {
        this.idEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad idLugar.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIdLugar() {
        return idLugar;
    }

    /**
     * Define el valor de la propiedad idLugar.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIdLugar(JAXBElement<Integer> value) {
        this.idLugar = value;
    }

    /**
     * Obtiene el valor de la propiedad lugar.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Lugar }{@code >}
     *     
     */
    public JAXBElement<Lugar> getLugar() {
        return lugar;
    }

    /**
     * Define el valor de la propiedad lugar.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Lugar }{@code >}
     *     
     */
    public void setLugar(JAXBElement<Lugar> value) {
        this.lugar = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setObservaciones(JAXBElement<String> value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPrecio(JAXBElement<BigDecimal> value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitud.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Solicitud }{@code >}
     *     
     */
    public JAXBElement<Solicitud> getSolicitud() {
        return solicitud;
    }

    /**
     * Define el valor de la propiedad solicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Solicitud }{@code >}
     *     
     */
    public void setSolicitud(JAXBElement<Solicitud> value) {
        this.solicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitudIdSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSolicitudIdSolicitud() {
        return solicitudIdSolicitud;
    }

    /**
     * Define el valor de la propiedad solicitudIdSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSolicitudIdSolicitud(JAXBElement<Long> value) {
        this.solicitudIdSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoEvento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTipoEvento() {
        return tipoEvento;
    }

    /**
     * Define el valor de la propiedad tipoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTipoEvento(JAXBElement<Integer> value) {
        this.tipoEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoEvento1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}
     *     
     */
    public JAXBElement<TipoEvento> getTipoEvento1() {
        return tipoEvento1;
    }

    /**
     * Define el valor de la propiedad tipoEvento1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}
     *     
     */
    public void setTipoEvento1(JAXBElement<TipoEvento> value) {
        this.tipoEvento1 = value;
    }

}
