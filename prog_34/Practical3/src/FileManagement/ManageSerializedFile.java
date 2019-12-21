package FileManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Data.Order;

public class ManageSerializedFile {

	static File originalFile = new File("OriginalOrderData.dat");
	static File newFile = new File("NewOrderData.dat");
	
	public static void InitializeSerializedFiles() {
		
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
		
	}
	
	public static void AddObjectToSerializedFile(Object a) {
		
		ObjectOutputStream oos;
	try {	
		if(newFile.length()==0) {
			oos = new ObjectOutputStream(new FileOutputStream(newFile));
		}else {
			oos = new MyObjectOutputStream(new FileOutputStream(newFile, true));
		}
		oos.writeObject(a);
		}catch(IOException e) {
		System.out.println("Problems to add information into Serialized File");
		}
	
	}
	
	public static void SaveInformationIntoSerializedFile(Object a) throws ClassNotFoundException {
		
		try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newFile));
		ObjectOutputStream ooss;
		
		while(true) {
			a = (Order)ois.readObject();
			if(originalFile.length()==0) {
				ooss = new ObjectOutputStream(new FileOutputStream(originalFile));
			}else {
				ooss = new MyObjectOutputStream(new FileOutputStream(originalFile, true));
			}
			ooss.writeObject(a);
			}
		}catch(IOException e) {
			System.out.println(" ");
		}
	}
	
	public static void ShowInformationIntoSerializedFiles(Object a) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oiis = new ObjectInputStream(new FileInputStream(originalFile));
		while(true) {
			a = (Order)oiis.readObject();
			System.out.println(a.toString());
		}
	}
	
	public static void ResetSerializedFiles() {
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
	}
	
	
		
}
