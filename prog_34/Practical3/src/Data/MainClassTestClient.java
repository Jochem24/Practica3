package Data;
import Exceptions.*;

public class MainClassTestClient {

	public static void main(String[] args) {
		Client j = new Client(1,"abc@def.nl","Street 1");
		Client k = new Client(2,"ghi@jkl.nl","Street 2");
		Client l = new Client(3,"mno@pqr.nl","Street 3");
		
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		
		ListClient test = new ListClient();
		
		//Adding new clients to the list
		try {
		test.addClient(j);
		test.addClient(k);
		test.addClient(l);
		}
		catch(ClientListFullException e) {
			
		}
		catch(ClientAlreadyExistsException e) {
			
		}
	
		System.out.println(test); //Check if adding to list is properly working.
		
		test.deleteClient(j);
		test.deleteClient(k);
		
		System.out.println(test); //Check if deleting clients from list is working
		
		@SuppressWarnings("unused")
		int i;
		
		
		Software a = new Software("n", "Windows");
		Software b = new Software("c","Apple");
		Hardware c = new Hardware("last", HardwareType.CPU);
		Hardware d = new Hardware("nam", HardwareType.Peripheral);
		ListProducts llist = new ListProducts(100);
		
		a.setPriceProduct(10); a.setStockProduct(15);
		b.setPriceProduct(15); b.setStockProduct(20);
		c.setPriceProduct(20); c.setStockProduct(25);
		d.setPriceProduct(25); d.setStockProduct(30);
		
		/*
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		System.out.println(a.getNameProduct()); //checking if the product is created correctly
		
		*/
		
		
		llist.addProduct(a);			//testing method addProduct()
		llist.addProduct(b);			
		llist.addProduct(c);
		llist.addProduct(d);			//method add product works correctly
		
		Product[] LP = llist.SearchNameProduct("name"); //instance of a table of products
		Product[] LP2 = llist.ShowProductsInStock();
		
		
		
		//System.out.println(llist);		//testing if the objects are added correctly. Works correctly
		
		//llist.ShowListProducts();		//testing the method to show all the products in the list. Works correctly
		

		//========================================================
		ListProducts llist2 = new ListProducts(100); // create second list of products
		llist2.addProduct(a);		
		llist2.addProduct(b);			
		llist2.addProduct(d);
		
		ListProducts llist3 = new ListProducts(100); 
		llist3.addProduct(b);			
		llist3.addProduct(d);
	
		
		String date = "28-11-2019"; // create new orders
		Order test1 = new Order(j.getID(),date);
		Order test2 = new Order(k.getID(),date);

		ListProducts llistNew = llist.removeStock(llist2); //remove stock
		ListProducts llistNew2 = llistNew.removeStock(llist3);
		
		test1.setListProducts(llist2); //assign lists of products to the order
		test2.setListProducts(llist3);
		
		test1.setTotalPrice(test1.getListProducts().calculateTotalPrice());	//calculating the total price of the order and changing the value.
		test2.setTotalPrice(test2.getListProducts().calculateTotalPrice());
	
		ListOrders list = new ListOrders(20); // create new list of orders
		
		try {
		list.addOrder(test1); // add orders to the list of orders
		list.addOrder(test2);
		}
		catch(OrderListFullException e) {
			
		}
		 
		System.out.println(list.toString()); //
		
		System.out.println(llistNew2.toString());
		
		
		
}
	
}
