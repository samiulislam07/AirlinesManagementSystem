package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import flightManagement.FlightDetails;
import flightManagement.Seat;

public class Customer extends User implements Serializable{

	private String name;
	private int age;
	private String contact;
	private double cost=0;
	
	
	public Customer(String name, int age, String contact, String userName, String password) {
		super(userName,password);
		this.name = name;
		this.age = age;
		this.contact = contact;
	}
	Customer(String userName, String password)
	{
		super(userName,password);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	private void readseatDetails(String flightNumber) {
		readFlight();
		for(int i=0; i<f.size(); i++) {
			if(f.get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
				Seat[] seats = f.get(i).getSeats();
				for(int j=0; j<seats.length; j++) {
					if(seats[j].getStatus() == false) {
						System.out.println(seats[j].getSeatNo());
					}
				}
			}
		}
		

	}
	
	public void searchFlight() {
		  readFlight();
	      
		  Scanner sc = new Scanner(System.in);
		  System.out.println("");
		  String b = sc.nextLine();
		  
		  int flag = 0;
		  
		  for(int i=0; i<f.size(); i++)
		  {
			  if(((f.get(i)).getFlightNumber().equalsIgnoreCase(b)))
			  {
				  flag = 1;
				  readseatDetails(b);
			  }
			  if(flag==1) {
				  break;
			  }
		  }
		  if(flag==0)
			  System.out.println("Flight Details Not Found!");
	}
	
	public void costCalculation(int index, String seatType) {
		
		readFlight();
	
		if(seatType.compareTo("Economy Class")==0)
	  {
		if(f.get(index).getflightDuration()<=3)
		{
			cost += 20000;
		}
		else if(f.get(index).getflightDuration()>3 && f.get(index).getflightDuration()<=7)
		{
			cost += 40000;
		}
		else
		{
			cost += 60000;
		}
	}
		else if(seatType.compareTo("Business Class")==0)
		{
			if(f.get(index).getflightDuration()<=3)
			{
				cost += 35000;
			}
			else if(f.get(index).getflightDuration()>3 && f.get(index).getflightDuration()<=7)
			{
				cost += 55000;
			}
			else
			{
				cost += 90000;
			}
			
		}
		else {
			
			if(f.get(index).getflightDuration()<=3)
			{
				cost += 40000;
			}
			else if(f.get(index).getflightDuration()>3 && f.get(index).getflightDuration()<=7)
			{
				cost += 80000;
			}
			else
			{
				cost += 120000;
			}
			
		}
		
	}
	
	public void buyTicket() {
		  readFlight();
	      
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Flight Number:");
		  String b = sc.nextLine();

		  int flag=0;
		  for(int i=0; i<f.size(); i++)
		  {
			  if((f.get(i)).getFlightNumber().equalsIgnoreCase(b)){
				  flag = 1;
				  readseatDetails(b);
				  System.out.println("Seat Number: ZS-");
				  int c = sc.nextInt();
				  if(f.get(i).getSeat(c).getStatus() == false) {
					  costCalculation(i, f.get(i).getSeat(c).getType());
					  f.get(i).getSeat(c).setStatus(true);
					  System.out.println("Purchased successfully! Total cost: "+cost);
				  }else {
					  System.out.println("Seat is booked");
				  }
			  }
			  if(flag==1) {
				  sc.close();
				  break;
			  }
		  }
			  
			  
		  }
	@Override
	ArrayList<FlightDetails> searchFlight(String a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "name= " + name + ", age= " + age + ", contact= " + contact + ", cost= " + cost;
	}
	
	
		  
}

