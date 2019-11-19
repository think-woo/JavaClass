import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class LinePanel extends JPanel {

	// data
	private Point pt1, pt2;
	private LineData nowData, savedData; // ���� ��ǥ�� ������ ��ǥ //�巡�� ��� ������ �и�
	private ArrayList<LineData> dataList;

	private JTextField txtStroke;

	private LineListener lineL;

	// method
	public LinePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));

		/*
		 * //1. �� 1�� �׸���
		 * pt1 = new Point();
		 * pt2 = new Point();
		 * 
		 * /*
		 * //getPoint()�� Point��ü�� ��ȯ�ϱ� ������ ������ �ʿ�� ����.
		 * //�׷���, ���⼭�� ó������ ������ ȸ���� �ؾ��ؼ� ���ܸ� ����Ű�Ƿ� �ϴ� �����Ѵ�.
		 * pt1 = null;
		 * pt2 = null;
		 */

		// 2. �� ���� �� �׸���, ���� ����
		nowData = new LineData();
		savedData = new LineData();
		dataList = new ArrayList<LineData>();

		txtStroke = new JTextField(6);
		add(txtStroke);

		lineL = new LineListener();

		addMouseListener(lineL);
		addMouseMotionListener(lineL);

	}// constructor

	public void paintComponent(Graphics page) {
		super.paintComponent(page); // �θ𿡰� paintComponent�� ���� ������ �޾ƿ��� �� //������ ���� ������ �����۵����� �ʴ´�

		/*
		 * //1. �� 1�� �׸���
		 * page.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
		 */

		// 2. �� ���� �� �׸���, ���� ����
		Graphics2D page2 = (Graphics2D) page;

		page2.setStroke(nowData.stroke);
		page.drawLine(nowData.pt1.x, nowData.pt1.y, nowData.pt2.x, nowData.pt2.y);

		for (LineData data : dataList) {
			page2.setStroke(data.stroke);
			page.drawLine(data.pt1.x, data.pt1.y, data.pt2.x, data.pt2.y);
		}

	}// paintComponent()

	private class LineListener implements MouseListener, MouseMotionListener { // ���콺 �����ʴ� ���� ����

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {

			/*
			 * //1. �� 1�� �׸���
			 * pt1 = e.getPoint();
			 */

			// 2. �� ���� �� �׸���, ���� ����
			nowData.pt1 = e.getPoint();
			savedData.pt1 = e.getPoint();

			int stroke = Integer.parseInt(txtStroke.getText());

			nowData.stroke = new BasicStroke(stroke);
			savedData.stroke = new BasicStroke(stroke);
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			/*
			 * //1. �� 1�� �׸���
			 * pt2 = e.getPoint();
			 */

			// 2. �� ���� �� �׸���, ���� ����
			nowData.pt2 = e.getPoint();
			savedData.pt2 = e.getPoint();
			dataList.add(new LineData(savedData));

			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mouseDragged(MouseEvent e) {

			// �������� ������ �г� ���̳�, ���콺�� Ŀ���� �巡�� ����� ������ ����� ���� �۵��Ѵ�. >> ���콺 ĸó��
			// �ڹ��� 2D�׷��� ������ ���콺 ĸó���� �ڵ����� ����.
			// �׷���, ��� �׷��� ������ ���� ĸó���� �ڵ����� �����ϴ� ���� �ƴϴ�.

			/*
			 * //1. �� 1�� �׸���
			 * pt2 = e.getPoint();
			 */

			// 2. �� ���� �� �׸���, ���� ����
			nowData.pt2 = e.getPoint();

			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {}

	}// LineListener class

}// LinePanel class
