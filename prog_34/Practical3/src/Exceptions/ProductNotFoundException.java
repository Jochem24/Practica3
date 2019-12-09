package Exceptions;

public class ProductNotFoundException extends Exception{

	public ProductNotFoundException () {
		super("The product is not found");
	}
		
}

