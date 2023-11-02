package users;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import customerView.CustomerDashboard;

public class PutInf {
	public static void main(String[] args) {
		ArrayList<Customer> customer = new ArrayList<>();
		customer.add(new Customer("Zuhayer Islam", 20, "01819515151", "zuhayer", "3200"));
		customer.add(new Customer("Samiul Islam", 20, "01745725482", "samiul", "3199"));
		customer.add(new Customer("Shefa Tabassum", 20, "01654517351", "shefa", "0580"));
		
		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("CustomerCredentials.dat"))){
			outfile.writeObject(customer);
			System.out.println("File written");
		}catch(IOException e) {
			System.out.println(e);
		}
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
			ArrayList<Customer> cust = (ArrayList<Customer>)infile.readObject();
			for(int i=0; i<cust.size(); i++) {
				System.out.println(cust.get(i).toString());
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
		System.out.println(e);
		}
		
		Scanner sc = new Scanner(System.in);
		String nameToCheck = sc.next();
		String passToCheck = sc.next();
		boolean loginSuccessful = false;
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
			ArrayList<Customer> arr = (ArrayList<Customer>)infile.readObject();
			for(int i=0; i<arr.size(); i++) {
		            if (nameToCheck.equalsIgnoreCase(arr.get(i).getUserName()) && passToCheck.equalsIgnoreCase(arr.get(i).getPassword())) {
		            	loginSuccessful = true;
	                    break;
		            }
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if (loginSuccessful) {
            System.out.println("Login successful");
        } else {
        	System.out.println("Login unsuccessful");
        }
	}
}


