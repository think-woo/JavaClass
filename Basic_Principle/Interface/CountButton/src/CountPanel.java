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
	// 2. ������ ��ü�� �����Ѵ�
	private CountButtonListener countButtonL;

	// method
	public CountPanel() {

		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 250));
		setLayout(null);

		// 2. ������ ��ü�� �����Ѵ�
		countButtonL = new CountButtonListener();

		_btnInc = new JButton("Increment");
		_btnInc.setBounds(30, 30, 250, 100);
		// 3.�������̽� ��ü�� ����� ��� ������Ʈ�� ��ü�� �߰��Ѵ�
		_btnInc.addActionListener(countButtonL);
		add(_btnInc);

		_btnDec = new JButton("Decrement");
		_btnDec.setBounds(320, 30, 250, 100);
		// 3.�������̽� ��ü�� ����� ��� ������Ʈ�� ��ü�� �߰��Ѵ�
		_btnDec.addActionListener(countButtonL);
		add(_btnDec);

		_nCount = 0;

		_lblCount = new JLabel("Count: " + _nCount);
		_lblCount.setForeground(Color.black);
		_lblCount.setFont(new Font("Verdana", Font.BOLD, 30));
		_lblCount.setBounds(230, 160, 200, 45);
		add(_lblCount);

	}// constructor

	// "inner class" ���� ���
	// 1. Ŭ���� ���ο� ������ Ŭ������ �����
	// ���ο����� ����ϴ� ���̹Ƿ� private
	private class CountButtonListener implements ActionListener { // �������̽��� implements

		@Override
		public void actionPerformed(ActionEvent e) { // �̺�Ʈ�� �߻��ϸ� ActionEvent ��ü�� ���� ������ �Ѿ�´�
			// 4. �̺�Ʈ �ڵ鷯(=�޼ҵ�)�� ����

			// getSource()�� �̺�Ʈ�� �߻��� ������Ʈ�� �޾ƿ´�
			// �ֻ��� Ŭ���� Object�̹Ƿ� ������Ʈ ������ ������� �� ����
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