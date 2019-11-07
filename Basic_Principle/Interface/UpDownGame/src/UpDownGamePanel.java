import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UpDownGamePanel extends JPanel {

	// data
	private JPanel leftPanel, rightPanel; // nested �г�

	private JLabel lblTtile, lblMark, lblHint; // left �гο� ��ġ

	private JLabel lblRange, lblCount; // right �гο� ��ġ
	private JButton btnStart, btnInput; // right �гο� ��ġ
	private JTextField txtInput; // right �гο� ��ġ

	private int nRandom, nInput, nCount; // ������, �Է°�, ����Ƚ��
	private int nMin, nMax; // �ּҰ�, �ִ밪

	private ButtonListener ButtonL; // �׼� ������

	// method
	public UpDownGamePanel() {

		// primary �г� ����
		setBackground(Color.white);
		setPreferredSize(new Dimension(430, 320));
		setLayout(null);

		// left�г� ����
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.pink);
		leftPanel.setBounds(10, 10, 200, 300);
		leftPanel.setLayout(null);
		add(leftPanel);

		lblTtile = new JLabel("UP DOWN GAME");
		lblTtile.setFont(new Font("Vedana", Font.BOLD, 22));
		lblTtile.setBounds(10, 10, 180, 45);
		lblTtile.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTtile);

		lblMark = new JLabel(); // ó������ �ִ� ������ ������ "100"���� �׽�Ʈ
		lblMark.setBounds(10, 65, 180, 170);
		lblMark.setFont(new Font("Vedana", Font.BOLD, 100));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblMark);

		lblHint = new JLabel(); // ó������ �ִ� ������ ������ "RIGHT"�� �׽�Ʈ
		lblHint.setBounds(10, 245, 180, 45);
		lblHint.setFont(new Font("Vedana", Font.BOLD + Font.ITALIC, 24));
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblHint);

		// right�г� ����
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.cyan);
		rightPanel.setBounds(220, 10, 200, 300);
		rightPanel.setLayout(null);
		add(rightPanel);

		ButtonL = new ButtonListener();

		btnStart = new JButton("Start");
		btnStart.setBackground(Color.darkGray);
		btnStart.setForeground(Color.white);
		btnStart.setBounds(40, 40, 120, 45);
		btnStart.addActionListener(ButtonL);
		rightPanel.add(btnStart);

		txtInput = new JTextField(); // �ȿ� ���� ������ �ش� ĭ �� ��ŭ ���´� //layout�Ŵ����� null�̸� ��� ����
		txtInput.setBounds(40, 95, 55, 30);
		txtInput.addActionListener(ButtonL);
		rightPanel.add(txtInput);

		btnInput = new JButton("In");
		btnInput.setBounds(100, 95, 60, 30);
		btnInput.setBackground(Color.lightGray);
		btnInput.setForeground(Color.white);
		btnInput.addActionListener(ButtonL);
		rightPanel.add(btnInput);

		lblRange = new JLabel();
		lblRange.setBounds(40, 135, 180, 20);
		lblRange.setFont(new Font("Vedana", Font.PLAIN, 12));
		rightPanel.add(lblRange);

		lblCount = new JLabel();
		lblCount.setBounds(40, 180, 180, 40);
		lblCount.setFont(new Font("Vedana", Font.BOLD + Font.ITALIC, 24));
		rightPanel.add(lblCount);

		// ���� �ʱ�ȭ
		initGame();

	}// constructor

	public void initGame() {
		// left �г� ����
		lblMark.setVisible(false);
		lblHint.setVisible(false);

		// right �г� ����
		btnStart.setEnabled(true);
		btnInput.setEnabled(false);
		txtInput.setEnabled(false);

		//
		nMax = 100;
		nMin = 1;
		lblRange.setText("[ " + nMin + " - " + nMax + " ]");

		nCount = 0;
		lblCount.setText("Count: " + nCount);

	} // initGame()

	public void OnGame() {
		// left �г� ����
		lblMark.setVisible(true);
		lblMark.setText("?");
		lblHint.setVisible(true);
		lblHint.setText("");

		// right �г� ����
		btnStart.setEnabled(false);

		btnInput.setEnabled(true);
		txtInput.setEnabled(true);

		//
		nRandom = (int) (Math.random() * 100) + 1;

	}// OnGame()

	// inner interface
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean bGame = false; // ���� ���� ���� ����

			Object obj = e.getSource();

			// ����
			if (obj == btnStart) {
				OnGame();
			} // if

			// �Է�
			if (obj == txtInput || obj == btnInput) {
				nInput = Integer.parseInt(txtInput.getText());
				txtInput.setText("");

				if (nRandom > nInput) {
					lblHint.setText("UP");
					nMin = nInput + 1;
				} else if (nRandom < nInput) {
					lblHint.setText("DOWN");
					nMax = nInput - 1;
				} else {// nRandom == nInput
					lblHint.setText("RIGHT");
					lblMark.setText(Integer.toString(nInput));

					bGame = true;
				}

				// right �г� ����
				lblRange.setText("[ " + nMin + " - " + nMax + " ]");

				nCount++;
				lblCount.setText("Count: " + nCount);

				// ���� ����� ����� ����
				if (bGame) {
					int result = JOptionPane.showConfirmDialog(rightPanel, "To be Continued?");

					switch (result) {
					case JOptionPane.YES_OPTION:
						initGame();
						break;
					case JOptionPane.NO_OPTION:
						System.exit(0);
						break;
					}// switch
				} // if

			} // if

		}// actionPerformed()

	}// GameButton class

}// UpDownGamePanel class
