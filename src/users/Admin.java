package users;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import flightManagement.FlightDetails;
import pilotManagement.AssignedPilot;

public class Admin extends User {

	private String Id;
	private FlightDetails fd;

	public Admin(){
		super();
	}
	Admin(String userName, String password, String Id)
	{
		super(userName, password);
		this.Id = Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	public String getId() {
		return Id;
	}
	
	void readFlightAssgDetails() {
		try(ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream("FlightAssgDetails.dat"))){
			ap =(ArrayList<AssignedPilot>)ob1.readObject();
		}catch(Exception e){
			System.out.println("Error!");
		}
	}
	
	public void addFlight(String flightNumber, String departure, String arrival, int month, int date, int hour,
			int minutes, int duration, int durationMins) {
		    
		        readFlight();
		        readFlightAssgDetails();
				
				FlightDetails fd = new FlightDetails();
				fd.setFlightNumber(flightNumber);
				fd.setDeparture(departure);
				fd.setArrival(arrival);
				fd.setDepartureDate(month, date, hour, minutes);
				fd.setArrivalDate(duration,durationMins);
				f.add(fd);
				ap.add(new AssignedPilot(fd.getFlightNumber(), null));
			    
				writeFlight();	
		}
	
	@Override
	public ArrayList<FlightDetails> searchFlight(String a) {
		  readFlight();
		  ArrayList<FlightDetails> foundFlights = new ArrayList<>();
		  int flag = 0;
		  
		  for(int i=0; i<f.size(); i++)
		  {
			  if(((f.get(i)).getFlightNumber()).equalsIgnoreCase(a))
			  {
//				  flag = 1;
				  foundFlights.add(f.get(i));
			  }
		  }
		  return foundFlights;
	}
	
	
	public boolean deleteFlightDetails(String a) {
		
		  readFlight();
		  readFlightAssgDetails();
		  boolean flag = false;
		  
		  for(int i=0; i<f.size(); i++)
		  {
			  if(((f.get(i)).getFlightNumber()).equalsIgnoreCase(a) && ap.get(i).getFlightNumber().equalsIgnoreCase(a))
			  { 
				flag = true;
				//return f.get(i);
				f.remove(i);
				ap.remove(i);
				writeFlight();
				return flag;
				//System.out.println("Deleted successfully!");
			  }
			  
		   }
			  
		  if(flag==false) {
			  return flag;
//			  System.out.println("Flight Details Not Found!");
//			  return new FlightDetails();
		  }else {
			  return flag;
		  }
		  
		  
	}
	

	}

	


	
	

