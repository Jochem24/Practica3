
public class Product {
	
	private String nameProduct;
	private double priceProduct;
	private int stockProduct;
	private int oldStock;
		
	public Product(String name, double price) {
		nameProduct=name;
		priceProduct=price;
		stockProduct=0;
		this.oldStock = 0;
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
	
	public int getOldStock() {
		return oldStock;
	}

	public void setOldStock(int oldStock) {
		this.oldStock = oldStock;
	}
		
	@Override
	public String toString() {
		return "Product [nameProduct=" + nameProduct + ", priceProduct=" + priceProduct + ", stockProduct=" + stockProduct + "]";
	}
		
	public Product copy() {
		Product same = new Product(nameProduct, priceProduct);
		return(same);
	}
		
}

