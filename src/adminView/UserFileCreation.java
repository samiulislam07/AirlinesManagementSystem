package adminView;
import java.io.*;
import java.util.ArrayList;

public class UserFileCreation {

	public static void main(String[] args) {
		ArrayList<AdminCredentials> arr = new ArrayList<>();
		arr.add(new AdminCredentials("Samin", "3199"));
		arr.add(new AdminCredentials("Zuhayer", "3200"));
		
		try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("AdminCredentials.dat"))){
			outfile.writeObject(arr);
			System.out.println("File written");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

