public class TestSoftwareAndHardware {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				
				@SuppressWarnings("unused")
				int i;
				
				
				Software a = new Software("n", 35.00, 5, "Windows");
				Software b = new Software("c", 10.00, 10, "Apple");
				Hardware c = new Hardware("last", 15.00, 3, HardwareType.CPU);
				Hardware d = new Hardware("nam", 20.00, 70, HardwareType.Peripheral);
				ListProducts llist = new ListProducts(100);
				
				
				
				System.out.println(a.toString());
				System.out.println(b.toString());
				System.out.println(c.toString());
				System.out.println(d.toString());
				
				System.out.println(a.getNameProduct()); //checking if the product is created correctly
				
				
				
				
				llist.addProduct(a);			//testing method addProduct()
				llist.addProduct(b);			
				llist.addProduct(c);
				llist.addProduct(d);			//method add product works correctly
				
				Product[] LP = llist.SearchNameProduct("name"); //instance of a table of products
				Product[] LP2 = llist.ShowProductsInStock();
				
				
				
				System.out.println(llist);		//testing if the objects are added correctly. Works correctly
				
				llist.ShowListProducts();		//testing the method to show all the products in the list. Works correctly
				
				
				
				
				for (i=0;i<llist.getNumProducts();i++) {   				//method to search and return the list of product given its name works correctly
					if(LP[i]!=null) {
					System.out.println(LP[i]);
				}
				}
				
				for(i=0;i<llist.getNumProducts();i++) {					//method to search for the products in stock works correctly
					if(LP2[i]!=null) {
						System.out.println(LP2[i]);
					}
				}
				
				
				
				
	}

}
