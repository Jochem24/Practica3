package Data;
import java.io.*;

import Exceptions.*;

public class ListProducts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			result = result + list[i].toString() +"\n";
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
	
	public boolean addProduct(Product p) {
		boolean found = false;	
		int i,j=0;
		for(i=0;i<NumProducts && !found;i++) {
			if(list[i].nameProduct.equals(p.nameProduct)) {
				found = true;
			}
		}

		if(NumProducts<list.length && !found) {
			list[NumProducts] = p;
			j=NumProducts+1;
			list[NumProducts].setIdentifier(j);
			NumProducts++;
		}
		return found;
	}
	
	public void addProductOrder(Product p) throws ProductListFullException {
		if(NumProducts<list.length) {
			list[NumProducts] = p;
			NumProducts++;
		}
		else throw new ProductListFullException();
	}
	
	public boolean DeleteProduct(int id) {
		boolean succesfull=false;
	
			if(list[id-1]!=null) {
				list[id-1]=null;
				succesfull = true;
				}
			
		return succesfull;		
	}
			
		
	
	public void ShowListProducts() {
		int i;
		for (i=0;i<NumProducts;i++) {
			if(list[i]!=null) {
				System.out.println(list[i].toString());
			}
		}
		
	}
	
	/**The following method shows all Hardware Type by Display from a List
	 * Author: Daniel Arias Cámara
	 * @param List
	 */
	public void ShowProductsHardware () {
		
		for(int i=0; i<list.length; i++) {
			if(list[i] instanceof Hardware) {
				System.out.println(list[i].toString());
			}
		}
	}
	
	
	/**The following method shows all Software Type by Display from a List
	 * Author: Daniel Arias Cámara
	 * @param List
	 */
	public void ShowProductsSoftware () {
		
		for(int i=0; i<list.length; i++) {
			if(list[i] instanceof Software) {
				System.out.println(list[i].toString());
			}
		}
	}
	
	
	/**The following method shows all Computer Configuration Type by Display from a List
	 * Author: Daniel Arias Cámara
	 * @param List
	 */
	public void ShowProductsComputerConfiguration () {
		
		for(int i=0; i<list.length; i++) {
			if(list[i] instanceof ComputerConfiguration) {
				System.out.println(list[i].toString());
			}
		}
	}
	
	/**The following method shows all the Products inside a Computer Configuration by Display
	 * Author: Daniel Arias Cámara
	 * @param configuration
	 */
	public void ShowProductsIntoComputerConfiguration(ComputerConfiguration configuration) {
		Product []ListProducts = configuration.getComputerConfiguration();
		for(int i=0; i<configuration.getNumProducts(); i++) {
				System.out.println(ListProducts[i].toString());
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
	
	public Product SearchProduct(String p) throws ProductNotFoundException {
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
	
	public Product SearchPosProduct(String p) throws ProductNotFoundException{
		int i=0;
		boolean found=false;
		Product x=null;
		
		for(i=0;i<NumProducts && !found;i++) {
			if(list[i].getNameProduct().equals(p)) {
				x = list[i];
			}
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
	
	public boolean EqualNameProducts (String a) {
		boolean equal = false;
		int i=0;
	
		while(i<NumProducts && !equal) {
			//The strings are equal when .compareTo("String") == 0
			if(list[i].getNameProduct().compareTo(a)==0) {
				equal = true;
			}
			i++;
		}
		
		return equal;
	}
	
	public boolean ProductIdentifierExists(int id) {
		boolean found=true;
		
		try {
			if(list[id-1]==null) {
				found = false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
		//	System.out.println("Error "+e);
		//	System.out.println("This identifier is out of the bounds in our list");
			found = false;
		}
		return found;
	}
	
	public void ShowStockProducts() {
		int i;
		
		for(i=0;i<NumProducts;i++) {
			if(list[i]!=null) {
			System.out.println("Product "+ list[i].nameProduct+" has "+list[i].stockProduct+" units");
		}
		}
	}
	
	
	public void ChangeStockProduct(int id, int numChange) {
		list[id-1].stockProduct = list[id-1].stockProduct + numChange; 
		if(list[id-1].stockProduct<0) {
			list[id-1].stockProduct=0;
		}
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
	
	
	public int SearchPositionProduct(Product product) {
		boolean found=false;
		int position=0;
		
		for(int i=0;i<NumProducts && !found;i++) {
		position++;	
			if(list[i] == product) {
			found = true;
			}
		}
		return (position);
	}
	
	
	public void removeStock(Product product) {
		int position; int newStock;
			position = SearchPositionProduct(product);
			newStock = list[position].getStockProduct()-1;
			list[position].setStockProduct(newStock);
	}
	
	
	public void restoreStock(ListProducts shoppingList) {
		int newStock;
		for(int i=0; i<NumProducts; i++) {
			
			newStock = list[i].getStockProduct()+1;
			list[i].setStockProduct(newStock);
			
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
