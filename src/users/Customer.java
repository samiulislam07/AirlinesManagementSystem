package users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public Customer() {}
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
	
	public void costCalculation(int flightIndex, String seatType) {
		
		readFlight();
	
		if(seatType.compareTo("Economy Class")==0)
	  {
		if(f.get(flightIndex).getflightDuration()<=3)
		{
			cost += 20000;
		}
		else if(f.get(flightIndex).getflightDuration()>3 && f.get(flightIndex).getflightDuration()<=7)
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
			if(f.get(flightIndex).getflightDuration()<=3)
			{
				cost += 35000;
			}
			else if(f.get(flightIndex).getflightDuration()>3 && f.get(flightIndex).getflightDuration()<=7)
			{
				cost += 55000;
			}
			else
			{
				cost += 90000;
			}
			
		}
		else {
			
			if(f.get(flightIndex).getflightDuration()<=3)
			{
				cost += 40000;
			}
			else if(f.get(flightIndex).getflightDuration()>3 && f.get(flightIndex).getflightDuration()<=7)
			{
				cost += 80000;
			}
			else
			{
				cost += 120000;
			}
			
		}
		
		//updating SessionInfo file
		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
			outfile.writeObject(this);
		}catch(Exception e) {
			System.out.println("SessionInfo updation error: "+e);
		}
		
		// updating cost in the main file
		try(ObjectInputStream filein = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
			ArrayList<Customer> cust = (ArrayList<Customer>)filein.readObject();
			for(int i=0; i<cust.size(); i++) {
				if(cust.get(i).getUserName().equalsIgnoreCase(this.getUserName())) {
					cust.remove(i);
					cust.add(i, this);
				}
			}
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("CustomerCredentials.dat"))){
				outfile.writeObject(cust);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public String buyTicket(String flightNumber, int seatNumber) {
		  readFlight();

		  int flag=0;
		  for(int i=0; i<f.size(); i++){
			  if((f.get(i)).getFlightNumber().equalsIgnoreCase(flightNumber)){
				  flag = 1;
				  if(f.get(i).getSeat(seatNumber).getStatus() == false) {
					  costCalculation(i, f.get(i).getSeat(seatNumber).getType());
					  f.get(i).getSeat(seatNumber).setStatus(true);
					  writeFlight();
					  //System.out.println("Purchased successfully! Total cost: "+cost);
				  }else {
					  return "Selected seat is already booked";
					  //System.out.println("Seat is booked");
				  }
			  }
			  if(flag==1) {
				  break;
			  }
		  }
		  return "Successfully booked the seat";
			  
			  
		  }
	
	public void editCustomerInfo(String text) {
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
			ArrayList<Customer> cust = (ArrayList<Customer>)infile.readObject();
			
			for(int i=0; i<cust.size(); i++)
			{
				if(cust.get(i).getUserName().compareTo(getUserName())==0)
					cust.get(i).setContact(text);
			}
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
				outfile.writeObject(this);
			}catch(Exception e) {
				System.out.println("SessionInfo updation error: "+e);
			}
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("CustomerCredentials.dat"))){
				outfile.writeObject(cust);
			}
		}catch(ClassNotFoundException exc) {
			System.out.println("Class Not Found");
		}catch(IOException exc) {
			System.out.println("IOException "+exc);
		}
	}
	public void editCustomerInfo(int age) {
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
			ArrayList<Customer> cust = (ArrayList<Customer>)infile.readObject();
			
			for(int i=0; i<cust.size(); i++)
			{
				if(cust.get(i).getUserName().compareTo(getUserName())==0)
					cust.get(i).setAge(age);
			}
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
				outfile.writeObject(this);
			}catch(Exception e) {
				System.out.println("SessionInfo updation error: "+e);
			}
			try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("CustomerCredentials.dat"))){
				outfile.writeObject(cust);
			}
		}catch(ClassNotFoundException exc) {
			System.out.println("Class Not Found");
		}catch(IOException exc) {
			System.out.println("IOException "+exc);
		}
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
				  foundFlights.add(f.get(i));
			  }
		  }
		  return foundFlights;
	}
	
	@Override
	public String toString() {
		return "name= " + name + ", age= " + age + ", contact= " + contact + ", cost= " + cost;
	}
	
	
		  
}

