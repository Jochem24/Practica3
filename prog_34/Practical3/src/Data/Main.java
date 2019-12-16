package Data;

import java.io.*;
import java.util.Scanner;
import java.util.*;

import Exceptions.*;
import FileManagement.*;
import Menus.*;

public class Main{
	
	static Scanner keyboard=new Scanner(System.in);

	
	//=========================================================================================================
	
	public static void manageDataAddProduct(ListProducts product) {
		int number = 0;
		boolean correct = false;
		Product x=null;
		
		while(!correct) {
			try {
				System.out.println("Choose between Software (1) or Hardware (2): ");
				number = keyboard.nextInt();
				correct = true;
			}catch(InputMismatchException e){
				System.out.println("Error "+e);
				System.out.println("The input should be an integer");
				keyboard.nextLine();
			}
			
		}	
				switch (number) {
				case 1:
					System.out.println("Please write the name of this software: ");
					String name = keyboard.next();
					
					System.out.println("What type of Operating System does it have? ");
					String OS = keyboard.next();
					
					Software prod = new Software(name, OS);
					
					if(product.addProduct(prod)==false) {
					correct = false;
					try {
						x=product.SearchPosProduct(name);
					}catch(ProductNotFoundException e) {
						System.out.println(e.toString());
					}
					
					while(!correct){
						try {
							System.out.println("Please write its price: ");
							double Price = keyboard.nextDouble();
							x.setPriceProduct(Price);
							correct = true;
						}catch(InputMismatchException e) {
							System.out.println("Error "+e);
							System.out.println("The input should be a double");
							keyboard.nextLine();
						}
					}
					
					correct = false;
					
					while(!correct) {
						try {
							System.out.println("How many units do you want to add? ");
							int units = keyboard.nextInt();
							x.setStockProduct(units);
							correct = true;
						}catch(InputMismatchException e) {
							System.out.println("Error "+e);
							System.out.println("The input should be an integer");
							keyboard.nextLine();
						}
					}					
					}else {
						correct = false;
						try {
							x=product.SearchPosProduct(name);
						}
						catch(ProductNotFoundException e) {
							System.out.println(e.toString());
						}
						while(!correct) {
							try {
								System.out.println("How many units do you want to add? ");
								int units = keyboard.nextInt();
								x.setStockProduct(x.stockProduct + units);
								correct = true;
							}catch(InputMismatchException e) {
								System.out.println("Error "+e);
								System.out.println("The input should be an integer");
								keyboard.nextLine();
							}
						}	
					}
						break;
					
				case 2:
					System.out.println("Please write the name of this hardware: ");
					String n = keyboard.next();
					HardwareType TP = null;
					String T;
					correct = false;
					while(!correct) {
						try {
							System.out.println("Which type of hardware would you like? You can choose between: ");
							System.out.println("CPU, MB, HDD, RAM, GPU, Peripheral ");
							T = keyboard.next();	
							TP = HardwareType.valueOf(T);
							correct = true;
						}catch(IllegalArgumentException e) {
							System.out.println("Error "+e);
							keyboard.nextLine();
						}
					}
					
					Hardware p = new Hardware(n,TP);
					product.addProduct(p);
					
					
					correct = false;
					
					while(!correct) {
						try {
							System.out.println("Please write its price: ");
							double P = keyboard.nextDouble();
							p.setPriceProduct(P);
							correct = true;
						}catch(InputMismatchException e) {
							System.out.println("Error "+e);
							System.out.println("The input should be a double");
							keyboard.nextLine();
						}
					}
					
					correct = false;
					
					while(!correct) {
						try {
							System.out.println("How many units do you want to add? ");
							int un = keyboard.nextInt();
							p.setStockProduct(un);
							correct = true;
						}catch(InputMismatchException e) {
							System.out.println("Error "+e);
							System.out.println("The input should be an integer");
							keyboard.nextLine();
						}
					}
					break;		
			}
	}
	
	public static void manageDataDeleteProduct(ListProducts product) {
		boolean correct = false;
		product.ShowListProducts();
		int id = 0;
		while(!correct) {
			try {
				System.out.println("Please write the identifier of the product you want to delete: ");
				id = keyboard.nextInt();
				correct = true;
			}catch(InputMismatchException e) {
				System.out.println("Error "+e);
				System.out.println("The input should be an integer");
				keyboard.nextLine();
			}
			if(product.ProductIdentifierExists(id)==false) {
				correct=false;
				keyboard.nextLine();
			}
		}
		
		
		if(product.DeleteProduct(id) == true) {
			System.out.println("The product "+id+" has been deleted");
			System.out.println("This is our new list of poducts:");
			product.ShowListProducts();
		}else {
			System.out.println("Product with identifier "+id+" doesn't exist in our files. It can't be deleted :(");
		}
		
	}
	
	public static void manageDataAddComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowStock(ListProducts product) {
		product.ShowStockProducts();
	}
	
