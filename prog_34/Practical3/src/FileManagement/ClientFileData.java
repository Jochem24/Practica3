package FileManagement;

import java.io.*;
import java.util.*;
import java.util.Locale;
import java.util.Scanner;

import Data.*;
import Exceptions.*;

public class ClientFileData {
	
	public static void ClientReadData(ListClient list) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("Client.txt"));
		String sentence=""; int identifier; String email; String postalAddress;
		sentence = f.readLine();
		while(sentence!=null) {
			StringTokenizer st = new StringTokenizer(sentence,"*");
			identifier= Integer.parseInt(st.nextToken());
			email = st.nextToken();
			postalAddress = st.nextToken();
			
			Client c = new Client(identifier, email, postalAddress);
		
			
			try {
				list.addClient(c);
			}
			catch(ClientListFullException e) {
			}
			catch(ClientAlreadyExistsException e) {
			}
			sentence = f.readLine();
		}
		f.close();
	}
	
	public static void ClientStoreData(ListClient list) throws IOException {
		Client client;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Client.txt"));
				for(int i=0; i<list.getNumOfClients(); i++) {
					client = list.getListClient()[i];
					writer.write(client.getID() + "*" + client.getEmail() + "*" + client.getPostalAddress() + "\n");
				}
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Error occured during the processing of the file");
		}
	}
}