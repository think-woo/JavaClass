import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BasicGUI {

	public static void main(String[] args) {

		JFrame frame = new JFrame("My First GUI"); // frame ����(=window), frame�� ���� ���ϱ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ���ᰡ �� �� �ֵ��� Xǥ�ø� �����ϴ� ��

		// GUI coding: start
		JPanel primaryPanel = new JPanel(); // panel ����
		frame.getContentPane().add(primaryPanel); // heavy weight�� ������ ���� �Ѵ�, frame�� panel �߰�
		// ��� container���� add()�� �־, �ٸ� component�� container�� ���� �� �ִ�.

		primaryPanel.setPreferredSize(new Dimension(400, 400)); // �г� ũ��
		primaryPanel.setBackground(new Color(255, 122, 122)); // ����

		JLabel lblText = new JLabel(); // lbl�� ���λ� //�ȿ� ���ڸ� ������, ������ �� ���ڿ� ����
		lblText.setText("Hello, world!");
		lblText.setFont(new Font("VErdana", Font.BOLD + Font.ITALIC, 20));
		lblText.setForeground(Color.red);
		primaryPanel.add(lblText);

		JLabel lblText2 = new JLabel("Sejong University");
		lblText2.setForeground(Color.blue);
		lblText2.setFont(new Font("Godlic", Font.BOLD + Font.ITALIC, 20));
		primaryPanel.add(lblText2);

		primaryPanel.setLayout(null);
		// ��� �����̳ʴ� layout manager��� ��ġ �����ڰ� �ִ�
		// �⺻ ������ flow layout. �߾ӿ� ��ġ, �Ѿ�� ���� �ٷ�
		// �� �ܿ��� �پ��� layout�� �����Ѵ�

		lblText.setBounds(200, 100, 400, 30);
		lblText2.setBounds(200, 130, 400, 30);
		// �����ڸ� null�ϸ� ������Ʈ�� position�� size�� ������� �Ѵ�. �ƴϸ� ȭ���� �� ��Ÿ����
		// setBounds���� layout�� �켱������

		// GUI coding: end
		frame.pack(); // frame�� �� component ��ü���� �޸� �Ҵ��� �������ش�
		//

		frame.setVisible(true); // ȭ�鿡 ����

	} // main()

} // MyFirstGUI class
