
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
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public Order copy(int i) {
		if(i<numOfOrders && listOfOrders[i]!=null) {
			return(listOfOrders[i].copy());
		}
		return(null);
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
				listOfOrders[i].getListProducts().removeStock();
				listOfOrders[i]=null;
				found=true;
			}		
		}
	}
	
	/**
	 * 
	 * @param clientID
	 */
	public void deleteOrder(int clientID) {
		boolean found = false;
		for(int i=0;i<numOfOrders && !found;i++) {
			if(listOfOrders[i].getClientID() == clientID) {
				listOfOrders[i].getListProducts().removeStock();
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
		for(int i=0;i<numOfOrders;i++) {
			if(listOfOrders[i].getClientID() == clientID){
				list.addOrder(listOfOrders[i]);
			}
		}
		return(list);	
	}
	
	/**
	 * 
	 * @param listProducts
	 * @param listClient
	 * @return
	 */
	
	public String[] productsInOrder(ListProducts listProducts, ListClient listClient) {
		Client client;
		int j=0;
		String[] list = new String[20];
		for(int i=0; i<numOfOrders; i++) {
			client = listClient.searchClient(listOfOrders[i].getClientID());
			list[j] = listOfOrders[i].getListProducts().toString() + client.toString();
			j++;
		}
		return(list);
	}
	
	/**
	 * 
	 * @param product1
	 * @param product2
	 * @return
	 */
	public String amountProductInOrderList(Product product1, Product product2) {
		String result = null;
		int counter = 0;
		for(int i=0; i<numOfOrders; i++) {
			if(listOfOrders[i].getListProducts().amountProductInList(product1) > listOfOrders[i].getListProducts().amountProductInList(product1)) {
				result = product1.toString();
				counter = listOfOrders[i].getListProducts().amountProductInList(product1);
			}
		}
		
		for(int i=0; i<numOfOrders; i++) {
			if(listOfOrders[i].getListProducts().amountProductInList(product1) < listOfOrders[i].getListProducts().amountProductInList(product1)) {
				result = product2.toString();
				counter = listOfOrders[i].getListProducts().amountProductInList(product2);
			}	
		}
	return(result + counter);
	}
}