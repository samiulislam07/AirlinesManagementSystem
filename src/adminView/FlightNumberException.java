package adminView;

public class FlightNumberException extends Exception{
	
	private String message;
	
	FlightNumberException(String message)
	{
		this.message = message;
	}
	
	public String toString() {
		return "Error: "+message;
	}
 
}
