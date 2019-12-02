import java.util.Scanner;

public class Main{
	
	static Scanner keyboard=new Scanner(System.in);

	
	public static void showMenuStart() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1.   Owner");
		System.out.println("\t2.   Client");
		System.out.println("\t3.   Close the system");
		System.out.print("\n\tChoose an option:\n");
	}
	
	public static void showMenuOwner() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1.   Manage products");
		System.out.println("\t2.   Manage clients");
		System.out.println("\t3.   Manage orders");
		System.out.println("\t4.   Return to the start screen");
		System.out.print("\n\tChoose an option:\n");
	}
	
	public static void showMenuProducts() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1.   Add a new product");
		System.out.println("\t2.   Delete a product");
		System.out.println("\t3.   Add a new computer pack");
		System.out.println("\t4.   Show available stock");
		System.out.println("\t5.   Change available stock of a product");
		System.out.println("\t6.   Show all products which are part of any computer packs");
		System.out.println("\t7.   Show the product catalogue");
		System.out.println("\t8.   Return to the owner menu");
		System.out.print("\n\tChoose an option:\n");
	}
	
	public static void showMenuClients() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1.   Add a client");
		System.out.println("\t2.   Remove a client");
		System.out.println("\t3.   Show all the clients in the system");
		System.out.println("\t4.   Return to the owner menu");
		System.out.print("\n\t\t\tChoose an option:\n");
	}

	public static void showMenuOrders() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1.   Show the products which appear in any of the orders");
		System.out.println("\t2.   Compare amount of orders of 2 products");
		System.out.println("\t3.   Show all the orders in the system");
		System.out.println("\t4.   Return to the owner menu");
		System.out.print("\n\t\t\tChoose an option:\n");
		
	}
	
	//=========================================================================================================
	
	
	public static void manageDataAddProduct(ListProducts product) {
		System.out.println("Choose between Software (1) or Hardware (2): ");
			int number = keyboard.nextInt();
				switch (number) {
				case 1:
					System.out.println("Please write the name of this software: ");
					String name = keyboard.next();
					
					System.out.println("What type of Operating System does it have? ");
					String OS = keyboard.next();
					
					Software prod = new Software(name, OS);
					product.addProduct(prod);
					
					Product x=product.SearchPosProduct(name);
					
					System.out.println("Please write its price: ");
					double Price = keyboard.nextDouble();
					x.setPriceProduct(Price);
					
					System.out.println("How many units do you want to add? ");
					int units = keyboard.nextInt();
					x.setStockProduct(units);
					
					break;
					
				case 2:
					System.out.println("Please write the name of this hardware: ");
					String n = keyboard.next();
					
					System.out.println("Which type of hardware would you like? You can choose between: ");
					System.out.println("CPU, MB, HDD, RAM, GPU, Peripheral ");
					String T = keyboard.next();					
					HardwareType TP = HardwareType.valueOf(T);
					
					Hardware p = new Hardware(n,TP);
					product.addProduct(p);
					
					System.out.println("Please write its price: ");
					double P = keyboard.nextDouble();
					p.setPriceProduct(P);
					System.out.println("How many units do you want to add? ");
					int un = keyboard.nextInt();
					p.setStockProduct(un);
					
					break;		
			}
		
		
	}
	
