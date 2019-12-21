package Exceptions;

public class NotEnoughProductsComputerConfigurationException extends Exception  {

	public NotEnoughProductsComputerConfigurationException() {
		super("There are not enough products to create a computer configuration.");
	}
}
