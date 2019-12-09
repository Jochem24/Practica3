package Data;

import java.io.*;

public class Order implements Serializable {
	static final long serialVersionIUD = 1;
	
	private int clientID;
	private String orderID;
	private int num;
	private ListProducts listProducts;
	private double totalPrice;
	private String date;
	
	/**
	 * 
	 * @param client
	 * @param product
	 * @param quantity
	 * @param date
	 */
	public Order(int clientID,String date) {
		this.clientID = clientID;
		num = getRandomNum();
		this.orderID = String.valueOf(clientID) + String.valueOf(num);
		listProducts = new ListProducts(20);
		this.totalPrice = 0;
		this.date = date; //configure the date in main file using java.time.LocalDate
	}

	public int getRandomNum(){
	    int num = (int)(Math.random()*(999-0)+1);
	    return (num);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getClientID() {
		return clientID;
	}



	/**
	 * 
	 * @param clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * 
	 * @return
	 */
	public String getOrderID() {
		return orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 
	 * @return
	 */
	public ListProducts getListProducts() {
		return listProducts;
	}

	/**
	 * 
	 * @param listProducts
	 */
	public void setListProducts(ListProducts listProducts) {
		this.listProducts = listProducts;
	}

	/**
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}


	
	/**
	 * Write the data of the constructor into a String format.
	 */
	@Override
	public String toString() {
		return "Order [clientID=" + clientID + ", orderID=" + orderID + ", num=" + num + ", listProducts="
				+ listProducts + ", totalPrice=" + totalPrice + ", date=" + date + "]";
	}
	
	/**
	 * 
	 * @return
	 */
	public Order copy(){
		Order clone = new Order(clientID,date);
		return(clone);
	}
	
	
}
