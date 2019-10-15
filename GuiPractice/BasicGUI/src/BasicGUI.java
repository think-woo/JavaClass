import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BasicGUI {

	public static void main(String[] args) {

		JFrame frame = new JFrame("My First GUI"); // frame 생성(=window), frame의 제목 정하기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 정상 종료가 될 수 있도록 X표시를 설정하는 것

		// GUI coding: start
		JPanel primaryPanel = new JPanel(); // panel 생성
		frame.getContentPane().add(primaryPanel); // heavy weight는 권한을 얻어야 한다, frame에 panel 추가
		// 모든 container에는 add()가 있어서, 다른 component나 container를 담을 수 있다.

		primaryPanel.setPreferredSize(new Dimension(400, 400)); // 패널 크기
		primaryPanel.setBackground(new Color(255, 122, 122)); // 배경색

		JLabel lblText = new JLabel(); // lbl은 접두사 //안에 문자를 넣으면, 생성할 때 문자열 생성
		lblText.setText("Hello, world!");
		lblText.setFont(new Font("VErdana", Font.BOLD + Font.ITALIC, 20));
		lblText.setForeground(Color.red);
		primaryPanel.add(lblText);

		JLabel lblText2 = new JLabel("Sejong University");
		lblText2.setForeground(Color.blue);
		lblText2.setFont(new Font("Godlic", Font.BOLD + Font.ITALIC, 20));
		primaryPanel.add(lblText2);

		primaryPanel.setLayout(null);
		// 모든 컨테이너는 layout manager라는 배치 관리자가 있다
		// 기본 설정은 flow layout. 중앙에 배치, 넘어가면 다음 줄로
		// 그 외에도 다양한 layout이 존재한다

		lblText.setBounds(200, 100, 400, 30);
		lblText2.setBounds(200, 130, 400, 30);
		// 관리자를 null하면 컴포넌트의 position과 size를 정해줘야 한다. 아니면 화면이 안 나타난다
		// setBounds보다 layout이 우선순위다

		// GUI coding: end
		frame.pack(); // frame에 들어간 component 객체들의 메모리 할당을 정리해준다
		//

		frame.setVisible(true); // 화면에 생성

	} // main()

} // MyFirstGUI class
