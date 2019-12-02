package Exceptions;

public class ListClientFullException extends Exception {
	
	public ListClientFullException() {
		super("The client cannot be added to the list, because the list is full.");
	}
}
