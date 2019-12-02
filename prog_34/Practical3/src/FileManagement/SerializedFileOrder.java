
package FileManagement;

import java.io.*;

import Data.Order;

public class SerializedFileOrder {
	
	public static void storeData(Order[] list) {
		ObjectOutputStream outputFile;
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream("Order.txt"));
			for(int i=0; i<list.length; i++) {
				outputFile.writeObject(list[i]);
			}
			outputFile.close();
		}
		catch(IOException e) {
			System.out.println("Error with the output file.");
		}
	}
	
	
	public static void readData(Order[] list) {
		ObjectInputStream inputFile;
		try {
			inputFile = new ObjectInputStream(new FileInputStream("Order.txt"));
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

	
