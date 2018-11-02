
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
 *         &lt;element name="ObtenerSuministrosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfsuministro" minOccurs="0"/&gt;
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
    "obtenerSuministrosResult"
})
@XmlRootElement(name = "ObtenerSuministrosResponse")
public class ObtenerSuministrosResponse {

    @XmlElementRef(name = "ObtenerSuministrosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfsuministro> obtenerSuministrosResult;

    /**
     * Obtiene el valor de la propiedad obtenerSuministrosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfsuministro }{@code >}
     *     
     */
    public JAXBElement<ArrayOfsuministro> getObtenerSuministrosResult() {
        return obtenerSuministrosResult;
    }

    /**
     * Define el valor de la propiedad obtenerSuministrosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfsuministro }{@code >}
     *     
     */
    public void setObtenerSuministrosResult(JAXBElement<ArrayOfsuministro> value) {
        this.obtenerSuministrosResult = value;
    }

}
