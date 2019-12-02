package Exceptions;

public class ClientAlreadyExistsException extends Exception {
	
	public ClientAlreadyExistsException() {
		super("The ID is already registred in the system.");
	}
}
