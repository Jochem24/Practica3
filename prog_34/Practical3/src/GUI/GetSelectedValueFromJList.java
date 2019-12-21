package GUI;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class GetSelectedValueFromJList
        extends JFrame implements ActionListener {

    private JList list;
    private JButton button;

    public GetSelectedValueFromJList() {
        String[] nameList = {
            "Value 1", "Value 2", "Value 3", "Value 4", "Value 5"
        };
        list = new JList(nameList);
        list.setSelectedIndex(2);

        button = new JButton("Check");
        button.addActionListener(this);

        add(list);
        add(button, BorderLayout.PAGE_END);

        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check")) {
            int index = list.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = (String) list.getSelectedValue();
            System.out.println("Value Selected: " + s);
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new GetSelectedValueFromJList().setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}