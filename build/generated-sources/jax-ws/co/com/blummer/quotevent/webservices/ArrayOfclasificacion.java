
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfclasificacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfclasificacion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clasificacion" type="{http://schemas.datacontract.org/2004/07/Dominio}clasificacion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfclasificacion", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "clasificacion"
})
public class ArrayOfclasificacion {

    @XmlElement(nillable = true)
    protected List<Clasificacion> clasificacion;

    /**
     * Gets the value of the clasificacion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clasificacion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClasificacion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Clasificacion }
     * 
     * 
     */
    public List<Clasificacion> getClasificacion() {
        if (clasificacion == null) {
            clasificacion = new ArrayList<Clasificacion>();
        }
        return this.clasificacion;
    }

}
