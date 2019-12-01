
public class ListClient {
	
	private int numOfClients;
	private Client[] list;
	
	/**
	 * Create a new list of the type ListClient, indicate the size of the list in the arguments.
	 * @param size The size of the list ListClient.
	 */
	public ListClient() {
		list = new Client[99];
	}
	
	/**
	 * Get the number of clients in the list.
	 * @return An integer value of numOfClients.
	 */
	public int getNumOfClients() {
		return (numOfClients);
	}
	
	/**
	 * 
	 * @return
	 */
	public ListClient copy() {
		ListClient list = new ListClient();
		return(list);
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public Client copy(int i) {
		if(i<numOfClients && list[i]!=null) {
			return(list[i].copy());
		}
		return(null);
	}
	
	/**
	 * Adding a new client to the list if the ID is unique.
	 * @param client The object Client added to the list ListClient.
	 */
	public void addClient(Client client) {		
		boolean found = false;	
		for(int i=0;i<numOfClients && !found;i++) {
			if(list[i].getID() == client.getID()) {
				found = true;
			}
		}

		if(numOfClients<list.length && !found) {
			list[numOfClients] = client.copy();
			numOfClients++;
		}
	}

	/**
	 * Delete a client from the list.
	 * @param client The object to be deleted from the list.
	 */
	public void deleteClient(Client client) {
		for(int i=0;i<numOfClients;i++) {
			if(list[i] != null && list[i].getID() == client.getID()) {
				list[i] = null;
			}
		}
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public boolean checkClient(int ID) {
		boolean found = false;
		for(int i=0; i<numOfClients && !found; i++) {
			if(list[i].getID() == ID) {
				found = true;
			}
		}
		return(found);
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public Client searchClient(int ID) {
		int j=0;
		boolean found = false;
		for(int i=0; i<numOfClients && !found; i++) {
			if(list[i].getID() == ID) {
				found = true;
				j=i;
			}
		}
		return(list[j].copy());
	}
}
