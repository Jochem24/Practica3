public class ListProducts {
	private int NumProducts;
	private Product[] list;
	
	
	public ListProducts (int size) {
		list = new Product[size];
		NumProducts = 0;
	}
	
	public int getNumProducts() {
		return NumProducts;
	}

	public void setNumProducts(int numProducts) {
		NumProducts = numProducts;
	}
	
	public Product[] getList() {
		return list;
	}

	public void setList(Product[] list) {
		this.list = list;
	}

	public String toString(){
		int i=0;
		String result = "";
		
		for(i=0;i<NumProducts;i++) {
			result = result + list[i].toString();
		}
		return result;
	}

	public boolean ExistsProduct(Product prod) {
		boolean found=false;
		int i=0;
		
		for(i=0;i<NumProducts && !found; i++) {
			if(list[i].equals(prod)) {
				found = true;
			}
		}
		return found;
		
	}
	
	public void addProduct(Product p) {
		boolean found = false;	
		for(int i=0;i<NumProducts && !found;i++) {
			if(list[i].equals(p)) {
			found = true;
			}
		}

		if(NumProducts<list.length && !found) {
			list[NumProducts] = p.copy();
			NumProducts++;
		}
	}
	
	public void ShowListProducts() {
		int i;
		for (i=0;i<NumProducts;i++) {
				System.out.println(list[i].toString());
		}
		
	}
	
	public Product SearchProduct(Product p) {
		int i=0;
		boolean found=false;
		Product x=null;
		
		for(i=0;i<NumProducts && !found;i++) {
			if(list[i].equals(p)) {
				x = list[i];
			}
		}
		if(!found) {
			System.out.println("This Exercise is not stored in our files!");
		}
		
		return x;
	}
	
	public Product SearchProduct(String p) {
		int i=0;
		boolean found=false;
		Product x=null;
		
		for(i=0;i<NumProducts && !found;i++) {
			if(list[i].getNameProduct().equals(p)) {
				x = list[i];
			}
		}
		if(!found) {
			System.out.println("This Exercise is not stored in our files!");
		}
		
		return x;
	}
	
	
	
	public Product[] SearchNameProduct(String s) {
		int i=0, j=0;
		Product[] prod= new Product[10];
		
		for(i=0;i<NumProducts;i++) {
				if (list[i].nameProduct==s) {
					prod[j]=list[i].copy();
					}	
			}
		return prod;
	}
	
	
	public Product[] ShowProductsInStock() {
		int i=0, j=0;
		Product[] prod = new Product[NumProducts];
		
		for (i=0;i<NumProducts;i++) {
			if ((list[i].stockProduct) >= 1) {
				prod[j] = list[i].copy();
				j++;
			}
		}
		
		return prod;
	}
//===========================================================================================
	private double totalPrice;
	
	/**
	 * 
	 */
	public double calculateTotalPrice() {
		for(int i=0;i<NumProducts && list[i]!=null;i++) {
			totalPrice += list[i].priceProduct;
		}
		return(totalPrice);
	}
	
	
	/**
	 * 
	 */
	
	public void removeStock() {
		int oldStock = 0;
		for(int i=0; i<NumProducts; i++) {
			oldStock = list[i].getStockProduct();
			list[i].setStockProduct(oldStock--);
		}
	}
	
	public void restoreStock() {
		int oldStock = 0;
		for(int i=0; i<NumProducts; i++) {
			oldStock = list[i].getStockProduct();
			list[i].setStockProduct(oldStock++);
		}
	}
	
	
	public int amountProductInList(Product product) {
		int counter = 0;
		for(int i=0; i<NumProducts; i++) {
			if(list[i].getIdentifier() == product.getIdentifier()) {
				counter++;
			}
		}
		return(counter);
	}
}

