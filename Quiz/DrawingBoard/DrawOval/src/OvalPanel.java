import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OvalPanel extends JPanel {

	// data

	// 1. ���� �⺻���� ���: ȭ�鿡 �ϳ��� ���� ���� ����
	/*
	 * private Point ptDot; // x,y ��ǥ�� ��Ÿ���� PointŬ����
	 * private int nSize; // ���� ������
	 */

	// 2. ArrayList�� ����ؼ� ��ǥ�� ũ�Ⱑ �ٸ� ���� �����ϴ� ���
	/*
	 * private ArrayList<Point> ptList; // �������� ���� �Ҵ� ����
	 * private ArrayList<Integer> sizeList; // Ŭ������ ��� ����
	 * private Color selectedColor; // �ʱ� ���� ����
	 * private JTextField txtSize; // ũ�� �Է�
	 */

	// 3. ���� ������ ���� Ŭ������ �����ϰ�, �ش� Ŭ������ �迭�� �����ؼ� �� �����ϴ� ���
	private OvalData savedData; // �� ������ ���� ����ü Ŭ����
	private ArrayList<OvalData> drawData; // ����ü ����Ʈ

	private JTextField txtSize; // ũ�� �Է�
	private JButton btnColor; // ���� ����

	// method
	public OvalPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));

		// 1. ���� �⺻���� ���: ȭ�鿡 �ϳ��� ���� ���� ����
		/*
		 * nSize = 40;
		 * ptDot = new Point(); // x,y��ǥ�� 0���� �ʱ�ȭ
		 */

		// 2. ArrayList�� ����ؼ� ��ǥ�� ũ�Ⱑ �ٸ� ���� �����ϴ� ���
		/*
		 * ptList = new ArrayList<Point>();
		 * sizeList = new ArrayList<Integer>();
		 * selectedColor = Color.black;
		 * 
		 * txtSize = new JTextField(6);
		 * add(txtSize);
		 */

		// 3. ���� ������ ���� Ŭ������ �����ϰ�, �ش� Ŭ������ �迭�� �����ؼ� �� �����ϴ� ���
		savedData = new OvalData();
		drawData = new ArrayList<OvalData>();

		txtSize = new JTextField(6);
		add(txtSize);

		btnColor = new JButton("Color");
		btnColor.addActionListener(new ButtonListener());
		add(btnColor);
		//

		addMouseListener(new DrawListener());
	}// constructor

	public void paintComponent(Graphics page) { // �׸��� ���� paintComponent �ȿ����� �׸� �� �ִ�
		super.paintComponent(page);

		// 1. ���� �⺻���� ���
		/*
		 * page.fillOval(ptDot.x - nSize / 2, ptDot.y - nSize / 2, nSize, nSize);
		 */

		// 2. ArrayList�� ����ؼ� ��ǥ�� ũ�Ⱑ �ٸ� ���� �����ϴ� ���
		/*
		 * for (int i = 0; i < ptList.size(); i++) {
		 * page.fillOval(ptList.get(i).x - sizeList.get(i) / 2, ptList.get(i).y - sizeList.get(i) / 2, sizeList.get(i), sizeList.get(i));
		 * }
		 */

		// 3. ���� ������ ���� Ŭ������ �����ϰ�, �ش� Ŭ������ �迭�� �����ؼ� �� �����ϴ� ���
		for (OvalData data : drawData) {
			page.setColor(data.col);
			page.fillOval(data.pt.x - data.nSize / 2, data.pt.y - data.nSize / 2, data.nSize, data.nSize);
		}
		//

	}// paintComponent()

	private class DrawListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			// 1. ���� �⺻���� ���
			/*
			 * ptDot = e.getPoint();
			 * ptDot.x = e.getX();
			 * ptDot.y = e.getY();
			 */

			// 2. ArrayList�� ����ؼ� ��ǥ�� ũ�Ⱑ �ٸ� ���� �����ϴ� ���
			/*
			 * ptList.add(e.getPoint());
			 * sizeList.add(Integer.parseInt(txtSize.getText()));
			 */

			// 3. ���� ������ ���� Ŭ������ �����ϰ�, �ش� Ŭ������ �迭�� �����ؼ� �� �����ϴ� ���
			savedData.pt = e.getPoint();
			if (!txtSize.getText().equals("")) {
				savedData.nSize = Integer.parseInt(txtSize.getText());
			}

			// dataData.add(savedData)�� ���� �ϳ��� �����ȴ�
			/*
			 * savedData�� ���۷��� Ÿ���̱� ������, ��ü�� �ϳ� ���̴�.
			 * drawData�� ����Ǵ� �͵� ���� ����Ǵ� ���� �ƴ϶� ���۷��� Ÿ�Ը� ��� ������ �ȴ�.
			 * (�ݺ����� ���� �۵� ��)
			 */
			drawData.add(new OvalData(savedData));
			//

			repaint(); // ȭ�鿡�� �ٷ� �������ش�
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}// DrawListener class

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object obj = e.getSource();

			if (obj == btnColor) {
				savedData.col = JColorChooser.showDialog(null, "Color Chooser", savedData.col);
			} // if

		}// actionPerformed()

	}// ButtonListener class

}// DrawPanel class
