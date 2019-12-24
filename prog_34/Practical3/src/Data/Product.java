package Data;

import java.io.*;

public abstract class Product implements Serializable{

	static final long serialVersionIUD = 1;
	
	protected String nameProduct;
	protected double priceProduct;
	protected int stockProduct;
	protected int identifier;
	
	public Product(String name) {
		nameProduct = name;
		priceProduct = 0;
		stockProduct = 0;
		identifier = 0;
	}


	

	/**
	 * @return the identifier
	 */
	public int getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public int getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(int stockProduct) {
		this.stockProduct = stockProduct;
	}
	
	
		
	@Override
	public String toString() {

		return "Identifier: " + identifier +"\tName: " + nameProduct + "\tPrice: " + priceProduct + "\tStock: "
				+ stockProduct;

	}

	
	public abstract Product copy();


		
	
		
}
