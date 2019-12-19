package GUI;

//Java Program  to create a vertical  
//JSplitPane to separate two text areas 
import javax.swing.event.*; 
import javax.swing.*; 


class OrderScreenGUI extends JFrame { 

	public OrderScreenGUI() {
		JFrame f = new JFrame("Frame");
		JPanel p1 = new JPanel();
		JPanel p = new JPanel();
		
	    JTextArea t1 = new JTextArea(20,20); 
	    JTextArea t2 = new JTextArea(20, 20); 
	    
	    t1.setText("this is first text area"); 
	    t2.setText("this is second text area"); 
	    
	     // create a splitpane 
	     JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p); 

	     // set Orientation for slider 
	     sl.setOrientation(SwingConstants.VERTICAL); 

	     // add panel 
	     add(sl); 
	     p1.add(t1); p.add(t2);

	     // set the size of frame 
	     setSize(600, 600); 
	     setVisible(true);	
	}
}
