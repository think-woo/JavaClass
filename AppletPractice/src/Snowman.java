import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Snowman extends JApplet {
	public void paint(Graphics page) {

		final int Start_X = 200;
		final int Start_Y = 100;

		setBackground(Color.cyan);

		page.setColor(Color.yellow);
		page.fillOval(-50, -50, 100, 100); // sun

		page.setColor(new Color(64, 0, 0));
		page.fillRect(0, Start_Y + 180, Start_X + 100, 50); // ground

		page.setColor(new Color(128, 255, 255));
		page.fillOval(Start_X - 25, Start_Y, 50, 50); // head
		page.fillOval(Start_X - 50, Start_Y + 40, 100, 75); // upper torso
		page.fillOval(Start_X - 75, Start_Y + 100, 150, 100); // lower torso

		page.setColor(Color.black);
		page.drawLine(Start_X - 25, Start_Y + 5, Start_X + 25, Start_Y + 5); // brim of hat
		page.fillRect(Start_X - 20, Start_Y - 25, 40, 30); // top of hat

		page.drawArc(Start_X - 20, Start_Y, 40, 40, 235, 75); // smile

		page.fillRect(Start_X - 10, Start_Y + 10, 5, 5); // left eye
		page.fillRect(Start_X + 5, Start_Y + 10, 5, 5); // right eye

		page.drawLine(Start_X - 25, Start_Y + 60, Start_X - 50, Start_Y + 30); // left arm
		page.drawLine(Start_X + 25, Start_Y + 60, Start_X + 75, Start_Y + 60); // right arm

	} // paint()

} // MyApplet class