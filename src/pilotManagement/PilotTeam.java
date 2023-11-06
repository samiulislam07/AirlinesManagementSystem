package pilotManagement;
import java.io.Serializable;

public class PilotTeam implements Serializable {

	private String Team;
    private String userName;
	private String password;
	private PilotDetails[] ob = new PilotDetails [2];
	
	public PilotTeam(String Team, String userName, String password, PilotDetails o[])
	{
		this.Team = Team;
		this.userName = userName;
		this.password = password;
		ob = o;
	}
	
	public String getTeam() {
		return Team;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public PilotDetails getOb(int i) {
		return ob[i];
	}

	public String toString() {
		
		return "Team:"+Team;
	}
}
