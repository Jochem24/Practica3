package Exceptions;

public class ClientNotFoundException extends Exception {

	public ClientNotFoundException() {
		super("The client is not found in the system.");
	}
}
