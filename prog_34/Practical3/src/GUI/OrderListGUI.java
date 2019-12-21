package GUI;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import Data.*;

public class OrderListGUI 
		extends JFrame implements ActionListener{
	
	private JFrame f= new JFrame();  
    private DefaultListModel<String> l1 = new DefaultListModel<>(); 
    private DefaultListModel<String> l2 = new DefaultListModel<>();
    private JButton b1 = new JButton("Show details of the order");
    
    private JList list;
	
	public OrderListGUI(ListOrders order) { 
	    for(int i=0; i<order.getNumOfOrders(); i++) {
	    	if(order.getListOrders()[i] != null) {
	    		l1.addElement(order.getListOrders()[i].getOrderID());
	    	}
	    }
	    
	    JList<String> list = new JList<>(l1);  
	    list.setBounds(15,15,185,335);  
	    f.add(list);

	    JList<String> list2 = new JList<>(l2);  
	    list2.setBounds(215,15,185,335);
	    f.add(list2);
	    
	    b1.addActionListener(this);
	    b1.setBounds(15,380, 200, 20);
	    f.add(b1, BorderLayout.PAGE_END);
	    
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    
        pack();
	}  
	

	public void ActionPerformed(ActionEvent e, ListOrders order) {
		DefaultListModel<String> l2 = new DefaultListModel<>();
		
		if(e.getActionCommand().equals("Show details of the order")){
			String orderID = (String) list.getSelectedValue();
			Order test = order.searchOrders(orderID);
			for(int i=0; i<test.getListProducts().getNumProducts(); i++) {
				if(test.getListProducts().getList()[i]!= null) {
					l2.addElement(test.getListProducts().getList()[i].getNameProduct() + test.getListProducts().getList()[i].getPriceProduct());
				}
			}
		}
	}	
}
