
public class ComputerConfiguration extends Product{

	private String nameConfiguration;
	private Software operatingSystem;
	int stock;
	public Product []ListProducts = new Product[50];
	
	public ComputerConfiguration(String name, int stock, Software os) {
		nameConfiguration=name;
		this.stock=stock;
		operatingSystem=os;

	}
	
	private calculateStock() {
		
		
	}
	
	private void calculatePrice(ComputerConfiguration []p) {
		
		double price;
		
		for(int i = 0; i < p.length; i++) {
			
		}
	}
	
	
	
	

}
