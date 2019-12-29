import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//간단한 목록 추가 프로그램
public class SimpleList {

	static class View extends JFrame {

		public View() {

			setDefaultCloseOperation(EXIT_ON_CLOSE);

			JPanel primary = new JPanel();
			getContentPane().add(primary);

			JTextField	txt		= new JTextField(10);
			JTextArea	area	= new JTextArea(10, 10);

			primary.add(txt);
			primary.add(area);

			txt.addKeyListener(new KeyAdapter() {
				//Listener가 아닌 Adapter를 사용하면 나머지 메소드를 오버라이딩하지 않아도 된다
				//단, 인터페이스가 아닌 상속이기 때문에 순수 이벤트핸들링 용도에 가장 적합하다
				//KeyListener에서는 keyTyped, keyPressed

				@Override
				public void keyReleased(KeyEvent e) {

					int key = e.getKeyCode();

					if (key == KeyEvent.VK_ENTER) {
						String str = txt.getText();
						area.setText(area.getText() + str + "\n");
						txt.setText("");
					} //if
				}//keyReleased

			});

			setSize(100, 400);
			setVisible(true);

		}//constructor

	}//View class

	public static void main(String[] args) {

		new View();

	}//main()

}//SimpleList class
