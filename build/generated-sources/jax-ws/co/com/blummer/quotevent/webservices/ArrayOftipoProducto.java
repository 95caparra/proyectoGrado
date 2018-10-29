
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOftipo_producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOftipo_producto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo_producto" type="{http://schemas.datacontract.org/2004/07/Dominio}tipo_producto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftipo_producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "tipoProducto"
})
public class ArrayOftipoProducto {

    @XmlElement(name = "tipo_producto", nillable = true)
    protected List<TipoProducto> tipoProducto;

    /**
     * Gets the value of the tipoProducto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoProducto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoProducto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoProducto }
     * 
     * 
     */
    public List<TipoProducto> getTipoProducto() {
        if (tipoProducto == null) {
            tipoProducto = new ArrayList<TipoProducto>();
        }
        return this.tipoProducto;
    }

}
