package com.nobelbiocare.rfid_cabinet;

/**
 * Service Endpoint Interface (generated by SAP WSDL to Java generator).
 */
@javax.jws.WebService(name = "MI302_SetEvents_Cabinets_oa", targetNamespace = "http://nobelbiocare.com/rfid_cabinet")
@javax.jws.soap.SOAPBinding(parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.BARE, style = javax.jws.soap.SOAPBinding.Style.DOCUMENT, use = javax.jws.soap.SOAPBinding.Use.LITERAL)
public interface MI302SetEventsCabinetsOa {

  /**
   * Java representation of web method [MI302_SetEvents_Cabinets_oa].
   */
  @javax.jws.WebMethod(operationName = "MI302_SetEvents_Cabinets_oa", action = "http://sap.com/xi/WebService/soap1.1")
  @javax.jws.Oneway
  public void mi302SetEventsCabinetsOa(@javax.jws.WebParam(name = "MT_SetEvents", targetNamespace = "http://nobelbiocare.com/rfid_cabinet", partName = "MT_SetEvents") com.nobelbiocare.rfid_cabinet.DTSetEvents MT_SetEvents);

}