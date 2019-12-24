package FileManagement;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;


import Exceptions.*;
import Data.*;

public class OrderFileData{

	public static void OrderReadData(ListOrders list) throws IOException{
		ObjectInputStream inputFile;
		boolean read = false;
		Order order;
		try {
			inputFile = new ObjectInputStream(new FileInputStream("Order.ser"));
			while(!read) {
				try {
					order = (Order) inputFile.readObject();
					list.addOrder(order);
					} catch(OrderListFullException e){ read = true;}
			} 
		inputFile.close();
		    }catch(FileNotFoundException e) {
				System.out.println(e.toString());
		    }catch(ClassNotFoundException e) {
				System.out.println(e.toString());
		    }catch(IOException e) {
				System.out.println(e.toString());
			}
	}

	
	public static void OrderStoreData(ListOrders list) throws IOException {
		ObjectOutputStream outputFile;
		try{
			outputFile=new ObjectOutputStream(new FileOutputStream("Order.ser"));
			for(int i=0; i<list.getNumOfOrders(); i++) {
				outputFile.writeObject(list.getListOrders()[i]);
			}
			outputFile.close();
		} catch(IOException e) {
				System.out.println(e.toString());
		}
	}
}
