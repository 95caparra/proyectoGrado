
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfciudad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfciudad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ciudad" type="{http://schemas.datacontract.org/2004/07/Dominio}ciudad" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfciudad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "ciudad"
})
public class ArrayOfciudad {

    @XmlElement(nillable = true)
    protected List<Ciudad> ciudad;

    /**
     * Gets the value of the ciudad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ciudad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCiudad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ciudad }
     * 
     * 
     */
    public List<Ciudad> getCiudad() {
        if (ciudad == null) {
            ciudad = new ArrayList<Ciudad>();
        }
        return this.ciudad;
    }

}
