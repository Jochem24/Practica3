package GUI;

import Data.ListClient;

public class MenuClient{
	
	static ListClient client = new ListClient(100);
	
	public static void main(String[] args) {
		
		Window1 LogIn = new Window1(client);
			
	}

}

