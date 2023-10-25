package p1reqs;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
public class FlightDetails implements Serializable{

	private String FlightNumber;
	private String Departure;
	private String Arrival;
	private Calendar DepartureDate = Calendar.getInstance();
	private Calendar ArrivalDate = Calendar.getInstance();
	
	
	
	public void setFlightNumber(String FlightNumber)
	{
		this.FlightNumber = FlightNumber;
	}
	public void setDeparture(String Departure)
	{
		this.Departure = Departure;
	}
	
	public void setArrival(String Arrival)
	{
		this.Arrival = Arrival;
	}
	public void setDepartureDate(int month, int date, int hour, int minutes) {
		
		DepartureDate.set(2023,(month-1), date, hour, minutes,0);
		ArrivalDate.set(2023, month-1, date, hour, minutes, 0);
	}
    public void setArrivalDate(int hour, int minutes) {
		
    	ArrivalDate.add(Calendar.HOUR, hour);
		ArrivalDate.add(Calendar.MINUTE, minutes);
		
		
	}
    
	
	public Date getArrivalDate() {
		return ArrivalDate.getTime();
	}
	public String getFlightNumber() {
		return FlightNumber;
	}
	public String getDeparture() {
		return Departure;
	}
	public String getArrival() {
		return Arrival;
	}
	public Date getDepartureDate() {
		return DepartureDate.getTime();
	}
	
	
	
    
	
	public String toString(){
		
		return "FlightNumber: "+FlightNumber+" Departure: "+Departure+" Arrival:"+Arrival+" Departure Date:"+getDepartureDate()+" Arrival Date:"+getArrivalDate();
	}
}
	



