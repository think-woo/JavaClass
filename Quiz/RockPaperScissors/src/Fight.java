
public class Fight {
	public int result(String player1, String player2) {

		if (player1.equals("Scissors")) {
			if (player2.equals("Scissors")) {
				return 0;
			} // draw
			else if (player2.equals("Paper")) {
				return 1;
			} // win
			else {
				return -1;
			} // defeat

		} // player1 == Scissors

		else if (player1.equals("Paper")) {
			if (player2.equals("Scissors")) {
				return -1;
			} // defeat
			else if (player2.equals("Paper")) {
				return 0;
			} // draw
			else {
				return 1;
			} // win
		} // player1 == Paper

		else {
			if (player2.equals("Scissors")) {
				return 1;
			} // win
			else if (player2.equals("Paper")) {
				return -1;
			} // defeat
			else {
				return 0;
			} // draw
		} // player1 == rock

	}// result()
}// Fight class
