package FileManagement;

import java.io.*;
import java.util.*;

import Exceptions.*;
import Data.*;

public class ProductFileData {
	
	public static void ProductReadData(ListProducts list) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("Product.txt"));
		String sentence="";
		sentence = f.readLine();
		while(sentence!=null) {
			StringTokenizer st = new StringTokenizer(sentence,"*");
			String name=st.nextToken();
			double price = Double.parseDouble(st.nextToken());
			int stock = Integer.parseInt(st.nextToken());
			int identifier = Integer.parseInt(st.nextToken());
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
	
	public static void ProductStoreData(ListProducts list, String filename) throws IOException {
		try {
			BufferedReader f = new BufferedReader(new FileReader(filename));
			BufferedWriter g = new BufferedWriter(new FileWriter(filename));
			String sentence = "";
			
			sentence = f.readLine();
			while(sentence!=null) {
				g.write(sentence);
				g.newLine();
				sentence = f.readLine();
			}
			f.close();
			g.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, the file does not exist");
		}
		catch(IOException e) {
			System.out.println("Error occured during the processing of the file");
		}
	}
	
}
