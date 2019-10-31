import javax.swing.JFrame;

public class myPrimaryPanelExam {

	public static void main(String[] args) {

		JFrame frame = new JFrame("PRimaryPanel");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		myPrimaryPanel primaryPanel = new myPrimaryPanel("Sejong University", "Media Communication");
		frame.getContentPane().add(primaryPanel);

		frame.pack();
		frame.setVisible(true);

	}// main()

}// myPrimaryPanelExam class
