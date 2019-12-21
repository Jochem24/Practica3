package GUI;

//Java Program  to create a vertical  
//JSplitPane to separate two text areas 
import javax.swing.event.*; 
import javax.swing.*; 

class solve extends JFrame { 

	public solve() {
		JFrame f = new JFrame("Frame");
		solve s = new solve();
		JPanel p1 = new JPanel();
		JPanel p = new JPanel();
		
	    JTextArea t1 = new JTextArea(10, 10); 
	    JTextArea t2 = new JTextArea(10, 10); 

	    t1.setText("this is first text area"); 
	    t2.setText("this is second text area"); 
	    
	     // create a splitpane 
	     JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p); 

	     // set Orientation for slider 
	     sl.setOrientation(SwingConstants.VERTICAL); 

	     // add panel 
	     f.add(sl); 

	     // set the size of frame 
	     f.setSize(300, 300); 

	    // f.show(); 
		
	}

 public static void main(String[] args) 
 { 

     // add text area to panel 
   //  p1.add(t1); 
   //  p.add(t2); 


 } 
} 
