
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idPedido" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fechaPedido" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idMedidaProducto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaSugerida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idPedido",
    "idProducto",
    "idProveedor",
    "fechaPedido",
    "cantidad",
    "idMedidaProducto",
    "observaciones",
    "fechaSugerida",
    "estado"
})
@XmlRootElement(name = "ObtenerPedidos")
public class ObtenerPedidos {

    protected Integer idPedido;
    protected Integer idProducto;
    protected Integer idProveedor;
    @XmlElementRef(name = "fechaPedido", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> fechaPedido;
    @XmlElementRef(name = "cantidad", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cantidad;
    protected Integer idMedidaProducto;
    @XmlElementRef(name = "observaciones", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> observaciones;
    @XmlElementRef(name = "fechaSugerida", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fechaSugerida;
    @XmlElementRef(name = "estado", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;

    /**
     * Obtiene el valor de la propiedad idPedido.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPedido() {
        return idPedido;
    }

    /**
     * Define el valor de la propiedad idPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPedido(Integer value) {
        this.idPedido = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProducto(Integer value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad idProveedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * Define el valor de la propiedad idProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProveedor(Integer value) {
        this.idProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPedido.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Define el valor de la propiedad fechaPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFechaPedido(JAXBElement<XMLGregorianCalendar> value) {
        this.fechaPedido = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCantidad(JAXBElement<String> value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad idMedidaProducto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdMedidaProducto() {
        return idMedidaProducto;
    }

    /**
     * Define el valor de la propiedad idMedidaProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdMedidaProducto(Integer value) {
        this.idMedidaProducto = value;
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
     * Obtiene el valor de la propiedad fechaSugerida.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFechaSugerida() {
        return fechaSugerida;
    }

    /**
     * Define el valor de la propiedad fechaSugerida.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFechaSugerida(JAXBElement<String> value) {
        this.fechaSugerida = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEstado(JAXBElement<String> value) {
        this.estado = value;
    }

}
