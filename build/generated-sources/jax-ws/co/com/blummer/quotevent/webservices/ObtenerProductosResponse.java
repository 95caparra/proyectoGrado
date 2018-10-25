
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
 *         &lt;element name="ObtenerProductosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfproducto" minOccurs="0"/&gt;
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
    "obtenerProductosResult"
})
@XmlRootElement(name = "ObtenerProductosResponse")
public class ObtenerProductosResponse {

    @XmlElementRef(name = "ObtenerProductosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfproducto> obtenerProductosResult;

    /**
     * Obtiene el valor de la propiedad obtenerProductosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfproducto }{@code >}
     *     
     */
    public JAXBElement<ArrayOfproducto> getObtenerProductosResult() {
        return obtenerProductosResult;
    }

    /**
     * Define el valor de la propiedad obtenerProductosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfproducto }{@code >}
     *     
     */
    public void setObtenerProductosResult(JAXBElement<ArrayOfproducto> value) {
        this.obtenerProductosResult = value;
    }

}
