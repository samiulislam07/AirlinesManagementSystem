package users;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import flightManagement.FlightDetails;
import pilotManagement.AssignedPilot;
import pilotManagement.PilotDetails;
import pilotManagement.PilotTeam;

public class Driver {
	public static void main(String[] args) throws Exception{
		FlightDetails f1 = new FlightDetails();
 		f1.setFlightNumber("ZS2021");
 		f1.setDeparture("Bangladesh");
 		f1.setArrival("Singapore");
 		f1.setDepartureDate(12, 1, 5, 45);
 		f1.setArrivalDate(1,20);
 		
 		FlightDetails f2 = new FlightDetails();
 		f2.setFlightNumber("ZS2191");
 		f2.setDeparture("Bangladesh");
 		f2.setArrival("Maylaysia");
 		f2.setDepartureDate(1, 1, 8, 15);
 		f2.setArrivalDate(2,0);
 		
 		FlightDetails f3 = new FlightDetails();
 		f3.setFlightNumber("ZS9101");
 		f3.setDeparture("Vietnam");
 		f3.setArrival("Maylaysia");
 		f3.setDepartureDate(1, 2, 10, 15);
 		f3.setArrivalDate(1,45);

 		ArrayList<FlightDetails> ob = new ArrayList<>();
 		ob.add(f1);
 		ob.add(f2);
 		ob.add(f3);
 		
 		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("FDetails.dat"))){
 			outfile.writeObject(ob);
 			System.out.println("FDetails Written");
 		}
 		
		ArrayList<PilotTeam> pTeam = new ArrayList<>();
		PilotDetails[] team1 = {new PilotDetails("Samiul Islam",201,"Captain"), new PilotDetails("Faisal Hasan",202,"Co Pilot")};
    	PilotTeam p1 = new PilotTeam("ZRSA","02A","ahik", team1);
    	PilotDetails[] team2 = {new PilotDetails("Zach Fang",203,"Captain"), new PilotDetails("Zyan Rahman",204,"Co Pilot")};
    	PilotTeam p2 = new PilotTeam("ZRSB","02B","ahik",team2);
    	pTeam.add(p1); pTeam.add(p2);
    	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("PilotTeamDetails.dat"))){
 			outfile.writeObject(pTeam);
 			System.out.println("PilotTeamDetails written");
 		}
    	
		ArrayList<AssignedPilot> AssgPilots = new ArrayList<>();
		for(int i=0; i<ob.size(); i++)
    	{
    		AssgPilots.add(new AssignedPilot(ob.get(i).getFlightNumber(), null));
    	}
		for(int i=0; i<AssgPilots.size(); i++)
 		{
 			System.out.println(AssgPilots.get(i));
 			
 		}
		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("FlightAssgDetails.dat"))){
 			outfile.writeObject(AssgPilots);
 			System.out.println("FlightAssgDetails written");
 		}
		
//		Pilot p = new Pilot();
//		ArrayList<AssignedPilot> AssgPilots = (ArrayList<AssignedPilot>)p.viewFlightAssgDetails();
//		for(int i=0; i<AssgPilots.size(); i++) {
//			System.out.println(AssgPilots.get(i));
//		}
//		p.chooseFlight();
		
//		PilotDetails[] team1 = {new PilotDetails("Samiul Islam",201,"Captain"), new PilotDetails("Faisal Hasan",202,"Co Pilot")};
//		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
//			outfile.writeObject(new PilotTeam("Alpha", "Alpha", "ahik", team1));
//			System.out.println("SessionInfo Written");
//		}
		
    	
    	
 		
	}

}
