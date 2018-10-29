
package co.com.blummer.quotevent.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfdetalle_producto_suministro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfdetalle_producto_suministro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detalle_producto_suministro" type="{http://schemas.datacontract.org/2004/07/Dominio}detalle_producto_suministro" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfdetalle_producto_suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "detalleProductoSuministro"
})
public class ArrayOfdetalleProductoSuministro {

    @XmlElement(name = "detalle_producto_suministro", nillable = true)
    protected List<DetalleProductoSuministro> detalleProductoSuministro;

    /**
     * Gets the value of the detalleProductoSuministro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleProductoSuministro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleProductoSuministro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleProductoSuministro }
     * 
     * 
     */
    public List<DetalleProductoSuministro> getDetalleProductoSuministro() {
        if (detalleProductoSuministro == null) {
            detalleProductoSuministro = new ArrayList<DetalleProductoSuministro>();
        }
        return this.detalleProductoSuministro;
    }

}
