
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para detalle_proveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalle_proveedor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="producto_id_suministro" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="proveedor" type="{http://schemas.datacontract.org/2004/07/Dominio}proveedor" minOccurs="0"/&gt;
 *         &lt;element name="proveedor_id_proveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="suministro" type="{http://schemas.datacontract.org/2004/07/Dominio}suministro" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalle_proveedor", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "id",
    "estado",
    "productoIdSuministro",
    "proveedor",
    "proveedorIdProveedor",
    "suministro"
})
public class DetalleProveedor {

    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElementRef(name = "producto_id_suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> productoIdSuministro;
    @XmlElementRef(name = "proveedor", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Proveedor> proveedor;
    @XmlElementRef(name = "proveedor_id_proveedor", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> proveedorIdProveedor;
    @XmlElementRef(name = "suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Suministro> suministro;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
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

    /**
     * Obtiene el valor de la propiedad productoIdSuministro.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getProductoIdSuministro() {
        return productoIdSuministro;
    }

    /**
     * Define el valor de la propiedad productoIdSuministro.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setProductoIdSuministro(JAXBElement<Integer> value) {
        this.productoIdSuministro = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedor.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Proveedor }{@code >}
     *     
     */
    public JAXBElement<Proveedor> getProveedor() {
        return proveedor;
    }

    /**
     * Define el valor de la propiedad proveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Proveedor }{@code >}
     *     
     */
    public void setProveedor(JAXBElement<Proveedor> value) {
        this.proveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedorIdProveedor.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getProveedorIdProveedor() {
        return proveedorIdProveedor;
    }

    /**
     * Define el valor de la propiedad proveedorIdProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setProveedorIdProveedor(JAXBElement<Integer> value) {
        this.proveedorIdProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad suministro.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Suministro }{@code >}
     *     
     */
    public JAXBElement<Suministro> getSuministro() {
        return suministro;
    }

    /**
     * Define el valor de la propiedad suministro.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Suministro }{@code >}
     *     
     */
    public void setSuministro(JAXBElement<Suministro> value) {
        this.suministro = value;
    }

}
