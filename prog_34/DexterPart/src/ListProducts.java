
public class ListProducts {
	private int NumProducts;
	private Product[] list;
	private int identifier;
	
	
	public ListProducts (int NumProducts, int identifier) {
		list = new Product[NumProducts];
		this.identifier = identifier;
	}
	
	
	
	
	/**
	 * @return the numProducts
	 */
	public int getNumProducts() {
		return NumProducts;
	}




	/**
	 * @param numProducts the numProducts to set
	 */
	public void setNumProducts(int numProducts) {
		NumProducts = numProducts;
	}




	/**
	 * @return the list
	 */
	public Product[] getList() {
		return list;
	}




	/**
	 * @param list the list to set
	 */
	public void setList(Product[] list) {
		this.list = list;
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


	public String toString(){
		int i=0;
		String result=null;
		
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
		return true;
		
	}
	
	
	public void addProduct(Product p) {
		
		if(NumProducts<list.length) {
			if(!ExistsProduct(p)) {
				int pos=NumProducts -1;
				list[pos+1]=p.copy();
				NumProducts++;
			}
		}
	}
	
	
	@SuppressWarnings("null")
	public Product[] ShowListProducts() {
		Product list1[] = null;
		int i = 0;
		
		for (i=0;i<NumProducts;i++) {
			list1[i]=list[i].copy();
		}
		
		return list1;
		
	}
	
	
	public Product SearchProduct(Product p) {
		boolean found = false;
		int i =0;
		Product prod = null;
		
		for(i=0; i< NumProducts && !found; i++) {
			if (list[i].equals(p)) {
				prod = p;
			}
			
		}
		
		return prod;
	}
	
	@SuppressWarnings("null")
	public Product[] SearchNameProduct(String name) {
		Product[] prod = null;
		int i=0;
		boolean found =list[i].getNameProduct().equals(name);
		
		for(i=0; i<NumProducts;i++) {
			if(found) {
				prod[i] = list[i].copy();
			}
		}
		return prod;
	}
	
	
	@SuppressWarnings("null")
	public Product[] ShowProductsInStock() {
		int i=0;
		Product[] prod = null;
		boolean available = list[i].getStockProduct()>=1;
		
		for (i=0;i<NumProducts;i++) {
			if(available) {
				prod[i]=list[i].copy();
			}
		}
		
		return prod;
	}
	
	
}
