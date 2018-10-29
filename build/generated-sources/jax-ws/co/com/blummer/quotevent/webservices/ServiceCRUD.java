
package co.com.blummer.quotevent.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceCRUD", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://localhost:55687/ServiceCRUD.svc?wsdl")
public class ServiceCRUD
    extends Service
{

    private final static URL SERVICECRUD_WSDL_LOCATION;
    private final static WebServiceException SERVICECRUD_EXCEPTION;
    private final static QName SERVICECRUD_QNAME = new QName("http://tempuri.org/", "ServiceCRUD");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:55687/ServiceCRUD.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICECRUD_WSDL_LOCATION = url;
        SERVICECRUD_EXCEPTION = e;
    }

    public ServiceCRUD() {
        super(__getWsdlLocation(), SERVICECRUD_QNAME);
    }

    public ServiceCRUD(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICECRUD_QNAME, features);
    }

    public ServiceCRUD(URL wsdlLocation) {
        super(wsdlLocation, SERVICECRUD_QNAME);
    }

    public ServiceCRUD(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICECRUD_QNAME, features);
    }

    public ServiceCRUD(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceCRUD(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IServiceCRUD
     */
    @WebEndpoint(name = "BasicHttpBinding_IServiceCRUD")
    public IServiceCRUD getBasicHttpBindingIServiceCRUD() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IServiceCRUD"), IServiceCRUD.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IServiceCRUD
     */
    @WebEndpoint(name = "BasicHttpBinding_IServiceCRUD")
    public IServiceCRUD getBasicHttpBindingIServiceCRUD(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IServiceCRUD"), IServiceCRUD.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICECRUD_EXCEPTION!= null) {
            throw SERVICECRUD_EXCEPTION;
        }
        return SERVICECRUD_WSDL_LOCATION;
    }

}
