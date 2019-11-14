import javax.swing.JFrame;

public class OvalExam {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Exam");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		OvalPanel primary = new OvalPanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}// main()

}// DrawExam class
