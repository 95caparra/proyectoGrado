
package co.com.blummer.quotevent.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para detalle_producto_suministro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalle_producto_suministro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="id_producto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="id_producto_suministro" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id_suministro" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="producto" type="{http://schemas.datacontract.org/2004/07/Dominio}producto" minOccurs="0"/&gt;
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
@XmlType(name = "detalle_producto_suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "cantidad",
    "estado",
    "idProducto",
    "idProductoSuministro",
    "idSuministro",
    "producto",
    "suministro"
})
public class DetalleProductoSuministro {

    @XmlElementRef(name = "cantidad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cantidad;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> estado;
    @XmlElement(name = "id_producto")
    protected Integer idProducto;
    @XmlElement(name = "id_producto_suministro")
    protected Long idProductoSuministro;
    @XmlElementRef(name = "id_suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> idSuministro;
    @XmlElementRef(name = "producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Producto> producto;
    @XmlElementRef(name = "suministro", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Suministro> suministro;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCantidad(JAXBElement<Integer> value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setEstado(JAXBElement<Integer> value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProducto(Integer value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad idProductoSuministro.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdProductoSuministro() {
        return idProductoSuministro;
    }

    /**
     * Define el valor de la propiedad idProductoSuministro.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdProductoSuministro(Long value) {
        this.idProductoSuministro = value;
    }

    /**
     * Obtiene el valor de la propiedad idSuministro.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIdSuministro() {
        return idSuministro;
    }

    /**
     * Define el valor de la propiedad idSuministro.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIdSuministro(JAXBElement<Integer> value) {
        this.idSuministro = value;
    }

    /**
     * Obtiene el valor de la propiedad producto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Producto }{@code >}
     *     
     */
    public JAXBElement<Producto> getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Producto }{@code >}
     *     
     */
    public void setProducto(JAXBElement<Producto> value) {
        this.producto = value;
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
