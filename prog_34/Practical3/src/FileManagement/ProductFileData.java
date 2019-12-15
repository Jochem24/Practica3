package FileManagement;

import java.io.*;
import java.util.*;

import Data.*;

public class ProductFileData {
	
	public static void ProductReadData(ListProducts list) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("Product.txt"));
		String sentence="";
		sentence = f.readLine();
		while(sentence!=null) {
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
	
	public static void ProductStoreData(ListProducts list){
		Product product; Hardware hardware; Software software;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Product.txt"));

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