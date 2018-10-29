
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
 *         &lt;element name="ObtenerPedidosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfpedido" minOccurs="0"/&gt;
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
    "obtenerPedidosResult"
})
@XmlRootElement(name = "ObtenerPedidosResponse")
public class ObtenerPedidosResponse {

    @XmlElementRef(name = "ObtenerPedidosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfpedido> obtenerPedidosResult;

    /**
     * Obtiene el valor de la propiedad obtenerPedidosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfpedido }{@code >}
     *     
     */
    public JAXBElement<ArrayOfpedido> getObtenerPedidosResult() {
        return obtenerPedidosResult;
    }

    /**
     * Define el valor de la propiedad obtenerPedidosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfpedido }{@code >}
     *     
     */
    public void setObtenerPedidosResult(JAXBElement<ArrayOfpedido> value) {
        this.obtenerPedidosResult = value;
    }

}
