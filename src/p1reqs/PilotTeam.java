package p1reqs;
import java.io.Serializable;

public class PilotTeam implements Serializable {

	public String Team;
    public String userName;
	public String password;
	public PilotDetails[] ob = new PilotDetails [2];
	
	public PilotTeam(String Team, String userName, String password, PilotDetails o[])
	{
		this.Team = Team;
		this.userName = userName;
		this.password = password;
		ob = o;
	}
	
	public String toString() {
		
		return "Team:"+Team/*+" Pilot Details:"+ob[0]+"\n"+ob[1]*/;
	}
}
