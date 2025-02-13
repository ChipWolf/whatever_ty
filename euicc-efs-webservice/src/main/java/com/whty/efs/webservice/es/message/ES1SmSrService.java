package com.whty.efs.webservice.es.message;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-09-08T17:55:13.054+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "ES1SmSrService", 
                  wsdlLocation = "file:WebServicesAPI1/ES1_SMSR.wsdl",
                  targetNamespace = "http://namespaces.gsma.org/esim-messaging/3") 
public class ES1SmSrService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://namespaces.gsma.org/esim-messaging/3", "ES1SmSrService");
    public final static QName SmSrES1Port = new QName("http://namespaces.gsma.org/esim-messaging/3", "SmSrES1Port");
    static {
        URL url = null;
        try {
            url = new URL("file:WebServicesAPI1/ES1_SMSR.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ES1SmSrService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:WebServicesAPI1/ES1_SMSR.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ES1SmSrService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ES1SmSrService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ES1SmSrService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
   /* public ES1SmSrService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ES1SmSrService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ES1SmSrService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    } */   




    /**
     *
     * @return
     *     returns ES1SmSr
     */
    @WebEndpoint(name = "SmSrES1Port")
    public ES1SmSr getSmSrES1Port() {
        return super.getPort(SmSrES1Port, ES1SmSr.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ES1SmSr
     */
    @WebEndpoint(name = "SmSrES1Port")
    public ES1SmSr getSmSrES1Port(WebServiceFeature... features) {
        return super.getPort(SmSrES1Port, ES1SmSr.class, features);
    }

}
