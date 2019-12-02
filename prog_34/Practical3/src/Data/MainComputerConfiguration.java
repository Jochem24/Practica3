package Data;

import java.util.Scanner;

public class MainComputerConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int MAX_PRODUCTS = 50;
		Product []ListProd = new Product[MAX_PRODUCTS];
		Scanner introduce = new Scanner(System.in);
		
		ListProd[0] = new Hardware("CPU", 15.9, 50, HardwareType.CPU);
		ListProd[1] = new Hardware("MB", 34.6, 50, HardwareType.MB);
		ListProd[2] = new Hardware("HDD", 76, 60, HardwareType.HDD);
		ListProd[3] = new Hardware("RAM", 22.9, 70, HardwareType.RAM);
		ListProd[4] = new Hardware("GPU", 90, 80, HardwareType.GPU);
		ListProd[5] = new Hardware("Box", 77.98, 40, HardwareType.Peripheral);
		ListProd[6] = new Hardware("CPU2", 19.9, 50, HardwareType.CPU);
		ListProd[7] = new Hardware("RAM2", 27.5, 80, HardwareType.RAM);
		
		ListProd[8] = new Software("Spotify", 10, 90, "Windows");
		ListProd[9] = new Software("Gimp", 7.75, 70, "Windows");
		ListProd[10] = new Software("Photoshop", 35.50, 20, "Mac");
		ListProd[11] = new Software("VLC", 1, 0, "Linux");
		
		System.out.println("Option selected: Create a new Computer Configuration.");
		ListProd[12] = new ComputerConfiguration("SuperComputer");	//Create the instance
		((ComputerConfiguration) ListProd[12]).UpdateComputerConfiguration(ListProd);	//Update the prices and the id
		Product []ListComputerConfiguration = ((ComputerConfiguration) ListProd[12]).getComputerConfiguration();	//get the list of products that form the configuration
		
		System.out.println("What operating system do you want to work with? ");
		String os = introduce.next();
		int pos = FindProductPositionByItsName("OS", ListComputerConfiguration);
		((Software)ListComputerConfiguration[pos]).setNameOS(os);
		
		((ComputerConfiguration) ListProd[12]).setComputerConfiguration(ListComputerConfiguration);
		
		System.out.println("Here are the products type HARDWARE available");
		ShowProductsHardware(ListProd);
		System.out.println("Here are the products type SOFTWARE available");
		ShowProductsSoftware(ListProd);
		
		System.out.println("Choose a product you want to introduce: ");
		System.out.println("When you're done write -1");
		
		int op=0, uds;
		op = introduce.nextInt();
		while(op!=-1) {
			System.out.println("Units: ");
			uds = introduce.nextInt();
			((ComputerConfiguration) ListProd[12]).AddProductIntoConfiguration(ListProd[op], uds);
			System.out.println("Choose a product you want to introduce: ");
			System.out.println("When you're done write -1");
			op = introduce.nextInt();
		}
		
		ListComputerConfiguration = ((ComputerConfiguration) ListProd[12]).getComputerConfiguration();
		ShowProductsComputerConfiguration(ListComputerConfiguration);
	}

	private static int FindProductPositionByItsName(String name, Product []List) {
		int i;
		for( i=0; i<List.length; i++) {
			if (name==List[i].getNameProduct())
				break;
		}
		return i;
	}
	
	private static void ShowProductsHardware (Product []List) {
		
		for(int i=0; i<List.length; i++) {
			if(List[i] instanceof Hardware) {
				System.out.println(i + ". " + List[i].getNameProduct());
			}
		}
	}
	
	private static void ShowProductsSoftware (Product []List) {
		
		for(int i=0; i<List.length; i++) {
			if(List[i] instanceof Software) {
				System.out.println(i + ". " + List[i].getNameProduct());
			}
		}
	}
	
	private static void ShowProductsComputerConfiguration(Product []ListComputerConfiguration) {
		
		for(int i=0; i<ListComputerConfiguration.length; i++) {
				System.out.println(i + ". " + ListComputerConfiguration[i].toString());
			
		}
	}
	
}

