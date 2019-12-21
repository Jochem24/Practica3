package FileManagement;

import java.io.*;
import java.util.*;

import Data.*;

public class ComputerConfigurationFileData {
	
	public static void ComputerConfigurationReadData(ComputerConfiguration cc, ListProducts list) throws IOException {
		//The computer configuration that a user wants to read
		//The general store stock
		
		int max_stock = list.getNumProducts();
		int num_cc=0;
		Product[]list_products = list.getList().clone();
		Product a;
		for(int i=0; i<max_stock; i++) {
			a=list_products[i];
			if(a instanceof ComputerConfiguration) {
				num_cc = num_cc + ((ComputerConfiguration) list_products[i]).getNumProducts();
			}
		}
		
		
		BufferedReader f = new BufferedReader(new FileReader("ComputerConfiguration.txt"));
		
		String sentence="";
		
		sentence = f.readLine();
		
		int num_lines = cc.getNumProducts();
		for(int i=num_cc; (i<num_lines)&&(sentence!=null); i++ ) {
			
			StringTokenizer st = new StringTokenizer(sentence,"*");
			
			int identifier = Integer.parseInt(st.nextToken());
			
			String name=st.nextToken();
			
			double price = Double.parseDouble(st.nextToken());
			
			int stock = Integer.parseInt(st.nextToken());
			
			String test = st.nextToken();
			
			if(test.equals("Windows")|| test.equals("Apple")||test.equals("Linux")) {
				String OS = test;
				Software s = new Software(name,OS);
				s.setPriceProduct(price); s.setStockProduct(stock); s.setIdentifier(identifier); 
				list.addProduct(s);
			}
			else {
			HardwareType type = HardwareType.valueOf(test);
			Hardware h = new Hardware(name, type);
			h.setPriceProduct(price); h.setStockProduct(stock); h.setIdentifier(identifier); 
			list.addProduct(h);
			}
			sentence = f.readLine();
		}
		f.close();
	}
	
	public static void ComputerConfigurationStoreData(ListProducts list){
		Product product; Hardware hardware; Software software;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ComputerConfiguration.txt"));

			for(int i=0; i<list.getNumProducts(); i++) {
				product = list.getList()[i];
				if(product instanceof Hardware) {
					writer.write(product.getIdentifier() +"*"+ product.getNameProduct() +"*"+ product.getPriceProduct() +"*"+ product.getStockProduct() +"*"+ ((Hardware) product).getType() +"\n");
				}
				else
					writer.write(product.getIdentifier() +"*"+ product.getNameProduct() +"*"+ product.getPriceProduct() +"*"+ product.getStockProduct() +"*"+ ((Software) product).getNameOS() +"\n");	
				}	
			writer.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, the file does not exist");
		}
		catch(IOException e) {
			System.out.println("Error occured during the processing of the file");
		}
	}
	
}