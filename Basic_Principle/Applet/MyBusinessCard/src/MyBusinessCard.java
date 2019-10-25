import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

public class MyBusinessCard extends JApplet {
	public void paint(Graphics page) {

		Color sejong_C = new Color(128, 0, 0);

		page.drawRect(0, 0, 400, 150); // frame

		page.setColor(sejong_C);

		page.drawRect(10, 10, 20, 20); // decoration
		page.drawRect(15, 15, 20, 20);

		page.setFont(new Font("Verdana", Font.BOLD, 20));
		page.drawString("Sejong University", 45, 30); // university

		page.setFont(new Font("Verdana", Font.BOLD, 15));
		page.drawString("Dept of Media Communication", 150, 50); // dept

		page.setFont(new Font("Verdana", Font.PLAIN, 45));
		page.drawString("Lee Myung Woo", 25, 105); // name

	} // paint()

} // MyBusinessCard Class
