package GUI;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import Data.*;
import Exceptions.*;

public class Window5{
	
	private JFrame f;
	private DefaultListModel<String> l1,l2;
	private JButton b1,b2;
    private JList<String> list, list2;
    private JLabel title1;
    
    private static ListOrders order;

	public Window5(ListOrders order) {  
    this.order = order;
    new OrderListGUI();
	}
	
	class OrderListGUI extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L; 
		
		public OrderListGUI() {
		f = new JFrame();	
			
		l1 = new DefaultListModel<>(); 
		l2 = new DefaultListModel<>();
		
	    b1 = new JButton("Show details of the order");
	    b2 = new JButton("Delete the order");
	    
	    title1 = new JLabel("Your orders:");
		
	    for(int i=0; i<order.getNumOfOrders(); i++) {
	    	if(order.getListOrders()[i] != null) {
	    		l1.addElement(order.getListOrders()[i].getOrderID());
	    	}
	    }
	    
	    list = new JList<String>(l1);  
	    list.setBounds(15,15,185,335);  
	    f.add(list);

	    list2 = new JList<String>(l2);  
	    list2.setBounds(215,15,185,335);
	    f.add(list2);
	    
	    b1.addActionListener(this);
	    b1.setBounds(15,380, 185, 20);
	    f.add(b1, BorderLayout.PAGE_END);
	    
	    b2.addActionListener(this);
	    b2.setBounds(215,380,185, 20);
	    f.add(b2, BorderLayout.PAGE_END);
	    
	    title1.setBounds(2,2,15,140);
	    f.add(title1, BorderLayout.PAGE_START);
	    
	    f.setSize(430,480);  
	    f.setLayout(null);  
	    f.setVisible(true);
	}  

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Show details of the order")){
			l2.clear();
			String orderID = (String) list.getSelectedValue();
			Order x  = order.searchOrder(orderID);
			
			for(int i=0; i<x.getListProducts().getNumProducts(); i++) {
				if(x.getListProducts().getList()[i] != null) {
					l2.addElement("Name: " + x.getListProducts().getList()[i].getNameProduct() +", Price: €"+ x.getListProducts().getList()[i].getPriceProduct());
				}
    		}
		}
		
		if(e.getActionCommand().equals("Delete the order")) {
			String orderID = (String) list.getSelectedValue();
			String answer;
			
			int option = JOptionPane.showConfirmDialog(null,"Do you really want to delete the order?", "Atention", JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION) {
				answer = "The order has been deleted succesfully!";
				try {
					order.deleteOrder(orderID);
				}catch(OrderIDNotFoundException error) {}
			}
			else answer = "Action has been cancelled";
		}
		
	}
	
	//order list has to be updated when order is removed. program crashes when you remove for example the final order. 
    //This is because an order in the middle of the list is removed, so the method recognizes null=null.
}
}