
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="idLugar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nombreLugar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantMaxPersonas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefonoContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCiudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
    "idLugar",
    "nombreLugar",
    "descripcion",
    "cantMaxPersonas",
    "direccion",
    "ubicacion",
    "contacto",
    "telefonoContacto",
    "idCiudad"
})
@XmlRootElement(name = "ObtenerLugares")
public class ObtenerLugares {

    protected Integer idLugar;
    @XmlElementRef(name = "nombreLugar", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombreLugar;
    @XmlElementRef(name = "descripcion", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descripcion;
    protected Integer cantMaxPersonas;
    @XmlElementRef(name = "direccion", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> direccion;
    @XmlElementRef(name = "ubicacion", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ubicacion;
    @XmlElementRef(name = "contacto", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contacto;
    @XmlElementRef(name = "telefonoContacto", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telefonoContacto;
    protected Integer idCiudad;

    /**
     * Obtiene el valor de la propiedad idLugar.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdLugar() {
        return idLugar;
    }

    /**
     * Define el valor de la propiedad idLugar.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdLugar(Integer value) {
        this.idLugar = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreLugar.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombreLugar() {
        return nombreLugar;
    }

    /**
     * Define el valor de la propiedad nombreLugar.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombreLugar(JAXBElement<String> value) {
        this.nombreLugar = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescripcion(JAXBElement<String> value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMaxPersonas.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantMaxPersonas() {
        return cantMaxPersonas;
    }

    /**
     * Define el valor de la propiedad cantMaxPersonas.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantMaxPersonas(Integer value) {
        this.cantMaxPersonas = value;
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
     * Obtiene el valor de la propiedad ubicacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUbicacion() {
        return ubicacion;
    }

    /**
     * Define el valor de la propiedad ubicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUbicacion(JAXBElement<String> value) {
        this.ubicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad contacto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContacto() {
        return contacto;
    }

    /**
     * Define el valor de la propiedad contacto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContacto(JAXBElement<String> value) {
        this.contacto = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoContacto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Define el valor de la propiedad telefonoContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelefonoContacto(JAXBElement<String> value) {
        this.telefonoContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad idCiudad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * Define el valor de la propiedad idCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCiudad(Integer value) {
        this.idCiudad = value;
    }

}
