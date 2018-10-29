
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfmedida_producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfmedida_producto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="medida_producto" type="{http://schemas.datacontract.org/2004/07/Dominio}medida_producto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfmedida_producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "medidaProducto"
})
public class ArrayOfmedidaProducto {

    @XmlElement(name = "medida_producto", nillable = true)
    protected List<MedidaProducto> medidaProducto;

    /**
     * Gets the value of the medidaProducto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medidaProducto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedidaProducto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedidaProducto }
     * 
     * 
     */
    public List<MedidaProducto> getMedidaProducto() {
        if (medidaProducto == null) {
            medidaProducto = new ArrayList<MedidaProducto>();
        }
        return this.medidaProducto;
    }

}
