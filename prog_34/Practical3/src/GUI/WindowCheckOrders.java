package GUI;

import java.awt.*;
import javax.swing.*;
import Data.*;

public class WindowCheckOrders extends JFrame {
	private JPanel buttonsPanel = new JPanel();
	private JList list = new JList();
	private JButton b1 = new JButton();
	private JButton b2 = new JButton("Exit");
	//private JLabel l1 = new Jlabel();
	
	public WindowCheckOrders(String title) {
		super(title);
		Container myContainer=getContentPane();
		myContainer.setLayout(new BorderLayout());
		
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.add(b1);
		buttonsPanel.add(b2);
		
		//list.setListData(order);
		//list.setVisibleRowCount(5);
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		myContainer.add(buttonsPanel, BorderLayout.SOUTH);
		myContainer.add(list);
		setVisible(true);
		
		String answer;
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this order?","Confirmation",JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION)
			answer = "Order deleted succesfully,";
		else
			answer = "Order NOT deleted.";
		}
		
}
	

