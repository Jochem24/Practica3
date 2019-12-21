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

public class TestProjectBinariFile {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		//sn.useDelimiter("\n");
		
		boolean salir = false;
		Order order;
		File originalFile = new File("OriginalOrderData.dat");
		File newFile = new File("NewOrderData.dat");
		
		if(newFile.exists()) newFile.delete();
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(!originalFile.exists()) {
				try {
					originalFile.createNewFile();			

				} catch (IOException e) {
					System.out.println("Order file can't be created!");
				}
		}
		
		
		
		while(!salir) {
			
			//System.out.println("1 Create files");		//OK
			System.out.println("2 Add order");			//OK
			System.out.println("3 Save Changes");		//OK
			System.out.println("4 Not Save Changes");	//no
			//System.out.println("5 Reset Data");		//no
			System.out.println("6 Show Original");		//OK
			System.out.println("7 Get out");			//OK
						
			try {
				System.out.println("Choose an option");
				
				int option = sn.nextInt();

				switch(option) {
														
				case 2:{
					
					int clientID = 0; 
					String date;
					
					System.out.println("Introduce the clientID Intger");
					clientID =sn.nextInt();
					
					System.out.println("Introduce the date String");
					date = sn.next();
					
					order = new Order(clientID, date);
					ObjectOutputStream oos;
					
					if(newFile.length()==0) {
						oos = new ObjectOutputStream(new FileOutputStream(newFile));
					}else {
						oos = new MyObjectOutputStream(new FileOutputStream(newFile, true));
					}
					oos.writeObject(order);
					
					break;
				}
					
				case 3: {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newFile));
					ObjectOutputStream ooss;
					
					while(true) {
						order = (Order)ois.readObject();
						if(originalFile.length()==0) {
							ooss = new ObjectOutputStream(new FileOutputStream(originalFile));
						}else {
							ooss = new MyObjectOutputStream(new FileOutputStream(originalFile, true));
						}
						ooss.writeObject(order);
					}
					
					
				}
				case 4:{
					/*if(newFile.exists()) {
						boolean a = newFile.delete();
						if (a) {
						System.out.println("File new data deleted");
						}else System.out.println("Problems");
					}else {
						System.out.println("File new data doesn't exist");
					}
					break;*/
					System.out.println("Without changes");
					break;
				}
				case 5:{
					if(originalFile.exists()) {
						boolean a = originalFile.delete();
						if (a) {
						System.out.println("File original deleted");
						}else System.out.println("Problems");
					}else {
						System.out.println("File original doesn't exist");
					}
				
					if(newFile.exists()) {
						boolean a = newFile.delete();
						if (a) {
						System.out.println("File new data deleted");
						}else System.out.println("Problems");
					}else {
						System.out.println("File new data doesn't exist");
					}
					break;
					
				}
				case 6:{
					ObjectInputStream oiis = new ObjectInputStream(new FileInputStream(originalFile));
					while(true) {
						order = (Order)oiis.readObject();
						System.out.println(order.toString());
					}
					
				}
				case 7:{
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

