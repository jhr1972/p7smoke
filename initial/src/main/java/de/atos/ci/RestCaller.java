package de.atos.ci;
import java.util.List;
import org.slf4j.*;

import org.springframework.web.client.*;
import com.jayway.jsonpath.*;

public class RestCaller{
	private  static Logger logger =  LoggerFactory.getLogger(RestCaller.class);
	
	public static SummaryChecks fillChecksfromRest(SummaryChecks  checks) {
		logger.debug("starting to fill SummaryChecks XML with REST result. ");
		RestTemplate restTemplate = new RestTemplate();
		List<Check> listcheck = checks.getSummarychecks();
			for (Check temp : listcheck ) {
				String result = restTemplate.getForObject(temp.geturi(), String.class);
				logger.debug("Result: "+ result);
				
				temp.setlastcheckresult(parseJson(result,temp.getpath()));
			} 
				return checks;
	}
	
	private static final int parseJson(String json,String path) {
		
		ReadContext ctx = JsonPath.parse(json);
		List<Integer> counts = ctx.read(path);
		
		logger.debug("Rest Response - Current Counts: " + counts.get(0));

		return counts.get(0);
	}

}