package Exceptions;

public class OrderIDNotFoundException extends Exception {
	
	public OrderIDNotFoundException(){
		super("The OrderID is not found");
	}

}
