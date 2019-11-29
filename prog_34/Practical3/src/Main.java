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
		System.out.println("\n\t1.   Show the products which appear in any order");
		System.out.println("\t2.   Compare amount of orders of 2 products");
		System.out.println("\t3.   Show all the orders in the system");
		System.out.println("\t4.   Return to the owner menu");
		System.out.print("\n\t\t\tChoose an option:\n");
		
	}
	
	//=========================================================================================================
	
	
	public static void manageDataAddProduct(ListProducts product) {
		
	}
	
	public static void manageDataDeleteProduct(ListProducts product) {
		
	}
	
	public static void manageDataAddComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowStock(ListProducts product) {
		
	}
	
	public static void manageDataChangeStock(ListProducts product) {
		
	}
	
	public static void manageDataShowProductsComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowCatalogue(ListProducts product) {
		
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
		System.out.println("\n\n\tClient succesfully added");
	}
	
	public static void manageDataDeleteClient(ListClient clientList) {
		int ID;
		System.out.println("n\n\tEnter the ID of the client you want to delete:\t");
		ID = keyboard.nextInt();
		Client c = clientList.searchClient(ID);
		clientList.deleteClient(c);
		
	}
		// still have to delete all the orders
	
	public static void manageDataShowAllClients(ListClient clientList) {
		
	}
	
	//=========================================================================================================
	public static void manageDataProductsOrder(ListOrders order) {
		
	}
	
	public static void manageDataCompareOrdersProducts(ListOrders order) {
		
	}
	
	public static void manageDataShowAllOrders(ListOrders order) {
		
	}
	
	//=========================================================================================================
	public static void menuOwner(int op, ListProducts product, ListClient client, ListOrders order) {
		showMenuOwner();
		op = Integer.parseInt(keyboard.nextLine());
		while (op!=4) {
			switch(op) {
			case 1: showMenuProducts(); 
					op = Integer.parseInt(keyboard.nextLine());
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
					op = Integer.parseInt(keyboard.nextLine());
					while(op!=4) {
						switch(op) {
						case 1: manageDataAddClient(client); break;
						case 2: manageDataDeleteClient(client); break;
						case 3: manageDataShowAllClients(client); break;
						}	
						break;
					}
					break;
			case 3: showMenuOrders();
					op = Integer.parseInt(keyboard.nextLine());
					while(op!=4) {
						switch(op) {
						case 1: manageDataProductsOrder(order); break;
						case 2: manageDataCompareOrdersProducts(order); break;
						case 3: manageDataShowAllOrders(order); break;
						}
						break;
					}
					break;
			}
		showMenuOwner();
		op = Integer.parseInt(keyboard.nextLine());
		}
	}
	
	public static void menuClient() {
		
	}
	//=========================================================================================================
	
	public static void main(String[] args) {
		
		ListProducts product = new ListProducts(20);
		ListClient client = new ListClient(20);
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
		op = Integer.parseInt(keyboard.nextLine());	
		}		
	}
}
