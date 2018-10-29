
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
 *         &lt;element name="ObtenerUsuariosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfusuario" minOccurs="0"/&gt;
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
    "obtenerUsuariosResult"
})
@XmlRootElement(name = "ObtenerUsuariosResponse")
public class ObtenerUsuariosResponse {

    @XmlElementRef(name = "ObtenerUsuariosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfusuario> obtenerUsuariosResult;

    /**
     * Obtiene el valor de la propiedad obtenerUsuariosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfusuario }{@code >}
     *     
     */
    public JAXBElement<ArrayOfusuario> getObtenerUsuariosResult() {
        return obtenerUsuariosResult;
    }

    /**
     * Define el valor de la propiedad obtenerUsuariosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfusuario }{@code >}
     *     
     */
    public void setObtenerUsuariosResult(JAXBElement<ArrayOfusuario> value) {
        this.obtenerUsuariosResult = value;
    }

}
