package users;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import flightManagement.FlightDetails;
import pilotManagement.AssignedPilot;

public abstract class User {

	private String userName;
	private String password;
	ArrayList<FlightDetails> f = new ArrayList<>();
	ArrayList<AssignedPilot> ap = new ArrayList<>();
	
	User(){}
	User(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void readFlight() {
		  try(ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream("FDetails.dat")))
			{
			     f = (ArrayList<FlightDetails>) ob1.readObject();
			   
			}catch(Exception e) {
				System.out.println("IO error"+e);
			}
	}
	
	public void writeFlight() {
		try(ObjectOutputStream ob1 = new ObjectOutputStream(new FileOutputStream("FDetails.dat")))
		{
			ob1.writeObject(f);
		}catch(Exception e) {
			System.out.println("Error!");
		}
		try(ObjectOutputStream ob1 = new ObjectOutputStream(new FileOutputStream("FlightAssgDetails.dat")))
		{
			ob1.writeObject(ap);
		}catch(Exception e) {
			System.out.println("Error!");
		}
	}
	
	public ArrayList<FlightDetails> viewFlight(){
		readFlight();
		return f;	
	}
	abstract ArrayList<FlightDetails> searchFlight(String a);
}
