package de.atos.ci;

import java.util.List;

public class StatusListe {
	private List<Check> checks;

	public List<Check> getChecks(){
		return checks;
	}
	
	public void setChecks(List<Check> checks ) {this.checks=checks;}
	
	
}
