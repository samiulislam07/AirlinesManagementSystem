package p1reqs;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




public class putInf {
        
	    public static void main(String args[]) throws Exception {
		
	    	ArrayList<FlightDetails> fd = new ArrayList<>();
	    	ArrayList<AssignedPilot> ap = new ArrayList<>();
//	        ArrayList s;
	 		FlightDetails f1 = new FlightDetails();
	 		f1.setFlightNumber("ZS2021");
	 		f1.setDeparture("Bangladesh Terminal 1");
	 		f1.setArrival("Singapore Terminal 2");
	 		f1.setDepartureDate(12, 1, 5, 45);
	 		f1.setArrivalDate(1,20);
	 		
	 		FlightDetails f2 = new FlightDetails();
	 		f2.setFlightNumber("ZS2191");
	 		f2.setDeparture("Bangladesh Terminal 1");
	 		f2.setArrival("Maylaysia Terminal 12");
	 		f2.setDepartureDate(1, 1, 8, 15);
	 		f2.setArrivalDate(2,0);
	 		
	 		FlightDetails f3 = new FlightDetails();
	 		f3.setFlightNumber("ZS9101");
	 		f3.setDeparture("Vietnam Terminal 1");
	 		f3.setArrival("Maylaysia Terminal 4");
	 		f3.setDepartureDate(1, 2, 10, 15);
	 		f3.setArrivalDate(1,45);
	 		
	 		fd.add(f1);
	 		fd.add(f2);
	 		fd.add(f3);
	 		
	 		ap.add(new AssignedPilot(f1.getFlightNumber(), null));
	 		ap.add(new AssignedPilot(f2.getFlightNumber(), null));
	 		ap.add(new AssignedPilot(f3.getFlightNumber(), null));
	 		
	 		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("FDetails.dat"))){
	 			outfile.writeObject(fd);
	 		}
	 		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("FlightAssgDetails.dat"))){
	 			outfile.writeObject(ap);
	 		}
	    	
	    	try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("FlightAssgDetails.dat"))){
	    		ap = (ArrayList<AssignedPilot>)infile.readObject();
	    	}
	    	for(int i=0; i<ap.size(); i++) {
	    		System.out.println(ap.get(i));
	    	}
	    }
	   
}
