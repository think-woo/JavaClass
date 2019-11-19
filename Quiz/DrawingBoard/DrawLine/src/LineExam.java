import javax.swing.JFrame;

public class LineExam {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Line Exam");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		LinePanel primary = new LinePanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}// main()

}// LineExam class
