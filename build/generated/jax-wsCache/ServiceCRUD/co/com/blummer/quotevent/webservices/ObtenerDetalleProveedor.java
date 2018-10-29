
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
 *         &lt;element name="idDetalleProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="proveedorIdProvedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="productoIdSuministro" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "idDetalleProveedor",
    "proveedorIdProvedor",
    "productoIdSuministro",
    "estado"
})
@XmlRootElement(name = "ObtenerDetalleProveedor")
public class ObtenerDetalleProveedor {

    protected Integer idDetalleProveedor;
    protected Integer proveedorIdProvedor;
    protected Integer productoIdSuministro;
    @XmlElementRef(name = "estado", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;

    /**
     * Obtiene el valor de la propiedad idDetalleProveedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdDetalleProveedor() {
        return idDetalleProveedor;
    }

    /**
     * Define el valor de la propiedad idDetalleProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdDetalleProveedor(Integer value) {
        this.idDetalleProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedorIdProvedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProveedorIdProvedor() {
        return proveedorIdProvedor;
    }

    /**
     * Define el valor de la propiedad proveedorIdProvedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProveedorIdProvedor(Integer value) {
        this.proveedorIdProvedor = value;
    }

    /**
     * Obtiene el valor de la propiedad productoIdSuministro.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProductoIdSuministro() {
        return productoIdSuministro;
    }

    /**
     * Define el valor de la propiedad productoIdSuministro.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProductoIdSuministro(Integer value) {
        this.productoIdSuministro = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEstado(JAXBElement<String> value) {
        this.estado = value;
    }

}
