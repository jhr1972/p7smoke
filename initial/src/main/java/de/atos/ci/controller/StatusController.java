package de.atos.ci.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import de.atos.ci.SummaryChecks;
import de.atos.ci.RestCaller;
import de.atos.ci.Check;

import java.io.File;
import java.util.List;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

	
	/*
	 * author: Jochen.Reitzig@atos.net
	 * 
	 */
	 
	@Controller
	public class StatusController {
		Logger logger =  LoggerFactory.getLogger(StatusController.class); 
		@RequestMapping("/status")
		public ModelAndView status() {
	 
			//String message = "<br><div style='text-align:center;'>"
					//+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
			
					//ModelAndView mv = new ModelAndView();
					
					logger.debug("Reading Status configuration SummaryChecks.xml");
					SummaryChecks checks =null;
					try {
					JAXBContext jc = JAXBContext.newInstance(SummaryChecks.class);
			        Unmarshaller unmarshaller = jc.createUnmarshaller();
			        File xml = new File("/tmp/SummaryChecks.xml");
			         checks = (SummaryChecks) unmarshaller.unmarshal(xml);
			        Marshaller marshaller = jc.createMarshaller();			      
			        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
			        logger.debug("Done reading Status configuration SummaryChecks.xml");
					}catch(JAXBException e) {
						logger.error("Invalid XML "+ e.getMessage());
						e.printStackTrace();
						return new ModelAndView("error","message",e.getMessage());
					}
					if (checks != null) {
						logger.debug("Starting to invoke RestCaller");
						RestCaller.fillChecksfromRest(checks);
						List <Check> listofchecks = checks.getSummarychecks();
						
						logger.debug("Done with RestCaller...SummaryChecks is now refreshed.");
						
						return new ModelAndView("status","listofchecks",listofchecks);
					}
					else {
						logger.error("Some error occured");
						return new ModelAndView("error","message","SummaryChecks was null");
					}
			        
			        
					
				   
					
				
		}
		
		
		
	}
	

