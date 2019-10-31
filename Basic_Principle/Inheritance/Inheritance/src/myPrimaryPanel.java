import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class myPrimaryPanel extends JPanel { // 상속할 때는 extends

	private static final String Graphics2D = null;
	// data
	JLabel _lbl1, _lbl2;

	// method
	public myPrimaryPanel(String arg1, String arg2) {

		setBackground(Color.white);
		setPreferredSize(new Dimension(300, 250));
		setLayout(null);

		_lbl1 = new JLabel(arg1);
		_lbl1.setBounds(20, 20, 260, 50);
		initSettingLabel(_lbl1);
		add(_lbl1);

		_lbl2 = new JLabel(arg2);
		_lbl2.setBounds(20, 90, 260, 50);
		initSettingLabel(_lbl2);
		add(_lbl2);

	}// constructor

	private void initSettingLabel(JLabel lbl) {
		Font fnt = new Font("Verdana", Font.BOLD, 20);

		lbl.setFont(fnt);
		lbl.setForeground(Color.pink);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);

	}// JLable 초기 설정

	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		page.setColor(Color.blue);
		Graphics2D page2 = (Graphics2D) page;
		page2.setStroke(new BasicStroke(10));
		page.drawLine(20, 160, 280, 160);

		page.setColor(Color.cyan);
		page.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
		page.drawString("Work Well!!", 60, 200);

	}// paintComponent

} // myPrimaryPanel class
