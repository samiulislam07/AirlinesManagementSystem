package flightManagement;

import java.io.Serializable;

public class Seat implements Serializable{
	private int seatNo;
	private String type;
	private boolean status;
	
	public Seat(int seatNo, String type){
		this.seatNo = seatNo;
		this.type = type;
		this.status = false;
	}
	
	public Seat(String passengerName, int seatNo) {
		this.seatNo = seatNo;
		if(this.seatNo>=0 && this.seatNo<20) this.type = "First Class";
		else if(this.seatNo>=20 && this.seatNo<40) this.type = "Business Class";
		else if(this.seatNo>=41 && this.seatNo<100) this.type = "Economy Class";
		status = true;
		
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seat No: ZS" + seatNo + ", Type: " + type+"\n";
	}
	
	
}
