import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountPanel extends JPanel {

	// data
	private JButton _btnInc, _btnDec;
	private JLabel _lblCount;
	private int _nCount;
	// 2. 리스너 객체를 선언한다
	private CountButtonListener countButtonL;

	// method
	public CountPanel() {

		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 250));
		setLayout(null);

		// 2. 리스너 객체를 생성한다
		countButtonL = new CountButtonListener();

		_btnInc = new JButton("Increment");
		_btnInc.setBounds(30, 30, 250, 100);
		// 3.인터페이스 객체를 사용할 모든 컴포넌트에 객체를 추가한다
		_btnInc.addActionListener(countButtonL);
		add(_btnInc);

		_btnDec = new JButton("Decrement");
		_btnDec.setBounds(320, 30, 250, 100);
		// 3.인터페이스 객체를 사용할 모든 컴포넌트에 객체를 추가한다
		_btnDec.addActionListener(countButtonL);
		add(_btnDec);

		_nCount = 0;

		_lblCount = new JLabel("Count: " + _nCount);
		_lblCount.setForeground(Color.black);
		_lblCount.setFont(new Font("Verdana", Font.BOLD, 30));
		_lblCount.setBounds(230, 160, 200, 45);
		add(_lblCount);

	}// constructor

	// "inner class" 구현 방법
	// 1. 클래스 내부에 리스너 클래스를 만든다
	// 내부에서만 사용하는 것이므로 private
	private class CountButtonListener implements ActionListener { // 인터페이스는 implements

		@Override
		public void actionPerformed(ActionEvent e) { // 이벤트가 발생하면 ActionEvent 객체에 각종 정보가 넘어온다
			// 4. 이벤트 핸들러(=메소드)를 구현

			// getSource()는 이벤트가 발생한 컴포넌트를 받아온다
			// 최상위 클래스 Object이므로 컴포넌트 종류에 상관없이 비교 가능
			Object obj = e.getSource();

			if (obj == _btnInc) {
				_nCount++;
			}
			if (obj == _btnDec) {
				_nCount--;
			}

			if (_nCount > 0)
				_lblCount.setForeground(Color.cyan);
			else if (_nCount < 0)
				_lblCount.setForeground(Color.pink);
			else
				/* _nCount = 0 */ _lblCount.setForeground(Color.black);

			_lblCount.setText("Count: " + _nCount);
		}// actionPerformed

	}// CountButtonListener

} // CountPanel class