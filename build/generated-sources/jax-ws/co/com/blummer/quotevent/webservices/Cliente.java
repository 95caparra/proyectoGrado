
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cliente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="celular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciudad1" type="{http://schemas.datacontract.org/2004/07/Dominio}ciudad" minOccurs="0"/&gt;
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_cliente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="n_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo_documento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tipo_documento1" type="{http://schemas.datacontract.org/2004/07/Dominio}tipo_documento" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "apellido",
    "celular",
    "ciudad",
    "ciudad1",
    "correo",
    "direccion",
    "estado",
    "idCliente",
    "nIdentificacion",
    "nombre",
    "telefono",
    "tipoDocumento",
    "tipoDocumento1"
})
public class Cliente {

    @XmlElementRef(name = "apellido", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> apellido;
    @XmlElementRef(name = "celular", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> celular;
    @XmlElementRef(name = "ciudad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> ciudad;
    @XmlElementRef(name = "ciudad1", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Ciudad> ciudad1;
    @XmlElementRef(name = "correo", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correo;
    @XmlElementRef(name = "direccion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> direccion;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElement(name = "id_cliente")
    protected Long idCliente;
    @XmlElementRef(name = "n_identificacion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nIdentificacion;
    @XmlElementRef(name = "nombre", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombre;
    @XmlElementRef(name = "telefono", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telefono;
    @XmlElement(name = "tipo_documento")
    protected Integer tipoDocumento;
    @XmlElementRef(name = "tipo_documento1", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<TipoDocumento> tipoDocumento1;

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApellido(JAXBElement<String> value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad celular.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCelular() {
        return celular;
    }

    /**
     * Define el valor de la propiedad celular.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCelular(JAXBElement<String> value) {
        this.celular = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCiudad(JAXBElement<Integer> value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Ciudad }{@code >}
     *     
     */
    public JAXBElement<Ciudad> getCiudad1() {
        return ciudad1;
    }

    /**
     * Define el valor de la propiedad ciudad1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Ciudad }{@code >}
     *     
     */
    public void setCiudad1(JAXBElement<Ciudad> value) {
        this.ciudad1 = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorreo(JAXBElement<String> value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDireccion(JAXBElement<String> value) {
        this.direccion = value;
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
     * Obtiene el valor de la propiedad idCliente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCliente(Long value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad nIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNIdentificacion() {
        return nIdentificacion;
    }

    /**
     * Define el valor de la propiedad nIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNIdentificacion(JAXBElement<String> value) {
        this.nIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombre(JAXBElement<String> value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelefono(JAXBElement<String> value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoDocumento(Integer value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumento1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}
     *     
     */
    public JAXBElement<TipoDocumento> getTipoDocumento1() {
        return tipoDocumento1;
    }

    /**
     * Define el valor de la propiedad tipoDocumento1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}
     *     
     */
    public void setTipoDocumento1(JAXBElement<TipoDocumento> value) {
        this.tipoDocumento1 = value;
    }

}
