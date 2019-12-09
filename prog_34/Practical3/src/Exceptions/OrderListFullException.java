package Exceptions;

public class OrderListFullException extends Exception{
	
	public OrderListFullException() {
		super("The list of orders is full");
	}
		
}
