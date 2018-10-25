
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfdetalle_empleado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfdetalle_empleado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detalle_empleado" type="{http://schemas.datacontract.org/2004/07/Dominio}detalle_empleado" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfdetalle_empleado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "detalleEmpleado"
})
public class ArrayOfdetalleEmpleado {

    @XmlElement(name = "detalle_empleado", nillable = true)
    protected List<DetalleEmpleado> detalleEmpleado;

    /**
     * Gets the value of the detalleEmpleado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleEmpleado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleEmpleado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleEmpleado }
     * 
     * 
     */
    public List<DetalleEmpleado> getDetalleEmpleado() {
        if (detalleEmpleado == null) {
            detalleEmpleado = new ArrayList<DetalleEmpleado>();
        }
        return this.detalleEmpleado;
    }

}
