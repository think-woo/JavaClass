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

	// 1. 가장 기본적인 방법: 화면에 하나의 원만 생성 가능
	/*
	 * private Point ptDot; // x,y 좌표를 나타내는 Point클래스
	 * private int nSize; // 원의 사이즈
	 */

	// 2. ArrayList를 사용해서 좌표와 크기가 다른 원을 생성하는 방법
	/*
	 * private ArrayList<Point> ptList; // 무한으로 동적 할당 가능
	 * private ArrayList<Integer> sizeList; // 클래스만 사용 가능
	 * private Color selectedColor; // 초기 색상 설정
	 * private JTextField txtSize; // 크기 입력
	 */

	// 3. 원의 정보를 가진 클래스를 설정하고, 해당 클래스를 배열에 저장해서 원 생성하는 방법
	private OvalData savedData; // 원 정보를 담을 구조체 클래스
	private ArrayList<OvalData> drawData; // 구조체 리스트

	private JTextField txtSize; // 크기 입력
	private JButton btnColor; // 색상 선택

	// method
	public OvalPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));

		// 1. 가장 기본적인 방법: 화면에 하나의 원만 생성 가능
		/*
		 * nSize = 40;
		 * ptDot = new Point(); // x,y좌표는 0으로 초기화
		 */

		// 2. ArrayList를 사용해서 좌표와 크기가 다른 원을 생성하는 방법
		/*
		 * ptList = new ArrayList<Point>();
		 * sizeList = new ArrayList<Integer>();
		 * selectedColor = Color.black;
		 * 
		 * txtSize = new JTextField(6);
		 * add(txtSize);
		 */

		// 3. 원의 정보를 가진 클래스를 설정하고, 해당 클래스를 배열에 저장해서 원 생성하는 방법
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

	public void paintComponent(Graphics page) { // 그림은 오직 paintComponent 안에서만 그릴 수 있다
		super.paintComponent(page);

		// 1. 가장 기본적인 방법
		/*
		 * page.fillOval(ptDot.x - nSize / 2, ptDot.y - nSize / 2, nSize, nSize);
		 */

		// 2. ArrayList를 사용해서 좌표와 크기가 다른 원을 생성하는 방법
		/*
		 * for (int i = 0; i < ptList.size(); i++) {
		 * page.fillOval(ptList.get(i).x - sizeList.get(i) / 2, ptList.get(i).y - sizeList.get(i) / 2, sizeList.get(i), sizeList.get(i));
		 * }
		 */

		// 3. 원의 정보를 가진 클래스를 설정하고, 해당 클래스를 배열에 저장해서 원 생성하는 방법
		for (OvalData data : drawData) {
			page.setColor(data.col);
			page.fillOval(data.pt.x - data.nSize / 2, data.pt.y - data.nSize / 2, data.nSize, data.nSize);
		}
		//

	}// paintComponent()

	private class DrawListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			// 1. 가장 기본적인 방법
			/*
			 * ptDot = e.getPoint();
			 * ptDot.x = e.getX();
			 * ptDot.y = e.getY();
			 */

			// 2. ArrayList를 사용해서 좌표와 크기가 다른 원을 생성하는 방법
			/*
			 * ptList.add(e.getPoint());
			 * sizeList.add(Integer.parseInt(txtSize.getText()));
			 */

			// 3. 원의 정보를 가진 클래스를 설정하고, 해당 클래스를 배열에 저장해서 원 생성하는 방법
			savedData.pt = e.getPoint();
			if (!txtSize.getText().equals("")) {
				savedData.nSize = Integer.parseInt(txtSize.getText());
			}

			// dataData.add(savedData)는 원이 하나만 생성된다
			/*
			 * savedData는 레퍼런스 타입이기 때문에, 실체는 하나 뿐이다.
			 * drawData에 저장되는 것도 값이 저장되는 것이 아니라 레퍼런스 타입만 계속 저장이 된다.
			 * (반복문은 정상 작동 중)
			 */
			drawData.add(new OvalData(savedData));
			//

			repaint(); // 화면에서 바로 갱신해준다
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
