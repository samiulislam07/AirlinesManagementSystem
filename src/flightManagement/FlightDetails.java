package flightManagement;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
public class FlightDetails implements Serializable{

	protected String FlightNumber;
	private String Departure;
	private String Arrival;
	private Calendar DepartureDate = Calendar.getInstance();
	private Calendar ArrivalDate = Calendar.getInstance();
	private double flightduration;
	private Seat[] seats = new Seat[100];
	
	public FlightDetails() {
		for(int i=0; i<20; i++)
		{
			seats[i] = new Seat(i, "First Class");
		}
		for(int i=20; i<40; i++)
		{
			seats[i] = new Seat(i, "Economy Class");
		}
		for(int i=40; i<100; i++)
		{
			seats[i] = new Seat(i, "Business Class");
		}
	}
	
	
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
	public double getflightDuration() {
		return flightduration;
	}
	public Seat[] getSeats() {
		return seats;
	}
	public Seat getSeat(int seatNo) {
		return seats[seatNo];
	}


	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	


	public String toString(){
		
		return "FlightNumber: "+FlightNumber+" Departure: "+Departure+" Arrival:"+Arrival+" Departure Date:"+getDepartureDate()+" Arrival Date:"+getArrivalDate();
	}
}
	



