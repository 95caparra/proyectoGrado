
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
 *         &lt;element name="ObtenerLugaresResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOflugar" minOccurs="0"/&gt;
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
    "obtenerLugaresResult"
})
@XmlRootElement(name = "ObtenerLugaresResponse")
public class ObtenerLugaresResponse {

    @XmlElementRef(name = "ObtenerLugaresResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOflugar> obtenerLugaresResult;

    /**
     * Obtiene el valor de la propiedad obtenerLugaresResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflugar }{@code >}
     *     
     */
    public JAXBElement<ArrayOflugar> getObtenerLugaresResult() {
        return obtenerLugaresResult;
    }

    /**
     * Define el valor de la propiedad obtenerLugaresResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflugar }{@code >}
     *     
     */
    public void setObtenerLugaresResult(JAXBElement<ArrayOflugar> value) {
        this.obtenerLugaresResult = value;
    }

}
