
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para lugar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lugar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidad_persona_max" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciudad" type="{http://schemas.datacontract.org/2004/07/Dominio}ciudad" minOccurs="0"/&gt;
 *         &lt;element name="contacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_ciudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="id_lugar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono_contacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lugar", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "cantidadPersonaMax",
    "ciudad",
    "contacto",
    "descripcion",
    "direccion",
    "idCiudad",
    "idLugar",
    "nombre",
    "telefonoContacto",
    "ubicacion"
})
public class Lugar {

    @XmlElementRef(name = "cantidad_persona_max", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cantidadPersonaMax;
    @XmlElementRef(name = "ciudad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Ciudad> ciudad;
    @XmlElementRef(name = "contacto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contacto;
    @XmlElementRef(name = "descripcion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descripcion;
    @XmlElementRef(name = "direccion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> direccion;
    @XmlElementRef(name = "id_ciudad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> idCiudad;
    @XmlElement(name = "id_lugar")
    protected Integer idLugar;
    @XmlElementRef(name = "nombre", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombre;
    @XmlElementRef(name = "telefono_contacto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telefonoContacto;
    @XmlElementRef(name = "ubicacion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ubicacion;

    /**
     * Obtiene el valor de la propiedad cantidadPersonaMax.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCantidadPersonaMax() {
        return cantidadPersonaMax;
    }

    /**
     * Define el valor de la propiedad cantidadPersonaMax.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCantidadPersonaMax(JAXBElement<Integer> value) {
        this.cantidadPersonaMax = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Ciudad }{@code >}
     *     
     */
    public JAXBElement<Ciudad> getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Ciudad }{@code >}
     *     
     */
    public void setCiudad(JAXBElement<Ciudad> value) {
        this.ciudad = value;
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
     * Obtiene el valor de la propiedad idCiudad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIdCiudad() {
        return idCiudad;
    }

    /**
     * Define el valor de la propiedad idCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIdCiudad(JAXBElement<Integer> value) {
        this.idCiudad = value;
    }

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

}