	public static void manageDataChangeStock(ListProducts product) {
		boolean correct = false;
		int id = 0;
		product.ShowListProducts();
		
		while(!correct) {
			try {
				System.out.println("Please introduce the identifier of the product you want to edit");
				id = keyboard.nextInt();
				correct = true;
			}catch(InputMismatchException e) {
				System.out.println("Error "+e);
				System.out.println("The input should be an integer ");
				keyboard.nextLine();
			}
			
			if(product.ProductIdentifierExists(id)==false) {
				correct = false;
				keyboard.nextLine();
			}
		}
		
		correct=false;
		int change = 0;
		while(!correct) {
			try {
				System.out.println("Introduce the number you want to add/substract of stock");
				change = keyboard.nextInt();
				correct=true;
			}catch(InputMismatchException e) {
				System.out.println("Error "+e);
				System.out.println("The input should be an integer ");
				keyboard.nextLine();
			}
		}
		product.ChangeStockProduct(id, change);
		
		product.ShowStockProducts();
		
	}
	
	public static void manageDataShowProductsComputerPack(ListProducts product) {
		
	}
	
	public static void manageDataShowCatalogue(ListProducts product) {
		product.ShowListProducts();
	}
	
	//=========================================================================================================
	
	public static void manageDataAddClient(ListClient clientList, ListOrders order, ListProducts product){
		int ID=0; String email, postalAddress;
		boolean error = false;
		
		while(!error) {
		System.out.println("\n\n\tEnter the ID of the client:\t");
		try{
			ID = keyboard.nextInt();
			error = true;
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("\n\n\tPlease enter an integer"); 
			keyboard.next();
		}
		}
		
		System.out.println("\n\n\tEnter the email address of the client:\t");
		email = keyboard.next();
		System.out.println("\n\n\tEnter the postal address of the client:\t");
		postalAddress = keyboard.next();
		Client c = new Client(ID, email, postalAddress);
		
		try {
		clientList.addClient(c);
		System.out.println("\n\n\tClient successfully added");
		}
		catch(ClientListFullException e){
			System.out.println(e.toString());
		}
		catch(ClientAlreadyExistsException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public static void manageDataDeleteClient(ListClient client, ListOrders order, ListProducts product) {
		int clientID=0;
		boolean error = false;
		
		while(!error) {
		System.out.println("\n\n\tEnter the ID of the client you want to delete:\t");
		try{
			clientID = keyboard.nextInt();
			error = true;
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("\n\n\tPlease enter an integer"); 
			keyboard.next();
		}
		}
		
		ListOrders allOrdersClient = null;
		
		//Find all the orders of the client. Delete the existing orders.
		try {
			allOrdersClient = order.searchOrders(clientID);
			order.deleteAllOrders(clientID);
		}
		catch(OrderListFullException e){
			e.toString();
		}
		
		//Return new catalog with updated stock.
		for(int i=0; i<allOrdersClient.getNumOfOrders(); i++) {
			product.restoreStock(allOrdersClient.getListOrders()[i].getListProducts());
		}
	
		client.deleteClient(clientID); //Delete the client from the list of Clients.
		
	}

	public static void manageDataShowAllClients(ListClient client) {
		for(int i=0;i<client.getNumOfClients();i++) {	
			System.out.println(client.copy(i)); //Print all the data of client list.
			}
		}
	
	//=========================================================================================================
	//Create a new order.
	public static void manageDataAddOrder(ListOrders listOrders, ListClient client, ListProducts product) {
		int clientID = 0; int num = 0; Product x = null;
		boolean error = false;
		
		System.out.println("\n\n\tEnter the clientID:\t");
		while(!error) {
		try{
			clientID = keyboard.nextInt();
			error = true;
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("\n\n\tPlease enter an integer");
			keyboard.next();
		}
		}
		
		System.out.println("\n\n\tEnter the date:\t");
		
		String date = keyboard.next();
		
		Order order = new Order(clientID, date);
		ListProducts shoppingList = new ListProducts(20);
		
		System.out.println("\n\n Options:");
		System.out.println("\t1.Add a product to the shoppinglist\t");
		System.out.println("\t2.Complete the shoppinglist\t");
		
		error = false;
		while(!error) {
		try{
			num = keyboard.nextInt();
			error = true;
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("\n\n\tPlease enter 1 or 2");
			keyboard.next();
		}
		}
	
		
		while(num!=2) {
			error = false;
			while(!error) {
			try {
				manageDataShowCatalogue(product);
				System.out.println("\n\n\tEnter the name of the product:\t");	
				String nameProduct = keyboard.next();
				x = product.SearchPosProduct(nameProduct);
				error= true;
			}
			catch(ProductNotFoundException e) {
				System.out.println(e.toString());
				keyboard.nextLine();
			}
			}
			
			product.removeStock(x);
			try {
			shoppingList.addProductOrder(x);
			}
			catch(ProductListFullException e) {
			}
			
			System.out.println("\n\n Options:");
			System.out.println("\t1.Add a product to the shoppinglist\t");
			System.out.println("\t2.Complete the shoppinglist\t");
			
			error = false;
			while(!error) {
			try{
				num = keyboard.nextInt();
				error = true;
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("\n\n\tPlease enter an integer");
				keyboard.next();
			}
			}
		}

		order.setTotalPrice(shoppingList.calculateTotalPrice());
		order.setListProducts(shoppingList);
		
		try {
			listOrders.addOrder(order);
			System.out.println("\n\n\tThe order is added to the list\t");
		}
		catch(OrderListFullException e) {
			System.out.println("\n\n\tThe order list is full\t");
		}
	}
	
	//Display all the product which are present in any order.
	public static void manageDataProductsOrder(ListOrders order, ListProducts product, ListClient client){
	String[] list = null;
	list = order.productsInOrder(product, client);
	System.out.println(list);
	}
	
	//Show the product which has had more orders and indicate how many it has.
	public static void manageDataCompareOrdersProducts(ListOrders order, ListProducts product) {
	Product x = null; Product y =null;
	boolean found = false;
		
	//Find the objects of the 2 different products in the list which contains all products.
	
	while(!found) {
	System.out.println("\n\n\tEnter the name of the first product:\t");
	try {
		String product1 = keyboard.next();
		x = product.SearchProduct(product1); 
		found = true;
	}
	catch(ProductNotFoundException e) {
		keyboard.next();
	}
	}
	
	found = false;
	while(!found) {
	System.out.println("\n\n\tEnter the name of the second product:\t");
	try {
		String product2 = keyboard.next();
		y = product.SearchProduct(product2);
		found = true;
	}
	catch(ProductNotFoundException e) {
		keyboard.next();
	}
	}
	System.out.println(order.amountProductInOrderList(x,y)); //Return the product which has more orders and show the amount.
	}
	
	//Print the list of orders.
	public static void manageDataShowAllOrders(ListOrders order) {
		for(int i=0;i<order.getNumOfOrders();i++) {	
			System.out.println(order.getListOrders()[i]);
		}
	}
	
	//=========================================================================================================
	public static void menuOwner(int op, ListProducts product, ListClient client, ListOrders order){
		showMenus.showMenuOwner();
		op = keyboard.nextInt();
		while (op!=4) {
			switch(op) {
			case 1: showMenus.showMenuProducts(); 
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
			
			case 2: showMenus.showMenuClients(); 
					op = keyboard.nextInt();
					while(op!=4) {
						switch(op) {
						case 1: manageDataAddClient(client,order,product); break;
						case 2: manageDataDeleteClient(client, order, product); break;
						case 3: manageDataShowAllClients(client); break;
						}	
						break;
					}
					break;
			case 3: showMenus.showMenuOrders();
					op = keyboard.nextInt();
					while(op!=5) {
						switch(op) {
						case 1:	manageDataAddOrder(order, client, product); break;
						case 2: manageDataProductsOrder(order, product, client); break;
						case 3: manageDataCompareOrdersProducts(order, product); break;
						case 4: manageDataShowAllOrders(order); break;
						}
						break;
					}
					break;
			}
		showMenus.showMenuOwner();
		op = keyboard.nextInt();
		}
	}
	
	public static void menuClient() {
		System.out.println("It works!");
	}
	
	//=========================================================================================================

	public static void main(String[] args) {
		//Load clients into the system.
		
		ListClient client = new ListClient(100);
		
		try {
			ClientFileData.ClientReadData(client);
		}
			catch(IOException e) {
			System.out.println(e.toString());
		}
		
		//Load products into the system.
		ListProducts product = new ListProducts(100);
		try {
			ProductFileData.ProductReadData(product);
		}
		catch(IOException e) {
			System.out.println(e.toString());
			}
		
		//Load orders into the system.
		ListOrders order = new ListOrders(20);
		try {
		OrderFileData.OrderReadData();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		
		
		int op;
		showMenus.showMenuStart();
		op = keyboard.nextInt();
		while(op!=3) {
			switch(op) {
			case 1: menuOwner(op, product, client, order); break;		
			case 2: menuClient(); break;
			}
		showMenus.showMenuStart();
		op = keyboard.nextInt();	
		}
		System.out.println("\n\n\tDo you want to save the changes in the files?");
		System.out.println("\n\tPress 1 if YES");
		System.out.println("\tPress 2 if NO");
		op = keyboard.nextInt();
		if(op==1) {
			try {
				ClientFileData.ClientStoreData(client);
				ProductFileData.ProductStoreData(product);
				OrderFileData.OrderStoreData(order);
			}
			catch(IOException e) {	
			}
			System.out.println("\n\tChanges saved succesfully");
		}
	}
}