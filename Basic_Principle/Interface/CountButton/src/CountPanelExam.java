import javax.swing.JFrame;

public class CountPanelExam {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Number Buttons");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		CountPanel primary = new CountPanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}

}
