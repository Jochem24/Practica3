
public class ListOrders {
	
	private int numOfOrders;
	private Order[] listOfOrders;

	/**
	 * 
	 * @param size
	 */
	public ListOrders(int size){
		listOfOrders = new Order[size];
	}

	/**
	 * Add an order to a list which contains all the different orders.
	 * @param order
	 * @param client
	 * @param product
	 */
	public int getNumOfOrders() {
		return(numOfOrders);
	}
	
	public void showListOrders() {
		for(int i=0;i<numOfOrders;i++) {
			System.out.println(listOfOrders[i].toString());
		}
	}
	
	public void addOrder(Order order){
		if(numOfOrders<listOfOrders.length) {
			listOfOrders[numOfOrders] = order;
			numOfOrders++;
		}
	}

	/**
	 * Delete an order of the list and restore the stock.
	 * @param orderID The ID of the order to find the order in the list.
	 * @param listProducts 
	 */
	public void deleteOrder(String orderID) {
		boolean found = false;
		for(int i=0;i<numOfOrders && !found;i++) {
			if(listOfOrders[i].getOrderID().equals(orderID)) {
				listOfOrders[i]=null;
				found=true;
			}		
		}
	}
	
	
	/**
	 * Search all the orders a customer has made.
	 * @param clientID
	 * @return A list of all orders the customer has made.
	 */
	
	public ListOrders searchOrders(int clientID) {
		ListOrders list = new ListOrders(20);
		int j=0;
		for(int i=0;i<numOfOrders;i++) {
			if(listOfOrders[i].getClientID() == clientID){
				list.addOrder(listOfOrders[i]);
				j++;
			}
		}
		return(list);	
	}
	
	public ListOrders searchOrderID(int clientID) {
		ListOrders list = new ListOrders(20);
		int j=0;
		for(int i=0;i<numOfOrders;i++) {
			if(listOfOrders[i].getClientID() == clientID){
				list.addOrder(listOfOrders[i]);
				j++;
			}
		}
		return(list);	
	}
}