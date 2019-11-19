import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class RectPanel extends JPanel {

	// data
	private RectData nowData, savedData;
	private ArrayList<RectData> dataList;
	private JCheckBox chkFill;

	private RectListener rectL;

	// method
	public RectPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));

		nowData = new RectData();
		savedData = new RectData();

		dataList = new ArrayList<RectData>();

		chkFill = new JCheckBox("Fill");
		chkFill.setFont(new Font("Vedrana", Font.BOLD, 20));
		add(chkFill);

		rectL = new RectListener();
		addMouseListener(rectL);
		addMouseMotionListener(rectL);

	}// constructor

	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		paintRect(page, nowData.pt1, nowData.pt2, nowData.bFill);

		for (RectData data : dataList) {
			paintRect(page, data.pt1, data.pt2, data.bFill);
		}

	}// paintComponent()

	public void paintRect(Graphics page, Point pt1, Point pt2, boolean fill) {
		int x, y, width, height;
		x = y = width = height = 0;

		// 사가가형의 시작은 좌측상단, 너비와 높이는 큰 좌표에서 작은 자표를 빼는 것
		if (pt1.x < pt2.x && pt1.y < pt2.y) {
			x = pt1.x;
			y = pt1.y;
			width = (pt2.x - pt1.x);
			height = (pt2.y - pt1.y);
		} else if (pt1.x > pt2.x && pt1.y > pt2.y) {
			x = pt2.x;
			y = pt2.y;
			width = (pt1.x - pt2.x);
			height = (pt1.y - pt2.y);
		} else if (pt1.x < pt2.x && pt1.y > pt2.y) {
			x = pt1.x;
			y = pt2.y;
			width = (pt2.x - pt1.x);
			height = (pt1.y - pt2.y);
		} else if (pt1.x > pt2.x && pt1.y < pt2.y) {
			x = pt2.x;
			y = pt1.y;
			width = (pt1.x - pt2.x);
			height = (pt2.y - pt1.y);
		}

		if (fill)
			page.fillRect(x, y, width, height);
		else
			page.drawRect(x, y, width, height);

	}// paintRect()

	private class RectListener implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			nowData.pt1 = e.getPoint();
			savedData.pt1 = e.getPoint();

			nowData.bFill = chkFill.isSelected();
			savedData.bFill = chkFill.isSelected();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			nowData.pt2 = e.getPoint();
			savedData.pt2 = e.getPoint();

			dataList.add(new RectData(savedData));

			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			nowData.pt2 = e.getPoint();

			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}// RectListener

}// RectPanel class
