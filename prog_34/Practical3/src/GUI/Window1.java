package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.ListClient;


public class Window1{
	
	FrameLogIn mimarco;

	static ListClient list;
	public Window1(ListClient a) {
		mimarco = new FrameLogIn();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
		list = a;
	}
	
	
	public static ListClient getList() {
		return list;
	}

	class FrameLogIn extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public FrameLogIn() {
			
			setTitle("LOG IN");
			
			setSize(500, 100);
					
			add(new PanelLogIn());
			
			Toolkit miSistema = Toolkit.getDefaultToolkit();
			
			Image miIcono = miSistema.getImage("user.png");
			
			setIconImage(miIcono);
			
			setResizable(false);
			
			setLocationRelativeTo(null);
						
			//dispose();
			
		}
		
		class PanelLogIn extends JPanel {
			
			private static final long serialVersionUID = 1L;
			JTextField cuadrotexto;
			JButton button_accept, button_cancel;
			
			public PanelLogIn() {
			
			JLabel text = new JLabel("\tIntroduce NIF: ");
				
			add(text);
			
			cuadrotexto = new JTextField(20);
				
			add(cuadrotexto);
			
			button_accept = new JButton("Accept");
			
			button_accept.addActionListener(new ObtainClient());
			
			add(button_accept);
			
			button_cancel = new JButton("Cancel");
			
			button_cancel.addActionListener(new ObtainClient());
			
			add(button_cancel);
				

			}
			
			private class ObtainClient implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					int identifier=0;
					
					if(e.getSource()==button_cancel) {
						int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want lo leave?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
					      if (answer == 0)
					         System.exit(0);
					}else {
						try {
							identifier = Integer.parseInt(cuadrotexto.getText());
							
							//if((e.getSource()==button_accept)&&(Window1.getList().checkClient(identifier))) {	
							if((e.getSource()==button_accept)) {	
								mimarco.dispose();
								Window2 MenuClient = new Window2();
								
								
							}else if((e.getSource()==button_accept)&&(!Window1.getList().checkClient(identifier))) {
								JOptionPane.showMessageDialog (null, "NIF Not Found " , "ERROR" , JOptionPane.ERROR_MESSAGE);
							}
							
							}catch(NumberFormatException a) {
								JOptionPane.showMessageDialog (null, "Invalid NIF " , "ERROR" , JOptionPane.ERROR_MESSAGE);
							}
						
					}
					
				}
					
			}
			
		}
	}

}





