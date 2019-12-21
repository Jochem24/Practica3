package Data;

public class ComputerConfiguration extends Product{

	public ComputerConfiguration(String name) {
		super(name);
		software = "";
		computerConfiguration[0] = new Hardware("CPU", HardwareType.CPU);
		computerConfiguration[0].setPriceProduct(0);
		computerConfiguration[0].setStockProduct(1);
		computerConfiguration[1] = new Hardware("MB", HardwareType.MB);
		computerConfiguration[1].setPriceProduct(0);
		computerConfiguration[1].setStockProduct(1);
		computerConfiguration[2] = new Hardware("HDD", HardwareType.HDD);
		computerConfiguration[2].setPriceProduct(0);
		computerConfiguration[2].setStockProduct(1);
		computerConfiguration[3] = new Hardware("RAM", HardwareType.RAM);
		computerConfiguration[3].setPriceProduct(0);
		computerConfiguration[3].setStockProduct(1);
		computerConfiguration[4] = new Hardware("GPU", HardwareType.GPU);
		computerConfiguration[4].setPriceProduct(0);
		computerConfiguration[4].setStockProduct(1);
		computerConfiguration[5] = new Hardware("Box", HardwareType.Peripheral);
		computerConfiguration[5].setPriceProduct(0);
		computerConfiguration[5].setStockProduct(1);

		
	}
	

	/**The following method checks if there are all minimum necessary products to create a computer configuration.
	 * Returns a boolean (false) in case there are not the necessary products.
	 * Minimum values: 
	 * Author: Daniel Arias Cámara
	 * @param ListProducts
	 * @return
	 */
	public boolean CheckComputerConfiguration(ListProducts products){
		boolean ok=false, cpu=false, mb=false, hdd=false, ram=false, gpu=false, peripheral=false;
		//CPU, MB, HDD, RAM, GPU, Peripheral
		Product []ListProducts = products.getList().clone();
		for(int i=0; i<products.getNumProducts(); i++) {
			if(ListProducts[i] instanceof Hardware) {
			Hardware a=(Hardware) ListProducts[i];
				if(a.getStockProduct()>0) {
					if((a.getType()==HardwareType.CPU)&&(a.getNameProduct().equals("CPU"))) {
						cpu=true;
					}
					if((a.getType()==HardwareType.MB)&&(a.getNameProduct().equals("MB"))) {
						mb=true;
					}
					if((a.getType()==HardwareType.HDD)&&(a.getNameProduct().equals("HDD"))) {
						hdd=true;
					}
					if((a.getType()==HardwareType.RAM)&&(a.getNameProduct().equals("RAM"))) {
						ram=true;
					}
					if((a.getType()==HardwareType.GPU)&&(a.getNameProduct().equals("GPU"))) {
						gpu=true;
					}
					if((a.getType()==HardwareType.Peripheral)&&(a.getNameProduct().equals("Box"))) {
						peripheral=true;
					}
					
				}
			}
			ok=(cpu | mb | hdd | ram | gpu | peripheral);
		}
		
		return ok;
			
	}
	
	
	/**The following method updates every individual product price.
	 * To be able to update the prices is necessary to check all products are available.
	 * Author: Daniel Arias Cámara
	 * @param ListProducts
	 */
	public void UpdateComputerConfiguration(ListProducts products) {
		Product []ListProducts = products.getList().clone();
		setIdentifier(products.getNumProducts());
		for(int i=0; i<numProducts; i++) {	
			for(int j=0; j<products.getNumProducts(); j++) {
				if(computerConfiguration[i]!=null) {
				if(computerConfiguration[i].getNameProduct().equals(ListProducts[j].getNameProduct())) {
					computerConfiguration[i].setPriceProduct(ListProducts[j].getPriceProduct());

					}
				}
			}
		}
	}
	
	
	/**The following method calculates the stock available to the current computer configuration.
	 * The stock depends on the general stock from the store.
	 * It is convenient to update the stock every time the general stock is modified.
	 * The stock is all minimum combination of every individual product.
	 * Author: Daniel Arias Cámara
	 * @param ListProducts
	 */
	public void CalculateStock(ListProducts products) {
		int stock, stockA, stockB;
		stock=10000;
		Product []ListProducts = products.getList().clone();
		for(int i=0; i<numProducts; i++) {
			for(int j=0; j<products.getNumProducts(); j++) {
				if(computerConfiguration[i].getNameProduct().equals(ListProducts[j].getNameProduct())) {
					stockA = computerConfiguration[i].getStockProduct();
					stockB = ListProducts[j].getStockProduct();
					if((stockB/stockA) < stock) {
						stock=stockB/stockA;
					}
				}
			}
		}
		this.setStockProduct(stock);
	}
	
	
	/**The following method calculates the final price of the Computer Configuration.
	 * The price consists in add all individual prices and rest -10%
	 * Author: Daniel Arias Cámara
	 */
	public void CalculatePrice() {
		double price=0.0;
		
		for(int i = 0; i < numProducts; i++) {
			price=price+computerConfiguration[i].getPriceProduct()*computerConfiguration[i].getStockProduct();
		}
		this.setPriceProduct(price*0.9);
	}
	
	/**The following method adds a Products inside a List of Products (from a ComputerConfiuration).
	 * This method checks if there is a product equal the one we want to add and overrides its stock.
	 * The stock of this product are the units chosen by the user.
	 * In case this is a new product, this method adds it in the end.
	 * Author: Daniel Arias Cámara
	 * @param ListProducts
	 * @param units
	 */
	public void AddProductIntoConfiguration(Product a, int units) {
		Product e;
		boolean found = false;
		for (int i=0; i<numProducts; i++ ) {
			e=computerConfiguration[i];
			if (e.getNameProduct().equals(a.getNameProduct())) {
				computerConfiguration[i].setStockProduct(units);
				found = true;
			}
		}
		if (!found) {
			computerConfiguration[numProducts]=a;
			computerConfiguration[numProducts].setStockProduct(units);
			numProducts++;
		}
		
	}

	//************************************ BASIC METHODS & VARIABLES ****************************************
	
	private final int MAX_PRODUCTS = 50;
	private Product []computerConfiguration = new Product[MAX_PRODUCTS];
	private String software;
	private int numProducts=6;
	
	public int getNumProducts() {
		return numProducts;
	}

	public void setNumProducts(int numProducts) {
		this.numProducts = numProducts;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public Product[] getComputerConfiguration() {
		return computerConfiguration;
	}

	public void setComputerConfiguration(Product[] computerConfiguration) {
		this.computerConfiguration = computerConfiguration;
	}	
	
	@Override
	public Product copy() {
		return null;
	}

	@Override
	public String toString() {
		return ("ComputerConfiguration: " + super.toString() + "\tOperatingSystem: " + software + "\n");
	}

}