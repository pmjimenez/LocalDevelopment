package com.nobelbiocare.rfid_cabinet;

/**
 * Service Endpoint Interface (generated by SAP WSDL to Java generator).
 */
@javax.jws.WebService(name = "MI300_GetEvents_Cabinets_os", targetNamespace = "http://nobelbiocare.com/rfid_cabinet")
@javax.jws.soap.SOAPBinding(parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.BARE, style = javax.jws.soap.SOAPBinding.Style.DOCUMENT, use = javax.jws.soap.SOAPBinding.Use.LITERAL)
public interface MI300GetEventsCabinetsOs {

  /**
   * Java representation of web method [MI300_GetEvents_Cabinets_os].
   */
  @javax.jws.WebMethod(operationName = "MI300_GetEvents_Cabinets_os", action = "http://sap.com/xi/WebService/soap1.1")
  @javax.jws.WebResult(name = "MT_EventsResponse", targetNamespace = "http://nobelbiocare.com/rfid_cabinet", partName = "MT_EventsResponse")
  public com.nobelbiocare.rfid_cabinet.DTEventsResponse mi300GetEventsCabinetsOs(@javax.jws.WebParam(name = "MT_GetEvents", targetNamespace = "http://nobelbiocare.com/rfid_cabinet", partName = "MT_GetEvents") com.nobelbiocare.rfid_cabinet.DTGetEvents MT_GetEvents);

}
