package users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import flightManagement.FlightDetails;
import pilotManagement.*;

public class Pilot extends User{
	private ArrayList<PilotTeam> p = new ArrayList<>();
	private ArrayList<AssignedPilot> ap = new ArrayList<>();
	private String Team;
	
    public Pilot() {}
	public Pilot(String userName, String password){
		super(userName, password);
		readPilotDetails();
		int x; int flag = 0;
		for(int i=0; i<p.size(); i++)
		{   
			if((p.get(i).getUserName()).compareTo(userName)==0 && (p.get(i).getPassword()).compareTo(password)==0)
			{
				Team = p.get(i).getTeam();
				x = i;
				flag = 1;
				System.out.println("Welcome Team:"+Team+"!");
				break;
			}
			
		}
		if(flag==0) System.out.println("Invalid username or password!");
		
	}
    
	private void readPilotDetails() {
    	try(ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream("PilotTeamDetails.dat")))
		{
		     p = (ArrayList)ob1.readObject();
		   
		}catch(Exception e) {
			System.out.println("IO error "+e);
		}
    }
	
	public ArrayList<FlightDetails> searchFlight(String a) {
		  readFlight();
		  ArrayList<FlightDetails> foundFlights = new ArrayList<>();
		  
		  int flag = 0;
		  
		  for(int i=0; i<f.size(); i++)
		  {
			 
			  if(((f.get(i)).getDeparture().equalsIgnoreCase(a)))
			  {
				  foundFlights.add(f.get(i));
			  }
			  
		  }
		  
		  return foundFlights;
	}
	
	public ArrayList<AssignedPilot> viewFlightAssgDetails() {
		
		try(ObjectInputStream AssgPilots = new ObjectInputStream(new FileInputStream("FlightAssgDetails.dat"))){
			ap =(ArrayList<AssignedPilot>)AssgPilots.readObject();
		}catch(Exception e) {
			System.out.println("Error!");
	    }
		return ap;
	}
	
	public boolean chooseFlight(String flightNumber) {
		readFlight();//f
		ArrayList<AssignedPilot> AssgPilots = this.viewFlightAssgDetails();
		boolean flag = false;
		for(int i=0; i<f.size(); i++)
		{   
			if(((f.get(i)).getFlightNumber().equalsIgnoreCase(flightNumber)) && (AssgPilots.get(i).getPilotTeam()==null))
			{
					//Assigning
					try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
						PilotTeam team = (PilotTeam)infile.readObject();
						AssgPilots.get(i).setPilotTeam(team);
						flag = true;
					}catch(Exception e) {
						System.out.println("Error");
					}
			}
				  
		}
		if(flag == false) {
			return flag;
		}else {
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("FlightAssgDetails.dat"))){
		 		outfile.writeObject(AssgPilots);
		 	}catch(Exception e) {
		 		System.out.println("Exception!");
		 	}
			return flag;
		}
		   
		
	 }


}
