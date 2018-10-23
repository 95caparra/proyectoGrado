
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contrasenia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="empleado" type="{http://schemas.datacontract.org/2004/07/Dominio}empleado" minOccurs="0"/&gt;
 *         &lt;element name="empleado_id_empleado" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_usuario" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="usuario1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuario", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "contrasenia",
    "empleado",
    "empleadoIdEmpleado",
    "estado",
    "idUsuario",
    "usuario1"
})
public class Usuario {

    @XmlElementRef(name = "contrasenia", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contrasenia;
    @XmlElementRef(name = "empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Empleado> empleado;
    @XmlElementRef(name = "empleado_id_empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> empleadoIdEmpleado;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElement(name = "id_usuario")
    protected Integer idUsuario;
    @XmlElementRef(name = "usuario1", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usuario1;

    /**
     * Obtiene el valor de la propiedad contrasenia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContrasenia() {
        return contrasenia;
    }

    /**
     * Define el valor de la propiedad contrasenia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContrasenia(JAXBElement<String> value) {
        this.contrasenia = value;
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
     * Obtiene el valor de la propiedad idUsuario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUsuario(Integer value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsuario1() {
        return usuario1;
    }

    /**
     * Define el valor de la propiedad usuario1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsuario1(JAXBElement<String> value) {
        this.usuario1 = value;
    }

}
