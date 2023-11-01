package flightManagement;

public class Seat{
	private String passengerName;
	private int seatNo;
	private String type;
	private boolean status;
	
	public Seat(int seatNo, String type){
		this.seatNo = seatNo;
		this.type = type;
		this.status = false;
	}
	
	public Seat(String passengerName, int seatNo) {
		super();
		this.passengerName = passengerName;
		this.seatNo = seatNo;
		if(this.seatNo>=1 && this.seatNo<=20) this.type = "First Class";
		else if(this.seatNo>=21 && this.seatNo<=40) this.type = "Economy Class";
		else if(this.seatNo>=41 && this.seatNo<=100) this.type = "Business Class";
		status = true;
		
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
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
}
