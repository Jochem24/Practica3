package GUI;

import javax.swing.*;
import java.awt.*;
import Data.*;

public class Test extends JFrame{
	private static final long serialVersionUID=1L;

	public static void main(String[] args) {
		ListOrders order = new ListOrders(20);
		new WindowCheckOrders("title");
	}

}
