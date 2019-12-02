package Data;

public class ComputerConfiguration extends Product{


	private final int MAX_PRODUCTS = 50;
	private Product []computerConfiguration = new Product[MAX_PRODUCTS];
	

	public ComputerConfiguration(String name) {
		super(name);
		computerConfiguration[0] = new Hardware("CPU", 1, 0, HardwareType.CPU);
		computerConfiguration[1] = new Hardware("MB", 1, 0, HardwareType.MB);
		computerConfiguration[2] = new Hardware("HDD", 1, 0, HardwareType.HDD);
		computerConfiguration[3] = new Hardware("RAM", 1, 0, HardwareType.RAM);
		computerConfiguration[4] = new Hardware("GPU", 1, 0, HardwareType.GPU);
		computerConfiguration[5] = new Hardware("Box", 1, 0, HardwareType.Peripheral);
		computerConfiguration[6] = new Software("OS", 1, 0, " ");//We should ask in the main program the Operating system
		
	}
	
	public Product[] getComputerConfiguration() {
		return computerConfiguration;
	}

	public void setComputerConfiguration(Product[] computerConfiguration) {
		this.computerConfiguration = computerConfiguration;
	}	
	
	/**
	 * Aquest mètode s'utilitza per actualitzar la llista configuració als preus establerts previament
	 * @param ListProducts
	 */
	public void UpdateComputerConfiguration(Product []ListProducts) {
		setId(ListProducts.length);
		for(int i=0; i<computerConfiguration.length; i++) {
			for(int j=0; j<ListProducts.length; j++) {
				if(computerConfiguration[i].getNameProduct()==ListProducts[j].getNameProduct()) {
					computerConfiguration[i].setPriceProduct(ListProducts[j].getPriceProduct());

				}
			}
		}
	}
	
	public void AddProductIntoConfiguration(Product product, int units) {
		computerConfiguration[computerConfiguration.length + 1] = product;
		computerConfiguration[computerConfiguration.length].setStockProduct(units);
	}
	
	public void CalculateStock(Product []ListProducts) {
		int stock=0, stockA, stockB;
		for(int i=0; i<computerConfiguration.length; i++) {
			for(int j=0; j<ListProducts.length; j++) {
				if(computerConfiguration[i].getNameProduct()==ListProducts[j].getNameProduct()) {
					stockA = computerConfiguration[i].getStockProduct();
					stockB = ListProducts[j].getStockProduct();
					if((stockB/stockA) < stock)
						stock=stockB/stockA;
				}
			}
		}
		setStockProduct(stock);
	}
	
	public void CalculatePrice() {
		double price=0.0;
		
		for(int i = 0; i < computerConfiguration.length; i++) {
			price=+computerConfiguration[i].getPriceProduct();
		}
		setPriceProduct(price*0.9);
	}


	
}
