package Data;

import Exceptions.*;
import java.io.*;


public class ListOrders implements Serializable{
	static final long serialVersionIUD = 1;
	
	private int numOfOrders;
	private Order[] listOfOrders;

	/**
	 * 
	 * @param size
	 */
	public ListOrders(int size){
		listOfOrders = new Order[size];
	}

	public Order[] getListOrders() {
		return listOfOrders;
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
	
	
	public void addOrder(Order order) throws OrderListFullException{
		if(numOfOrders<listOfOrders.length) {
			listOfOrders[numOfOrders] = order; //Have to use a reference because copy will return the "empty" constructor again.
			numOfOrders++;
		}
		else throw new OrderListFullException();
	}

	/**
	 * Delete an order of the list and restore the stock.
	 * @param orderID The ID of the order to find the order in the list.
	 * @param listProducts 
	 */
	//still have to change stock
	public void deleteOrder(String orderID) throws OrderIDNotFoundException {
		boolean found = false;
		for(int i=0;i<numOfOrders && !found;i++) {
			if(listOfOrders[i].getOrderID().equals(orderID)) {
				listOfOrders[i]=null;
				found=true;
			}
		}
		if(!found) {
			throw new OrderIDNotFoundException();
		}
	}
	
	/**
	 * 
	 * @param clientID
	 * @param catalogue
	 */
	
	public void deleteAllOrders(int clientID){ //, ListProducts catalogue
		//ListProducts shoppingList;
		for(int i=0;i<numOfOrders;i++) {
			if(listOfOrders[i].getClientID() == clientID) {
				//shoppingList = listOfOrders[i].getListProducts();
				//catalogue.restoreStock(shoppingList);
				listOfOrders[i] = null;
			}
		}	
	}
	
	
	/**
	 * Search all the orders a customer has made.
	 * @param clientID
	 * @return A list of all orders the customer has made.
	 */
	
	public ListOrders searchOrders(int clientID) throws OrderListFullException {
		ListOrders list = new ListOrders(20);
		for(int i=0;i<numOfOrders;i++) {
			if(listOfOrders[i].getClientID() == clientID){
				list.addOrder(listOfOrders[i]);
			}
		}
		if(list.getNumOfOrders()==19) {	
			throw new OrderListFullException();
		}
		return(list);	
	}
	
	
	/**
	 * 
	 * @param orderID
	 * @return
	 * @throws OrderIDNotFoundException
	 */
	public Order SearchPosOrder(String orderID) throws OrderIDNotFoundException{
		int i=0;
		boolean found=false;
		Order x=null;
		
		for(i=0;i<numOfOrders && !found;i++) {
			if(listOfOrders[i].getOrderID().equals(orderID)) {
				x = listOfOrders[i];
			}
		}
		if(!found) {
			throw new OrderIDNotFoundException();
		}
		
		return x;
	}
	
	/**
	 * 
	 * @param listProducts
	 * @param listClient
	 * @return
	 */
	
	public String[] productsInOrder(ListProducts listProducts, ListClient listClient){
		int x =0; Client client = null;
		int j=0;
		String[] list = new String[20];
		for(int i=0; i<numOfOrders; i++) {
			try {
			x = listOfOrders[i].getClientID();	
			client = listClient.searchClient(x);
			}
			catch(ClientNotFoundException e) {
			}
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
		int counterProduct1 = 0; 
		int counterProduct2 = 0;
		for(int i=0; i<numOfOrders; i++) {
			counterProduct1 += listOfOrders[i].getListProducts().amountProductInList(product1); 
			counterProduct2 += listOfOrders[i].getListProducts().amountProductInList(product2);
		}
		if(counterProduct1>counterProduct2) {
			result = product1.getNameProduct()+", Amount of times ordered: " + counterProduct1;
		}
		else 
			result = product2.getNameProduct()+", Amount of times ordered: " + counterProduct2;
		return(result);
	}

	@Override
	public String toString(){
		int i=0;
		String result = "";
		
		for(i=0;i<numOfOrders;i++) {
			if(listOfOrders[i]!=null){
			result = result + listOfOrders[i].toString();
		}
		}
		return result;
	}

}
