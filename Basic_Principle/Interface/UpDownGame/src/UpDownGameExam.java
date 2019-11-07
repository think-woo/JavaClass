import javax.swing.JFrame;

public class UpDownGameExam {

	public static void main(String[] args) {
		JFrame frame = new JFrame("UP DOWN GAME");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		UpDownGamePanel primary = new UpDownGamePanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);
	}
}
