package de.atos.ci;
import java.io.File;
import org.slf4j.*;
import javax.xml.bind.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TestSummaryChecks {
	 public static void main(String[] args) throws Exception {
			 Logger logger =  LoggerFactory.getLogger(TestSummaryChecks.class);
			 logger.debug("Starting...");
			 
		   JAXBContext jc = JAXBContext.newInstance(SummaryChecks.class);

	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        File xml = new File("SummaryChecks.xml");
	        SummaryChecks checks = (SummaryChecks) unmarshaller.unmarshal(xml);

	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
	        //marshaller.marshal(checks, System.out);
	        RestCaller.fillChecksfromRest(checks);
	        marshaller.marshal(checks, System.out);
	        
	 }
}
