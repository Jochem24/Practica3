package Exceptions;

public class ClientListFullException extends Exception {
	
	public ClientListFullException() {
		super("The client cannot be added to the list, because the list is full.");
	}
}
