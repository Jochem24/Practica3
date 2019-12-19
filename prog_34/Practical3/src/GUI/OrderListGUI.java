package GUI;

import javax.swing.*;
import javax.swing.event.*;
import Data.*;

public class OrderListGUI extends JFrame{
	
	public OrderListGUI(ListOrders order) { 
		JFrame f= new JFrame();  
	    DefaultListModel<String> l1 = new DefaultListModel<>(); 
	    DefaultListModel<String> l2 = new DefaultListModel<>();
	    
	    for(int i=0; i<order.getNumOfOrders(); i++) {
	    	if(order.getListOrders()[i] != null) {
	    		l1.addElement(order.getListOrders()[i].getOrderID());
	    	}
	    	for(int j=0; j<order.getListOrders()[i].getListProducts().getNumProducts(); j++) {
	    		if(order.getListOrders()[i].getListProducts().getList()[j] != null) {
	    			l2.addElement(order.getListOrders()[i].getListProducts().getList()[j].getNameProduct());
	    		}
	    	}
	    }
	    JList<String> list = new JList<>(l1);  
	    list.setBounds(15,15,185,335);  
	    f.add(list);

	    JList<String> list2 = new JList<>(l2);  
	    list2.setBounds(215,15,185,335);
	    f.add(list2);
	    
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    setLocationRelativeTo(null);
	}  
}
