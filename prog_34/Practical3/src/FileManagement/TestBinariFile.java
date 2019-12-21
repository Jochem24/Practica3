package FileManagement;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Data.Order;

public class TestBinariFile {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		//sn.useDelimiter("\n");
		
		boolean salir = false;
		Order order;
		File ficher = new File("Order.dat");
		
		while(!salir) {
			System.out.println("1 Create file");
			System.out.println("2 Add order");
			System.out.println("3 Show order");
			System.out.println("4 Delete file");
			System.out.println("5 Get out");
			
			try {
				System.out.println("Choose an option");
				
				int option = sn.nextInt();

				switch(option) {
				case 1:{
					
					if(ficher.exists()) {
						System.out.println("File exists");
					}else {
						if(ficher.createNewFile()) {
							System.out.println("File created");
						}else {
							System.out.println("Problem file can't be created");
						}
					}
					break;
				}
										
				case 2:{
					
					int clientID = 0; 
					String date;
					
					System.out.println("Introduce the clientID Intger");
					clientID =sn.nextInt();
					
					System.out.println("Introduce the date String");
					date = sn.next();
					
					order = new Order(clientID, date);
					ObjectOutputStream oos;
					
					if(ficher.length()==0) {
						oos = new ObjectOutputStream(new FileOutputStream(ficher));
					}else {
						oos = new MyObjectOutputStream(new FileOutputStream(ficher, true));
					}
					oos.writeObject(order);
					
					break;
				}
					
				case 3: {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficher));
					
					while(true) {
						order = (Order)ois.readObject();
						
						System.out.println(order.toString());
					}
					
				}
				case 4:{
					if(ficher.exists()) {
						boolean a = ficher.delete();
						if (a) {
						System.out.println("File deleted");
						}else System.out.println("Problems");
					}else {
						System.out.println("File doesn't exist");
					}
					
					break;
				}
				case 5:{
					System.out.println("Bye bye");
					salir = true;
					sn.close();
				}
				}
			}catch(EOFException e){
				System.out.println(" ");
			}catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException");
			}catch(IOException e) {
				System.out.println("IOException");
			}catch(SecurityException e) {
				System.out.println("SecurityException");
			}
		}
	}
}

			
		
