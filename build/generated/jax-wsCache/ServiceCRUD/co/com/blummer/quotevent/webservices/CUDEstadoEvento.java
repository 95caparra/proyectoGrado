
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
 *         &lt;element name="opcion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estadoEvento" type="{http://schemas.datacontract.org/2004/07/Dominio}estado_evento" minOccurs="0"/&gt;
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
    "opcion",
    "estadoEvento"
})
@XmlRootElement(name = "CUDEstadoEvento")
public class CUDEstadoEvento {

    protected Integer opcion;
    @XmlElementRef(name = "estadoEvento", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<EstadoEvento> estadoEvento;

    /**
     * Obtiene el valor de la propiedad opcion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOpcion() {
        return opcion;
    }

    /**
     * Define el valor de la propiedad opcion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOpcion(Integer value) {
        this.opcion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEvento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}
     *     
     */
    public JAXBElement<EstadoEvento> getEstadoEvento() {
        return estadoEvento;
    }

    /**
     * Define el valor de la propiedad estadoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}
     *     
     */
    public void setEstadoEvento(JAXBElement<EstadoEvento> value) {
        this.estadoEvento = value;
    }

}
