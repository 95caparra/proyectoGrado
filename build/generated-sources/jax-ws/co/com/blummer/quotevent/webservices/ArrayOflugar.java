
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOflugar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOflugar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lugar" type="{http://schemas.datacontract.org/2004/07/Dominio}lugar" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOflugar", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "lugar"
})
public class ArrayOflugar {

    @XmlElement(nillable = true)
    protected List<Lugar> lugar;

    /**
     * Gets the value of the lugar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lugar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLugar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lugar }
     * 
     * 
     */
    public List<Lugar> getLugar() {
        if (lugar == null) {
            lugar = new ArrayList<Lugar>();
        }
        return this.lugar;
    }

}
