
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
 *         &lt;element name="evento" type="{http://schemas.datacontract.org/2004/07/Dominio}evento" minOccurs="0"/&gt;
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
    "evento"
})
@XmlRootElement(name = "CUDEvento")
public class CUDEvento {

    protected Integer opcion;
    @XmlElementRef(name = "evento", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<Evento> evento;

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
     * Obtiene el valor de la propiedad evento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Evento }{@code >}
     *     
     */
    public JAXBElement<Evento> getEvento() {
        return evento;
    }

    /**
     * Define el valor de la propiedad evento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Evento }{@code >}
     *     
     */
    public void setEvento(JAXBElement<Evento> value) {
        this.evento = value;
    }

}
