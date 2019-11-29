
public class MainClassTestClient {

	public static void main(String[] args) {
		Client j = new Client(1,"abc@def.nl","Street 1");
		Client k = new Client(2,"ghi@jkl.nl","Street 2");
		Client l = new Client(3,"mno@pqr.nl","Street 3");
		
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		
		ListClient test = new ListClient(10);
		
		//Adding new clients to the list
		test.addClient(j);
		test.addClient(k);
		test.addClient(l);
		
	
		System.out.println(test); //Check if adding to list is properly working.
		
		test.deleteClient(j);
		test.deleteClient(k);
		
		System.out.println(test); //Check if deleting clients from list is working
		
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
		

		//========================================================
		ListProducts llist2 = new ListProducts(100); // create second list of products
		llist2.addProduct(a);		
		llist2.addProduct(b);			
		llist2.addProduct(d);
		
		String date = "28-11-2019"; // create new orders
		Order test1 = new Order(j.getID(),date);
		Order test2 = new Order(k.getID(),date);

		test1.setListProducts(llist);	//assign lists of products to the order
		test2.setListProducts(llist2);
		
		System.out.println(test1);	//test if adding list of products is succesfull
		System.out.println(test2);
		
		test1.setTotalPrice(test1.getListProducts().calculateTotalPrice());	//calculating the total price of the order and changing the value.
		test2.setTotalPrice(test2.getListProducts().calculateTotalPrice());
		
		test1.getListProducts().lowerStock();
		test2.getListProducts().lowerStock();
		
		ListOrders list = new ListOrders(20); // create new list of orders
		
		list.addOrder(test1); // add orders to the list of orders
		list.addOrder(test2);
		
		list.showListOrders(); // show the complete order
}
	
}
