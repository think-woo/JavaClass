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
	private JPanel leftPanel, rightPanel; // nested 패널

	private JLabel lblTtile, lblMark, lblHint; // left 패널에 위치

	private JLabel lblRange, lblCount; // right 패널에 위치
	private JButton btnStart, btnInput; // right 패널에 위치
	private JTextField txtInput; // right 패널에 위치

	private int nRandom, nInput, nCount; // 랜덤값, 입력값, 도전횟수
	private int nMin, nMax; // 최소값, 최대값

	private ButtonListener ButtonL; // 액션 리스너

	// method
	public UpDownGamePanel() {

		// primary 패널 설정
		setBackground(Color.white);
		setPreferredSize(new Dimension(430, 320));
		setLayout(null);

		// left패널 설정
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

		lblMark = new JLabel(); // 처음에는 최대 길이의 문자인 "100"으로 테스트
		lblMark.setBounds(10, 65, 180, 170);
		lblMark.setFont(new Font("Vedana", Font.BOLD, 100));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblMark);

		lblHint = new JLabel(); // 처음에는 최대 길이의 문자인 "RIGHT"로 테스트
		lblHint.setBounds(10, 245, 180, 45);
		lblHint.setFont(new Font("Vedana", Font.BOLD + Font.ITALIC, 24));
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblHint);

		// right패널 설정
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

		txtInput = new JTextField(); // 안에 숫자 넣으면 해당 칸 수 만큼 나온다 //layout매니저가 null이면 상관 없다
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

		// 게임 초기화
		initGame();

	}// constructor

	public void initGame() {
		// left 패널 설정
		lblMark.setVisible(false);
		lblHint.setVisible(false);

		// right 패널 설정
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
		// left 패널 설정
		lblMark.setVisible(true);
		lblMark.setText("?");
		lblHint.setVisible(true);
		lblHint.setText("");

		// right 패널 설정
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
			boolean bGame = false; // 게임 종료 상항 제어

			Object obj = e.getSource();

			// 시작
			if (obj == btnStart) {
				OnGame();
			} // if

			// 입력
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

				// right 패널 설정
				lblRange.setText("[ " + nMin + " - " + nMax + " ]");

				nCount++;
				lblCount.setText("Count: " + nCount);

				// 게임 종료시 재시작 여부
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
