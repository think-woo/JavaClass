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
	private LineData nowData, savedData; // 현재 좌표와 저장할 좌표 //드래그 기능 때문에 분리
	private ArrayList<LineData> dataList;

	private JTextField txtStroke;

	private LineListener lineL;

	// method
	public LinePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));

		/*
		 * //1. 선 1개 그리기
		 * pt1 = new Point();
		 * pt2 = new Point();
		 * 
		 * /*
		 * //getPoint()가 Point객체를 반환하기 때문에 생성할 필요는 없다.
		 * //그러나, 여기서는 처음에는 무조건 회출을 해야해서 예외를 일으키므로 일단 생성한다.
		 * pt1 = null;
		 * pt2 = null;
		 */

		// 2. 선 여러 개 그리고, 굵기 설정
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
		super.paintComponent(page); // 부모에게 paintComponent에 대한 권한을 받아오는 것 //권한을 받지 않으면 정상작동하지 않는다

		/*
		 * //1. 선 1개 그리기
		 * page.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
		 */

		// 2. 선 여러 개 그리고, 굵기 설정
		Graphics2D page2 = (Graphics2D) page;

		page2.setStroke(nowData.stroke);
		page.drawLine(nowData.pt1.x, nowData.pt1.y, nowData.pt2.x, nowData.pt2.y);

		for (LineData data : dataList) {
			page2.setStroke(data.stroke);
			page.drawLine(data.pt1.x, data.pt1.y, data.pt2.x, data.pt2.y);
		}

	}// paintComponent()

	private class LineListener implements MouseListener, MouseMotionListener { // 마우스 리스너는 같이 쓴다

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {

			/*
			 * //1. 선 1개 그리기
			 * pt1 = e.getPoint();
			 */

			// 2. 선 여러 개 그리고, 굵기 설정
			nowData.pt1 = e.getPoint();
			savedData.pt1 = e.getPoint();

			int stroke = Integer.parseInt(txtStroke.getText());

			nowData.stroke = new BasicStroke(stroke);
			savedData.stroke = new BasicStroke(stroke);
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			/*
			 * //1. 선 1개 그리기
			 * pt2 = e.getPoint();
			 */

			// 2. 선 여러 개 그리고, 굵기 설정
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

			// 리스너의 범위는 패널 안이나, 마우스의 커서의 드래그 모션이 범위를 벗어나도 정상 작동한다. >> 마우스 캡처링
			// 자바의 2D그래픽 엔진은 마우스 캡처링을 자동으로 지원.
			// 그러나, 모든 그래피 엔진이 망스 캡처링을 자동으로 지원하는 것은 아니다.

			/*
			 * //1. 선 1개 그리기
			 * pt2 = e.getPoint();
			 */

			// 2. 선 여러 개 그리고, 굵기 설정
			nowData.pt2 = e.getPoint();

			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {}

	}// LineListener class

}// LinePanel class
