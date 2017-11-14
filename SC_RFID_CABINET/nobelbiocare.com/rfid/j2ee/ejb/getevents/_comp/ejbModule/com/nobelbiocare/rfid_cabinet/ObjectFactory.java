
package com.nobelbiocare.rfid_cabinet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nobelbiocare.rfid_cabinet package. 
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

    private final static QName _MTGetEvents_QNAME = new QName(
			"http://nobelbiocare.com/rfid_cabinet", "MT_GetEvents");
	private final static QName _MTEventsResponse_QNAME = new QName(
			"http://nobelbiocare.com/rfid_cabinet", "MT_EventsResponse");
	private final static QName _MTSetEvents_QNAME = new QName("http://nobelbiocare.com/rfid_cabinet", "MT_SetEvents");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nobelbiocare.rfid_cabinet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTSetEvents }
     * 
     */
    public DTSetEvents createDTSetEvents() {
        return new DTSetEvents();
    }

    /**
     * Create an instance of {@link DTEvents }
     * 
     */
    public DTEvents createDTEvents() {
        return new DTEvents();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTSetEvents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nobelbiocare.com/rfid_cabinet", name = "MT_SetEvents")
    public JAXBElement<DTSetEvents> createMTSetEvents(DTSetEvents value) {
        return new JAXBElement<DTSetEvents>(_MTSetEvents_QNAME, DTSetEvents.class, null, value);
    }

	/**
	 * Create an instance of  {@link DTGetEvents  }
	 */
	public DTGetEvents createDTGetEvents() {
		return new DTGetEvents();
	}

	/**
	 * Create an instance of  {@link DTEventsResponse  }
	 */
	public DTEventsResponse createDTEventsResponse() {
		return new DTEventsResponse();
	}

	/**
	 * Create an instance of  {@link JAXBElement  } {@code  <} {@link DTEventsResponse  } {@code  >} }
	 */
	@XmlElementDecl(namespace = "http://nobelbiocare.com/rfid_cabinet", name = "MT_EventsResponse")
	public JAXBElement<DTEventsResponse> createMTEventsResponse(
			DTEventsResponse value) {
		return new JAXBElement<DTEventsResponse>(_MTEventsResponse_QNAME,
				DTEventsResponse.class, null, value);
	}

	/**
	 * Create an instance of  {@link JAXBElement  } {@code  <} {@link DTGetEvents  } {@code  >} }
	 */
	@XmlElementDecl(namespace = "http://nobelbiocare.com/rfid_cabinet", name = "MT_GetEvents")
	public JAXBElement<DTGetEvents> createMTGetEvents(DTGetEvents value) {
		return new JAXBElement<DTGetEvents>(_MTGetEvents_QNAME,
				DTGetEvents.class, null, value);
	}

}
