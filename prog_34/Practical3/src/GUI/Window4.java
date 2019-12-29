package GUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

import Data.*;
import Exceptions.*;

public class Window4{

	private JFrame f;
	JList<String> list, list2;
	private DefaultListModel<String> available, shoppingList;
	private JButton b1, b2;
	private JLabel title1, title2, title3;
	
	private static ListProducts catalogue, shopList; 
	private static ListOrders order;
	
	public Window4(ListOrders order, ListProducts product){
		this.order = order;
		catalogue = product;
		shopList = new ListProducts(20);
		new createOrder();
	}
		
		
	class createOrder extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L; 
			
		public createOrder() {
			f = new JFrame();
			
			available = new DefaultListModel<String>();
			shoppingList = new DefaultListModel<String>();
			
			b1 = new JButton("Add products to order");
			b2 = new JButton("Complete order");
			
			title1 = new JLabel("Catalogue");
			title1.setBounds(15, 0, 185, 20);
			title2 = new JLabel("Shoppinglist");
			title2.setBounds(215, 0, 185, 20);
			
			f.add(title1);
			f.add(title2);
			
			for(int i=0; i<catalogue.getNumProducts(); i++) {
				Product x = catalogue.getList()[i];
				String entry = x.getNameProduct();
				if(entry != null) {
					available.addElement(entry);	
				}
			}
			
			list = new JList<String>(available); 
			list.setBounds(15,20,185,335);  
			list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION); // single to test
			
			list2 = new JList<String>(shoppingList);
			list2.setBounds(215,20,185,335);
			
			f.add(list);
			f.add(list2);
			
		    b1.addActionListener(this);
		    b1.setBounds(15,380, 185, 20);
		    f.add(b1, BorderLayout.PAGE_END);
		    
		    b2.addActionListener(this);
		    b2.setBounds(215,380,185, 20);
		    f.add(b2, BorderLayout.PAGE_END);
		    
		    f.setSize(430,480);  
		    f.setLayout(null);  
		    f.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Add products to order")) {
				String x = list.getSelectedValue();
				//for(int i=0; i<x.length; i++) {
					try {
					Product test = catalogue.SearchProduct(x);
					shopList.addProduct(test);
					}catch(ProductNotFoundException error) {}
					shoppingList.addElement(x);
				//}
				
				title3 = new JLabel("Total price: "+ shopList.calculateTotalPrice());
				title3.setBounds(215, 350, 130, 20);
			}
				
			if(e.getActionCommand().equals("Complete order")) {
				for(int i=0; i<shopList.getNumProducts(); i++) {
					if(shopList.getList()[i].getStockProduct()>1) {
						catalogue.removeStock(shopList.getList()[i]);
					}
					else
						JOptionPane.showMessageDialog(null, shopList.getList()[i].getNameProduct() + " is out of stock","Attention", JOptionPane.WARNING_MESSAGE);
					
				}
			JOptionPane.showMessageDialog(null, "The order has been completed");	
			}
		}
	}
}	

