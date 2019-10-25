import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Transaction {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Transaction Window");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JPanel primaryPanel = new JPanel();
		frame.getContentPane().add(primaryPanel);
		primaryPanel.setPreferredSize(new Dimension(830, 620));
		primaryPanel.setBackground(Color.white);
		primaryPanel.setLayout(null);

		JPanel leftPanel, rightPanel;

		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 300, 600);
		leftPanel.setBackground(Color.pink);
		leftPanel.setLayout(null);
		primaryPanel.add(leftPanel);

		rightPanel = new JPanel();
		rightPanel.setBounds(320, 10, 500, 600);
		rightPanel.setBackground(Color.cyan);
		rightPanel.setLayout(null);
		primaryPanel.add(rightPanel);

		BankAccount account[] = new BankAccount[3];

		account[0] = new BankAccount("Hong", "010-1234-5678", 369842, 236365, true);
		account[1] = new BankAccount("Hong", "010-1234-5678", 267816, 0, false);
		account[2] = new BankAccount("Kang", "010-5678-1234", 895147, 123456, true);

		JLabel TextLeft[] = new JLabel[3];

		for (int i = 0, j = 1; i < TextLeft.length; i++, j++) {
			TextLeft[i] = new JLabel(account[i].accountInfo());
			TextLeft[i].setBounds(20, 20 * j, 200, 20);
			leftPanel.add(TextLeft[i]);
		}

		JLabel TextRight[] = new JLabel[3];

		for (int i = 0, j = 1; i < TextRight.length; i++, j++) {
			TextRight[i] = new JLabel(account[i].accountInfoSpecific());
			TextRight[i].setBounds(20, 20 * j, 200, 20);
			rightPanel.add(TextRight[i]);
		}

		frame.pack();
		frame.setVisible(true);

	}

} // Transaction class
