
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
 *         &lt;element name="ObtenerProveedoresResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfproveedor" minOccurs="0"/&gt;
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
    "obtenerProveedoresResult"
})
@XmlRootElement(name = "ObtenerProveedoresResponse")
public class ObtenerProveedoresResponse {

    @XmlElementRef(name = "ObtenerProveedoresResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfproveedor> obtenerProveedoresResult;

    /**
     * Obtiene el valor de la propiedad obtenerProveedoresResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfproveedor }{@code >}
     *     
     */
    public JAXBElement<ArrayOfproveedor> getObtenerProveedoresResult() {
        return obtenerProveedoresResult;
    }

    /**
     * Define el valor de la propiedad obtenerProveedoresResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfproveedor }{@code >}
     *     
     */
    public void setObtenerProveedoresResult(JAXBElement<ArrayOfproveedor> value) {
        this.obtenerProveedoresResult = value;
    }

}
