import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Images {
	public static void main(String[] args) {

		JFrame frame = new JFrame("My First Nested Panels");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		// GUI coding start
		JPanel primaryPanel = new JPanel();
		frame.getContentPane().add(primaryPanel);
		primaryPanel.setPreferredSize(new Dimension(430, 420));
		primaryPanel.setBackground(Color.white);
		primaryPanel.setLayout(null);

		JPanel leftPanel, rightPanel;

		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 200, 400);
		leftPanel.setBackground(Color.pink);
		primaryPanel.add(leftPanel);

		rightPanel = new JPanel();
		rightPanel.setBounds(220, 10, 200, 400);
		rightPanel.setBackground(Color.cyan);
		primaryPanel.add(rightPanel);

		// �󺧰�ü�� �̿��ؼ� �̹��� ǥ��
		ImageIcon icon = new ImageIcon("images/images.png"); // �����
		JLabel lblIcon1 = new JLabel("V left", icon, SwingConstants.CENTER);
		leftPanel.add(lblIcon1);

		JLabel lblIcon2 = new JLabel("V right", icon, SwingConstants.CENTER);
		lblIcon2.setHorizontalTextPosition(SwingConstants.LEFT);
		leftPanel.add(lblIcon2);

		JLabel lblIcon3 = new JLabel("V Above", icon, SwingConstants.CENTER);
		lblIcon3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIcon3.setVerticalTextPosition(SwingConstants.BOTTOM);
		leftPanel.add(lblIcon3);

		// ���� ũ�⸦ �г� ũ�� ��ŭ �����ؼ�, �̹����� �г��� �߾ӿ� ��ġ��Ű��
		JLabel lblIcon4 = new JLabel("V Center", icon, SwingConstants.CENTER);
		lblIcon4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIcon4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblIcon4.setBounds(10, 10, 180, 380);
		rightPanel.setLayout(null);
		rightPanel.add(lblIcon4);

		// GUI coding end
		frame.pack();
		frame.setVisible(true);

	}// main()
}// Images class
