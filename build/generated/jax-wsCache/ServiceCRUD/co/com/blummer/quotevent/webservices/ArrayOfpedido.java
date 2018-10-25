
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfpedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfpedido"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pedido" type="{http://schemas.datacontract.org/2004/07/Dominio}pedido" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfpedido", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "pedido"
})
public class ArrayOfpedido {

    @XmlElement(nillable = true)
    protected List<Pedido> pedido;

    /**
     * Gets the value of the pedido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pedido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPedido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pedido }
     * 
     * 
     */
    public List<Pedido> getPedido() {
        if (pedido == null) {
            pedido = new ArrayList<Pedido>();
        }
        return this.pedido;
    }

}
