
public class MainClassTestClient {

	public static void main(String[] args) {
		Client a = new Client(1,"abc@def.nl","Street 1");
		Client b = new Client(2,"ghi@jkl.nl","Street 2");
		Client c = new Client(3,"mno@pqr.nl","Street 3");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		ListClient test = new ListClient(10);
		
		//Adding new clients to the list
		test.addClient(a);
		test.addClient(b);
		test.addClient(c);
		
	
		System.out.println(test); //Check if adding to list is properly working.
		
		test.deleteClient(a);
		test.deleteClient(b);
		
		System.out.println(test); //Check if deleting clients from list is working
	}
}
