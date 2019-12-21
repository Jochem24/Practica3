package Exceptions;

public class ProductAlreadyExistsException extends Exception{

	public ProductAlreadyExistsException () {
		super("The product already exists.");
	}
}
