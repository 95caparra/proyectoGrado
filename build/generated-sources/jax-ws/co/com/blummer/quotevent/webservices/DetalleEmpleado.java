
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para detalle_empleado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalle_empleado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calificacion" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="empleado" type="{http://schemas.datacontract.org/2004/07/Dominio}empleado" minOccurs="0"/&gt;
 *         &lt;element name="empleado_id_empleado" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="evento_id_evento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id_detalle_empleado" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalle_empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "calificacion",
    "empleado",
    "empleadoIdEmpleado",
    "estado",
    "eventoIdEvento",
    "idDetalleEmpleado"
})
public class DetalleEmpleado {

    @XmlElementRef(name = "calificacion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> calificacion;
    @XmlElementRef(name = "empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Empleado> empleado;
    @XmlElementRef(name = "empleado_id_empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> empleadoIdEmpleado;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElement(name = "evento_id_evento")
    protected Long eventoIdEvento;
    @XmlElement(name = "id_detalle_empleado")
    protected Long idDetalleEmpleado;

    /**
     * Obtiene el valor de la propiedad calificacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCalificacion() {
        return calificacion;
    }

    /**
     * Define el valor de la propiedad calificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCalificacion(JAXBElement<Double> value) {
        this.calificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad empleado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Empleado }{@code >}
     *     
     */
    public JAXBElement<Empleado> getEmpleado() {
        return empleado;
    }

    /**
     * Define el valor de la propiedad empleado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Empleado }{@code >}
     *     
     */
    public void setEmpleado(JAXBElement<Empleado> value) {
        this.empleado = value;
    }

    /**
     * Obtiene el valor de la propiedad empleadoIdEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    /**
     * Define el valor de la propiedad empleadoIdEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setEmpleadoIdEmpleado(JAXBElement<Long> value) {
        this.empleadoIdEmpleado = value;
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

    /**
     * Obtiene el valor de la propiedad eventoIdEvento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEventoIdEvento() {
        return eventoIdEvento;
    }

    /**
     * Define el valor de la propiedad eventoIdEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEventoIdEvento(Long value) {
        this.eventoIdEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad idDetalleEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDetalleEmpleado() {
        return idDetalleEmpleado;
    }

    /**
     * Define el valor de la propiedad idDetalleEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDetalleEmpleado(Long value) {
        this.idDetalleEmpleado = value;
    }

}
