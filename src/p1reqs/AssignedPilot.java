package p1reqs;
import java.io.Serializable;

public class AssignedPilot implements Serializable {

	 String FlightNumber;
	 public PilotTeam pt;
	
	public AssignedPilot(String FlightNumber,PilotTeam pt){
		
		this.FlightNumber = FlightNumber;
		this.pt = pt;
	
		
	}

	public String toString() {
		if(this.pt == null) {
			return "FlightNumber= "+ FlightNumber +" "+"NOT ASSIGNED";
		}else {
			return "FlightNumber= "+ FlightNumber +" "+pt;
		}
		
	}
	
}
