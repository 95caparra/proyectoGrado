
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOftipo_evento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOftipo_evento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo_evento" type="{http://schemas.datacontract.org/2004/07/Dominio}tipo_evento" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftipo_evento", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "tipoEvento"
})
public class ArrayOftipoEvento {

    @XmlElement(name = "tipo_evento", nillable = true)
    protected List<TipoEvento> tipoEvento;

    /**
     * Gets the value of the tipoEvento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoEvento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoEvento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoEvento }
     * 
     * 
     */
    public List<TipoEvento> getTipoEvento() {
        if (tipoEvento == null) {
            tipoEvento = new ArrayList<TipoEvento>();
        }
        return this.tipoEvento;
    }

}
