
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
 *         &lt;element name="opcion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="detalleEmpleado" type="{http://schemas.datacontract.org/2004/07/Dominio}detalle_empleado" minOccurs="0"/&gt;
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
    "opcion",
    "detalleEmpleado"
})
@XmlRootElement(name = "CUDDetalleEmpleado")
public class CUDDetalleEmpleado {

    protected Integer opcion;
    @XmlElementRef(name = "detalleEmpleado", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<DetalleEmpleado> detalleEmpleado;

    /**
     * Obtiene el valor de la propiedad opcion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOpcion() {
        return opcion;
    }

    /**
     * Define el valor de la propiedad opcion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOpcion(Integer value) {
        this.opcion = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DetalleEmpleado }{@code >}
     *     
     */
    public JAXBElement<DetalleEmpleado> getDetalleEmpleado() {
        return detalleEmpleado;
    }

    /**
     * Define el valor de la propiedad detalleEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DetalleEmpleado }{@code >}
     *     
     */
    public void setDetalleEmpleado(JAXBElement<DetalleEmpleado> value) {
        this.detalleEmpleado = value;
    }

}
