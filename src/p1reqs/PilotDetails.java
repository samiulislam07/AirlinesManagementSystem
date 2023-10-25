package p1reqs;
import java.io.Serializable;
public class PilotDetails implements Serializable {
	public String Name;
	public int Id;
	public String Rank;

	public PilotDetails(String Name, int Id,String rank){
	
		this.Name = Name;
		this.Id = Id;
		this.Rank = rank;
		
	}

	
	public String toString() {
		return "Pilot Name: "+Name+"\nRank: "+Rank+"\nId: "+Id;
	}
	

}

