package FileManagement;

import java.io.*;
import java.util.Scanner;

import Exceptions.*;

import Data.*;

public class OrderFileData {

	public static void OrderReadData() throws IOException{
		int clientID; String orderID;double totalPrice; String date;
		ListProducts listProducts; int size;
	
		ObjectInputStream inputFile;
	
		ListOrders list = new ListOrders(20);
		try {
			inputFile = new ObjectInputStream(new FileInputStream("Order.ser"));
		
			Order order = (Order)inputFile.readObject();
			clientID = order.getClientID();
			orderID = order.getOrderID();
			totalPrice = order.getTotalPrice();
			date = order.getDate();
			
			Order newOrder = new Order(clientID,date);
			try {
				list.addOrder(newOrder);
			}
			catch(OrderListFullException e) {
			}
		inputFile.close();
		}
		catch(IOException e) {
		System.out.println("Error with the output file");
		}
		catch(ClassNotFoundException e) {
		System.out.println("Error, the file format is not correct."+e);
		}
	}
	
	public static void OrderStoreData(ListOrders list) throws IOException {
		ObjectOutputStream fout;

		try{
			fout=new ObjectOutputStream(new FileOutputStream("Order.ser"));
			for(int i=0; i<list.getNumOfOrders(); i++) {
				Order x = list.getListOrders()[i];
				fout.writeObject(x);
				}
			fout.close();
		}
		catch(IOException e) {
		}
	}
	
	
	public static void OrderReadData(ListOrders listOrders, String filename) throws IOException  {
		Product product;
		Order order;
		String writeLine = "";
		try ( ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(filename))){
			outputFile.writeObject("OrderList");
			for(int i=0; i<listOrders.getNumOfOrders(); i++) {
				order = listOrders.getListOrders()[i];
				writeLine += order.getClientID() + "*" + order.getOrderID() + "*" + order.getListProducts() + "*" + order.getTotalPrice() + "*" + order.getDate();
				outputFile.writeObject(writeLine + "\n");
				writeLine = "";
			}
			outputFile.close();
		}
	}
	
	/*
	
	
	public void OrderReadData(File nameF) {
		String name, message="";
		Density aux=new Density("",0);
		float dens;
		boolean isRead=false;
		ObjectInputStream fin;
		try{
			fin=new ObjectInputStream(new FileInputStream(nameF));
			while (!isRead) {
				aux=(Density)fin.readObject();
				name=aux.getNameCity();
				dens=aux.getDensityValue();
				message=message+"City "+name+", density "+dens+" pers/km2\n";
				}
			fin.close();
		}
		catch (FileNotFoundException e) {
			text.setText("The input data file does not exist");
		}
		catch (ClassNotFoundException e) {
			text.setText("File format is not correct");
		}
		catch (EOFException e) {
			isRead=true;
		}
		catch (IOException e) {
			text.setText("Error with files");
		}
		text.setText(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void createDensitiesBin() {
		BufferedReader f;
		ObjectOutputStream fout;
		String line, name, message="";
		int city;
		float area, dens;
		try{
			f=new BufferedReader(new FileReader("Example.txt"));
			fout=new ObjectOutputStream(new FileOutputStream("Densities.ser"));
			Scanner particio;
			line=f.readLine();
			while (line!=null) {
				particio=new Scanner(line);
				particio.useDelimiter(";");
				try {
					name=particio.next();
					city=particio.nextInt();
					area=particio.nextFloat();
					if (area==0) throw new ArithmeticException("Area cannot be zero");
					dens=city/area;
					//we store the information in a class
					fout.writeObject(new Density(name, dens));
					message=message+name+": "+dens+" pers/km2\n";
				}
				catch (NumberFormatException e) {
					message=message+"Second and third values must be numbers\n";
				}
				catch (NoSuchElementException e) {
					message=message+"Missing or incorrect data\n";
				}
				catch (ArithmeticException e) {
					message=message+e+"\n";
				}
				line=f.readLine();
			}
			f.close();
			fout.close();
			text.setText(message);
		}
		catch (FileNotFoundException e) {
			text.setText("The input data file does not exist");
		}
		catch (IOException e) {
			text.setText("Error with files");
		}
	}
	*/
}