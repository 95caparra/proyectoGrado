
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
 *         &lt;element name="ObtenerTipoEventosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOftipo_evento" minOccurs="0"/&gt;
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
    "obtenerTipoEventosResult"
})
@XmlRootElement(name = "ObtenerTipoEventosResponse")
public class ObtenerTipoEventosResponse {

    @XmlElementRef(name = "ObtenerTipoEventosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOftipoEvento> obtenerTipoEventosResult;

    /**
     * Obtiene el valor de la propiedad obtenerTipoEventosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOftipoEvento }{@code >}
     *     
     */
    public JAXBElement<ArrayOftipoEvento> getObtenerTipoEventosResult() {
        return obtenerTipoEventosResult;
    }

    /**
     * Define el valor de la propiedad obtenerTipoEventosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOftipoEvento }{@code >}
     *     
     */
    public void setObtenerTipoEventosResult(JAXBElement<ArrayOftipoEvento> value) {
        this.obtenerTipoEventosResult = value;
    }

}
