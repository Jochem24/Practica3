package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import Data.*;
import FileManagement.OrderFileData;
import FileManagement.ProductFileData;

public class Test extends JFrame{
	private static final long serialVersionUID=1L;

	
	
	public static void main(String[] args) {
		ListProducts product = new ListProducts(20);
		ListOrders order = new ListOrders(20);
		
		try {
			ProductFileData.ProductReadData(product);
		} catch(IOException e) {
		}
		
		try {
			OrderFileData.OrderReadData(order);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		
		new Window4(order,product);
		//new Window5(order);
	}

}
