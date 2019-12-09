package Menus;

public class showMenus {

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
		System.out.println("\n\t1.   Add a new order");
		System.out.println("\t2.   Show the products which appear in any of the orders");
		System.out.println("\t3.   Compare amount of orders of 2 products");
		System.out.println("\t4.   Show all the orders in the system");
		System.out.println("\t5.   Return to the owner menu");
		System.out.print("\n\t\t\tChoose an option:\n");
		
	}
}
