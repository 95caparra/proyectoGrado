
package co.com.blummer.quotevent.webservices;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.blummer.quotevent.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ciudad_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ciudad");
    private final static QName _Clasificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "clasificacion");
    private final static QName _Cliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cliente");
    private final static QName _TipoDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo_documento");
    private final static QName _DetalleEmpleado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "detalle_empleado");
    private final static QName _Empleado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "empleado");
    private final static QName _Rol_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "rol");
    private final static QName _DetalleProductoSuministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "detalle_producto_suministro");
    private final static QName _Producto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "producto");
    private final static QName _MedidaProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "medida_producto");
    private final static QName _ArrayOfpedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfpedido");
    private final static QName _Pedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "pedido");
    private final static QName _Proveedor_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "proveedor");
    private final static QName _TipoProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo_producto");
    private final static QName _Suministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "suministro");
    private final static QName _DetalleProveedor_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "detalle_proveedor");
    private final static QName _EstadoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "estado_evento");
    private final static QName _Evento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "evento");
    private final static QName _Lugar_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "lugar");
    private final static QName _Solicitud_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "solicitud");
    private final static QName _TipoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo_evento");
    private final static QName _Paquete_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "paquete");
    private final static QName _Usuario_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "usuario");
    private final static QName _ArrayOfciudad_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfciudad");
    private final static QName _ArrayOfclasificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfclasificacion");
    private final static QName _ArrayOfcliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfcliente");
    private final static QName _ArrayOfdetalleEmpleado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfdetalle_empleado");
    private final static QName _ArrayOfdetalleProductoSuministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfdetalle_producto_suministro");
    private final static QName _ArrayOfdetalleProveedor_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfdetalle_proveedor");
    private final static QName _ArrayOfempleado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfempleado");
    private final static QName _ArrayOfestadoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfestado_evento");
    private final static QName _ArrayOfevento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfevento");
    private final static QName _ArrayOflugar_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOflugar");
    private final static QName _ArrayOfmedidaProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfmedida_producto");
    private final static QName _ArrayOfpaquete_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfpaquete");
    private final static QName _ArrayOfproducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfproducto");
    private final static QName _ArrayOfproveedor_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfproveedor");
    private final static QName _ArrayOfrol_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfrol");
    private final static QName _ArrayOfsolicitud_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfsolicitud");
    private final static QName _ArrayOfsuministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfsuministro");
    private final static QName _ArrayOftipoDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOftipo_documento");
    private final static QName _ArrayOftipoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOftipo_evento");
    private final static QName _ArrayOftipoProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOftipo_producto");
    private final static QName _ArrayOfusuario_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ArrayOfusuario");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _CUDCiudadesCiudad_QNAME = new QName("http://tempuri.org/", "ciudad");
    private final static QName _CUDCiudadesResponseCUDCiudadesResult_QNAME = new QName("http://tempuri.org/", "CUDCiudadesResult");
    private final static QName _CUDClasificacionClasificacion_QNAME = new QName("http://tempuri.org/", "clasificacion");
    private final static QName _CUDClasificacionResponseCUDClasificacionResult_QNAME = new QName("http://tempuri.org/", "CUDClasificacionResult");
    private final static QName _CUDClienteCliente_QNAME = new QName("http://tempuri.org/", "cliente");
    private final static QName _CUDClienteResponseCUDClienteResult_QNAME = new QName("http://tempuri.org/", "CUDClienteResult");
    private final static QName _CUDDetalleEmpleadoDetalleEmpleado_QNAME = new QName("http://tempuri.org/", "detalleEmpleado");
    private final static QName _CUDDetalleEmpleadoResponseCUDDetalleEmpleadoResult_QNAME = new QName("http://tempuri.org/", "CUDDetalleEmpleadoResult");
    private final static QName _CUDDetalleProductoDetalleProducto_QNAME = new QName("http://tempuri.org/", "detalleProducto");
    private final static QName _CUDDetalleProductoResponseCUDDetalleProductoResult_QNAME = new QName("http://tempuri.org/", "CUDDetalleProductoResult");
    private final static QName _CUDDetalleProveedorDetalleProveedor_QNAME = new QName("http://tempuri.org/", "detalleProveedor");
    private final static QName _CUDDetalleProveedorResponseCUDDetalleProveedorResult_QNAME = new QName("http://tempuri.org/", "CUDDetalleProveedorResult");
    private final static QName _CUDEmpleadoEmpleado_QNAME = new QName("http://tempuri.org/", "empleado");
    private final static QName _CUDEmpleadoResponseCUDEmpleadoResult_QNAME = new QName("http://tempuri.org/", "CUDEmpleadoResult");
    private final static QName _CUDEstadoEventoEstadoEvento_QNAME = new QName("http://tempuri.org/", "estadoEvento");
    private final static QName _CUDEstadoEventoResponseCUDEstadoEventoResult_QNAME = new QName("http://tempuri.org/", "CUDEstadoEventoResult");
    private final static QName _CUDEventoEvento_QNAME = new QName("http://tempuri.org/", "evento");
    private final static QName _CUDEventoResponseCUDEventoResult_QNAME = new QName("http://tempuri.org/", "CUDEventoResult");
    private final static QName _CUDLugarLugar_QNAME = new QName("http://tempuri.org/", "lugar");
    private final static QName _CUDLugarResponseCUDLugarResult_QNAME = new QName("http://tempuri.org/", "CUDLugarResult");
    private final static QName _CUDMedidaProductoTipoDocumento_QNAME = new QName("http://tempuri.org/", "tipoDocumento");
    private final static QName _CUDMedidaProductoResponseCUDMedidaProductoResult_QNAME = new QName("http://tempuri.org/", "CUDMedidaProductoResult");
    private final static QName _CUDPaquetePaquete_QNAME = new QName("http://tempuri.org/", "paquete");
    private final static QName _CUDPaqueteResponseCUDPaqueteResult_QNAME = new QName("http://tempuri.org/", "CUDPaqueteResult");
    private final static QName _CUDPedidoPedido_QNAME = new QName("http://tempuri.org/", "pedido");
    private final static QName _CUDPedidoResponseCUDPedidoResult_QNAME = new QName("http://tempuri.org/", "CUDPedidoResult");
    private final static QName _CUDProductoProducto_QNAME = new QName("http://tempuri.org/", "producto");
    private final static QName _CUDProductoResponseCUDProductoResult_QNAME = new QName("http://tempuri.org/", "CUDProductoResult");
    private final static QName _CUDProveedorProveedor_QNAME = new QName("http://tempuri.org/", "proveedor");
    private final static QName _CUDProveedorResponseCUDProveedorResult_QNAME = new QName("http://tempuri.org/", "CUDProveedorResult");
    private final static QName _CUDRolesRol_QNAME = new QName("http://tempuri.org/", "rol");
    private final static QName _CUDRolesResponseCUDRolesResult_QNAME = new QName("http://tempuri.org/", "CUDRolesResult");
    private final static QName _CUDSolicitudesSolicitud_QNAME = new QName("http://tempuri.org/", "solicitud");
    private final static QName _CUDSolicitudesResponseCUDSolicitudesResult_QNAME = new QName("http://tempuri.org/", "CUDSolicitudesResult");
    private final static QName _CUDSuministroSuministro_QNAME = new QName("http://tempuri.org/", "suministro");
    private final static QName _CUDSuministroResponseCUDSuministroResult_QNAME = new QName("http://tempuri.org/", "CUDSuministroResult");
    private final static QName _CUDTipoDocumentoResponseCUDTipoDocumentoResult_QNAME = new QName("http://tempuri.org/", "CUDTipoDocumentoResult");
    private final static QName _CUDTipoEventoTipoEvento_QNAME = new QName("http://tempuri.org/", "tipoEvento");
    private final static QName _CUDTipoEventoResponseCUDTipoEventoResult_QNAME = new QName("http://tempuri.org/", "CUDTipoEventoResult");
    private final static QName _CUDTipoProductoTipoProducto_QNAME = new QName("http://tempuri.org/", "tipoProducto");
    private final static QName _CUDTipoProductoResponseCUDTipoProductoResult_QNAME = new QName("http://tempuri.org/", "CUDTipoProductoResult");
    private final static QName _CUDUsuarioUsuario_QNAME = new QName("http://tempuri.org/", "usuario");
    private final static QName _CUDUsuarioResponseCUDUsuarioResult_QNAME = new QName("http://tempuri.org/", "CUDUsuarioResult");
    private final static QName _ObtenerCiudadesNombre_QNAME = new QName("http://tempuri.org/", "nombre");
    private final static QName _ObtenerCiudadesResponseObtenerCiudadesResult_QNAME = new QName("http://tempuri.org/", "ObtenerCiudadesResult");
    private final static QName _ObtenerClasificacionNombreClasificacion_QNAME = new QName("http://tempuri.org/", "nombreClasificacion");
    private final static QName _ObtenerClasificacionResponseObtenerClasificacionResult_QNAME = new QName("http://tempuri.org/", "ObtenerClasificacionResult");
    private final static QName _ObtenerClientesNombreCliente_QNAME = new QName("http://tempuri.org/", "nombreCliente");
    private final static QName _ObtenerClientesNumeroIdentificacion_QNAME = new QName("http://tempuri.org/", "numeroIdentificacion");
    private final static QName _ObtenerClientesApellido_QNAME = new QName("http://tempuri.org/", "apellido");
    private final static QName _ObtenerClientesTelefono_QNAME = new QName("http://tempuri.org/", "telefono");
    private final static QName _ObtenerClientesCelular_QNAME = new QName("http://tempuri.org/", "celular");
    private final static QName _ObtenerClientesDireccion_QNAME = new QName("http://tempuri.org/", "direccion");
    private final static QName _ObtenerClientesCorreo_QNAME = new QName("http://tempuri.org/", "correo");
    private final static QName _ObtenerClientesEstado_QNAME = new QName("http://tempuri.org/", "estado");
    private final static QName _ObtenerClientesResponseObtenerClientesResult_QNAME = new QName("http://tempuri.org/", "ObtenerClientesResult");
    private final static QName _ObtenerDetalleEmpleadoResponseObtenerDetalleEmpleadoResult_QNAME = new QName("http://tempuri.org/", "ObtenerDetalleEmpleadoResult");
    private final static QName _ObtenerDetalleProductoResponseObtenerDetalleProductoResult_QNAME = new QName("http://tempuri.org/", "ObtenerDetalleProductoResult");
    private final static QName _ObtenerDetalleProveedorResponseObtenerDetalleProveedorResult_QNAME = new QName("http://tempuri.org/", "ObtenerDetalleProveedorResult");
    private final static QName _ObtenerEmpleadosNombreEmpleado_QNAME = new QName("http://tempuri.org/", "nombreEmpleado");
    private final static QName _ObtenerEmpleadosApellidoEmpleado_QNAME = new QName("http://tempuri.org/", "apellidoEmpleado");
    private final static QName _ObtenerEmpleadosBarrio_QNAME = new QName("http://tempuri.org/", "barrio");
    private final static QName _ObtenerEmpleadosResponseObtenerEmpleadosResult_QNAME = new QName("http://tempuri.org/", "ObtenerEmpleadosResult");
    private final static QName _ObtenerEstadosEventosResponseObtenerEstadosEventosResult_QNAME = new QName("http://tempuri.org/", "ObtenerEstadosEventosResult");
    private final static QName _ObtenerEventosObservaciones_QNAME = new QName("http://tempuri.org/", "observaciones");
    private final static QName _ObtenerEventosResponseObtenerEventosResult_QNAME = new QName("http://tempuri.org/", "ObtenerEventosResult");
    private final static QName _ObtenerLugaresNombreLugar_QNAME = new QName("http://tempuri.org/", "nombreLugar");
    private final static QName _ObtenerLugaresDescripcion_QNAME = new QName("http://tempuri.org/", "descripcion");
    private final static QName _ObtenerLugaresUbicacion_QNAME = new QName("http://tempuri.org/", "ubicacion");
    private final static QName _ObtenerLugaresContacto_QNAME = new QName("http://tempuri.org/", "contacto");
    private final static QName _ObtenerLugaresTelefonoContacto_QNAME = new QName("http://tempuri.org/", "telefonoContacto");
    private final static QName _ObtenerLugaresResponseObtenerLugaresResult_QNAME = new QName("http://tempuri.org/", "ObtenerLugaresResult");
    private final static QName _ObtenerMedidasNombreMedidaProducto_QNAME = new QName("http://tempuri.org/", "nombreMedidaProducto");
    private final static QName _ObtenerMedidasResponseObtenerMedidasResult_QNAME = new QName("http://tempuri.org/", "ObtenerMedidasResult");
    private final static QName _ObtenerPaquetesNombrePaquete_QNAME = new QName("http://tempuri.org/", "nombrePaquete");
    private final static QName _ObtenerPaquetesPdf_QNAME = new QName("http://tempuri.org/", "pdf");
    private final static QName _ObtenerPaquetesFoto_QNAME = new QName("http://tempuri.org/", "foto");
    private final static QName _ObtenerPaquetesResponseObtenerPaquetesResult_QNAME = new QName("http://tempuri.org/", "ObtenerPaquetesResult");
    private final static QName _ObtenerPedidosFechaPedido_QNAME = new QName("http://tempuri.org/", "fechaPedido");
    private final static QName _ObtenerPedidosCantidad_QNAME = new QName("http://tempuri.org/", "cantidad");
    private final static QName _ObtenerPedidosFechaSugerida_QNAME = new QName("http://tempuri.org/", "fechaSugerida");
    private final static QName _ObtenerPedidosResponseObtenerPedidosResult_QNAME = new QName("http://tempuri.org/", "ObtenerPedidosResult");
    private final static QName _ObtenerProductosResponseObtenerProductosResult_QNAME = new QName("http://tempuri.org/", "ObtenerProductosResult");
    private final static QName _ObtenerProveedoresRazonSocial_QNAME = new QName("http://tempuri.org/", "razonSocial");
    private final static QName _ObtenerProveedoresResponseObtenerProveedoresResult_QNAME = new QName("http://tempuri.org/", "ObtenerProveedoresResult");
    private final static QName _ObtenerRolesNombreRol_QNAME = new QName("http://tempuri.org/", "nombreRol");
    private final static QName _ObtenerRolesResponseObtenerRolesResult_QNAME = new QName("http://tempuri.org/", "ObtenerRolesResult");
    private final static QName _ObtenerSolicitudesEmail_QNAME = new QName("http://tempuri.org/", "email");
    private final static QName _ObtenerSolicitudesHora_QNAME = new QName("http://tempuri.org/", "hora");
    private final static QName _ObtenerSolicitudesResponseObtenerSolicitudesResult_QNAME = new QName("http://tempuri.org/", "ObtenerSolicitudesResult");
    private final static QName _ObtenerSuministrosNombreSuministro_QNAME = new QName("http://tempuri.org/", "nombreSuministro");
    private final static QName _ObtenerSuministrosResponseObtenerSuministrosResult_QNAME = new QName("http://tempuri.org/", "ObtenerSuministrosResult");
    private final static QName _ObtenerTipoDocumentosNombreTipoDocumento_QNAME = new QName("http://tempuri.org/", "nombreTipoDocumento");
    private final static QName _ObtenerTipoDocumentosAbreviatura_QNAME = new QName("http://tempuri.org/", "abreviatura");
    private final static QName _ObtenerTipoDocumentosResponseObtenerTipoDocumentosResult_QNAME = new QName("http://tempuri.org/", "ObtenerTipoDocumentosResult");
    private final static QName _ObtenerTipoEventosNombreTipoEvento_QNAME = new QName("http://tempuri.org/", "nombreTipoEvento");
    private final static QName _ObtenerTipoEventosResponseObtenerTipoEventosResult_QNAME = new QName("http://tempuri.org/", "ObtenerTipoEventosResult");
    private final static QName _ObtenerTipoProductosNombreTipoProducto_QNAME = new QName("http://tempuri.org/", "nombreTipoProducto");
    private final static QName _ObtenerTipoProductosResponseObtenerTipoProductosResult_QNAME = new QName("http://tempuri.org/", "ObtenerTipoProductosResult");
    private final static QName _ObtenerUsuariosNombreUsuario_QNAME = new QName("http://tempuri.org/", "nombreUsuario");
    private final static QName _ObtenerUsuariosResponseObtenerUsuariosResult_QNAME = new QName("http://tempuri.org/", "ObtenerUsuariosResult");
    private final static QName _UsuarioContrasenia_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "contrasenia");
    private final static QName _UsuarioEmpleadoIdEmpleado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "empleado_id_empleado");
    private final static QName _UsuarioEstado_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "estado");
    private final static QName _UsuarioUsuario1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "usuario1");
    private final static QName _TipoProductoNombre_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "nombre");
    private final static QName _TipoDocumentoAbreviatura_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "abreviatura");
    private final static QName _TipoDocumentoDescripcionDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "descripcion_documento");
    private final static QName _SuministroCantidad_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cantidad");
    private final static QName _SuministroCantidadMinima_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cantidad_minima");
    private final static QName _SuministroFoto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "foto");
    private final static QName _SuministroMedida_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "medida");
    private final static QName _SuministroObservaciones_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "observaciones");
    private final static QName _SuministroPrecioUnidad_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "precio_unidad");
    private final static QName _SolicitudCantidadPersonas_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cantidad_personas");
    private final static QName _SolicitudEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "email");
    private final static QName _SolicitudFecha_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "fecha");
    private final static QName _SolicitudHora_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "hora");
    private final static QName _SolicitudIdTipoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_tipo_evento");
    private final static QName _SolicitudNombreCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "nombre_cliente");
    private final static QName _SolicitudTelefono_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "telefono");
    private final static QName _SolicitudVisto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "visto");
    private final static QName _ProveedorCorreo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "correo");
    private final static QName _ProveedorDireccion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "direccion");
    private final static QName _ProveedorRazonSocial_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "razon_social");
    private final static QName _ProductoTipo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo");
    private final static QName _PedidoFechaPedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "fecha_pedido");
    private final static QName _PedidoFechaSugerida_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "fecha_sugerida");
    private final static QName _PedidoIdMedidaProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_medida_producto");
    private final static QName _PedidoProductoIdProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "producto_id_producto");
    private final static QName _PedidoProveedorIdProveedor_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "proveedor_id_proveedor");
    private final static QName _PaqueteClasificacionIdClasificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "clasificacion_id_clasificacion");
    private final static QName _PaqueteDescripcion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "descripcion");
    private final static QName _PaqueteIdLugar_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_lugar");
    private final static QName _PaquetePdf_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "pdf");
    private final static QName _PaquetePrecio_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "precio");
    private final static QName _LugarCantidadPersonaMax_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cantidad_persona_max");
    private final static QName _LugarContacto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "contacto");
    private final static QName _LugarIdCiudad_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_ciudad");
    private final static QName _LugarTelefonoContacto_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "telefono_contacto");
    private final static QName _LugarUbicacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ubicacion");
    private final static QName _EventoCantidadMeseros_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cantidad_meseros");
    private final static QName _EventoClienteIdCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "cliente_id_cliente");
    private final static QName _EventoEstadoEvento1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "estado_evento1");
    private final static QName _EventoHoraFin_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "hora_fin");
    private final static QName _EventoHoraInicio_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "hora_inicio");
    private final static QName _EventoSolicitudIdSolicitud_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "solicitud_id_solicitud");
    private final static QName _EventoTipoEvento1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo_evento1");
    private final static QName _EmpleadoApellido_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "apellido");
    private final static QName _EmpleadoBarrio_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "barrio");
    private final static QName _EmpleadoEmpleadoIdRol_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "empleado_id_rol");
    private final static QName _EmpleadoIdTipoDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_tipo_documento");
    private final static QName _EmpleadoNIdentificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "n_identificacion");
    private final static QName _DetalleProveedorProductoIdSuministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "producto_id_suministro");
    private final static QName _DetalleProductoSuministroIdSuministro_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "id_suministro");
    private final static QName _DetalleEmpleadoCalificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "calificacion");
    private final static QName _ClienteCelular_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "celular");
    private final static QName _ClienteCiudad1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "ciudad1");
    private final static QName _ClienteTipoDocumento1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "tipo_documento1");
    private final static QName _CiudadNombre_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dominio", "Nombre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.blummer.quotevent.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CUDCiudades }
     * 
     */
    public CUDCiudades createCUDCiudades() {
        return new CUDCiudades();
    }

    /**
     * Create an instance of {@link Ciudad }
     * 
     */
    public Ciudad createCiudad() {
        return new Ciudad();
    }

    /**
     * Create an instance of {@link CUDCiudadesResponse }
     * 
     */
    public CUDCiudadesResponse createCUDCiudadesResponse() {
        return new CUDCiudadesResponse();
    }

    /**
     * Create an instance of {@link CUDClasificacion }
     * 
     */
    public CUDClasificacion createCUDClasificacion() {
        return new CUDClasificacion();
    }

    /**
     * Create an instance of {@link Clasificacion }
     * 
     */
    public Clasificacion createClasificacion() {
        return new Clasificacion();
    }

    /**
     * Create an instance of {@link CUDClasificacionResponse }
     * 
     */
    public CUDClasificacionResponse createCUDClasificacionResponse() {
        return new CUDClasificacionResponse();
    }

    /**
     * Create an instance of {@link CUDCliente }
     * 
     */
    public CUDCliente createCUDCliente() {
        return new CUDCliente();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link CUDClienteResponse }
     * 
     */
    public CUDClienteResponse createCUDClienteResponse() {
        return new CUDClienteResponse();
    }

    /**
     * Create an instance of {@link CUDDetalleEmpleado }
     * 
     */
    public CUDDetalleEmpleado createCUDDetalleEmpleado() {
        return new CUDDetalleEmpleado();
    }

    /**
     * Create an instance of {@link DetalleEmpleado }
     * 
     */
    public DetalleEmpleado createDetalleEmpleado() {
        return new DetalleEmpleado();
    }

    /**
     * Create an instance of {@link CUDDetalleEmpleadoResponse }
     * 
     */
    public CUDDetalleEmpleadoResponse createCUDDetalleEmpleadoResponse() {
        return new CUDDetalleEmpleadoResponse();
    }

    /**
     * Create an instance of {@link CUDDetalleProducto }
     * 
     */
    public CUDDetalleProducto createCUDDetalleProducto() {
        return new CUDDetalleProducto();
    }

    /**
     * Create an instance of {@link DetalleProductoSuministro }
     * 
     */
    public DetalleProductoSuministro createDetalleProductoSuministro() {
        return new DetalleProductoSuministro();
    }

    /**
     * Create an instance of {@link CUDDetalleProductoResponse }
     * 
     */
    public CUDDetalleProductoResponse createCUDDetalleProductoResponse() {
        return new CUDDetalleProductoResponse();
    }

    /**
     * Create an instance of {@link CUDDetalleProveedor }
     * 
     */
    public CUDDetalleProveedor createCUDDetalleProveedor() {
        return new CUDDetalleProveedor();
    }

    /**
     * Create an instance of {@link DetalleProveedor }
     * 
     */
    public DetalleProveedor createDetalleProveedor() {
        return new DetalleProveedor();
    }

    /**
     * Create an instance of {@link CUDDetalleProveedorResponse }
     * 
     */
    public CUDDetalleProveedorResponse createCUDDetalleProveedorResponse() {
        return new CUDDetalleProveedorResponse();
    }

    /**
     * Create an instance of {@link CUDEmpleado }
     * 
     */
    public CUDEmpleado createCUDEmpleado() {
        return new CUDEmpleado();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link CUDEmpleadoResponse }
     * 
     */
    public CUDEmpleadoResponse createCUDEmpleadoResponse() {
        return new CUDEmpleadoResponse();
    }

    /**
     * Create an instance of {@link CUDEstadoEvento }
     * 
     */
    public CUDEstadoEvento createCUDEstadoEvento() {
        return new CUDEstadoEvento();
    }

    /**
     * Create an instance of {@link EstadoEvento }
     * 
     */
    public EstadoEvento createEstadoEvento() {
        return new EstadoEvento();
    }

    /**
     * Create an instance of {@link CUDEstadoEventoResponse }
     * 
     */
    public CUDEstadoEventoResponse createCUDEstadoEventoResponse() {
        return new CUDEstadoEventoResponse();
    }

    /**
     * Create an instance of {@link CUDEvento }
     * 
     */
    public CUDEvento createCUDEvento() {
        return new CUDEvento();
    }

    /**
     * Create an instance of {@link Evento }
     * 
     */
    public Evento createEvento() {
        return new Evento();
    }

    /**
     * Create an instance of {@link CUDEventoResponse }
     * 
     */
    public CUDEventoResponse createCUDEventoResponse() {
        return new CUDEventoResponse();
    }

    /**
     * Create an instance of {@link CUDLugar }
     * 
     */
    public CUDLugar createCUDLugar() {
        return new CUDLugar();
    }

    /**
     * Create an instance of {@link Lugar }
     * 
     */
    public Lugar createLugar() {
        return new Lugar();
    }

    /**
     * Create an instance of {@link CUDLugarResponse }
     * 
     */
    public CUDLugarResponse createCUDLugarResponse() {
        return new CUDLugarResponse();
    }

    /**
     * Create an instance of {@link CUDMedidaProducto }
     * 
     */
    public CUDMedidaProducto createCUDMedidaProducto() {
        return new CUDMedidaProducto();
    }

    /**
     * Create an instance of {@link MedidaProducto }
     * 
     */
    public MedidaProducto createMedidaProducto() {
        return new MedidaProducto();
    }

    /**
     * Create an instance of {@link CUDMedidaProductoResponse }
     * 
     */
    public CUDMedidaProductoResponse createCUDMedidaProductoResponse() {
        return new CUDMedidaProductoResponse();
    }

    /**
     * Create an instance of {@link CUDPaquete }
     * 
     */
    public CUDPaquete createCUDPaquete() {
        return new CUDPaquete();
    }

    /**
     * Create an instance of {@link Paquete }
     * 
     */
    public Paquete createPaquete() {
        return new Paquete();
    }

    /**
     * Create an instance of {@link CUDPaqueteResponse }
     * 
     */
    public CUDPaqueteResponse createCUDPaqueteResponse() {
        return new CUDPaqueteResponse();
    }

    /**
     * Create an instance of {@link CUDPedido }
     * 
     */
    public CUDPedido createCUDPedido() {
        return new CUDPedido();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link CUDPedidoResponse }
     * 
     */
    public CUDPedidoResponse createCUDPedidoResponse() {
        return new CUDPedidoResponse();
    }

    /**
     * Create an instance of {@link CUDProducto }
     * 
     */
    public CUDProducto createCUDProducto() {
        return new CUDProducto();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link CUDProductoResponse }
     * 
     */
    public CUDProductoResponse createCUDProductoResponse() {
        return new CUDProductoResponse();
    }

    /**
     * Create an instance of {@link CUDProveedor }
     * 
     */
    public CUDProveedor createCUDProveedor() {
        return new CUDProveedor();
    }

    /**
     * Create an instance of {@link Proveedor }
     * 
     */
    public Proveedor createProveedor() {
        return new Proveedor();
    }

    /**
     * Create an instance of {@link CUDProveedorResponse }
     * 
     */
    public CUDProveedorResponse createCUDProveedorResponse() {
        return new CUDProveedorResponse();
    }

    /**
     * Create an instance of {@link CUDRoles }
     * 
     */
    public CUDRoles createCUDRoles() {
        return new CUDRoles();
    }

    /**
     * Create an instance of {@link Rol }
     * 
     */
    public Rol createRol() {
        return new Rol();
    }

    /**
     * Create an instance of {@link CUDRolesResponse }
     * 
     */
    public CUDRolesResponse createCUDRolesResponse() {
        return new CUDRolesResponse();
    }

    /**
     * Create an instance of {@link CUDSolicitudes }
     * 
     */
    public CUDSolicitudes createCUDSolicitudes() {
        return new CUDSolicitudes();
    }

    /**
     * Create an instance of {@link Solicitud }
     * 
     */
    public Solicitud createSolicitud() {
        return new Solicitud();
    }

    /**
     * Create an instance of {@link CUDSolicitudesResponse }
     * 
     */
    public CUDSolicitudesResponse createCUDSolicitudesResponse() {
        return new CUDSolicitudesResponse();
    }

    /**
     * Create an instance of {@link CUDSuministro }
     * 
     */
    public CUDSuministro createCUDSuministro() {
        return new CUDSuministro();
    }

    /**
     * Create an instance of {@link Suministro }
     * 
     */
    public Suministro createSuministro() {
        return new Suministro();
    }

    /**
     * Create an instance of {@link CUDSuministroResponse }
     * 
     */
    public CUDSuministroResponse createCUDSuministroResponse() {
        return new CUDSuministroResponse();
    }

    /**
     * Create an instance of {@link CUDTipoDocumento }
     * 
     */
    public CUDTipoDocumento createCUDTipoDocumento() {
        return new CUDTipoDocumento();
    }

    /**
     * Create an instance of {@link TipoDocumento }
     * 
     */
    public TipoDocumento createTipoDocumento() {
        return new TipoDocumento();
    }

    /**
     * Create an instance of {@link CUDTipoDocumentoResponse }
     * 
     */
    public CUDTipoDocumentoResponse createCUDTipoDocumentoResponse() {
        return new CUDTipoDocumentoResponse();
    }

    /**
     * Create an instance of {@link CUDTipoEvento }
     * 
     */
    public CUDTipoEvento createCUDTipoEvento() {
        return new CUDTipoEvento();
    }

    /**
     * Create an instance of {@link TipoEvento }
     * 
     */
    public TipoEvento createTipoEvento() {
        return new TipoEvento();
    }

    /**
     * Create an instance of {@link CUDTipoEventoResponse }
     * 
     */
    public CUDTipoEventoResponse createCUDTipoEventoResponse() {
        return new CUDTipoEventoResponse();
    }

    /**
     * Create an instance of {@link CUDTipoProducto }
     * 
     */
    public CUDTipoProducto createCUDTipoProducto() {
        return new CUDTipoProducto();
    }

    /**
     * Create an instance of {@link TipoProducto }
     * 
     */
    public TipoProducto createTipoProducto() {
        return new TipoProducto();
    }

    /**
     * Create an instance of {@link CUDTipoProductoResponse }
     * 
     */
    public CUDTipoProductoResponse createCUDTipoProductoResponse() {
        return new CUDTipoProductoResponse();
    }

    /**
     * Create an instance of {@link CUDUsuario }
     * 
     */
    public CUDUsuario createCUDUsuario() {
        return new CUDUsuario();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link CUDUsuarioResponse }
     * 
     */
    public CUDUsuarioResponse createCUDUsuarioResponse() {
        return new CUDUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerCiudades }
     * 
     */
    public ObtenerCiudades createObtenerCiudades() {
        return new ObtenerCiudades();
    }

    /**
     * Create an instance of {@link ObtenerCiudadesResponse }
     * 
     */
    public ObtenerCiudadesResponse createObtenerCiudadesResponse() {
        return new ObtenerCiudadesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfciudad }
     * 
     */
    public ArrayOfciudad createArrayOfciudad() {
        return new ArrayOfciudad();
    }

    /**
     * Create an instance of {@link ObtenerClasificacion }
     * 
     */
    public ObtenerClasificacion createObtenerClasificacion() {
        return new ObtenerClasificacion();
    }

    /**
     * Create an instance of {@link ObtenerClasificacionResponse }
     * 
     */
    public ObtenerClasificacionResponse createObtenerClasificacionResponse() {
        return new ObtenerClasificacionResponse();
    }

    /**
     * Create an instance of {@link ArrayOfclasificacion }
     * 
     */
    public ArrayOfclasificacion createArrayOfclasificacion() {
        return new ArrayOfclasificacion();
    }

    /**
     * Create an instance of {@link ObtenerClientes }
     * 
     */
    public ObtenerClientes createObtenerClientes() {
        return new ObtenerClientes();
    }

    /**
     * Create an instance of {@link ObtenerClientesResponse }
     * 
     */
    public ObtenerClientesResponse createObtenerClientesResponse() {
        return new ObtenerClientesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfcliente }
     * 
     */
    public ArrayOfcliente createArrayOfcliente() {
        return new ArrayOfcliente();
    }

    /**
     * Create an instance of {@link ObtenerDetalleEmpleado }
     * 
     */
    public ObtenerDetalleEmpleado createObtenerDetalleEmpleado() {
        return new ObtenerDetalleEmpleado();
    }

    /**
     * Create an instance of {@link ObtenerDetalleEmpleadoResponse }
     * 
     */
    public ObtenerDetalleEmpleadoResponse createObtenerDetalleEmpleadoResponse() {
        return new ObtenerDetalleEmpleadoResponse();
    }

    /**
     * Create an instance of {@link ArrayOfdetalleEmpleado }
     * 
     */
    public ArrayOfdetalleEmpleado createArrayOfdetalleEmpleado() {
        return new ArrayOfdetalleEmpleado();
    }

    /**
     * Create an instance of {@link ObtenerDetalleProducto }
     * 
     */
    public ObtenerDetalleProducto createObtenerDetalleProducto() {
        return new ObtenerDetalleProducto();
    }

    /**
     * Create an instance of {@link ObtenerDetalleProductoResponse }
     * 
     */
    public ObtenerDetalleProductoResponse createObtenerDetalleProductoResponse() {
        return new ObtenerDetalleProductoResponse();
    }

    /**
     * Create an instance of {@link ArrayOfdetalleProductoSuministro }
     * 
     */
    public ArrayOfdetalleProductoSuministro createArrayOfdetalleProductoSuministro() {
        return new ArrayOfdetalleProductoSuministro();
    }

    /**
     * Create an instance of {@link ObtenerDetalleProveedor }
     * 
     */
    public ObtenerDetalleProveedor createObtenerDetalleProveedor() {
        return new ObtenerDetalleProveedor();
    }

    /**
     * Create an instance of {@link ObtenerDetalleProveedorResponse }
     * 
     */
    public ObtenerDetalleProveedorResponse createObtenerDetalleProveedorResponse() {
        return new ObtenerDetalleProveedorResponse();
    }

    /**
     * Create an instance of {@link ArrayOfdetalleProveedor }
     * 
     */
    public ArrayOfdetalleProveedor createArrayOfdetalleProveedor() {
        return new ArrayOfdetalleProveedor();
    }

    /**
     * Create an instance of {@link ObtenerEmpleados }
     * 
     */
    public ObtenerEmpleados createObtenerEmpleados() {
        return new ObtenerEmpleados();
    }

    /**
     * Create an instance of {@link ObtenerEmpleadosResponse }
     * 
     */
    public ObtenerEmpleadosResponse createObtenerEmpleadosResponse() {
        return new ObtenerEmpleadosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfempleado }
     * 
     */
    public ArrayOfempleado createArrayOfempleado() {
        return new ArrayOfempleado();
    }

    /**
     * Create an instance of {@link ObtenerEstadosEventos }
     * 
     */
    public ObtenerEstadosEventos createObtenerEstadosEventos() {
        return new ObtenerEstadosEventos();
    }

    /**
     * Create an instance of {@link ObtenerEstadosEventosResponse }
     * 
     */
    public ObtenerEstadosEventosResponse createObtenerEstadosEventosResponse() {
        return new ObtenerEstadosEventosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfestadoEvento }
     * 
     */
    public ArrayOfestadoEvento createArrayOfestadoEvento() {
        return new ArrayOfestadoEvento();
    }

    /**
     * Create an instance of {@link ObtenerEventos }
     * 
     */
    public ObtenerEventos createObtenerEventos() {
        return new ObtenerEventos();
    }

    /**
     * Create an instance of {@link ObtenerEventosResponse }
     * 
     */
    public ObtenerEventosResponse createObtenerEventosResponse() {
        return new ObtenerEventosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfevento }
     * 
     */
    public ArrayOfevento createArrayOfevento() {
        return new ArrayOfevento();
    }

    /**
     * Create an instance of {@link ObtenerLugares }
     * 
     */
    public ObtenerLugares createObtenerLugares() {
        return new ObtenerLugares();
    }

    /**
     * Create an instance of {@link ObtenerLugaresResponse }
     * 
     */
    public ObtenerLugaresResponse createObtenerLugaresResponse() {
        return new ObtenerLugaresResponse();
    }

    /**
     * Create an instance of {@link ArrayOflugar }
     * 
     */
    public ArrayOflugar createArrayOflugar() {
        return new ArrayOflugar();
    }

    /**
     * Create an instance of {@link ObtenerMedidas }
     * 
     */
    public ObtenerMedidas createObtenerMedidas() {
        return new ObtenerMedidas();
    }

    /**
     * Create an instance of {@link ObtenerMedidasResponse }
     * 
     */
    public ObtenerMedidasResponse createObtenerMedidasResponse() {
        return new ObtenerMedidasResponse();
    }

    /**
     * Create an instance of {@link ArrayOfmedidaProducto }
     * 
     */
    public ArrayOfmedidaProducto createArrayOfmedidaProducto() {
        return new ArrayOfmedidaProducto();
    }

    /**
     * Create an instance of {@link ObtenerPaquetes }
     * 
     */
    public ObtenerPaquetes createObtenerPaquetes() {
        return new ObtenerPaquetes();
    }

    /**
     * Create an instance of {@link ObtenerPaquetesResponse }
     * 
     */
    public ObtenerPaquetesResponse createObtenerPaquetesResponse() {
        return new ObtenerPaquetesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfpaquete }
     * 
     */
    public ArrayOfpaquete createArrayOfpaquete() {
        return new ArrayOfpaquete();
    }

    /**
     * Create an instance of {@link ObtenerPedidos }
     * 
     */
    public ObtenerPedidos createObtenerPedidos() {
        return new ObtenerPedidos();
    }

    /**
     * Create an instance of {@link ObtenerPedidosResponse }
     * 
     */
    public ObtenerPedidosResponse createObtenerPedidosResponse() {
        return new ObtenerPedidosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfpedido }
     * 
     */
    public ArrayOfpedido createArrayOfpedido() {
        return new ArrayOfpedido();
    }

    /**
     * Create an instance of {@link ObtenerProductos }
     * 
     */
    public ObtenerProductos createObtenerProductos() {
        return new ObtenerProductos();
    }

    /**
     * Create an instance of {@link ObtenerProductosResponse }
     * 
     */
    public ObtenerProductosResponse createObtenerProductosResponse() {
        return new ObtenerProductosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfproducto }
     * 
     */
    public ArrayOfproducto createArrayOfproducto() {
        return new ArrayOfproducto();
    }

    /**
     * Create an instance of {@link ObtenerProveedores }
     * 
     */
    public ObtenerProveedores createObtenerProveedores() {
        return new ObtenerProveedores();
    }

    /**
     * Create an instance of {@link ObtenerProveedoresResponse }
     * 
     */
    public ObtenerProveedoresResponse createObtenerProveedoresResponse() {
        return new ObtenerProveedoresResponse();
    }

    /**
     * Create an instance of {@link ArrayOfproveedor }
     * 
     */
    public ArrayOfproveedor createArrayOfproveedor() {
        return new ArrayOfproveedor();
    }

    /**
     * Create an instance of {@link ObtenerRoles }
     * 
     */
    public ObtenerRoles createObtenerRoles() {
        return new ObtenerRoles();
    }

    /**
     * Create an instance of {@link ObtenerRolesResponse }
     * 
     */
    public ObtenerRolesResponse createObtenerRolesResponse() {
        return new ObtenerRolesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfrol }
     * 
     */
    public ArrayOfrol createArrayOfrol() {
        return new ArrayOfrol();
    }

    /**
     * Create an instance of {@link ObtenerSolicitudes }
     * 
     */
    public ObtenerSolicitudes createObtenerSolicitudes() {
        return new ObtenerSolicitudes();
    }

    /**
     * Create an instance of {@link ObtenerSolicitudesResponse }
     * 
     */
    public ObtenerSolicitudesResponse createObtenerSolicitudesResponse() {
        return new ObtenerSolicitudesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfsolicitud }
     * 
     */
    public ArrayOfsolicitud createArrayOfsolicitud() {
        return new ArrayOfsolicitud();
    }

    /**
     * Create an instance of {@link ObtenerSuministros }
     * 
     */
    public ObtenerSuministros createObtenerSuministros() {
        return new ObtenerSuministros();
    }

    /**
     * Create an instance of {@link ObtenerSuministrosResponse }
     * 
     */
    public ObtenerSuministrosResponse createObtenerSuministrosResponse() {
        return new ObtenerSuministrosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfsuministro }
     * 
     */
    public ArrayOfsuministro createArrayOfsuministro() {
        return new ArrayOfsuministro();
    }

    /**
     * Create an instance of {@link ObtenerTipoDocumentos }
     * 
     */
    public ObtenerTipoDocumentos createObtenerTipoDocumentos() {
        return new ObtenerTipoDocumentos();
    }

    /**
     * Create an instance of {@link ObtenerTipoDocumentosResponse }
     * 
     */
    public ObtenerTipoDocumentosResponse createObtenerTipoDocumentosResponse() {
        return new ObtenerTipoDocumentosResponse();
    }

    /**
     * Create an instance of {@link ArrayOftipoDocumento }
     * 
     */
    public ArrayOftipoDocumento createArrayOftipoDocumento() {
        return new ArrayOftipoDocumento();
    }

    /**
     * Create an instance of {@link ObtenerTipoEventos }
     * 
     */
    public ObtenerTipoEventos createObtenerTipoEventos() {
        return new ObtenerTipoEventos();
    }

    /**
     * Create an instance of {@link ObtenerTipoEventosResponse }
     * 
     */
    public ObtenerTipoEventosResponse createObtenerTipoEventosResponse() {
        return new ObtenerTipoEventosResponse();
    }

    /**
     * Create an instance of {@link ArrayOftipoEvento }
     * 
     */
    public ArrayOftipoEvento createArrayOftipoEvento() {
        return new ArrayOftipoEvento();
    }

    /**
     * Create an instance of {@link ObtenerTipoProductos }
     * 
     */
    public ObtenerTipoProductos createObtenerTipoProductos() {
        return new ObtenerTipoProductos();
    }

    /**
     * Create an instance of {@link ObtenerTipoProductosResponse }
     * 
     */
    public ObtenerTipoProductosResponse createObtenerTipoProductosResponse() {
        return new ObtenerTipoProductosResponse();
    }

    /**
     * Create an instance of {@link ArrayOftipoProducto }
     * 
     */
    public ArrayOftipoProducto createArrayOftipoProducto() {
        return new ArrayOftipoProducto();
    }

    /**
     * Create an instance of {@link ObtenerUsuarios }
     * 
     */
    public ObtenerUsuarios createObtenerUsuarios() {
        return new ObtenerUsuarios();
    }

    /**
     * Create an instance of {@link ObtenerUsuariosResponse }
     * 
     */
    public ObtenerUsuariosResponse createObtenerUsuariosResponse() {
        return new ObtenerUsuariosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfusuario }
     * 
     */
    public ArrayOfusuario createArrayOfusuario() {
        return new ArrayOfusuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ciudad")
    public JAXBElement<Ciudad> createCiudad(Ciudad value) {
        return new JAXBElement<Ciudad>(_Ciudad_QNAME, Ciudad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clasificacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "clasificacion")
    public JAXBElement<Clasificacion> createClasificacion(Clasificacion value) {
        return new JAXBElement<Clasificacion>(_Clasificacion_QNAME, Clasificacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cliente")
    public JAXBElement<Cliente> createCliente(Cliente value) {
        return new JAXBElement<Cliente>(_Cliente_QNAME, Cliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_documento")
    public JAXBElement<TipoDocumento> createTipoDocumento(TipoDocumento value) {
        return new JAXBElement<TipoDocumento>(_TipoDocumento_QNAME, TipoDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "detalle_empleado")
    public JAXBElement<DetalleEmpleado> createDetalleEmpleado(DetalleEmpleado value) {
        return new JAXBElement<DetalleEmpleado>(_DetalleEmpleado_QNAME, DetalleEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado")
    public JAXBElement<Empleado> createEmpleado(Empleado value) {
        return new JAXBElement<Empleado>(_Empleado_QNAME, Empleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "rol")
    public JAXBElement<Rol> createRol(Rol value) {
        return new JAXBElement<Rol>(_Rol_QNAME, Rol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleProductoSuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "detalle_producto_suministro")
    public JAXBElement<DetalleProductoSuministro> createDetalleProductoSuministro(DetalleProductoSuministro value) {
        return new JAXBElement<DetalleProductoSuministro>(_DetalleProductoSuministro_QNAME, DetalleProductoSuministro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "producto")
    public JAXBElement<Producto> createProducto(Producto value) {
        return new JAXBElement<Producto>(_Producto_QNAME, Producto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida_producto")
    public JAXBElement<MedidaProducto> createMedidaProducto(MedidaProducto value) {
        return new JAXBElement<MedidaProducto>(_MedidaProducto_QNAME, MedidaProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfpedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfpedido")
    public JAXBElement<ArrayOfpedido> createArrayOfpedido(ArrayOfpedido value) {
        return new JAXBElement<ArrayOfpedido>(_ArrayOfpedido_QNAME, ArrayOfpedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "pedido")
    public JAXBElement<Pedido> createPedido(Pedido value) {
        return new JAXBElement<Pedido>(_Pedido_QNAME, Pedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "proveedor")
    public JAXBElement<Proveedor> createProveedor(Proveedor value) {
        return new JAXBElement<Proveedor>(_Proveedor_QNAME, Proveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_producto")
    public JAXBElement<TipoProducto> createTipoProducto(TipoProducto value) {
        return new JAXBElement<TipoProducto>(_TipoProducto_QNAME, TipoProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "suministro")
    public JAXBElement<Suministro> createSuministro(Suministro value) {
        return new JAXBElement<Suministro>(_Suministro_QNAME, Suministro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleProveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "detalle_proveedor")
    public JAXBElement<DetalleProveedor> createDetalleProveedor(DetalleProveedor value) {
        return new JAXBElement<DetalleProveedor>(_DetalleProveedor_QNAME, DetalleProveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado_evento")
    public JAXBElement<EstadoEvento> createEstadoEvento(EstadoEvento value) {
        return new JAXBElement<EstadoEvento>(_EstadoEvento_QNAME, EstadoEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Evento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "evento")
    public JAXBElement<Evento> createEvento(Evento value) {
        return new JAXBElement<Evento>(_Evento_QNAME, Evento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "lugar")
    public JAXBElement<Lugar> createLugar(Lugar value) {
        return new JAXBElement<Lugar>(_Lugar_QNAME, Lugar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "solicitud")
    public JAXBElement<Solicitud> createSolicitud(Solicitud value) {
        return new JAXBElement<Solicitud>(_Solicitud_QNAME, Solicitud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_evento")
    public JAXBElement<TipoEvento> createTipoEvento(TipoEvento value) {
        return new JAXBElement<TipoEvento>(_TipoEvento_QNAME, TipoEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Paquete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "paquete")
    public JAXBElement<Paquete> createPaquete(Paquete value) {
        return new JAXBElement<Paquete>(_Paquete_QNAME, Paquete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfciudad")
    public JAXBElement<ArrayOfciudad> createArrayOfciudad(ArrayOfciudad value) {
        return new JAXBElement<ArrayOfciudad>(_ArrayOfciudad_QNAME, ArrayOfciudad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfclasificacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfclasificacion")
    public JAXBElement<ArrayOfclasificacion> createArrayOfclasificacion(ArrayOfclasificacion value) {
        return new JAXBElement<ArrayOfclasificacion>(_ArrayOfclasificacion_QNAME, ArrayOfclasificacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfcliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfcliente")
    public JAXBElement<ArrayOfcliente> createArrayOfcliente(ArrayOfcliente value) {
        return new JAXBElement<ArrayOfcliente>(_ArrayOfcliente_QNAME, ArrayOfcliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfdetalle_empleado")
    public JAXBElement<ArrayOfdetalleEmpleado> createArrayOfdetalleEmpleado(ArrayOfdetalleEmpleado value) {
        return new JAXBElement<ArrayOfdetalleEmpleado>(_ArrayOfdetalleEmpleado_QNAME, ArrayOfdetalleEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleProductoSuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfdetalle_producto_suministro")
    public JAXBElement<ArrayOfdetalleProductoSuministro> createArrayOfdetalleProductoSuministro(ArrayOfdetalleProductoSuministro value) {
        return new JAXBElement<ArrayOfdetalleProductoSuministro>(_ArrayOfdetalleProductoSuministro_QNAME, ArrayOfdetalleProductoSuministro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleProveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfdetalle_proveedor")
    public JAXBElement<ArrayOfdetalleProveedor> createArrayOfdetalleProveedor(ArrayOfdetalleProveedor value) {
        return new JAXBElement<ArrayOfdetalleProveedor>(_ArrayOfdetalleProveedor_QNAME, ArrayOfdetalleProveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfempleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfempleado")
    public JAXBElement<ArrayOfempleado> createArrayOfempleado(ArrayOfempleado value) {
        return new JAXBElement<ArrayOfempleado>(_ArrayOfempleado_QNAME, ArrayOfempleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfestadoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfestado_evento")
    public JAXBElement<ArrayOfestadoEvento> createArrayOfestadoEvento(ArrayOfestadoEvento value) {
        return new JAXBElement<ArrayOfestadoEvento>(_ArrayOfestadoEvento_QNAME, ArrayOfestadoEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfevento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfevento")
    public JAXBElement<ArrayOfevento> createArrayOfevento(ArrayOfevento value) {
        return new JAXBElement<ArrayOfevento>(_ArrayOfevento_QNAME, ArrayOfevento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOflugar")
    public JAXBElement<ArrayOflugar> createArrayOflugar(ArrayOflugar value) {
        return new JAXBElement<ArrayOflugar>(_ArrayOflugar_QNAME, ArrayOflugar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfmedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfmedida_producto")
    public JAXBElement<ArrayOfmedidaProducto> createArrayOfmedidaProducto(ArrayOfmedidaProducto value) {
        return new JAXBElement<ArrayOfmedidaProducto>(_ArrayOfmedidaProducto_QNAME, ArrayOfmedidaProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfpaquete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfpaquete")
    public JAXBElement<ArrayOfpaquete> createArrayOfpaquete(ArrayOfpaquete value) {
        return new JAXBElement<ArrayOfpaquete>(_ArrayOfpaquete_QNAME, ArrayOfpaquete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfproducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfproducto")
    public JAXBElement<ArrayOfproducto> createArrayOfproducto(ArrayOfproducto value) {
        return new JAXBElement<ArrayOfproducto>(_ArrayOfproducto_QNAME, ArrayOfproducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfproveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfproveedor")
    public JAXBElement<ArrayOfproveedor> createArrayOfproveedor(ArrayOfproveedor value) {
        return new JAXBElement<ArrayOfproveedor>(_ArrayOfproveedor_QNAME, ArrayOfproveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfrol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfrol")
    public JAXBElement<ArrayOfrol> createArrayOfrol(ArrayOfrol value) {
        return new JAXBElement<ArrayOfrol>(_ArrayOfrol_QNAME, ArrayOfrol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsolicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfsolicitud")
    public JAXBElement<ArrayOfsolicitud> createArrayOfsolicitud(ArrayOfsolicitud value) {
        return new JAXBElement<ArrayOfsolicitud>(_ArrayOfsolicitud_QNAME, ArrayOfsolicitud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfsuministro")
    public JAXBElement<ArrayOfsuministro> createArrayOfsuministro(ArrayOfsuministro value) {
        return new JAXBElement<ArrayOfsuministro>(_ArrayOfsuministro_QNAME, ArrayOfsuministro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOftipo_documento")
    public JAXBElement<ArrayOftipoDocumento> createArrayOftipoDocumento(ArrayOftipoDocumento value) {
        return new JAXBElement<ArrayOftipoDocumento>(_ArrayOftipoDocumento_QNAME, ArrayOftipoDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOftipo_evento")
    public JAXBElement<ArrayOftipoEvento> createArrayOftipoEvento(ArrayOftipoEvento value) {
        return new JAXBElement<ArrayOftipoEvento>(_ArrayOftipoEvento_QNAME, ArrayOftipoEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOftipo_producto")
    public JAXBElement<ArrayOftipoProducto> createArrayOftipoProducto(ArrayOftipoProducto value) {
        return new JAXBElement<ArrayOftipoProducto>(_ArrayOftipoProducto_QNAME, ArrayOftipoProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfusuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ArrayOfusuario")
    public JAXBElement<ArrayOfusuario> createArrayOfusuario(ArrayOfusuario value) {
        return new JAXBElement<ArrayOfusuario>(_ArrayOfusuario_QNAME, ArrayOfusuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ciudad", scope = CUDCiudades.class)
    public JAXBElement<Ciudad> createCUDCiudadesCiudad(Ciudad value) {
        return new JAXBElement<Ciudad>(_CUDCiudadesCiudad_QNAME, Ciudad.class, CUDCiudades.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDCiudadesResult", scope = CUDCiudadesResponse.class)
    public JAXBElement<String> createCUDCiudadesResponseCUDCiudadesResult(String value) {
        return new JAXBElement<String>(_CUDCiudadesResponseCUDCiudadesResult_QNAME, String.class, CUDCiudadesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clasificacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clasificacion", scope = CUDClasificacion.class)
    public JAXBElement<Clasificacion> createCUDClasificacionClasificacion(Clasificacion value) {
        return new JAXBElement<Clasificacion>(_CUDClasificacionClasificacion_QNAME, Clasificacion.class, CUDClasificacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDClasificacionResult", scope = CUDClasificacionResponse.class)
    public JAXBElement<String> createCUDClasificacionResponseCUDClasificacionResult(String value) {
        return new JAXBElement<String>(_CUDClasificacionResponseCUDClasificacionResult_QNAME, String.class, CUDClasificacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "cliente", scope = CUDCliente.class)
    public JAXBElement<Cliente> createCUDClienteCliente(Cliente value) {
        return new JAXBElement<Cliente>(_CUDClienteCliente_QNAME, Cliente.class, CUDCliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDClienteResult", scope = CUDClienteResponse.class)
    public JAXBElement<String> createCUDClienteResponseCUDClienteResult(String value) {
        return new JAXBElement<String>(_CUDClienteResponseCUDClienteResult_QNAME, String.class, CUDClienteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "detalleEmpleado", scope = CUDDetalleEmpleado.class)
    public JAXBElement<DetalleEmpleado> createCUDDetalleEmpleadoDetalleEmpleado(DetalleEmpleado value) {
        return new JAXBElement<DetalleEmpleado>(_CUDDetalleEmpleadoDetalleEmpleado_QNAME, DetalleEmpleado.class, CUDDetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDDetalleEmpleadoResult", scope = CUDDetalleEmpleadoResponse.class)
    public JAXBElement<String> createCUDDetalleEmpleadoResponseCUDDetalleEmpleadoResult(String value) {
        return new JAXBElement<String>(_CUDDetalleEmpleadoResponseCUDDetalleEmpleadoResult_QNAME, String.class, CUDDetalleEmpleadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleProductoSuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "detalleProducto", scope = CUDDetalleProducto.class)
    public JAXBElement<DetalleProductoSuministro> createCUDDetalleProductoDetalleProducto(DetalleProductoSuministro value) {
        return new JAXBElement<DetalleProductoSuministro>(_CUDDetalleProductoDetalleProducto_QNAME, DetalleProductoSuministro.class, CUDDetalleProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDDetalleProductoResult", scope = CUDDetalleProductoResponse.class)
    public JAXBElement<String> createCUDDetalleProductoResponseCUDDetalleProductoResult(String value) {
        return new JAXBElement<String>(_CUDDetalleProductoResponseCUDDetalleProductoResult_QNAME, String.class, CUDDetalleProductoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleProveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "detalleProveedor", scope = CUDDetalleProveedor.class)
    public JAXBElement<DetalleProveedor> createCUDDetalleProveedorDetalleProveedor(DetalleProveedor value) {
        return new JAXBElement<DetalleProveedor>(_CUDDetalleProveedorDetalleProveedor_QNAME, DetalleProveedor.class, CUDDetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDDetalleProveedorResult", scope = CUDDetalleProveedorResponse.class)
    public JAXBElement<String> createCUDDetalleProveedorResponseCUDDetalleProveedorResult(String value) {
        return new JAXBElement<String>(_CUDDetalleProveedorResponseCUDDetalleProveedorResult_QNAME, String.class, CUDDetalleProveedorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "empleado", scope = CUDEmpleado.class)
    public JAXBElement<Empleado> createCUDEmpleadoEmpleado(Empleado value) {
        return new JAXBElement<Empleado>(_CUDEmpleadoEmpleado_QNAME, Empleado.class, CUDEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDEmpleadoResult", scope = CUDEmpleadoResponse.class)
    public JAXBElement<String> createCUDEmpleadoResponseCUDEmpleadoResult(String value) {
        return new JAXBElement<String>(_CUDEmpleadoResponseCUDEmpleadoResult_QNAME, String.class, CUDEmpleadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estadoEvento", scope = CUDEstadoEvento.class)
    public JAXBElement<EstadoEvento> createCUDEstadoEventoEstadoEvento(EstadoEvento value) {
        return new JAXBElement<EstadoEvento>(_CUDEstadoEventoEstadoEvento_QNAME, EstadoEvento.class, CUDEstadoEvento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDEstadoEventoResult", scope = CUDEstadoEventoResponse.class)
    public JAXBElement<String> createCUDEstadoEventoResponseCUDEstadoEventoResult(String value) {
        return new JAXBElement<String>(_CUDEstadoEventoResponseCUDEstadoEventoResult_QNAME, String.class, CUDEstadoEventoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Evento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "evento", scope = CUDEvento.class)
    public JAXBElement<Evento> createCUDEventoEvento(Evento value) {
        return new JAXBElement<Evento>(_CUDEventoEvento_QNAME, Evento.class, CUDEvento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDEventoResult", scope = CUDEventoResponse.class)
    public JAXBElement<String> createCUDEventoResponseCUDEventoResult(String value) {
        return new JAXBElement<String>(_CUDEventoResponseCUDEventoResult_QNAME, String.class, CUDEventoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "lugar", scope = CUDLugar.class)
    public JAXBElement<Lugar> createCUDLugarLugar(Lugar value) {
        return new JAXBElement<Lugar>(_CUDLugarLugar_QNAME, Lugar.class, CUDLugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDLugarResult", scope = CUDLugarResponse.class)
    public JAXBElement<String> createCUDLugarResponseCUDLugarResult(String value) {
        return new JAXBElement<String>(_CUDLugarResponseCUDLugarResult_QNAME, String.class, CUDLugarResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "tipoDocumento", scope = CUDMedidaProducto.class)
    public JAXBElement<MedidaProducto> createCUDMedidaProductoTipoDocumento(MedidaProducto value) {
        return new JAXBElement<MedidaProducto>(_CUDMedidaProductoTipoDocumento_QNAME, MedidaProducto.class, CUDMedidaProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDMedidaProductoResult", scope = CUDMedidaProductoResponse.class)
    public JAXBElement<String> createCUDMedidaProductoResponseCUDMedidaProductoResult(String value) {
        return new JAXBElement<String>(_CUDMedidaProductoResponseCUDMedidaProductoResult_QNAME, String.class, CUDMedidaProductoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Paquete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "paquete", scope = CUDPaquete.class)
    public JAXBElement<Paquete> createCUDPaquetePaquete(Paquete value) {
        return new JAXBElement<Paquete>(_CUDPaquetePaquete_QNAME, Paquete.class, CUDPaquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDPaqueteResult", scope = CUDPaqueteResponse.class)
    public JAXBElement<String> createCUDPaqueteResponseCUDPaqueteResult(String value) {
        return new JAXBElement<String>(_CUDPaqueteResponseCUDPaqueteResult_QNAME, String.class, CUDPaqueteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pedido", scope = CUDPedido.class)
    public JAXBElement<Pedido> createCUDPedidoPedido(Pedido value) {
        return new JAXBElement<Pedido>(_CUDPedidoPedido_QNAME, Pedido.class, CUDPedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDPedidoResult", scope = CUDPedidoResponse.class)
    public JAXBElement<String> createCUDPedidoResponseCUDPedidoResult(String value) {
        return new JAXBElement<String>(_CUDPedidoResponseCUDPedidoResult_QNAME, String.class, CUDPedidoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "producto", scope = CUDProducto.class)
    public JAXBElement<Producto> createCUDProductoProducto(Producto value) {
        return new JAXBElement<Producto>(_CUDProductoProducto_QNAME, Producto.class, CUDProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDProductoResult", scope = CUDProductoResponse.class)
    public JAXBElement<String> createCUDProductoResponseCUDProductoResult(String value) {
        return new JAXBElement<String>(_CUDProductoResponseCUDProductoResult_QNAME, String.class, CUDProductoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "proveedor", scope = CUDProveedor.class)
    public JAXBElement<Proveedor> createCUDProveedorProveedor(Proveedor value) {
        return new JAXBElement<Proveedor>(_CUDProveedorProveedor_QNAME, Proveedor.class, CUDProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDProveedorResult", scope = CUDProveedorResponse.class)
    public JAXBElement<String> createCUDProveedorResponseCUDProveedorResult(String value) {
        return new JAXBElement<String>(_CUDProveedorResponseCUDProveedorResult_QNAME, String.class, CUDProveedorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "rol", scope = CUDRoles.class)
    public JAXBElement<Rol> createCUDRolesRol(Rol value) {
        return new JAXBElement<Rol>(_CUDRolesRol_QNAME, Rol.class, CUDRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDRolesResult", scope = CUDRolesResponse.class)
    public JAXBElement<String> createCUDRolesResponseCUDRolesResult(String value) {
        return new JAXBElement<String>(_CUDRolesResponseCUDRolesResult_QNAME, String.class, CUDRolesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "solicitud", scope = CUDSolicitudes.class)
    public JAXBElement<Solicitud> createCUDSolicitudesSolicitud(Solicitud value) {
        return new JAXBElement<Solicitud>(_CUDSolicitudesSolicitud_QNAME, Solicitud.class, CUDSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDSolicitudesResult", scope = CUDSolicitudesResponse.class)
    public JAXBElement<String> createCUDSolicitudesResponseCUDSolicitudesResult(String value) {
        return new JAXBElement<String>(_CUDSolicitudesResponseCUDSolicitudesResult_QNAME, String.class, CUDSolicitudesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "suministro", scope = CUDSuministro.class)
    public JAXBElement<Suministro> createCUDSuministroSuministro(Suministro value) {
        return new JAXBElement<Suministro>(_CUDSuministroSuministro_QNAME, Suministro.class, CUDSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDSuministroResult", scope = CUDSuministroResponse.class)
    public JAXBElement<String> createCUDSuministroResponseCUDSuministroResult(String value) {
        return new JAXBElement<String>(_CUDSuministroResponseCUDSuministroResult_QNAME, String.class, CUDSuministroResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "tipoDocumento", scope = CUDTipoDocumento.class)
    public JAXBElement<TipoDocumento> createCUDTipoDocumentoTipoDocumento(TipoDocumento value) {
        return new JAXBElement<TipoDocumento>(_CUDMedidaProductoTipoDocumento_QNAME, TipoDocumento.class, CUDTipoDocumento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDTipoDocumentoResult", scope = CUDTipoDocumentoResponse.class)
    public JAXBElement<String> createCUDTipoDocumentoResponseCUDTipoDocumentoResult(String value) {
        return new JAXBElement<String>(_CUDTipoDocumentoResponseCUDTipoDocumentoResult_QNAME, String.class, CUDTipoDocumentoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "tipoEvento", scope = CUDTipoEvento.class)
    public JAXBElement<TipoEvento> createCUDTipoEventoTipoEvento(TipoEvento value) {
        return new JAXBElement<TipoEvento>(_CUDTipoEventoTipoEvento_QNAME, TipoEvento.class, CUDTipoEvento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDTipoEventoResult", scope = CUDTipoEventoResponse.class)
    public JAXBElement<String> createCUDTipoEventoResponseCUDTipoEventoResult(String value) {
        return new JAXBElement<String>(_CUDTipoEventoResponseCUDTipoEventoResult_QNAME, String.class, CUDTipoEventoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "tipoProducto", scope = CUDTipoProducto.class)
    public JAXBElement<TipoProducto> createCUDTipoProductoTipoProducto(TipoProducto value) {
        return new JAXBElement<TipoProducto>(_CUDTipoProductoTipoProducto_QNAME, TipoProducto.class, CUDTipoProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDTipoProductoResult", scope = CUDTipoProductoResponse.class)
    public JAXBElement<String> createCUDTipoProductoResponseCUDTipoProductoResult(String value) {
        return new JAXBElement<String>(_CUDTipoProductoResponseCUDTipoProductoResult_QNAME, String.class, CUDTipoProductoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "usuario", scope = CUDUsuario.class)
    public JAXBElement<Usuario> createCUDUsuarioUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_CUDUsuarioUsuario_QNAME, Usuario.class, CUDUsuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CUDUsuarioResult", scope = CUDUsuarioResponse.class)
    public JAXBElement<String> createCUDUsuarioResponseCUDUsuarioResult(String value) {
        return new JAXBElement<String>(_CUDUsuarioResponseCUDUsuarioResult_QNAME, String.class, CUDUsuarioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombre", scope = ObtenerCiudades.class)
    public JAXBElement<String> createObtenerCiudadesNombre(String value) {
        return new JAXBElement<String>(_ObtenerCiudadesNombre_QNAME, String.class, ObtenerCiudades.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerCiudadesResult", scope = ObtenerCiudadesResponse.class)
    public JAXBElement<ArrayOfciudad> createObtenerCiudadesResponseObtenerCiudadesResult(ArrayOfciudad value) {
        return new JAXBElement<ArrayOfciudad>(_ObtenerCiudadesResponseObtenerCiudadesResult_QNAME, ArrayOfciudad.class, ObtenerCiudadesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreClasificacion", scope = ObtenerClasificacion.class)
    public JAXBElement<String> createObtenerClasificacionNombreClasificacion(String value) {
        return new JAXBElement<String>(_ObtenerClasificacionNombreClasificacion_QNAME, String.class, ObtenerClasificacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfclasificacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerClasificacionResult", scope = ObtenerClasificacionResponse.class)
    public JAXBElement<ArrayOfclasificacion> createObtenerClasificacionResponseObtenerClasificacionResult(ArrayOfclasificacion value) {
        return new JAXBElement<ArrayOfclasificacion>(_ObtenerClasificacionResponseObtenerClasificacionResult_QNAME, ArrayOfclasificacion.class, ObtenerClasificacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreCliente", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesNombreCliente(String value) {
        return new JAXBElement<String>(_ObtenerClientesNombreCliente_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "numeroIdentificacion", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesNumeroIdentificacion(String value) {
        return new JAXBElement<String>(_ObtenerClientesNumeroIdentificacion_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "apellido", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesApellido(String value) {
        return new JAXBElement<String>(_ObtenerClientesApellido_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "telefono", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesTelefono(String value) {
        return new JAXBElement<String>(_ObtenerClientesTelefono_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "celular", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesCelular(String value) {
        return new JAXBElement<String>(_ObtenerClientesCelular_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "direccion", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesDireccion(String value) {
        return new JAXBElement<String>(_ObtenerClientesDireccion_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "correo", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesCorreo(String value) {
        return new JAXBElement<String>(_ObtenerClientesCorreo_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerClientes.class)
    public JAXBElement<String> createObtenerClientesEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerClientes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfcliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerClientesResult", scope = ObtenerClientesResponse.class)
    public JAXBElement<ArrayOfcliente> createObtenerClientesResponseObtenerClientesResult(ArrayOfcliente value) {
        return new JAXBElement<ArrayOfcliente>(_ObtenerClientesResponseObtenerClientesResult_QNAME, ArrayOfcliente.class, ObtenerClientesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerDetalleEmpleado.class)
    public JAXBElement<String> createObtenerDetalleEmpleadoEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerDetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerDetalleEmpleadoResult", scope = ObtenerDetalleEmpleadoResponse.class)
    public JAXBElement<ArrayOfdetalleEmpleado> createObtenerDetalleEmpleadoResponseObtenerDetalleEmpleadoResult(ArrayOfdetalleEmpleado value) {
        return new JAXBElement<ArrayOfdetalleEmpleado>(_ObtenerDetalleEmpleadoResponseObtenerDetalleEmpleadoResult_QNAME, ArrayOfdetalleEmpleado.class, ObtenerDetalleEmpleadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleProductoSuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerDetalleProductoResult", scope = ObtenerDetalleProductoResponse.class)
    public JAXBElement<ArrayOfdetalleProductoSuministro> createObtenerDetalleProductoResponseObtenerDetalleProductoResult(ArrayOfdetalleProductoSuministro value) {
        return new JAXBElement<ArrayOfdetalleProductoSuministro>(_ObtenerDetalleProductoResponseObtenerDetalleProductoResult_QNAME, ArrayOfdetalleProductoSuministro.class, ObtenerDetalleProductoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerDetalleProveedor.class)
    public JAXBElement<String> createObtenerDetalleProveedorEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerDetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdetalleProveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerDetalleProveedorResult", scope = ObtenerDetalleProveedorResponse.class)
    public JAXBElement<ArrayOfdetalleProveedor> createObtenerDetalleProveedorResponseObtenerDetalleProveedorResult(ArrayOfdetalleProveedor value) {
        return new JAXBElement<ArrayOfdetalleProveedor>(_ObtenerDetalleProveedorResponseObtenerDetalleProveedorResult_QNAME, ArrayOfdetalleProveedor.class, ObtenerDetalleProveedorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "numeroIdentificacion", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosNumeroIdentificacion(String value) {
        return new JAXBElement<String>(_ObtenerClientesNumeroIdentificacion_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreEmpleado", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosNombreEmpleado(String value) {
        return new JAXBElement<String>(_ObtenerEmpleadosNombreEmpleado_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "apellidoEmpleado", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosApellidoEmpleado(String value) {
        return new JAXBElement<String>(_ObtenerEmpleadosApellidoEmpleado_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "correo", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosCorreo(String value) {
        return new JAXBElement<String>(_ObtenerClientesCorreo_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "direccion", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosDireccion(String value) {
        return new JAXBElement<String>(_ObtenerClientesDireccion_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "telefono", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosTelefono(String value) {
        return new JAXBElement<String>(_ObtenerClientesTelefono_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "barrio", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosBarrio(String value) {
        return new JAXBElement<String>(_ObtenerEmpleadosBarrio_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerEmpleados.class)
    public JAXBElement<String> createObtenerEmpleadosEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerEmpleados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfempleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerEmpleadosResult", scope = ObtenerEmpleadosResponse.class)
    public JAXBElement<ArrayOfempleado> createObtenerEmpleadosResponseObtenerEmpleadosResult(ArrayOfempleado value) {
        return new JAXBElement<ArrayOfempleado>(_ObtenerEmpleadosResponseObtenerEmpleadosResult_QNAME, ArrayOfempleado.class, ObtenerEmpleadosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombre", scope = ObtenerEstadosEventos.class)
    public JAXBElement<String> createObtenerEstadosEventosNombre(String value) {
        return new JAXBElement<String>(_ObtenerCiudadesNombre_QNAME, String.class, ObtenerEstadosEventos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfestadoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerEstadosEventosResult", scope = ObtenerEstadosEventosResponse.class)
    public JAXBElement<ArrayOfestadoEvento> createObtenerEstadosEventosResponseObtenerEstadosEventosResult(ArrayOfestadoEvento value) {
        return new JAXBElement<ArrayOfestadoEvento>(_ObtenerEstadosEventosResponseObtenerEstadosEventosResult_QNAME, ArrayOfestadoEvento.class, ObtenerEstadosEventosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "observaciones", scope = ObtenerEventos.class)
    public JAXBElement<String> createObtenerEventosObservaciones(String value) {
        return new JAXBElement<String>(_ObtenerEventosObservaciones_QNAME, String.class, ObtenerEventos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfevento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerEventosResult", scope = ObtenerEventosResponse.class)
    public JAXBElement<ArrayOfevento> createObtenerEventosResponseObtenerEventosResult(ArrayOfevento value) {
        return new JAXBElement<ArrayOfevento>(_ObtenerEventosResponseObtenerEventosResult_QNAME, ArrayOfevento.class, ObtenerEventosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreLugar", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresNombreLugar(String value) {
        return new JAXBElement<String>(_ObtenerLugaresNombreLugar_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "descripcion", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresDescripcion(String value) {
        return new JAXBElement<String>(_ObtenerLugaresDescripcion_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "direccion", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresDireccion(String value) {
        return new JAXBElement<String>(_ObtenerClientesDireccion_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ubicacion", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresUbicacion(String value) {
        return new JAXBElement<String>(_ObtenerLugaresUbicacion_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "contacto", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresContacto(String value) {
        return new JAXBElement<String>(_ObtenerLugaresContacto_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "telefonoContacto", scope = ObtenerLugares.class)
    public JAXBElement<String> createObtenerLugaresTelefonoContacto(String value) {
        return new JAXBElement<String>(_ObtenerLugaresTelefonoContacto_QNAME, String.class, ObtenerLugares.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerLugaresResult", scope = ObtenerLugaresResponse.class)
    public JAXBElement<ArrayOflugar> createObtenerLugaresResponseObtenerLugaresResult(ArrayOflugar value) {
        return new JAXBElement<ArrayOflugar>(_ObtenerLugaresResponseObtenerLugaresResult_QNAME, ArrayOflugar.class, ObtenerLugaresResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreMedidaProducto", scope = ObtenerMedidas.class)
    public JAXBElement<String> createObtenerMedidasNombreMedidaProducto(String value) {
        return new JAXBElement<String>(_ObtenerMedidasNombreMedidaProducto_QNAME, String.class, ObtenerMedidas.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfmedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerMedidasResult", scope = ObtenerMedidasResponse.class)
    public JAXBElement<ArrayOfmedidaProducto> createObtenerMedidasResponseObtenerMedidasResult(ArrayOfmedidaProducto value) {
        return new JAXBElement<ArrayOfmedidaProducto>(_ObtenerMedidasResponseObtenerMedidasResult_QNAME, ArrayOfmedidaProducto.class, ObtenerMedidasResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombrePaquete", scope = ObtenerPaquetes.class)
    public JAXBElement<String> createObtenerPaquetesNombrePaquete(String value) {
        return new JAXBElement<String>(_ObtenerPaquetesNombrePaquete_QNAME, String.class, ObtenerPaquetes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "descripcion", scope = ObtenerPaquetes.class)
    public JAXBElement<String> createObtenerPaquetesDescripcion(String value) {
        return new JAXBElement<String>(_ObtenerLugaresDescripcion_QNAME, String.class, ObtenerPaquetes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pdf", scope = ObtenerPaquetes.class)
    public JAXBElement<String> createObtenerPaquetesPdf(String value) {
        return new JAXBElement<String>(_ObtenerPaquetesPdf_QNAME, String.class, ObtenerPaquetes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "foto", scope = ObtenerPaquetes.class)
    public JAXBElement<String> createObtenerPaquetesFoto(String value) {
        return new JAXBElement<String>(_ObtenerPaquetesFoto_QNAME, String.class, ObtenerPaquetes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerPaquetes.class)
    public JAXBElement<String> createObtenerPaquetesEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerPaquetes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfpaquete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerPaquetesResult", scope = ObtenerPaquetesResponse.class)
    public JAXBElement<ArrayOfpaquete> createObtenerPaquetesResponseObtenerPaquetesResult(ArrayOfpaquete value) {
        return new JAXBElement<ArrayOfpaquete>(_ObtenerPaquetesResponseObtenerPaquetesResult_QNAME, ArrayOfpaquete.class, ObtenerPaquetesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fechaPedido", scope = ObtenerPedidos.class)
    public JAXBElement<XMLGregorianCalendar> createObtenerPedidosFechaPedido(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ObtenerPedidosFechaPedido_QNAME, XMLGregorianCalendar.class, ObtenerPedidos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "cantidad", scope = ObtenerPedidos.class)
    public JAXBElement<String> createObtenerPedidosCantidad(String value) {
        return new JAXBElement<String>(_ObtenerPedidosCantidad_QNAME, String.class, ObtenerPedidos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "observaciones", scope = ObtenerPedidos.class)
    public JAXBElement<String> createObtenerPedidosObservaciones(String value) {
        return new JAXBElement<String>(_ObtenerEventosObservaciones_QNAME, String.class, ObtenerPedidos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fechaSugerida", scope = ObtenerPedidos.class)
    public JAXBElement<String> createObtenerPedidosFechaSugerida(String value) {
        return new JAXBElement<String>(_ObtenerPedidosFechaSugerida_QNAME, String.class, ObtenerPedidos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerPedidos.class)
    public JAXBElement<String> createObtenerPedidosEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerPedidos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfpedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerPedidosResult", scope = ObtenerPedidosResponse.class)
    public JAXBElement<ArrayOfpedido> createObtenerPedidosResponseObtenerPedidosResult(ArrayOfpedido value) {
        return new JAXBElement<ArrayOfpedido>(_ObtenerPedidosResponseObtenerPedidosResult_QNAME, ArrayOfpedido.class, ObtenerPedidosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombre", scope = ObtenerProductos.class)
    public JAXBElement<String> createObtenerProductosNombre(String value) {
        return new JAXBElement<String>(_ObtenerCiudadesNombre_QNAME, String.class, ObtenerProductos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "foto", scope = ObtenerProductos.class)
    public JAXBElement<String> createObtenerProductosFoto(String value) {
        return new JAXBElement<String>(_ObtenerPaquetesFoto_QNAME, String.class, ObtenerProductos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "observaciones", scope = ObtenerProductos.class)
    public JAXBElement<String> createObtenerProductosObservaciones(String value) {
        return new JAXBElement<String>(_ObtenerEventosObservaciones_QNAME, String.class, ObtenerProductos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerProductos.class)
    public JAXBElement<String> createObtenerProductosEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerProductos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfproducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerProductosResult", scope = ObtenerProductosResponse.class)
    public JAXBElement<ArrayOfproducto> createObtenerProductosResponseObtenerProductosResult(ArrayOfproducto value) {
        return new JAXBElement<ArrayOfproducto>(_ObtenerProductosResponseObtenerProductosResult_QNAME, ArrayOfproducto.class, ObtenerProductosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "razonSocial", scope = ObtenerProveedores.class)
    public JAXBElement<String> createObtenerProveedoresRazonSocial(String value) {
        return new JAXBElement<String>(_ObtenerProveedoresRazonSocial_QNAME, String.class, ObtenerProveedores.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "direccion", scope = ObtenerProveedores.class)
    public JAXBElement<String> createObtenerProveedoresDireccion(String value) {
        return new JAXBElement<String>(_ObtenerClientesDireccion_QNAME, String.class, ObtenerProveedores.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "telefono", scope = ObtenerProveedores.class)
    public JAXBElement<String> createObtenerProveedoresTelefono(String value) {
        return new JAXBElement<String>(_ObtenerClientesTelefono_QNAME, String.class, ObtenerProveedores.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "correo", scope = ObtenerProveedores.class)
    public JAXBElement<String> createObtenerProveedoresCorreo(String value) {
        return new JAXBElement<String>(_ObtenerClientesCorreo_QNAME, String.class, ObtenerProveedores.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerProveedores.class)
    public JAXBElement<String> createObtenerProveedoresEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerProveedores.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfproveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerProveedoresResult", scope = ObtenerProveedoresResponse.class)
    public JAXBElement<ArrayOfproveedor> createObtenerProveedoresResponseObtenerProveedoresResult(ArrayOfproveedor value) {
        return new JAXBElement<ArrayOfproveedor>(_ObtenerProveedoresResponseObtenerProveedoresResult_QNAME, ArrayOfproveedor.class, ObtenerProveedoresResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreRol", scope = ObtenerRoles.class)
    public JAXBElement<String> createObtenerRolesNombreRol(String value) {
        return new JAXBElement<String>(_ObtenerRolesNombreRol_QNAME, String.class, ObtenerRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfrol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerRolesResult", scope = ObtenerRolesResponse.class)
    public JAXBElement<ArrayOfrol> createObtenerRolesResponseObtenerRolesResult(ArrayOfrol value) {
        return new JAXBElement<ArrayOfrol>(_ObtenerRolesResponseObtenerRolesResult_QNAME, ArrayOfrol.class, ObtenerRolesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreCliente", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesNombreCliente(String value) {
        return new JAXBElement<String>(_ObtenerClientesNombreCliente_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "telefono", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesTelefono(String value) {
        return new JAXBElement<String>(_ObtenerClientesTelefono_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "email", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesEmail(String value) {
        return new JAXBElement<String>(_ObtenerSolicitudesEmail_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "hora", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesHora(String value) {
        return new JAXBElement<String>(_ObtenerSolicitudesHora_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "observaciones", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesObservaciones(String value) {
        return new JAXBElement<String>(_ObtenerEventosObservaciones_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerSolicitudes.class)
    public JAXBElement<String> createObtenerSolicitudesEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerSolicitudes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsolicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerSolicitudesResult", scope = ObtenerSolicitudesResponse.class)
    public JAXBElement<ArrayOfsolicitud> createObtenerSolicitudesResponseObtenerSolicitudesResult(ArrayOfsolicitud value) {
        return new JAXBElement<ArrayOfsolicitud>(_ObtenerSolicitudesResponseObtenerSolicitudesResult_QNAME, ArrayOfsolicitud.class, ObtenerSolicitudesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreSuministro", scope = ObtenerSuministros.class)
    public JAXBElement<String> createObtenerSuministrosNombreSuministro(String value) {
        return new JAXBElement<String>(_ObtenerSuministrosNombreSuministro_QNAME, String.class, ObtenerSuministros.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "foto", scope = ObtenerSuministros.class)
    public JAXBElement<String> createObtenerSuministrosFoto(String value) {
        return new JAXBElement<String>(_ObtenerPaquetesFoto_QNAME, String.class, ObtenerSuministros.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "observaciones", scope = ObtenerSuministros.class)
    public JAXBElement<String> createObtenerSuministrosObservaciones(String value) {
        return new JAXBElement<String>(_ObtenerEventosObservaciones_QNAME, String.class, ObtenerSuministros.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerSuministros.class)
    public JAXBElement<String> createObtenerSuministrosEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerSuministros.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsuministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerSuministrosResult", scope = ObtenerSuministrosResponse.class)
    public JAXBElement<ArrayOfsuministro> createObtenerSuministrosResponseObtenerSuministrosResult(ArrayOfsuministro value) {
        return new JAXBElement<ArrayOfsuministro>(_ObtenerSuministrosResponseObtenerSuministrosResult_QNAME, ArrayOfsuministro.class, ObtenerSuministrosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreTipoDocumento", scope = ObtenerTipoDocumentos.class)
    public JAXBElement<String> createObtenerTipoDocumentosNombreTipoDocumento(String value) {
        return new JAXBElement<String>(_ObtenerTipoDocumentosNombreTipoDocumento_QNAME, String.class, ObtenerTipoDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "abreviatura", scope = ObtenerTipoDocumentos.class)
    public JAXBElement<String> createObtenerTipoDocumentosAbreviatura(String value) {
        return new JAXBElement<String>(_ObtenerTipoDocumentosAbreviatura_QNAME, String.class, ObtenerTipoDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerTipoDocumentosResult", scope = ObtenerTipoDocumentosResponse.class)
    public JAXBElement<ArrayOftipoDocumento> createObtenerTipoDocumentosResponseObtenerTipoDocumentosResult(ArrayOftipoDocumento value) {
        return new JAXBElement<ArrayOftipoDocumento>(_ObtenerTipoDocumentosResponseObtenerTipoDocumentosResult_QNAME, ArrayOftipoDocumento.class, ObtenerTipoDocumentosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreTipoEvento", scope = ObtenerTipoEventos.class)
    public JAXBElement<String> createObtenerTipoEventosNombreTipoEvento(String value) {
        return new JAXBElement<String>(_ObtenerTipoEventosNombreTipoEvento_QNAME, String.class, ObtenerTipoEventos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerTipoEventosResult", scope = ObtenerTipoEventosResponse.class)
    public JAXBElement<ArrayOftipoEvento> createObtenerTipoEventosResponseObtenerTipoEventosResult(ArrayOftipoEvento value) {
        return new JAXBElement<ArrayOftipoEvento>(_ObtenerTipoEventosResponseObtenerTipoEventosResult_QNAME, ArrayOftipoEvento.class, ObtenerTipoEventosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreTipoProducto", scope = ObtenerTipoProductos.class)
    public JAXBElement<String> createObtenerTipoProductosNombreTipoProducto(String value) {
        return new JAXBElement<String>(_ObtenerTipoProductosNombreTipoProducto_QNAME, String.class, ObtenerTipoProductos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOftipoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerTipoProductosResult", scope = ObtenerTipoProductosResponse.class)
    public JAXBElement<ArrayOftipoProducto> createObtenerTipoProductosResponseObtenerTipoProductosResult(ArrayOftipoProducto value) {
        return new JAXBElement<ArrayOftipoProducto>(_ObtenerTipoProductosResponseObtenerTipoProductosResult_QNAME, ArrayOftipoProducto.class, ObtenerTipoProductosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nombreUsuario", scope = ObtenerUsuarios.class)
    public JAXBElement<String> createObtenerUsuariosNombreUsuario(String value) {
        return new JAXBElement<String>(_ObtenerUsuariosNombreUsuario_QNAME, String.class, ObtenerUsuarios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "estado", scope = ObtenerUsuarios.class)
    public JAXBElement<String> createObtenerUsuariosEstado(String value) {
        return new JAXBElement<String>(_ObtenerClientesEstado_QNAME, String.class, ObtenerUsuarios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfusuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerUsuariosResult", scope = ObtenerUsuariosResponse.class)
    public JAXBElement<ArrayOfusuario> createObtenerUsuariosResponseObtenerUsuariosResult(ArrayOfusuario value) {
        return new JAXBElement<ArrayOfusuario>(_ObtenerUsuariosResponseObtenerUsuariosResult_QNAME, ArrayOfusuario.class, ObtenerUsuariosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "contrasenia", scope = Usuario.class)
    public JAXBElement<String> createUsuarioContrasenia(String value) {
        return new JAXBElement<String>(_UsuarioContrasenia_QNAME, String.class, Usuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado", scope = Usuario.class)
    public JAXBElement<Empleado> createUsuarioEmpleado(Empleado value) {
        return new JAXBElement<Empleado>(_Empleado_QNAME, Empleado.class, Usuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado_id_empleado", scope = Usuario.class)
    public JAXBElement<Long> createUsuarioEmpleadoIdEmpleado(Long value) {
        return new JAXBElement<Long>(_UsuarioEmpleadoIdEmpleado_QNAME, Long.class, Usuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Usuario.class)
    public JAXBElement<String> createUsuarioEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Usuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "usuario1", scope = Usuario.class)
    public JAXBElement<String> createUsuarioUsuario1(String value) {
        return new JAXBElement<String>(_UsuarioUsuario1_QNAME, String.class, Usuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = TipoProducto.class)
    public JAXBElement<String> createTipoProductoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, TipoProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = TipoEvento.class)
    public JAXBElement<String> createTipoEventoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, TipoEvento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "abreviatura", scope = TipoDocumento.class)
    public JAXBElement<String> createTipoDocumentoAbreviatura(String value) {
        return new JAXBElement<String>(_TipoDocumentoAbreviatura_QNAME, String.class, TipoDocumento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "descripcion_documento", scope = TipoDocumento.class)
    public JAXBElement<String> createTipoDocumentoDescripcionDocumento(String value) {
        return new JAXBElement<String>(_TipoDocumentoDescripcionDocumento_QNAME, String.class, TipoDocumento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad", scope = Suministro.class)
    public JAXBElement<Integer> createSuministroCantidad(Integer value) {
        return new JAXBElement<Integer>(_SuministroCantidad_QNAME, Integer.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_minima", scope = Suministro.class)
    public JAXBElement<Integer> createSuministroCantidadMinima(Integer value) {
        return new JAXBElement<Integer>(_SuministroCantidadMinima_QNAME, Integer.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Suministro.class)
    public JAXBElement<String> createSuministroEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "foto", scope = Suministro.class)
    public JAXBElement<String> createSuministroFoto(String value) {
        return new JAXBElement<String>(_SuministroFoto_QNAME, String.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida", scope = Suministro.class)
    public JAXBElement<Integer> createSuministroMedida(Integer value) {
        return new JAXBElement<Integer>(_SuministroMedida_QNAME, Integer.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida_producto", scope = Suministro.class)
    public JAXBElement<MedidaProducto> createSuministroMedidaProducto(MedidaProducto value) {
        return new JAXBElement<MedidaProducto>(_MedidaProducto_QNAME, MedidaProducto.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Suministro.class)
    public JAXBElement<String> createSuministroNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "observaciones", scope = Suministro.class)
    public JAXBElement<String> createSuministroObservaciones(String value) {
        return new JAXBElement<String>(_SuministroObservaciones_QNAME, String.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "precio_unidad", scope = Suministro.class)
    public JAXBElement<BigDecimal> createSuministroPrecioUnidad(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SuministroPrecioUnidad_QNAME, BigDecimal.class, Suministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_personas", scope = Solicitud.class)
    public JAXBElement<Integer> createSolicitudCantidadPersonas(Integer value) {
        return new JAXBElement<Integer>(_SolicitudCantidadPersonas_QNAME, Integer.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "email", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudEmail(String value) {
        return new JAXBElement<String>(_SolicitudEmail_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "fecha", scope = Solicitud.class)
    public JAXBElement<XMLGregorianCalendar> createSolicitudFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SolicitudFecha_QNAME, XMLGregorianCalendar.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "hora", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudHora(String value) {
        return new JAXBElement<String>(_SolicitudHora_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_tipo_evento", scope = Solicitud.class)
    public JAXBElement<Integer> createSolicitudIdTipoEvento(Integer value) {
        return new JAXBElement<Integer>(_SolicitudIdTipoEvento_QNAME, Integer.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre_cliente", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudNombreCliente(String value) {
        return new JAXBElement<String>(_SolicitudNombreCliente_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "observaciones", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudObservaciones(String value) {
        return new JAXBElement<String>(_SuministroObservaciones_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "telefono", scope = Solicitud.class)
    public JAXBElement<String> createSolicitudTelefono(String value) {
        return new JAXBElement<String>(_SolicitudTelefono_QNAME, String.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_evento", scope = Solicitud.class)
    public JAXBElement<TipoEvento> createSolicitudTipoEvento(TipoEvento value) {
        return new JAXBElement<TipoEvento>(_TipoEvento_QNAME, TipoEvento.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "visto", scope = Solicitud.class)
    public JAXBElement<Boolean> createSolicitudVisto(Boolean value) {
        return new JAXBElement<Boolean>(_SolicitudVisto_QNAME, Boolean.class, Solicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Rol.class)
    public JAXBElement<String> createRolNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Rol.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "correo", scope = Proveedor.class)
    public JAXBElement<String> createProveedorCorreo(String value) {
        return new JAXBElement<String>(_ProveedorCorreo_QNAME, String.class, Proveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "direccion", scope = Proveedor.class)
    public JAXBElement<String> createProveedorDireccion(String value) {
        return new JAXBElement<String>(_ProveedorDireccion_QNAME, String.class, Proveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Proveedor.class)
    public JAXBElement<String> createProveedorEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Proveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "razon_social", scope = Proveedor.class)
    public JAXBElement<String> createProveedorRazonSocial(String value) {
        return new JAXBElement<String>(_ProveedorRazonSocial_QNAME, String.class, Proveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "telefono", scope = Proveedor.class)
    public JAXBElement<String> createProveedorTelefono(String value) {
        return new JAXBElement<String>(_SolicitudTelefono_QNAME, String.class, Proveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_minima", scope = Producto.class)
    public JAXBElement<Integer> createProductoCantidadMinima(Integer value) {
        return new JAXBElement<Integer>(_SuministroCantidadMinima_QNAME, Integer.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Producto.class)
    public JAXBElement<String> createProductoEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "foto", scope = Producto.class)
    public JAXBElement<String> createProductoFoto(String value) {
        return new JAXBElement<String>(_SuministroFoto_QNAME, String.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida", scope = Producto.class)
    public JAXBElement<Integer> createProductoMedida(Integer value) {
        return new JAXBElement<Integer>(_SuministroMedida_QNAME, Integer.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida_producto", scope = Producto.class)
    public JAXBElement<MedidaProducto> createProductoMedidaProducto(MedidaProducto value) {
        return new JAXBElement<MedidaProducto>(_MedidaProducto_QNAME, MedidaProducto.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Producto.class)
    public JAXBElement<String> createProductoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "observaciones", scope = Producto.class)
    public JAXBElement<String> createProductoObservaciones(String value) {
        return new JAXBElement<String>(_SuministroObservaciones_QNAME, String.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "precio_unidad", scope = Producto.class)
    public JAXBElement<BigDecimal> createProductoPrecioUnidad(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SuministroPrecioUnidad_QNAME, BigDecimal.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo", scope = Producto.class)
    public JAXBElement<Integer> createProductoTipo(Integer value) {
        return new JAXBElement<Integer>(_ProductoTipo_QNAME, Integer.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_producto", scope = Producto.class)
    public JAXBElement<TipoProducto> createProductoTipoProducto(TipoProducto value) {
        return new JAXBElement<TipoProducto>(_TipoProducto_QNAME, TipoProducto.class, Producto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad", scope = Pedido.class)
    public JAXBElement<String> createPedidoCantidad(String value) {
        return new JAXBElement<String>(_SuministroCantidad_QNAME, String.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Pedido.class)
    public JAXBElement<String> createPedidoEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "fecha_pedido", scope = Pedido.class)
    public JAXBElement<XMLGregorianCalendar> createPedidoFechaPedido(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PedidoFechaPedido_QNAME, XMLGregorianCalendar.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "fecha_sugerida", scope = Pedido.class)
    public JAXBElement<String> createPedidoFechaSugerida(String value) {
        return new JAXBElement<String>(_PedidoFechaSugerida_QNAME, String.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_medida_producto", scope = Pedido.class)
    public JAXBElement<Integer> createPedidoIdMedidaProducto(Integer value) {
        return new JAXBElement<Integer>(_PedidoIdMedidaProducto_QNAME, Integer.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedidaProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "medida_producto", scope = Pedido.class)
    public JAXBElement<MedidaProducto> createPedidoMedidaProducto(MedidaProducto value) {
        return new JAXBElement<MedidaProducto>(_MedidaProducto_QNAME, MedidaProducto.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "observaciones", scope = Pedido.class)
    public JAXBElement<String> createPedidoObservaciones(String value) {
        return new JAXBElement<String>(_SuministroObservaciones_QNAME, String.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "producto", scope = Pedido.class)
    public JAXBElement<Producto> createPedidoProducto(Producto value) {
        return new JAXBElement<Producto>(_Producto_QNAME, Producto.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "producto_id_producto", scope = Pedido.class)
    public JAXBElement<Integer> createPedidoProductoIdProducto(Integer value) {
        return new JAXBElement<Integer>(_PedidoProductoIdProducto_QNAME, Integer.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "proveedor", scope = Pedido.class)
    public JAXBElement<Proveedor> createPedidoProveedor(Proveedor value) {
        return new JAXBElement<Proveedor>(_Proveedor_QNAME, Proveedor.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "proveedor_id_proveedor", scope = Pedido.class)
    public JAXBElement<Integer> createPedidoProveedorIdProveedor(Integer value) {
        return new JAXBElement<Integer>(_PedidoProveedorIdProveedor_QNAME, Integer.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_personas", scope = Paquete.class)
    public JAXBElement<Integer> createPaqueteCantidadPersonas(Integer value) {
        return new JAXBElement<Integer>(_SolicitudCantidadPersonas_QNAME, Integer.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clasificacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "clasificacion", scope = Paquete.class)
    public JAXBElement<Clasificacion> createPaqueteClasificacion(Clasificacion value) {
        return new JAXBElement<Clasificacion>(_Clasificacion_QNAME, Clasificacion.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "clasificacion_id_clasificacion", scope = Paquete.class)
    public JAXBElement<Integer> createPaqueteClasificacionIdClasificacion(Integer value) {
        return new JAXBElement<Integer>(_PaqueteClasificacionIdClasificacion_QNAME, Integer.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "descripcion", scope = Paquete.class)
    public JAXBElement<String> createPaqueteDescripcion(String value) {
        return new JAXBElement<String>(_PaqueteDescripcion_QNAME, String.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Paquete.class)
    public JAXBElement<String> createPaqueteEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "foto", scope = Paquete.class)
    public JAXBElement<String> createPaqueteFoto(String value) {
        return new JAXBElement<String>(_SuministroFoto_QNAME, String.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_lugar", scope = Paquete.class)
    public JAXBElement<Integer> createPaqueteIdLugar(Integer value) {
        return new JAXBElement<Integer>(_PaqueteIdLugar_QNAME, Integer.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "lugar", scope = Paquete.class)
    public JAXBElement<Lugar> createPaqueteLugar(Lugar value) {
        return new JAXBElement<Lugar>(_Lugar_QNAME, Lugar.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Paquete.class)
    public JAXBElement<String> createPaqueteNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "pdf", scope = Paquete.class)
    public JAXBElement<String> createPaquetePdf(String value) {
        return new JAXBElement<String>(_PaquetePdf_QNAME, String.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "precio", scope = Paquete.class)
    public JAXBElement<BigDecimal> createPaquetePrecio(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PaquetePrecio_QNAME, BigDecimal.class, Paquete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = MedidaProducto.class)
    public JAXBElement<String> createMedidaProductoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, MedidaProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfpedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "pedido", scope = MedidaProducto.class)
    public JAXBElement<ArrayOfpedido> createMedidaProductoPedido(ArrayOfpedido value) {
        return new JAXBElement<ArrayOfpedido>(_Pedido_QNAME, ArrayOfpedido.class, MedidaProducto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_persona_max", scope = Lugar.class)
    public JAXBElement<Integer> createLugarCantidadPersonaMax(Integer value) {
        return new JAXBElement<Integer>(_LugarCantidadPersonaMax_QNAME, Integer.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ciudad", scope = Lugar.class)
    public JAXBElement<Ciudad> createLugarCiudad(Ciudad value) {
        return new JAXBElement<Ciudad>(_Ciudad_QNAME, Ciudad.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "contacto", scope = Lugar.class)
    public JAXBElement<String> createLugarContacto(String value) {
        return new JAXBElement<String>(_LugarContacto_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "descripcion", scope = Lugar.class)
    public JAXBElement<String> createLugarDescripcion(String value) {
        return new JAXBElement<String>(_PaqueteDescripcion_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "direccion", scope = Lugar.class)
    public JAXBElement<String> createLugarDireccion(String value) {
        return new JAXBElement<String>(_ProveedorDireccion_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_ciudad", scope = Lugar.class)
    public JAXBElement<Integer> createLugarIdCiudad(Integer value) {
        return new JAXBElement<Integer>(_LugarIdCiudad_QNAME, Integer.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Lugar.class)
    public JAXBElement<String> createLugarNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "telefono_contacto", scope = Lugar.class)
    public JAXBElement<String> createLugarTelefonoContacto(String value) {
        return new JAXBElement<String>(_LugarTelefonoContacto_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ubicacion", scope = Lugar.class)
    public JAXBElement<String> createLugarUbicacion(String value) {
        return new JAXBElement<String>(_LugarUbicacion_QNAME, String.class, Lugar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_meseros", scope = Evento.class)
    public JAXBElement<Integer> createEventoCantidadMeseros(Integer value) {
        return new JAXBElement<Integer>(_EventoCantidadMeseros_QNAME, Integer.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad_personas", scope = Evento.class)
    public JAXBElement<Integer> createEventoCantidadPersonas(Integer value) {
        return new JAXBElement<Integer>(_SolicitudCantidadPersonas_QNAME, Integer.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cliente", scope = Evento.class)
    public JAXBElement<Cliente> createEventoCliente(Cliente value) {
        return new JAXBElement<Cliente>(_Cliente_QNAME, Cliente.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cliente_id_cliente", scope = Evento.class)
    public JAXBElement<Long> createEventoClienteIdCliente(Long value) {
        return new JAXBElement<Long>(_EventoClienteIdCliente_QNAME, Long.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado_evento", scope = Evento.class)
    public JAXBElement<Integer> createEventoEstadoEvento(Integer value) {
        return new JAXBElement<Integer>(_EstadoEvento_QNAME, Integer.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado_evento1", scope = Evento.class)
    public JAXBElement<EstadoEvento> createEventoEstadoEvento1(EstadoEvento value) {
        return new JAXBElement<EstadoEvento>(_EventoEstadoEvento1_QNAME, EstadoEvento.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "fecha", scope = Evento.class)
    public JAXBElement<XMLGregorianCalendar> createEventoFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SolicitudFecha_QNAME, XMLGregorianCalendar.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "hora_fin", scope = Evento.class)
    public JAXBElement<XMLGregorianCalendar> createEventoHoraFin(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_EventoHoraFin_QNAME, XMLGregorianCalendar.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "hora_inicio", scope = Evento.class)
    public JAXBElement<XMLGregorianCalendar> createEventoHoraInicio(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_EventoHoraInicio_QNAME, XMLGregorianCalendar.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_lugar", scope = Evento.class)
    public JAXBElement<Integer> createEventoIdLugar(Integer value) {
        return new JAXBElement<Integer>(_PaqueteIdLugar_QNAME, Integer.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lugar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "lugar", scope = Evento.class)
    public JAXBElement<Lugar> createEventoLugar(Lugar value) {
        return new JAXBElement<Lugar>(_Lugar_QNAME, Lugar.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "observaciones", scope = Evento.class)
    public JAXBElement<String> createEventoObservaciones(String value) {
        return new JAXBElement<String>(_SuministroObservaciones_QNAME, String.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "precio", scope = Evento.class)
    public JAXBElement<BigDecimal> createEventoPrecio(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PaquetePrecio_QNAME, BigDecimal.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "solicitud", scope = Evento.class)
    public JAXBElement<Solicitud> createEventoSolicitud(Solicitud value) {
        return new JAXBElement<Solicitud>(_Solicitud_QNAME, Solicitud.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "solicitud_id_solicitud", scope = Evento.class)
    public JAXBElement<Long> createEventoSolicitudIdSolicitud(Long value) {
        return new JAXBElement<Long>(_EventoSolicitudIdSolicitud_QNAME, Long.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_evento", scope = Evento.class)
    public JAXBElement<Integer> createEventoTipoEvento(Integer value) {
        return new JAXBElement<Integer>(_TipoEvento_QNAME, Integer.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_evento1", scope = Evento.class)
    public JAXBElement<TipoEvento> createEventoTipoEvento1(TipoEvento value) {
        return new JAXBElement<TipoEvento>(_EventoTipoEvento1_QNAME, TipoEvento.class, Evento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = EstadoEvento.class)
    public JAXBElement<String> createEstadoEventoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, EstadoEvento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "apellido", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoApellido(String value) {
        return new JAXBElement<String>(_EmpleadoApellido_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "barrio", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoBarrio(String value) {
        return new JAXBElement<String>(_EmpleadoBarrio_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "correo", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoCorreo(String value) {
        return new JAXBElement<String>(_ProveedorCorreo_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "direccion", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoDireccion(String value) {
        return new JAXBElement<String>(_ProveedorDireccion_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado_id_rol", scope = Empleado.class)
    public JAXBElement<Integer> createEmpleadoEmpleadoIdRol(Integer value) {
        return new JAXBElement<Integer>(_EmpleadoEmpleadoIdRol_QNAME, Integer.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_tipo_documento", scope = Empleado.class)
    public JAXBElement<Integer> createEmpleadoIdTipoDocumento(Integer value) {
        return new JAXBElement<Integer>(_EmpleadoIdTipoDocumento_QNAME, Integer.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "n_identificacion", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoNIdentificacion(String value) {
        return new JAXBElement<String>(_EmpleadoNIdentificacion_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "rol", scope = Empleado.class)
    public JAXBElement<Rol> createEmpleadoRol(Rol value) {
        return new JAXBElement<Rol>(_Rol_QNAME, Rol.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "telefono", scope = Empleado.class)
    public JAXBElement<String> createEmpleadoTelefono(String value) {
        return new JAXBElement<String>(_SolicitudTelefono_QNAME, String.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_documento", scope = Empleado.class)
    public JAXBElement<TipoDocumento> createEmpleadoTipoDocumento(TipoDocumento value) {
        return new JAXBElement<TipoDocumento>(_TipoDocumento_QNAME, TipoDocumento.class, Empleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = DetalleProveedor.class)
    public JAXBElement<String> createDetalleProveedorEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, DetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "producto_id_suministro", scope = DetalleProveedor.class)
    public JAXBElement<Integer> createDetalleProveedorProductoIdSuministro(Integer value) {
        return new JAXBElement<Integer>(_DetalleProveedorProductoIdSuministro_QNAME, Integer.class, DetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "proveedor", scope = DetalleProveedor.class)
    public JAXBElement<Proveedor> createDetalleProveedorProveedor(Proveedor value) {
        return new JAXBElement<Proveedor>(_Proveedor_QNAME, Proveedor.class, DetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "proveedor_id_proveedor", scope = DetalleProveedor.class)
    public JAXBElement<Integer> createDetalleProveedorProveedorIdProveedor(Integer value) {
        return new JAXBElement<Integer>(_PedidoProveedorIdProveedor_QNAME, Integer.class, DetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "suministro", scope = DetalleProveedor.class)
    public JAXBElement<Suministro> createDetalleProveedorSuministro(Suministro value) {
        return new JAXBElement<Suministro>(_Suministro_QNAME, Suministro.class, DetalleProveedor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "cantidad", scope = DetalleProductoSuministro.class)
    public JAXBElement<Integer> createDetalleProductoSuministroCantidad(Integer value) {
        return new JAXBElement<Integer>(_SuministroCantidad_QNAME, Integer.class, DetalleProductoSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = DetalleProductoSuministro.class)
    public JAXBElement<Integer> createDetalleProductoSuministroEstado(Integer value) {
        return new JAXBElement<Integer>(_UsuarioEstado_QNAME, Integer.class, DetalleProductoSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "id_suministro", scope = DetalleProductoSuministro.class)
    public JAXBElement<Integer> createDetalleProductoSuministroIdSuministro(Integer value) {
        return new JAXBElement<Integer>(_DetalleProductoSuministroIdSuministro_QNAME, Integer.class, DetalleProductoSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "producto", scope = DetalleProductoSuministro.class)
    public JAXBElement<Producto> createDetalleProductoSuministroProducto(Producto value) {
        return new JAXBElement<Producto>(_Producto_QNAME, Producto.class, DetalleProductoSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suministro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "suministro", scope = DetalleProductoSuministro.class)
    public JAXBElement<Suministro> createDetalleProductoSuministroSuministro(Suministro value) {
        return new JAXBElement<Suministro>(_Suministro_QNAME, Suministro.class, DetalleProductoSuministro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "calificacion", scope = DetalleEmpleado.class)
    public JAXBElement<Double> createDetalleEmpleadoCalificacion(Double value) {
        return new JAXBElement<Double>(_DetalleEmpleadoCalificacion_QNAME, Double.class, DetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado", scope = DetalleEmpleado.class)
    public JAXBElement<Empleado> createDetalleEmpleadoEmpleado(Empleado value) {
        return new JAXBElement<Empleado>(_Empleado_QNAME, Empleado.class, DetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "empleado_id_empleado", scope = DetalleEmpleado.class)
    public JAXBElement<Long> createDetalleEmpleadoEmpleadoIdEmpleado(Long value) {
        return new JAXBElement<Long>(_UsuarioEmpleadoIdEmpleado_QNAME, Long.class, DetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = DetalleEmpleado.class)
    public JAXBElement<String> createDetalleEmpleadoEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, DetalleEmpleado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "apellido", scope = Cliente.class)
    public JAXBElement<String> createClienteApellido(String value) {
        return new JAXBElement<String>(_EmpleadoApellido_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "celular", scope = Cliente.class)
    public JAXBElement<String> createClienteCelular(String value) {
        return new JAXBElement<String>(_ClienteCelular_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ciudad", scope = Cliente.class)
    public JAXBElement<Integer> createClienteCiudad(Integer value) {
        return new JAXBElement<Integer>(_Ciudad_QNAME, Integer.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ciudad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "ciudad1", scope = Cliente.class)
    public JAXBElement<Ciudad> createClienteCiudad1(Ciudad value) {
        return new JAXBElement<Ciudad>(_ClienteCiudad1_QNAME, Ciudad.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "correo", scope = Cliente.class)
    public JAXBElement<String> createClienteCorreo(String value) {
        return new JAXBElement<String>(_ProveedorCorreo_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "direccion", scope = Cliente.class)
    public JAXBElement<String> createClienteDireccion(String value) {
        return new JAXBElement<String>(_ProveedorDireccion_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "estado", scope = Cliente.class)
    public JAXBElement<String> createClienteEstado(String value) {
        return new JAXBElement<String>(_UsuarioEstado_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "n_identificacion", scope = Cliente.class)
    public JAXBElement<String> createClienteNIdentificacion(String value) {
        return new JAXBElement<String>(_EmpleadoNIdentificacion_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Cliente.class)
    public JAXBElement<String> createClienteNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "telefono", scope = Cliente.class)
    public JAXBElement<String> createClienteTelefono(String value) {
        return new JAXBElement<String>(_SolicitudTelefono_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "tipo_documento1", scope = Cliente.class)
    public JAXBElement<TipoDocumento> createClienteTipoDocumento1(TipoDocumento value) {
        return new JAXBElement<TipoDocumento>(_ClienteTipoDocumento1_QNAME, TipoDocumento.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "nombre", scope = Clasificacion.class)
    public JAXBElement<String> createClasificacionNombre(String value) {
        return new JAXBElement<String>(_TipoProductoNombre_QNAME, String.class, Clasificacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dominio", name = "Nombre", scope = Ciudad.class)
    public JAXBElement<String> createCiudadNombre(String value) {
        return new JAXBElement<String>(_CiudadNombre_QNAME, String.class, Ciudad.class, value);
    }

}
