package p1;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import p1reqs.FlightDetails;

public class Admin extends User {

	private String Id;

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
//	 void readFlight() {
//		
//		  try(ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream("FDetails.dat")))
//			{
//			     f = (ArrayList<FlightDetails>) ob1.readObject();
//			   
//			}catch(Exception e) {
//				System.out.println("IO error"+e);
//			}
//	}
	
//	public ArrayList<FlightDetails> viewFlight() {
//		
//		readFlight();
//		return f;	
//	}
	

	
	public void addFlight(String flightNumber, String departure, String arrival, int month, int date, int hour,
			int minutes, int duration, int durationMins) {
		    
		        readFlight();
		        
//				Scanner sc = new Scanner(System.in);
//			    System.out.println("Enter 0 to quit:");
//			    int intkey = 1; 
//			    while(intkey!=0) {
//			    System.out.println("Press 0 to quit or anything else to continue:");
//			    intkey = sc.nextInt();
//			    if(intkey==0)
//			    	break;
			    
//			    sc.nextLine();
//				System.out.println("Flight Number:");
//				String a = sc.nextLine();
//				System.out.println("Departure:");
//				String b = sc.nextLine();
//				System.out.println("Arrival:");
//				String c = sc.nextLine();
//				System.out.println("Enter Departure month:");
//				int mon = sc.nextInt();
//				System.out.println("Enter Departure date:");
//				int dt = sc.nextInt();
//				System.out.println("Enter Departure hour:");
//				int hr = sc.nextInt();
//				System.out.println("Enter Departure minutes:");
//				int min = sc.nextInt(); 
//				System.out.println("Enter Flight Duration hours:");
//				int fhr = sc.nextInt();
//				System.out.println("In mins:");
//				int fmin = sc.nextInt();
				
				FlightDetails fd = new FlightDetails();
				fd.setFlightNumber(flightNumber);
				fd.setDeparture(departure);
				fd.setArrival(arrival);
				fd.setDepartureDate(month, date, hour, minutes);
				fd.setArrivalDate(duration,durationMins);
				f.add(fd);
			    
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
		  boolean flag = false;
		  
		  for(int i=0; i<f.size(); i++)
		  {
			  if(((f.get(i)).getFlightNumber()).equalsIgnoreCase(a))
			  { 
				flag = true;
				//return f.get(i);
				f.remove(i);
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

	


	
	

