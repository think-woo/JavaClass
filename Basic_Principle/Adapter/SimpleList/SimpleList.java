import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//������ ��� �߰� ���α׷�
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
				//Listener�� �ƴ� Adapter�� ����ϸ� ������ �޼ҵ带 �������̵����� �ʾƵ� �ȴ�
				//��, �������̽��� �ƴ� ����̱� ������ ���� �̺�Ʈ�ڵ鸵 �뵵�� ���� �����ϴ�
				//KeyListener������ keyTyped, keyPressed

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
