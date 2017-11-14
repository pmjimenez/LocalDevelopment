package com.nobelbiocare.rfid_cabinet;

/**
 * Service implementation of {MI300_GetEvents_Cabinets_os_Service} (generated by SAP WSDL to Java generator).
 */
@javax.xml.ws.WebServiceClient(name = "MI300_GetEvents_Cabinets_os_Service", targetNamespace = "http://nobelbiocare.com/rfid_cabinet", wsdlLocation = "META-INF/wsdl/com/nobelbiocare/rfid_cabinet/MI300_GetEvents_Cabinets_os/MI300_GetEvents_Cabinets_os.wsdl")
public class MI300GetEventsCabinetsOsService extends javax.xml.ws.Service {

  private final static java.net.URL MI300GETEVENTSCABINETSOSSERVICE_WSDL_LOCATION = null;
  /**
   * Default service constructor.
   */
  public MI300GetEventsCabinetsOsService() throws java.net.MalformedURLException {
    super(MI300GETEVENTSCABINETSOSSERVICE_WSDL_LOCATION, new javax.xml.namespace.QName("http://nobelbiocare.com/rfid_cabinet", "MI300_GetEvents_Cabinets_os_Service"));
  }
  public MI300GetEventsCabinetsOsService(java.net.URL wsdlLocation, javax.xml.namespace.QName serviceName) {
    super(wsdlLocation, serviceName);
  }
  /**
   * Get method for webservice port [MI300_GetEvents_Cabinets_os_Port].
   */
  @javax.xml.ws.WebEndpoint(name = "MI300_GetEvents_Cabinets_os_Port")
  public com.nobelbiocare.rfid_cabinet.MI300GetEventsCabinetsOs getMI300_GetEvents_Cabinets_os_Port() {
    javax.xml.namespace.QName portName = new javax.xml.namespace.QName("http://nobelbiocare.com/rfid_cabinet","MI300_GetEvents_Cabinets_os_Port");
    return (com.nobelbiocare.rfid_cabinet.MI300GetEventsCabinetsOs) super.getPort(portName,com.nobelbiocare.rfid_cabinet.MI300GetEventsCabinetsOs.class);
  }
}
