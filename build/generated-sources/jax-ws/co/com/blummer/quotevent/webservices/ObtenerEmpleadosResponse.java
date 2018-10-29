
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
 *         &lt;element name="ObtenerEmpleadosResult" type="{http://schemas.datacontract.org/2004/07/Dominio}ArrayOfempleado" minOccurs="0"/&gt;
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
    "obtenerEmpleadosResult"
})
@XmlRootElement(name = "ObtenerEmpleadosResponse")
public class ObtenerEmpleadosResponse {

    @XmlElementRef(name = "ObtenerEmpleadosResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfempleado> obtenerEmpleadosResult;

    /**
     * Obtiene el valor de la propiedad obtenerEmpleadosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfempleado }{@code >}
     *     
     */
    public JAXBElement<ArrayOfempleado> getObtenerEmpleadosResult() {
        return obtenerEmpleadosResult;
    }

    /**
     * Define el valor de la propiedad obtenerEmpleadosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfempleado }{@code >}
     *     
     */
    public void setObtenerEmpleadosResult(JAXBElement<ArrayOfempleado> value) {
        this.obtenerEmpleadosResult = value;
    }

}
