package GUI;

import java.io.IOException;

import javax.swing.*;
import Data.*;
import FileManagement.ClientFileData;
import FileManagement.OrderFileData;
import FileManagement.ProductFileData;

public class Test extends JFrame{
	private static final long serialVersionUID=1L;

	public static void main(String[] args) {
		
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
		OrderFileData.OrderReadData(order);
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		new OrderListGUI(order);
	}

}