public static void manageDataDeleteProduct(ListProducts product) {
		
		product.ShowListProducts();
		System.out.println("Please write the identifier of the product you want to delete: ");
		int id = keyboard.nextInt();
		
		product.DeleteProduct(id);
		System.out.println("The product "+id+" has been deleted");
	}
	
	public static void manageDataAddComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowStock(ListProducts product) {
		product.ShowStockProducts();
	}
	
	public static void manageDataChangeStock(ListProducts product) {
		
	}
	
	public static void manageDataShowProductsComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowCatalogue(ListProducts product) {
		product.ShowListProducts();
	}
	
	
	
	//=========================================================================================================
	
	public static void manageDataAddClient(ListClient clientList) {
		int ID; String email, postalAddress;
		System.out.println("\n\n\tEnter the ID of the client:\t");
		ID = keyboard.nextInt();
		System.out.println("\n\n\tEnter the email address of the client:\t");
		email = keyboard.nextLine();
		System.out.println("\n\n\tEnter the postal address of the client:\t");
		postalAddress = keyboard.nextLine();
		Client c = new Client(ID, email, postalAddress);
		clientList.addClient(c);
		System.out.println("\n\n\tClient successfully added");
	}
	
	public static void manageDataDeleteClient(ListClient client, ListOrders order) {
		int ID;
		System.out.println("n\n\tEnter the ID of the client you want to delete:\t");
		ID = keyboard.nextInt();
		Client c = client.searchClient(ID); //Find the object of the client based on the clientID of the person.
		client.deleteClient(c); //Delete the client from the list of Clients.
		order.searchOrders(ID).deleteOrder(ID); //Delete all the orders the client has made and restore the stock of the products.
		
	}

	public static void manageDataShowAllClients(ListClient client) {
		for(int i=0;i<client.getNumOfClients();i++) {	
			System.out.println(client.copy(i)); //Print all the data of client list.
			}
		}
	
	//=========================================================================================================
	public static void manageDataProductsOrder(ListOrders order, ListProducts product, ListClient client) {
	order.productsInOrder(product, client);	
	}
	
	public static void manageDataCompareOrdersProducts(ListOrders order, ListProducts product) {
	System.out.println("n\n\tEnter the name of the first product:\t");
	String product1 = keyboard.nextLine();
	System.out.println("n\n\tEnter the name of the second product:\t");
	String product2 = keyboard.nextLine();
	
	Product x = product.SearchProduct(product1); //Find the objects of the 2 different products in the list which contains all products.
	Product y = product.SearchProduct(product2);
	
	System.out.println(order.amountProductInOrderList(x,y)); //Return the product which has more orders and show the amount.
	}
	
	public static void manageDataShowAllOrders(ListOrders order) {
		for(int i=0;i<order.getNumOfOrders();i++) {	
			System.out.println(order.copy(i));
		}
	}
	
	
	//=========================================================================================================
	public static void menuOwner(int op, ListProducts product, ListClient client, ListOrders order) {
		showMenuOwner();
		op = keyboard.nextInt();
		while (op!=4) {
			switch(op) {
			case 1: showMenuProducts(); 
					op = keyboard.nextInt();
					while(op!=8) {
						switch(op) {
						case 1: manageDataAddProduct(product); break;
						case 2: manageDataDeleteProduct(product); break;
						case 3: manageDataAddComputerPack(product); break;
						case 4: manageDataShowStock(product); break;
						case 5: manageDataChangeStock(product); break;
						case 6: manageDataShowProductsComputerPack(product); break;
						case 7: manageDataShowCatalogue(product); break;
						}
						break;
					}
					break;
			
			case 2: showMenuClients(); 
					op = keyboard.nextInt();
					while(op!=4) {
						switch(op) {
						case 1: manageDataAddClient(client); break;
						case 2: manageDataDeleteClient(client, order); break;
						case 3: manageDataShowAllClients(client); break;
						}	
						break;
					}
					break;
			case 3: showMenuOrders();
					op = keyboard.nextInt();
					while(op!=4) {
						switch(op) {
						case 1: manageDataProductsOrder(order, product, client); break;
						case 2: manageDataCompareOrdersProducts(order, product); break;
						case 3: manageDataShowAllOrders(order); break;
						}
						break;
					}
					break;
			}
		showMenuOwner();
		op = keyboard.nextInt();
		}
	}
	
	public static void menuClient() {
		System.out.println("It works!");
	}
	//=========================================================================================================
	
	public static void main(String[] args) {
		
		ListProducts product = new ListProducts(20);
		ListClient client = new ListClient();
		ListOrders order = new ListOrders(20);
		
		int op;
		
		showMenuStart();
		op = Integer.parseInt(keyboard.nextLine());
		while(op!=3) {
			switch(op) {
			case 1: menuOwner(op, product, client, order); break;		
			case 2: menuClient(); break;
			}
		showMenuStart();
		op = keyboard.nextInt();	
		}		
	}
}



