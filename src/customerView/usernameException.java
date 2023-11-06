package customerView;

public class usernameException extends Exception{
	
	private String message;
	
	usernameException(String msg){
		this.message = msg;
	}
	
	public String toString() {
		return "Error: "+message;
	}

}
