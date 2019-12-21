package GUI;

import Data.ListClient;

public class MenuClient{
	
	static ListClient client = new ListClient(20000);
	
	public static void main(String[] args) {
		
		Window1 LogIn = new Window1(client);
			
	}

}

