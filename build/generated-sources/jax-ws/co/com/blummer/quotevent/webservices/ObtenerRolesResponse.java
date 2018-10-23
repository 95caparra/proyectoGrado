
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
 *         &lt;element name="ObtenerRolesResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfrol" minOccurs="0"/&gt;
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
    "obtenerRolesResult"
})
@XmlRootElement(name = "ObtenerRolesResponse")
public class ObtenerRolesResponse {

    @XmlElementRef(name = "ObtenerRolesResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfrol> obtenerRolesResult;

    /**
     * Obtiene el valor de la propiedad obtenerRolesResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfrol }{@code >}
     *     
     */
    public JAXBElement<ArrayOfrol> getObtenerRolesResult() {
        return obtenerRolesResult;
    }

    /**
     * Define el valor de la propiedad obtenerRolesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfrol }{@code >}
     *     
     */
    public void setObtenerRolesResult(JAXBElement<ArrayOfrol> value) {
        this.obtenerRolesResult = value;
    }

}
