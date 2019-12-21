package FileManagement;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

import Data.Order;
import Data.*;

public class SerializedFileOrder {
	
	
	/*
	public static void OrderStoreData(String file, ListOrders list) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
		objectOutputStream.writeObject(list);
		objectOutputStream.close();
	}
	*/
	

	public static void storeData(ListOrders listOrders, String filename) throws IOException  {
		
		Product product;
		Order order;
		String writeLine = "";
		try ( ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(filename))){
			outputFile.writeObject("Order List");
			for(int i=0; i<listOrders.getNumOfOrders(); i++) {
				order = listOrders.getListOrders()[i];
				for(int j=0; j<order.getListProducts().getNumProducts(); j++) {
					product = order.getListProducts().getList()[j];
						writeLine += order.getClientID() + "*" + order.getOrderID() + "*" + product + "*" + order.getTotalPrice() + "*" + order.getDate() + ";[";
				}
				writeLine += "]";
				outputFile.writeObject(writeLine + "\n");
				writeLine = "";
			}
			outputFile.close();
		}
	}
	

	public static Object OrderReadData(String file) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void readData(ListOrders list) throws FileNotFoundException {
	
	String line;
	int clientID;
	String orderID;
	ListProducts listProducts;
	double totalPrice;
	String date;
	
	
	ObjectInputStream inputFile;
	ListOrders newList = new ListOrders(20);
	
	try {
		inputFile = new ObjectInputStream(new FileInputStream("Orders.ser"));
		for(int i=0; i<list.getNumOfOrders(); i++) {
			list.getListOrders()[i] = (Order)inputFile.readObject();
		}
		inputFile.close();
	}
	catch(IOException e) {
		System.out.println("Error with the output file");
	}
	catch(ClassNotFoundException e) {
		System.out.println("Error, the file format is not correct."+e);
	}
	catch(ClassCastException e) {
		System.out.println("Error, the file format is not correct for the current class Order definition"+e);	
	}
	}
	
	/*
	try {
		for (int i=0; i<newList.getNumOfOrders(); i++) {
	}
	*/

			
	public void readData(Order[] list) {
		ObjectInputStream inputFile;
		try {
			inputFile = new ObjectInputStream(new FileInputStream("Orders.ser"));
			for(int i=0; i<list.length; i++) {
				list[i] = (Order)inputFile.readObject();
			}
			inputFile.close();
		}
		catch(IOException e) {
			System.out.println("Error with the output file");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error, the file format is not correct."+e);
		}
		catch(ClassCastException e) {
			System.out.println("Error, the file format is not correct for the current class Order definition"+e);	
		}
	}
}
