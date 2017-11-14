package com.nobelbiocare.pi.j2ee.ejb.job;

import java.util.logging.Logger;


import com.nobelbiocare.rfid_cabinet.DTEventsResponse;
import com.nobelbiocare.rfid_cabinet.DTGetEvents;
import com.nobelbiocare.rfid_cabinet.DTSetEvents;

import com.nobelbiocare.rfid_cabinet.MI300GetEventsCabinetsOs;
import com.nobelbiocare.rfid_cabinet.MI300GetEventsCabinetsOsService;
import com.nobelbiocare.rfid_cabinet.MI302SetEventsCabinetsOa;
import com.nobelbiocare.rfid_cabinet.MI302SetEventsCabinetsOaService;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.JobParameter;

/**
 * Message-Driven Bean implementation class for: GetCabinetEventsJob
 *
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition=\'GetCabinetEventsJob\' AND ApplicationName=\'nobelbiocare.com/rfid~j2ee~ear~getevents\'") })
		
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@TransactionManagement(value = TransactionManagementType.BEAN)		
public class GetCabinetEventsJob extends MDBJobImplementation {
	

	private static final long serialVersionUID = 1L;

	//Services reference
	@WebServiceRef(name = "MI300GetEventsCabinetsOsService")
	private  MI300GetEventsCabinetsOsService serviceGetEvents;
	

	@WebServiceRef(name = "MI302SetEventsCabinetsOaService")
	private  MI302SetEventsCabinetsOaService serviceSetEvents;	
	
	//Service port
	private MI300GetEventsCabinetsOs portGetEvents;
	private MI302SetEventsCabinetsOa portSetEvents;
	
	private JobParameter limit,evenTypes,devices;
	private String step;
	
	

    /**
     * Default constructor. 
     */
    public GetCabinetEventsJob() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void onJob(JobContext jobContext) throws Exception {

		Logger log = jobContext.getLogger();

		String devicesList[];
		boolean error = false;

		
		log.info("Job starts....");

		// Get job parameters
		limit = jobContext.getJobParameter("LIMIT");
		evenTypes = jobContext.getJobParameter("EVENT_TYPES");
		devices = jobContext.getJobParameter("DEVICES");

		//Set requets parameters
		DTGetEvents reqEvents = new DTGetEvents();
		reqEvents.setLimit(limit.getStringValue());
		reqEvents.setEventTypes(evenTypes.getStringValue());

		log.info("Starting events request....");

		if (devices.getStringValue() != null) {
			devicesList = devices.getStringValue().split(",");
			for (String device : devicesList) {
				if (manageDeviceRequest(reqEvents, log, device))
					error = true;
			}
		} else {
			if (manageDeviceRequest(reqEvents, log, ""))
				error = true;
		}

		

		if (error) {
			log.info("Exception during job execution, check log");
			jobContext.setReturnCode((short)-1);
			//jobContext.jobFailed();
		} else {
			log.info("Job ends....");
		}
	}
	
	public boolean manageDeviceRequest(DTGetEvents reqEvents, Logger log, String device){
		
		try {
			// Get cabinets events
			step = "Get events";
			reqEvents.setDevice(device);// Current device
			log.info("Starting request for device: " + device);

			portGetEvents = serviceGetEvents
					.getPort(MI300GetEventsCabinetsOs.class);
			DTEventsResponse repEvents = portGetEvents
					.mi300GetEventsCabinetsOs(reqEvents);
			String batchId = repEvents.getBatchId();
			
			if(repEvents.getEvents().size() > 0){

				// Send data to backend...
				step = "Send data to backend";

				portSetEvents = serviceSetEvents
						.getPort(MI302SetEventsCabinetsOa.class);
				DTSetEvents setEvents = new DTSetEvents();
				setEvents.getEvents().addAll(repEvents.getEvents());
				setEvents.setBatchId(batchId);
				portSetEvents.mi302SetEventsCabinetsOa(setEvents);

			} else {
				log.info("No events found!!");
			}

		} catch (Exception e) {
			log.info("Exception during job execution during step: " + step);
			log.info(e.toString());
			return true;
		}
		
		return false;
		
	}

}
