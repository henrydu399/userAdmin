package usermanager.exceptions;

import usermanager.enums.ErrorEnum;

public class UserManagerExceptions extends Exception{
	
	private ErrorEnum error;

	private String message;
	
	public UserManagerExceptions(ErrorEnum error) {
		super();
		this.error = error;
		this.message = error.toString();
	}
	
	public  UserManagerExceptions(ErrorEnum error, String message) {
		super();
		this.error = error;
		
		if(message== null || message.isEmpty() || message.equals("null")) {
			this.message = error.toString();
		}else {
			this.message = message;
		}
			
	}

}
