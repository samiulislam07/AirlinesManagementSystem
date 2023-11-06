package pilotManagement;
import java.io.Serializable;

public class AssignedPilot implements Serializable {

	 private String FlightNumber;
	 private PilotTeam pt;
	
	public AssignedPilot(String FlightNumber,PilotTeam pt){
		
		this.FlightNumber = FlightNumber;
		this.pt = pt;
	}
	
	public String getFlightNumber() {
		return FlightNumber;
	}
	public void setPilotTeam(PilotTeam pt)
	{
		this.pt = pt;
	}
	public PilotTeam getPilotTeam() {
		
		return pt;
	}
	public String toString() {
		if(this.pt == null) {
			return "FlightNumber= "+ FlightNumber +" "+"NOT ASSIGNED";
		}else {
			return "FlightNumber= "+ FlightNumber +" "+pt;
		}
		
	}
	
}
