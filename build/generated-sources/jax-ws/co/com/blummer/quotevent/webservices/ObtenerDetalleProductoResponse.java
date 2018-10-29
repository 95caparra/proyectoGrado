
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
 *         &lt;element name="ObtenerDetalleProductoResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfdetalle_producto_suministro" minOccurs="0"/&gt;
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
    "obtenerDetalleProductoResult"
})
@XmlRootElement(name = "ObtenerDetalleProductoResponse")
public class ObtenerDetalleProductoResponse {

    @XmlElementRef(name = "ObtenerDetalleProductoResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfdetalleProductoSuministro> obtenerDetalleProductoResult;

    /**
     * Obtiene el valor de la propiedad obtenerDetalleProductoResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdetalleProductoSuministro }{@code >}
     *     
     */
    public JAXBElement<ArrayOfdetalleProductoSuministro> getObtenerDetalleProductoResult() {
        return obtenerDetalleProductoResult;
    }

    /**
     * Define el valor de la propiedad obtenerDetalleProductoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdetalleProductoSuministro }{@code >}
     *     
     */
    public void setObtenerDetalleProductoResult(JAXBElement<ArrayOfdetalleProductoSuministro> value) {
        this.obtenerDetalleProductoResult = value;
    }

}
