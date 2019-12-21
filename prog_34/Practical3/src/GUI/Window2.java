package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window2{
	
	FrameMenuClient b;
	Boolean next;
	
	public Window2() {
		b = new FrameMenuClient();
		
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	class FrameMenuClient extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public FrameMenuClient() {
			
			setTitle("MENU CLIENT");
			
			setSize(450, 250);
					
			add(new PanelMenuClient());
			
			Toolkit miSistema = Toolkit.getDefaultToolkit();
			
			Image miIcono = miSistema.getImage("user.png");
			
			setIconImage(miIcono);
			
			setResizable(false);
			
			setLocationRelativeTo(null);
					
			setVisible(true);
			
		}
	}

	class PanelMenuClient extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		JButton option1, option2, option3;

		public PanelMenuClient() {
			
		//setLayout(new GridLayout(4,0));
		setLayout(null);
		
		JLabel text = new JLabel("\tChoose an option: ");
		text.setBounds(15, 10, 400, 50);
		add(text);
		
		option1 = new JButton("Search Product");
		option1.setBounds(15, 50, 400, 40);
		option1.addActionListener(new ObtainAnswerClient());
		add(option1);
		
		option2 = new JButton("Check Command");
		option2.setBounds(15, 100, 400, 40);
		option2.addActionListener(new ObtainAnswerClient());
		add(option2);
		
		option3 = new JButton("Exit");
		option3.setBounds(15, 150, 400, 40);
		option3.addActionListener(new ObtainAnswerClient());
		add(option3);
			

		}
		
		private class ObtainAnswerClient implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==option1) {	
					
				}else if(e.getSource()==option2) {
					
				}else {
				
					int answer = JOptionPane.showConfirmDialog(null, "¿Are you sure you want lo leave?", "Confirmation", JOptionPane.YES_NO_OPTION);
				      if (answer == 0)
				         System.exit(0);
				
				}
				
				
			}
				
		}
		
	}
}




