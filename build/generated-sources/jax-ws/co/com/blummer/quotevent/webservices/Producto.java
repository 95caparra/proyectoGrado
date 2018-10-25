
package co.com.blummer.quotevent.webservices;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="producto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidad_minima" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="foto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_producto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="medida" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="medida_producto" type="{http://schemas.datacontract.org/2004/07/Dominio}medida_producto" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precio_unidad" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tipo_producto" type="{http://schemas.datacontract.org/2004/07/Dominio}tipo_producto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", propOrder = {
    "cantidadMinima",
    "estado",
    "foto",
    "idProducto",
    "medida",
    "medidaProducto",
    "nombre",
    "observaciones",
    "precioUnidad",
    "tipo",
    "tipoProducto"
})
public class Producto {

    @XmlElementRef(name = "cantidad_minima", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cantidadMinima;
    @XmlElementRef(name = "estado", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElementRef(name = "foto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> foto;
    @XmlElement(name = "id_producto")
    protected Integer idProducto;
    @XmlElementRef(name = "medida", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> medida;
    @XmlElementRef(name = "medida_producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<MedidaProducto> medidaProducto;
    @XmlElementRef(name = "nombre", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombre;
    @XmlElementRef(name = "observaciones", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> observaciones;
    @XmlElementRef(name = "precio_unidad", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> precioUnidad;
    @XmlElementRef(name = "tipo", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> tipo;
    @XmlElementRef(name = "tipo_producto", namespace = "http://schemas.datacontract.org/2004/07/Dominio", type = JAXBElement.class, required = false)
    protected JAXBElement<TipoProducto> tipoProducto;

    /**
     * Obtiene el valor de la propiedad cantidadMinima.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * Define el valor de la propiedad cantidadMinima.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCantidadMinima(JAXBElement<Integer> value) {
        this.cantidadMinima = value;
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
     * Obtiene el valor de la propiedad foto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFoto() {
        return foto;
    }

    /**
     * Define el valor de la propiedad foto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFoto(JAXBElement<String> value) {
        this.foto = value;
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
     * Obtiene el valor de la propiedad medida.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMedida() {
        return medida;
    }

    /**
     * Define el valor de la propiedad medida.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMedida(JAXBElement<Integer> value) {
        this.medida = value;
    }

    /**
     * Obtiene el valor de la propiedad medidaProducto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}
     *     
     */
    public JAXBElement<MedidaProducto> getMedidaProducto() {
        return medidaProducto;
    }

    /**
     * Define el valor de la propiedad medidaProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}
     *     
     */
    public void setMedidaProducto(JAXBElement<MedidaProducto> value) {
        this.medidaProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombre(JAXBElement<String> value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setObservaciones(JAXBElement<String> value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad precioUnidad.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * Define el valor de la propiedad precioUnidad.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPrecioUnidad(JAXBElement<BigDecimal> value) {
        this.precioUnidad = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTipo(JAXBElement<Integer> value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoProducto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TipoProducto }{@code >}
     *     
     */
    public JAXBElement<TipoProducto> getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Define el valor de la propiedad tipoProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TipoProducto }{@code >}
     *     
     */
    public void setTipoProducto(JAXBElement<TipoProducto> value) {
        this.tipoProducto = value;
    }

}
