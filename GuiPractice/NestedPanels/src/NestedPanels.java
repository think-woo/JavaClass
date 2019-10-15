import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NestedPanels {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Nested Panels");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		// GUI coding start
		JPanel primaryPanel = new JPanel();
		frame.getContentPane().add(primaryPanel);
		primaryPanel.setBackground(Color.white);
		primaryPanel.setPreferredSize(new Dimension(430, 320));

		JPanel leftPanel, rightPanel;

		primaryPanel.setLayout(null);

		leftPanel = new JPanel();
		leftPanel.setBackground(Color.cyan);
		leftPanel.setBounds(10, 10, 200, 300);
		primaryPanel.add(leftPanel);

		rightPanel = new JPanel();
		rightPanel.setBackground(Color.pink);
		rightPanel.setBounds(220, 10, 200, 300);
		primaryPanel.add(rightPanel);
		// GUI coding end

		frame.pack();
		frame.setVisible(true);

	} // main()

} // Nested Class
