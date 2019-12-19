package GUI;
import javax.swing.*;
import javax.swing.event.*;

public class OrderListGUI extends JFrame{
	
	public OrderListGUI() { 
		JFrame f= new JFrame();  
	    DefaultListModel<String> l1 = new DefaultListModel<>();  
	    l1.addElement("Order1");  
	    l1.addElement("Order2");  
	    l1.addElement("Order3");  
	    l1.addElement("Order4");  
	    JList<String> list = new JList<>(l1);  
	    list.setBounds(15,15,185,335);  
	    f.add(list);
	   
	    DefaultListModel<String> l2 = new DefaultListModel<>();
	    l2.addElement("Product1");
	    l2.addElement("Product2");
	    l2.addElement("Product3");
	    JList<String> list2 = new JList<>(l2);  
	    list2.setBounds(215,15,185,335);
	    f.add(list2);
	    
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	    
	}  
}
