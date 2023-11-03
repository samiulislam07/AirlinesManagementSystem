package flightManagement;

import java.io.Serializable;

public class Ticket implements Serializable{
	private String passengerName;
	private String flightNumber;
	private String seatClass;
	private String seatNo;
	public Ticket(String passengerName, String flightNumber,String seatClass, String seatNo) {
		this.passengerName = passengerName;
		this.flightNumber = flightNumber;
		this.seatClass = seatClass;
		this.seatNo = seatNo;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return "passengerName: " + passengerName + ", flightNumber: " + flightNumber+", "+seatClass + ", seatNo=" + seatNo+"\n";
	}
	
}
