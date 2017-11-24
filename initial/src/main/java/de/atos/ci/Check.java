package de.atos.ci;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Check {
	    private int checkid;
	    private String description;
	    private String uri;
	    private String path;
	
	    private int expectedresultMin;
	    private int expectedresultMax;
	    private int lastcheckresult;
	    private int statusok;
	    @XmlAttribute
	    private String type;

public int getcheckid() {return checkid;}
public String getdescription() { return description;}
public String geturi() { return uri;}
public String getpath() { return path;}
public int getexpectedresultMin() { return expectedresultMin; }
public int getexpectedresultMax() { return expectedresultMax; }
public int getlastcheckresult() { return lastcheckresult;}
public int getstatusok() { return statusok;}

public void  setlastcheckresult(int lastcheckresult) { 
	this.lastcheckresult =  lastcheckresult;
	if( (lastcheckresult >= expectedresultMin) && (lastcheckresult <= expectedresultMax)) { this.statusok=1;}
	else { this.statusok=0;}
}



}





