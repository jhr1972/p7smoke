package de.atos.ci;
import java.util.List;
import javax.xml.bind.annotation.*;


@XmlRootElement(name="SummaryChecks", namespace="SummaryChecks")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryChecks {

    @XmlElement(name="Check")
    private List<Check> summarychecks;
    
    public  List<de.atos.ci.Check> getSummarychecks(){return summarychecks;}
}
