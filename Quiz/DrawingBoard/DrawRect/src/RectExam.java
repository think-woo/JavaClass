import javax.swing.JFrame;

public class RectExam {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Rect Exam");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		RectPanel primary = new RectPanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}// main()

}// RectExam class
